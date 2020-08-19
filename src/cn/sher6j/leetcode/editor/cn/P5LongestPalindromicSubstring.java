//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划


package cn.sher6j.leetcode.editor.cn;
//Java：最长回文子串
public class P5LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
//        return dpMethod(s);
        return centerToSideMethod(s);
    }

    /**
     * 法二：中心拓展法
     * 枚举可能出现的回文中心，然后从回文中心用两个指针分别向左右拓展，判断该回文中心下的回文数
     * 回文中心有两种：
     *      ① 回文长度为奇数：回文中心为一个字符，即 left = right
     *      ② 回文长度为偶数：回文中心为两个字符，即 left + 1 = right
     * 设字符串长度为 n，则可能的回文中心有 2 * n - 1 个回文中心[li, ri]
     *      其中 li = i / 2, ri = i / 2 + i % 2
     * 如字符串长度为 4，其可能的回文中心为
     *      i           li          ri
     *      0           0           0
     *      1           0           1
     *      2           1           1
     *      3           1           2
     *      4           2           2
     *      5           2           3
     *      6           3           3
     * @param s
     * @return
     */
    private String centerToSideMethod(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return s;
        int n = s.length(), left = 0, right = 0, len = 1;
        for (int i = 0; i < 2 * n - 1; i++) {
            int midStart = i / 2, midEnd = i / 2 + i % 2;
            while (midStart >= 0 && midEnd < n && s.charAt(midStart) == s.charAt(midEnd)) {
                // 注意这里必须是先判断，后--和++
                if (midEnd - midStart + 1 >= len) {
                    left = midStart;
                    right = midEnd;
                    len = right - left + 1;
                }
                midStart--;
                midEnd++;
            }
        }
        return s.substring(left, right + 1);
    }

    /**
     * 法一：动态规划
     * dp[i][j]：[i, j]的字符串是否能构成回文串，
     * dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j]
     * base case：
     *      ① dp[i][i] = true （单字符）
     *      ② dp[i][j] = true （空字符）
     * return：j ≥ i 时，使dp[i][j]为true且使 j - i + 1 最大（即最长回文子串）的最大值
     * @param s
     * @return
     */
    public String dpMethod(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return s;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int len = 1, left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (j - 1 < i + 1) dp[i + 1][j - 1] = true;
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if (dp[i][j] == true && (j - i + 1 >= len)) {
                    left = i;
                    right = j;
                    len = right - left + 1;
                }
            }
        }
        return s.substring(left, right + 1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}