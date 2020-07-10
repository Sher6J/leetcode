//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划


package cn.sher6j.leetcode.editor.cn;
//Java：最佳买卖股票时机含冷冻期
public class P309BestTimeToBuyAndSellStockWithCooldown{
    public static void main(String[] args) {
        Solution solution = new P309BestTimeToBuyAndSellStockWithCooldown().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        // dp[i][0] 当天结束后 有股票
        // dp[i][1] 当天结束后 无股票 + 冻结状态
        // dp[i][2] 当天结束后 无股票 + 非冻结状态
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0]; //dp[0][1]和dp[0][2]默认为0
        for (int i = 1; i < n; i++) {
            /**
             * 当天结束有股票，只可能有两张情况
             *     1. 昨天就有股票，今天就不用买入 即 dp[i - 1][0]
             *     2. 昨天没有股票但是昨天结束时是非冻结状态，今天需要买入 即 dp[i - 1][2] - prices[i]
             */
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            /**
             * 当天结束无股票 + 冻结，只可能是本来有股票，然后今天卖了 即 dp[i - 1][0] + prices[i]
             */
            dp[i][1] = dp[i - 1][0] + prices[i];
            /**
             * 当天结束无股票 + 非冻结，两种情况（昨天要是有股票，今天卖出必为冻结状态）
             *     1. 昨天无股票 + 冻结 即 dp[i - 1][1]
             *     2. 昨天无股票 + 非冻结 即 dp[i - 1][2]
             */
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        // 最大累计获利 即 最后一天无股票状态的最大值
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}