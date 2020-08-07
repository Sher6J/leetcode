//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法


package cn.sher6j.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

//Java：字符串的排列
public class POffer38ZiFuChuanDePaiLieLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 38ZiFuChuanDePaiLieLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Set<String> res = new HashSet<>();
        StringBuilder track = new StringBuilder();
        int[] visited = new int[chars.length];
        backtrack(track, chars, res, visited);
        String[] ans = new String[res.size()];
        int i = 0;
        Iterator<String> iterator = res.iterator();
        while (iterator.hasNext()) {
            String cur = iterator.next();
            ans[i++] = cur;
        }
        return ans;
    }

    public void backtrack(StringBuilder track, char[] chars, Set<String> res, int[] visited) {
        if (track.length() == chars.length) {
            res.add(track.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            track.append(chars[i]);
            backtrack(track, chars, res, visited);
            visited[i] = 0;
            track.deleteCharAt(track.length() - 1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}