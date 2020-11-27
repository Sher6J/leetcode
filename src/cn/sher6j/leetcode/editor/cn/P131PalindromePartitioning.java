//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回 s 所有可能的分割方案。 
//
// 示例: 
//
// 输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//] 
// Related Topics 回溯算法 
// 👍 429 👎 0


package cn.sher6j.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：分割回文串
public class P131PalindromePartitioning{
    public static void main(String[] args) {
        Solution solution = new P131PalindromePartitioning().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        List<List<String>> res = new LinkedList<>();
        int n = s.length();
        backtrack(res, new LinkedList<>(), 0, n, s);
        return res;
    }

    private void backtrack(List<List<String>> res, LinkedList<String> path, int start, int len, String s) {
        if (start == len) {
            res.add(new ArrayList<>(path));
        }

        for (int i = start; i < len; i++) {
            if (!isPalindrome(s, start, i)) {
                continue;
            }
            path.addLast(s.substring(start, i + 1));
            backtrack(res, path, i + 1, len, s);
            path.removeLast();
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}