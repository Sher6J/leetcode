//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划


package cn.sher6j.leetcode.editor.cn;
//Java：回文子串
public class P647PalindromicSubstrings{
    public static void main(String[] args) {
        Solution solution = new P647PalindromicSubstrings().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
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
    public int centerToSideMethod(String s) {
        int len = s.length(), count = 0;
        for (int i = 0; i < 2 * len - 1; i++) {
            int left = i / 2, right = i / 2 + i % 2;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                count++;
            }
        }
        return count;
    }

    /**
     * 法一：动态规划
     * dp[i][j]：[i, j]的字符串是否能构成回文串，
     * dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j]
     * base case：
     *      ① dp[i][i] = true （单字符）
     *      ② dp[i][j] = true （空字符）
     * return：j ≥ i 时，dp[i][j]为true的数量
     * @param s
     * @return
     */
    public int dpMethod(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            count++;
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (j - 1 < i + 1) dp[i + 1][j - 1] = true;
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if (dp[i][j] == true) count++;
            }
        }
        return count;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}