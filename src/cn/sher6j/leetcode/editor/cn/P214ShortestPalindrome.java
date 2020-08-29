//给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。 
//
// 示例 1: 
//
// 输入: "aacecaaa"
//输出: "aaacecaaa"
// 
//
// 示例 2: 
//
// 输入: "abcd"
//输出: "dcbabcd" 
// Related Topics 字符串


package cn.sher6j.leetcode.editor.cn;
//Java：最短回文串
public class P214ShortestPalindrome{
    public static void main(String[] args) {
        Solution solution = new P214ShortestPalindrome().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String shortestPalindrome(String s) {
//        return stupidMethod(s);
        int i = 0, j = s.length() - 1;
        while (j >= 0) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
            j--;
        }
        if (i == s.length()) return s;
        String suffix = s.substring(i);
        StringBuilder reverse = new StringBuilder(suffix).reverse();
        return reverse + shortestPalindrome(s.substring(0, i)) + suffix;
    }

    /**
     * 法一：暴力法 119 / 120 个通过测试用例
     * 减去字符串末尾的第1个数判断剩余是否为回文串，若不为则
     * 减去字符串末尾的第2个数判断剩余是否为回文串，若不为则
     * ……………………
     * 减去字符串末尾的第n个数判断剩余是否为回文串，此时为回文串
     * 则最短回文串为在 s 前插入 s 的 [n + 1， s.length() - 1]部分的逆
     * @param s
     * @return
     */
    public String stupidMethod(String s) {
        int end = s.length() - 1;
//        for ( ; end > 0; end--) {
//            if (isPalindrome(s, 0, end)) break;
//        }
        while(end > 0) {
            if (isPalindrome(s, 0, end)) break;
            end--;
        }
        StringBuilder res = new StringBuilder(s.substring(end + 1, s.length())).reverse();
        return res + s;
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}