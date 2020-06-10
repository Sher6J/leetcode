//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串


package cn.sher6j.leetcode.editor.cn;
//Java：验证回文串
public class P125ValidPalindrome{
    public static void main(String[] args) {
        Solution solution = new P125ValidPalindrome().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        /**
         * 法一：将字符串中所有非字母和数字的字符都去掉再进行回文判断
         */
//        return isPalindrome1(s);

        /**
         * 法二：双指针（左向右指针和右向左指针），碰到非字母数字的字符就跳过
         */
        int front = 0;
        int back = s.length() - 1;
        while (front < back) {
            while (front < back && !Character.isLetterOrDigit(s.charAt(front))) front++;
            while (front < back && !Character.isLetterOrDigit(s.charAt(back))) back--;
            if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(back))) return false;
            front++;
            back--;
        }
        return true;

    }

    private boolean isPalindrome1(String s) {
        if (s == null || s.equals("")) return true;
        String str = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                sb.append(c);
            }
        }
        char[] finalChars = sb.toString().toCharArray();
        for (int i = 0; i < finalChars.length / 2; i++) {
            if (finalChars[i] != finalChars[finalChars.length - 1 - i]) return false;
        }
        return true;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}