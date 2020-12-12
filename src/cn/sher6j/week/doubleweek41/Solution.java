package cn.sher6j.week.doubleweek41;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sher6j
 * @create 2020-12-12-22:24
 */
public class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            set.add(c);
        }
        int res = 0;
        for (String s : words) {
            if (isConsist(s, set)) {
                res++;
            }
        }
        return res;
    }

    private boolean isConsist(String s, Set<Character> set) {
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                return false;
            }
        }
        return true;
    }


    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] left = new int[n]; // n的前缀和
        int[] right = new int[n]; // n的右边数的和
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            left[i] = sum;
        }
        for (int i = 0; i < n; i++) {
            right[i] = sum - left[i];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                res[i] = right[i] - (n - 1) * nums[i];
            } else if (i == n - 1) {
                res[i] = n * nums[i] - left[i];
            } else {
                res[i] = (i + 1) * nums[i] - left[i] + right[i] - (n - i - 1) * nums[i];
            }
        }
        return res;
    }

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i1, i2) -> aliceValues[i2] + bobValues[i2] - aliceValues[i1] - bobValues[i1]);
        int alice = 0;
        int bob = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                alice += aliceValues[idx[i]];
            } else {
                bob += bobValues[idx[i]];
            }
        }
        if (alice > bob) {
            return 1;
        } else if (alice < bob) {
            return -1;
        } else {
            return 0;
        }
    }
}
