//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 
//示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
// Related Topics 二分查找


package cn.sher6j.leetcode.editor.cn;
//Java：二分查找
public class P704BinarySearch{
    public static void main(String[] args) {
        Solution solution = new P704BinarySearch().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == -1) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // 计算 mid 时需要防止溢出，代码中
            // left + (right - left) / 2 和 (left + right) / 2 的结果相同，
            // 但是有效防止了 left 和 right 太大直接相加导致溢出
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) return mid;
            else if (target < nums[mid]) right = mid - 1;
            else  left = mid + 1;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}