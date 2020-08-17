//把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。 
//
// 
//
// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
// 
//
// 示例 2: 
//
// 输入: 2
//输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0
//.05556,0.02778] 
//
// 
//
// 限制： 
//
// 1 <= n <= 11 
//


package cn.sher6j.leetcode.editor.cn;
//Java：n个骰子的点数
public class POffer60NgeTouZiDeDianShuLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 60NgeTouZiDeDianShuLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] twoSum(int n) {
//        return dpNoSpaceOptimize(n);
        return dpWithSpaceOptimize(n);
    }

    /**
     * 动态规划带空间优化
     * @param n
     * @return
     */
    public double[] dpWithSpaceOptimize(int n) {
        int[] dp = new int[6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 6 * i; j >= i; j--) {
                dp[j] = 0;
                for (int cur = 1; cur <= 6; cur++) {
                    if (j - cur >= i - 1) {
                        dp[j] += dp[j - cur];
                    }
                }
            }
        }
        double allPoints = Math.pow(6, n);
        double[] res = new double[6 * n - n + 1];
        int idx = 0;
        for (int i = n; i <= 6 * n; i++) {
            res[idx++] = dp[i] * 1.0 / allPoints;
        }
        return res;
    }

    /**
     * 动态规划：
     * dp[i][j]：投完 i 个骰子后总点数 j 出现的次数
     * base case：dp[1][sum] = 1， sum = [1, 6]
     * dp[i][j] = sum(dp[i - 1][j - k])，k = [1, 6]
     * @param n
     * @return
     */
    public double[] dpNoSpaceOptimize(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int cur = 1; cur <= 6; cur++) {
                    if (j - cur > 0) {
                        dp[i][j] += dp[i - 1][j - cur];
                    }
                }
            }
        }
        double allPoints = Math.pow(6, n);
        double[] res = new double[6 * n - n + 1];
        int idx = 0;
        for (int i = n; i <= 6 * n; i++) {
            res[idx++] = dp[n][i] * 1.0 / allPoints;
        }
        return res;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}