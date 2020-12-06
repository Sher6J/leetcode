package cn.sher6j.week.week218;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author sher6j
 * @create 2020-12-06-10:26
 */
public class Solution {


    public String interpret(String command) {
        int n = command.length();
        int idx = 0;
        StringBuilder res = new StringBuilder();
        while (idx < n) {
            if (command.charAt(idx) == 'G') {
                res.append('G');
                idx++;
            } else if (command.charAt(idx) == '(' && command.charAt(idx + 1) == 'a') {
                res.append("al");
                idx += 4;
            } else {
                res.append("o");
                idx += 2;
            }
        }
        return res.toString();
    }


    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        boolean[] isDelete = new boolean[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= k) {
                break;
            }
            if (isDelete[i] == true) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > k - nums[i]) {
                    right = mid - 1;
                } else if (nums[mid] < k - nums[i]) {
                    left = mid + 1;
                } else if (nums[mid] == k - nums[i]) {
                    right = mid - 1;
                }
            }
            if (left >= nums.length || nums[left] != k - nums[i]) {
                continue;
            }
            if (isDelete[left] == false) {
                isDelete[left] = true;
                isDelete[i] = true;
                res++;
            } else {
                while (left + 1 < nums.length && nums[left + 1] == nums[left]) {
                    if (isDelete[left + 1] == false) {
                        isDelete[left + 1] = true;
                        isDelete[i] = true;
                        res++;
                        break;
                    } else {
                        left++;
                    }
                }
            }
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == k && !isDelete[i] && !isDelete[j]) {
//                    isDelete[i] = true;
//                    isDelete[j] = true;
//                    res++;
//                }
//            }
        }
        return res;
    }

    public int concatenatedBinary(int n) {
        long res = 1;
        int MOD = 1000000007;
        if (n == 1) {
            return 1;
        }
        int shift = 1;
        for (int i = 2; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                shift++;
            }
            res = ((res << shift) % MOD + i) % MOD;
        }
        return (int) res;
    }

    @Test
    public void test() {
        int n = 4;
        String string = Integer.toBinaryString(n);
        System.out.println(string);
        BigInteger num = new BigInteger(string);
        System.out.println(num.intValue());
    }
}
