//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 
//
// 示例 1: 
//
// 
//输入:
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出: 3
//解释: 
//长度最长的公共子数组是 [3, 2, 1]。
// 
//
// 说明: 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 哈希表 二分查找 动态规划


package cn.sher6j.leetcode.editor.cn;
//Java：最长重复子数组
public class P718MaximumLengthOfRepeatedSubarray{
    public static void main(String[] args) {
        Solution solution = new P718MaximumLengthOfRepeatedSubarray().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLength(int[] A, int[] B) {
        return dpMethod(A, B);
    }

    /**
     * 法一：动态规划
     * @param A
     * @param B
     * @return
     */
    private int dpMethod(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[][] dp = new int[m+1][n+1];
        int res = 0;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
//                if (i == 0 || j == 0) {
//                    dp[i][j] = 0;
//                } else {
//                    if ((A[i-1]==B[j-1])) dp[i][j] = dp[i-1][j-1] + 1;
//                    else dp[i][j] = 0;
//                }
                //由于数组初始化时默认值即为0，所以上述代码可以简化为下面一行
                if ((A[i-1] == B[j-1])) dp[i][j] = dp[i-1][j-1] + 1;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}