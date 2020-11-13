//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1411 👎 0


package cn.sher6j.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//Java：括号生成
public class P22GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder path, int open, int close, int max) {
        if (path.length() == max * 2) {
            res.add(path.toString());
            return;
        }

        if (open < max) {
            path.append('(');
            backtrack(res, path, open + 1, close, max);
            path.deleteCharAt(path.length() - 1);
        }

        if (close < open) {
            path.append(')');
            backtrack(res, path, open, close + 1, max);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}