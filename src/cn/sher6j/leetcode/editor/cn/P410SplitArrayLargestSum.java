//给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。 
//
// 注意: 
//数组长度 n 满足以下条件: 
//
// 
// 1 ≤ n ≤ 1000 
// 1 ≤ m ≤ min(50, n) 
// 
//
// 示例: 
//
// 
//输入:
//nums = [7,2,5,10,8]
//m = 2
//
//输出:
//18
//
//解释:
//一共有四种方法将nums分割为2个子数组。
//其中最好的方式是将其分为[7,2,5] 和 [10,8]，
//因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
// 
// Related Topics 二分查找 动态规划


package cn.sher6j.leetcode.editor.cn;
//Java：分割数组的最大值
public class P410SplitArrayLargestSum{
    public static void main(String[] args) {
        Solution solution = new P410SplitArrayLargestSum().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int splitArray(int[] nums, int m) {
        return dpMethod(nums, m);
    }

    /**
     * 法一：动态规划
     * 模式识别 ————「将数组分割为 m 段，求……」是动态规划题目常见的问法
     * 时间复杂度：O(N^2·M)
     * 空间复杂度：O(N·M)
     * @param nums
     * @param m
     * @return
     */
    private int dpMethod(int[] nums, int m) {
        int n = nums.length;
        //dp[i][j]：将数组前i个数分为j段所能得到的最大连续子数组和的最小值
        int[][] dp = new int[n + 1][m + 1];
        int[] sum = new int[n + 1]; //前i项和
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i < j) {
                    dp[i][j] = Integer.MAX_VALUE;//base case
                } else if (j == 0) {
                    dp[i][j] = 0;//base case
                } else if (j == 1) {
                    dp[i][j] = sum[i];//base case
                } else {
                    dp[i][j] = Integer.MAX_VALUE; //否则dp[i][j]默认为0，则下面的Math.min一直返回0
                    for (int k = 1; k < i; k++) {
                        //dp[i][j] = min {max(dp[k][j - 1], sum(k + 1, i))}, 0 < k < i
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sum[i] - sum[k]));
                    }
                }
            }
        }
        return dp[n][m];
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}