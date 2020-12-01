//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 854 👎 0


package cn.sher6j.leetcode.editor.cn;
//Java：乘积最大子数组
public class P152MaximumProductSubarray{
    public static void main(String[] args) {
        Solution solution = new P152MaximumProductSubarray().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] p_dp = new int[n]; // 以 nums[i] 结尾的乘积为正数的最大子数组
        int[] n_dp = new int[n]; // 以 nums[i] 结尾的乘积为负数的最大子数组
        p_dp[0] = nums[0] > 0 ? nums[0] : 0;
        n_dp[0] = nums[0] < 0 ? nums[0] : 0;
        int res = p_dp[0] > 0 ? p_dp[0] : n_dp[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                p_dp[i] = p_dp[i - 1] * nums[i];
                if (p_dp[i] == 0) p_dp[i] = nums[i];
                n_dp[i] = n_dp[i - 1] * nums[i];
            } else if (nums[i] < 0) {
                p_dp[i] = n_dp[i - 1] * nums[i];
                n_dp[i] = p_dp[i - 1] * nums[i];
                if (n_dp[i] == 0) n_dp[i] = nums[i];
            } else {
                p_dp[i] = 0;
                n_dp[i] = 0;
            }
            res = Math.max(res, p_dp[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}