package cn.sher6j.week.week220;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sher6j
 * @create 2020-12-20-10:24
 */
public class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> idx = new HashMap<>();
        int curSum = 0;
        int max = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            int cur = nums[right];
            int count = map.getOrDefault(cur, 0);
            if (count == 0) {
                map.put(cur, 1);
                idx.put(cur, right);
                curSum += cur;
                max =Math.max(curSum, max);
                right++;
            } else {
                map.put(cur, 0);
                while (left <= idx.get(cur)) {
                    curSum -= nums[left];
                    left++;
                }
                map.put(cur, right);
            }
        }
        return max;
    }
}
