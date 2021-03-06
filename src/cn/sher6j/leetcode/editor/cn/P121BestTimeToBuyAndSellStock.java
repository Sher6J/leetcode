//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。 
//
// 注意：你不能在买入股票前卖出股票。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划


package cn.sher6j.leetcode.editor.cn;
//Java：买卖股票的最佳时机
public class P121BestTimeToBuyAndSellStock{
    public static void main(String[] args) {
        Solution solution = new P121BestTimeToBuyAndSellStock().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
//        return method1(prices);
//        return dpMethod(prices);
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int max_withstock = -prices[0];
        int max_nostock = 0;
        for (int i = 1; i < n; i++) {
            max_nostock = Math.max(max_nostock, max_withstock + prices[i]);
            max_withstock = Math.max(max_withstock, -prices[i]);
        }
        return max_nostock;
    }

    private int dpMethod(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }

    private int method1(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int min = prices[0]; //若卖出第i天的股票，min记录第i天前的股票最便宜的那天
        int maxDiff = prices[1] - min; //记录最大利润
        for (int i = 2; i < prices.length; i++) {
            if (prices[i - 1] < min) min = prices[i - 1];
            int curDiff = prices[i] - min;
            if (curDiff > maxDiff) maxDiff = curDiff;
        }
        if (maxDiff < 0) return 0;
        return maxDiff;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}