//给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。 
//
// 示例 1: 
//
// 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出: false 
// Related Topics 字符串 动态规划


package cn.sher6j.leetcode.editor.cn;
//Java：交错字符串
public class P97InterleavingString{
    public static void main(String[] args) {
        Solution solution = new P97InterleavingString().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), len = s3.length();
        if (m + n != len) return false;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int p = i + j - 1;
                if (i > 0) dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(p);
                if (j > 0) dp[j] = dp[j]  || (dp[j - 1]&& s2.charAt(j - 1) == s3.charAt(p));
            }
        }
        return dp[n];
//        return dp1dMethod(s1, s2, s3);
    }

    /**
     * 动态规划
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    private boolean dp1dMethod(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), len = s3.length();
        if (m + n != len) return false;
        //dp[i][j]表示s1的前i个字符和s2的前j个字符是否可以交替组成s3的前(i + j)个字符
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0] == true;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1) && dp[0][j - 1] == true;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int p = i + j - 1;
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));//其他情况都是false
//                if (s1.charAt(i - 1) != s3.charAt(p) && s2.charAt(j - 1) != s3.charAt(p)) {
//                    dp[i][j] = false;
//                } else if (s1.charAt(i - 1) == s3.charAt(p) && s2.charAt(j - 1) != s3.charAt(p)) {
//                    dp[i][j] = dp[i - 1][j];
//                } else if (s2.charAt(j - 1) == s3.charAt(p) && s1.charAt(i - 1) != s3.charAt(p)) {
//                    dp[i][j] = dp[i][j - 1];
//                } else if (s1.charAt(i - 1) == s3.charAt(p) && s2.charAt(j - 1) == s3.charAt(p)) {
//                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
//                }
            }
        }
        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}