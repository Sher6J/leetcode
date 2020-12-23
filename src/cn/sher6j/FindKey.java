package cn.sher6j;

/**
 * @author sher6j
 * @create 2020-12-22-19:46
 */
public class FindKey {

}

class Solution {
    public int find(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
