//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出
//这个数字。 
//
// 
//
// 示例 1: 
//
// 输入: [0,1,3]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [0,1,2,3,4,5,6,7,9]
//输出: 8 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 10000 
// Related Topics 数组 二分查找


package cn.sher6j.leetcode.editor.cn;
//Java：0～n-1中缺失的数字
public class POffer53IIQueShiDeShuZiLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 53 - IIQueShiDeShuZiLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        return getMissingNumber(nums, 0, nums.length - 1);
    }

    public int getMissingNumber(int[] nums, int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (nums[mid] == mid + 1) {
            if (mid > left && nums[mid - 1] == (mid - 1) || mid == left) return mid;
            else right = mid - 1;
        } else {
            left = mid + 1;
        }
        if (left == nums.length) return nums.length;
        return getMissingNumber(nums, left, right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}