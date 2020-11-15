//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划


package cn.sher6j.leetcode.editor.cn;
//Java：最大子序和
public class P53MaximumSubarray{
    public static void main(String[] args) {
        Solution solution = new P53MaximumSubarray().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
//        return dpMethod(nums);
        return greedyMethod(nums);
    }

    private int greedyMethod(int[] nums) {
        int n = nums.length;
        int curSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            curSum += nums[i];
            max = Math.max(curSum, max);
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return max;
    }

    private int dpMethod(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = max > dp[i] ? max : dp[i];
        }
        return max;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}