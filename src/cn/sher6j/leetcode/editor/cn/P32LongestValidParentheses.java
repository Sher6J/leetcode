//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划


package cn.sher6j.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//Java：最长有效括号
public class P32LongestValidParentheses{
    public static void main(String[] args) {
        Solution solution = new P32LongestValidParentheses().new Solution();
        String s = "(()";
        System.out.println(solution.isValid(s));
        System.out.println(solution.longestValidParentheses(s));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        return stackMethod(s);
//        return dpMethod(s);
//        return stupidMethod(s);
    }

    /**
     * 法三：利用栈
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param s
     * @return
     */
    public int stackMethod(String s) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int len = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else {
                    len = i - stack.peek();
                    max = Math.max(len, max);
                }
            }
        }
        return max;
    }

    /**
     * 法二：动态规划
     * 状态转移方程：dp[i] = 2 + dp[i-1] + dp[i-dp[i-1]-2]
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param s
     * @return
     */
    public int dpMethod(String s) {
        int max = 0;
        if (s.length() < 2) return 0;
        int[] dp = new int[s.length()];
        //当前字符为'('时，dp[i]为0，由于初始数组即为0，所以不需要单独判断
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i-1] > 0 && s.charAt(i - dp[i-1] - 1) == '(') {
                    dp[i] = dp[i-1] + ((i - dp[i-1]) >= 2 ? dp[i - dp[i-1] - 2] : 0) + 2;
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    /**
     * 法一：暴力解法，但是不能通过所有测试，个别会超时  227 / 230 个通过测试用例
     * 从字符串长度向下取最大偶数，然后依次遍历下一大的偶数 i
     * 然后查看所有为长度为 i 的子串是否为有效子串， 然后返回 i 即可
     * 时间复杂度：O(n^3)，i 为一层循环，j 为一层， 取子串又为一层
     * 空间复杂度：O(n)，子字符串的长度最多会需要一个深度为n的栈
     * @param s
     * @return
     */
    public int stupidMethod(String s) {
        if (s.length() < 2) return 0;
        //有效括号字符串必为偶数长度
        int n = s.length() % 2 == 0 ? s.length() : (s.length() - 1);
        for (int i = n; i > 1 ; i = i - 2) {
            int l = s.length() - i + 1;
            for (int j = 0; j < l; j++) {
                if (isValid(s.substring(j, j + i))) return i;
            }
        }
        return 0;
    }

    /**
     * 判断字符串是否为有效括号
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push('(');
            else if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
            else return false;
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}