//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组


package cn.sher6j.leetcode.editor.cn;
//Java：下一个排列
public class P31NextPermutation{
    public static void main(String[] args) {
        Solution solution = new P31NextPermutation().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        /**
         * 1.从后向前遍历找到第一个出现倒序的元素满足 a[i] < a[i+1]
         * 2.从后向前遍历找到第一个比a[i]大的元素a[j]
         * 3.交换a[i]和a[j]
         * 4.将a[i]后的元素进行反转
         */
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) j--;
            swap(nums, i , j);
        }
        reverse(nums, i + 1);
    }

    public void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) swap(nums, i++, j--);
//        while (i < j) {
//            swap(nums, i, j);
//            i++;
//            j--;
//        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}