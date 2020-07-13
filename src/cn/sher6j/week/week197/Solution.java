package cn.sher6j.week.week197;

/**
 * @author sher6j
 * @create 2020-07-12-10:29
 */
public class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) count++;
            }
        }
        return count;
    }
}
