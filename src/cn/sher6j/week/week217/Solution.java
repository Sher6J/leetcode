package cn.sher6j.week.week217;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author sher6j
 * @create 2020-11-29-10:24
 */
public class Solution {

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] a : accounts) {
            int sum = 0;
            for (int n : a) {
                sum += n;
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    public int[] mostCompetitive(int[] nums, int k) {
        int[] res = new int[k];
        int start = -1;
        int idx = 0;
        for (int i = k; i > 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = start + 1; j < nums.length - i + 1; j++) {
                if (nums[j] < min) {
                    start = j;
                    min = nums[j];
                }
            }
            res[idx++] = min;
        }
        return res;
    }
}
