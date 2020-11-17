//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。 
//
// 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。 
//
// 示例 1: 
//
// 输入: nums = [2,5,6,0,0,1,2], target = 0
//输出: true
// 
//
// 示例 2: 
//
// 输入: nums = [2,5,6,0,0,1,2], target = 3
//输出: false 
//
// 进阶: 
//
// 
// 这是 搜索旋转排序数组 的延伸题目，本题中的 nums 可能包含重复元素。 
// 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？ 
// 
// Related Topics 数组 二分查找 
// 👍 246 👎 0


package cn.sher6j.leetcode.editor.cn;
//Java：搜索旋转排序数组 II
public class P81SearchInRotatedSortedArrayIi{
    public static void main(String[] args) {
        Solution solution = new P81SearchInRotatedSortedArrayIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // skip duplications
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }

            // either nums[left...mid] or nums[mid...right] must be ordered

            // nums[left...mid] is ordered
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else if (target < nums[left] || target > nums[mid]) {
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) { // nums[mid...right] is ordered
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else if (target > nums[right] || target < nums[mid]) {
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}