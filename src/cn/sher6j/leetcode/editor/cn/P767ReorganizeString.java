//给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。 
//
// 若可行，输出任意可行的结果。若不可行，返回空字符串。 
//
// 示例 1: 
//
// 
//输入: S = "aab"
//输出: "aba"
// 
//
// 示例 2: 
//
// 
//输入: S = "aaab"
//输出: ""
// 
//
// 注意: 
//
// 
// S 只包含小写字母并且长度在[1, 500]区间内。 
// 
// Related Topics 堆 贪心算法 排序 字符串 
// 👍 190 👎 0


package cn.sher6j.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

//Java：重构字符串
public class P767ReorganizeString{
    public static void main(String[] args) {
        Solution solution = new P767ReorganizeString().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reorganizeString(String S) {
        if (S.length() < 2) {
            return S;
        }
        int[] counts = new int[26];
        int maxCount = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        if (maxCount > (S.length() + 1) / 2) {
            return "";
        }

        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                return counts[c2 - 'a'] - counts[c1 - 'a'];
            }
        });

        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) {
                queue.offer(c);
            }
        }

        StringBuilder res = new StringBuilder();
        while (queue.size() > 1) {
            char c1 = queue.poll();
            char c2 = queue.poll();
            res.append(c1);
            res.append(c2);
            if (--counts[c1 - 'a'] > 0) {
                queue.offer(c1);
            }
            if (--counts[c2 - 'a'] > 0) {
                queue.offer(c2);
            }
        }

        if (queue.size() == 1) {
            res.append(queue.poll());
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}