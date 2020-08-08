package cn.sher6j.week.doubleweek32;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author sher6j
 * @create 2020-08-08-22:30
 */
class Solution {

    /**
     * 5468. 第 k 个缺失的正整数
     * @param arr
     * @param k
     * @return
     */
    public int findKthPositive(int[] arr, int k) {
        int m = 0;
        int res = 1;
        for (int i = 1; ; i++) {
            if (search(arr, i) == -1) m++;
            if (m == k) {
                res = i;
                break;
            }
        }
        return res;
    }

    public int search(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            if (target < nums[pivot]) right = pivot - 1;
            else left = pivot + 1;
        }
        return -1;
    }

    /**
     * K 次操作转变字符串
     * @param s
     * @param t
     * @param k
     * @return
     */
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) return false;
        int[] sub = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int curSub = t.charAt(i) - s.charAt(i);
            if (curSub < 0) curSub = 26 + curSub;
            sub[i] = curSub;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int sumK = 0;
        for (int i = 0; i < sub.length; i++) {
            if (sub[i] == 0) continue;
            if (sumK > k) return false;
            if (!map.containsKey(sub[i])) {
                map.put(sub[i], 1);
                sumK = Math.max(sumK, sub[i]);
            } else {
                int mul = map.get(sub[i]);
                map.put(sub[i], mul + 1);
                sumK = Math.max(sumK, sub[i] + 26 * mul);
            }
        }
        if (sumK > k) return false;
        return true;
    }

    /**
     * 平衡括号字符串的最少插入次数
     * (  ---  ())  2
     * () ---  ())  1
     *
     * @param s
     * @return
     */
//    public int minInsertions(String s) {
//
//    }

    public int longestAwesome(String s) {
        //map中包含每个字符的出现个数
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int count = map.get(s.charAt(i));
                map.put(s.charAt(i), count + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        Character key = null;
        int value = 0;
        int count = 0; // count为出现奇数次字符的个数
        Iterator<Character> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            key = iterator.next();
            value = map.get(key);
            if (value % 2 != 0) count++;
        }
        for (int i = 0, j = s.length() - 1; i < j;) {
            if (count == 1 || count == 0) return j - i + 1;
            int countI = map.get(s.charAt(i));
            int countJ = map.get(s.charAt(j));
            if (countI % 2 == 1) {
                map.put(s.charAt(i), countI - 1);
                count--;
                i++;
            } else if (countJ % 2 == 1) {
                map.put(s.charAt(j), countJ - 1);
                count--;
                j--;
            } else {
                int left = longestAwesome(s.substring(i + 1, j + 1));
                int right = longestAwesome(s.substring(i, j));
                if (left >= right) {
                    map.put(s.charAt(i), countI - 1);
                    count++;
                    i++;
                } else {
                    map.put(s.charAt(j), countJ - 1);
                    count++;
                    j--;
                }
            }
        }
        return 1;
    }

}
