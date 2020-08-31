package cn.sher6j.week.week204;

/**
 * @author sher6j
 * @create 2020-08-31-11:08
 */
class Solution {

    /**
     * 1566. 重复至少 K 次且长度为 M 的模式
     * 直接暴力法，判断每个可能成为模式的部分能否出现 k 次
     * @param arr 数组
     * @param m 模式的长度
     * @param k 模式的出现次数
     * @return
     */
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        for (int i = 0; i + m * k <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                for (int l = 1; l < k; l++) {
                    flag &= (arr[i + (l - 1) * m + j] == arr[i + l * m + j]);
                }
            }
            if (flag) return true;
        }
        return false;
    }

    /**
     * 1567. 乘积为正数的最长子数组长度
     * 动态规划
     * p_dp[]：以 nums[i] 为结尾的乘积为正的最长子数组长度
     * n_dp[]：以 nums[i] 为结尾的乘积为负的最长子数组长度
     * @param nums 输入的数组
     * @return
     */
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int[] p_dp = new int[n];
        int[] n_dp = new int[n];
        p_dp[0] = nums[0] > 0 ? 1 : 0;
        n_dp[0] = nums[0] < 0 ? 1 : 0;
        int res = p_dp[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                p_dp[i] = p_dp[i - 1] + 1;
                n_dp[i] = n_dp[i - 1] > 0 ? n_dp[i - 1] + 1 : 0;
            } else if (nums[i] < 0) {
                p_dp[i] = n_dp[i - 1] > 0 ? n_dp[i - 1] + 1 : 0;
                n_dp[i] = p_dp[i - 1] + 1;
            } else {
                p_dp[i] = 0;
                n_dp[i] = 0;
            }
            res = Math.max(res, p_dp[i]);
        }
        return res;
    }
}
