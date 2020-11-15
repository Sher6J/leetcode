//给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。 
//
// 注意: 
//
// 
// num 的长度小于 10002 且 ≥ k。 
// num 不会包含任何前导零。 
// 
//
// 示例 1 : 
//
// 
//输入: num = "1432219", k = 3
//输出: "1219"
//解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
// 
//
// 示例 2 : 
//
// 
//输入: num = "10200", k = 1
//输出: "200"
//解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 : 
//
// 
//输入: num = "10", k = 2
//输出: "0"
//解释: 从原数字移除所有的数字，剩余为空就是0。
// 
// Related Topics 栈 贪心算法 
// 👍 350 👎 0


package cn.sher6j.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：移掉K位数字
public class P402RemoveKDigits{
    public static void main(String[] args) {
        Solution solution = new P402RemoveKDigits().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            char cur = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > cur) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(cur);
        }

        while (k > 0) {
            deque.pollLast();
            k--;
        }

        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty() && deque.peekFirst() == '0') {
            deque.pollFirst();
        }

        while (!deque.isEmpty()) {
            res.append(deque.pollFirst());
        }

        return res.length() == 0 ? "0" : res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}