//给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之
//外其余各元素的乘积。 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4]
//输出: [24,12,8,6] 
//
// 
//
// 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。 
//
// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 进阶： 
//你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。） 
// Related Topics 数组


package cn.sher6j.leetcode.editor.cn;
//Java：除自身以外数组的乘积
public class P238ProductOfArrayExceptSelf{
    public static void main(String[] args) {
        Solution solution = new P238ProductOfArrayExceptSelf().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        /**
         * 法一：除当前元素的其他元素积 = 当前元素前缀积 * 当前元素后缀积
         *     故两个数组分别保存前缀积和后缀积，output为两个数组对应元素相乘
         *     时间复杂度：O(n) [遍历三次，分别生成l、r、output数组]
         *     空间复杂度：O(n) [创建了l、r数组]
         */
//        int[] l = new int[nums.length]; //前缀积
//        int[] r = new int[nums.length]; //后缀积
//        l[0] = 1;
//        r[nums.length - 1] = 1;
//        for (int i = 1; i < nums.length; i++) {
//            l[i] = nums[i - 1] * l[i - 1];
//        }
//        for (int i = nums.length - 2; i > -1; i--) {
//            r[i] = nums[i + 1] * r[i + 1];
//        }
//        int[] output = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            output[i] = l[i] * r[i];
//        }
//        return output;

        /**
         * 优化后，空间复杂度为O(1)
         */
        int[] output = new int[nums.length];
        output[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            output[i] = output[i - 1] * nums[i - 1]; //先将output数组作为前缀积数组
        }
        int r = 1;
        for (int i = nums.length - 1; i > -1; i--) {
            output[i] = output[i] * r;
            r = r * nums[i];
        }
        return output;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}