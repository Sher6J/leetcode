//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找


package cn.sher6j.leetcode.editor.cn;
//Java：在排序数组中查找数字 I
public class POffer53IZaiPaiXuShuZuZhongChaZhaoShuZiLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 53 - IZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int count = 0;
        if (nums != null && nums.length > 0) {
            int firstIdx = getFirstTarget(nums, 0, nums.length - 1, target);
            int lastIdx = getLastTarget(nums, 0, nums.length - 1, target);
            if (firstIdx > -1 && lastIdx > -1) {
                count = lastIdx - firstIdx + 1;
            }
        }
        return count;
    }

    /**
     * 在数组的子区间 [start, end] 中查找目标元素第一次出现的索引
     * @param nums
     * @param start inclusive
     * @param end inclusive
     * @param target
     * @return
     */
    public int getFirstTarget(int[] nums, int start, int end, int target) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            if (mid > 0 && nums[mid - 1] != target || mid == 0) return mid;
            else end = mid - 1;
        } else if (nums[mid] < target) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
        return getFirstTarget(nums, start, end, target);
    }

    /**
     * 在数组的子区间 [start, end] 中查找目标元素最后一次出现的索引
     * @param nums
     * @param start inclusive
     * @param end inclusive
     * @param target
     * @return
     */
    public int getLastTarget(int[] nums, int start, int end, int target) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            if (mid < end && nums[mid + 1] != target || mid == end) return mid;
            else start = mid + 1;
        } else if (nums[mid] < target) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
        return getLastTarget(nums, start, end, target);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}