//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划


package cn.sher6j.leetcode.editor.cn;
//Java：分割等和子集
public class P416PartitionEqualSubsetSum{
    public static void main(String[] args) {
        Solution solution = new P416PartitionEqualSubsetSum().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        return dpMethod1D(nums);
//        return dpMethod2D(nums);
    }

    /**
     * 动态规划，一维数组的动态规划
     * 观察二维方法，dp[i][j]都是通过上一行dp[i-1][...]转移过来的，而再之前的数据不会再使用了
     * 可以进行降维空间优化
     * @param nums
     * @return
     */
    public boolean dpMethod1D(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 != 0) return false;
        int n = nums.length, m = sum / 2;
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 0; j--) {
                if (j - nums[i] >= 0) dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[m];
    }

    /**
     * 动态规划，二维数组的动态规划
     * @param nums
     * @return
     */
    public boolean dpMethod2D(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % 2 != 0) return false;
        int n = nums.length, m = sum / 2;
        //dp[n][m]表示将n个物品放入容量为m的背包中，能否将背包装满
        boolean[][] dp = new boolean[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true; //若背包容量为0，一定能装满
            //dp[0][j] (j != 0) 一定为false，0个物品装入有容量的背包，一定装不满，dp默认为false，不用特殊赋值
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j - nums[i - 1] < 0) { //当前背包总容量不能容纳第i个物品
                    //if成立 则 当前背包容量不可能装下第i个物品，所以是否满完全由第i-1个物品时状态决定
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //若当前物品装入，则状态由dp[i - 1][j - nums[i - 1]]决定，nums[i - 1]为第i个物品的重量
                    //若当前物品不转入，则状态由dp[i - 1][j]决定
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}