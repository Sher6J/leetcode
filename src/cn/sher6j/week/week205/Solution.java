package cn.sher6j.week.week205;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sher6j
 * @create 2020-09-06-10:24
 */
class Solution {
    public String modifyString(String s) {
        if (s == null || s.length() == 0) return s;
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            if (chars[i] != '?') continue;
            char last = '#', next = '#';
            if (i > 0) last = chars[i - 1];
            if (i < len - 1) next = chars[i + 1];
            if (last == '#' && next == '#') {
                chars[i] = 'a';
            } else if (next != '?') {
                for (char j = 'a'; j <= 'z'; j++) {
                    if (j != last && j != next) {
                        chars[i] = j;
                        break;
                    }
                }
            } else if (next == '?') {
                for (char j = 'a'; j <= 'z'; j++) {
                    if (j != last) {
                        chars[i] = j;
                        break;
                    }
                }
            }
        }
        return String.valueOf(chars);
    }


    /**
     * 5508. 数的平方等于两数乘积的方法数
     * @param nums1
     * @param nums2
     * @return
     */
    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Map<Integer, Integer> c1 = new HashMap<>();
        Map<Integer, Integer> c2 = new HashMap<>();
        int count = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        double[] d1 = new double[len1];
        for (int i = 0; i < len1; i++) {
            d1[i] = nums1[i] * nums1[i];
            c1.put(nums1[i], c1.getOrDefault(nums1[i], 0) + 1);
        }
        double[] d2 = new double[len2];
        for (int i = 0; i < len2; i++) {
            d2[i] = nums2[i] * nums2[i];
            c2.put(nums2[i], c2.getOrDefault(nums2[i], 0) + 1);
        }
        for (int i = 0; i < len2 - 1; i++) {
            for (int j = i + 1; j < len2; j++) {
                double mul = nums2[i] * nums2[j];
                int idx = Arrays.binarySearch(d1, mul);
                if (idx >= 0) count += c1.get(nums1[idx]);
            }
        }
        for (int i = 0; i < len1 - 1; i++) {
            for (int j = i + 1; j < len1; j++) {
                double mul = nums1[i] * nums1[j];
                int idx = Arrays.binarySearch(d2, mul);
                if (idx >= 0) count += c2.get(nums2[idx]);
            }
        }
        return count;
    }


    public int minCost(String s, int[] cost) {
        int len = s.length();
        int costSum = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            if (chars[i] != chars[i + 1]) continue;
            if (chars[i] == chars[i + 1]) {
                if (cost[i] > cost[i + 1]) {
                    costSum += cost[i + 1];
                    cost[i + 1] = cost[i];
                } else {
                    costSum += cost[i];
                }
            }
        }
        return costSum;
    }
}
