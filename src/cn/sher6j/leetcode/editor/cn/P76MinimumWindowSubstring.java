//给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。 
//
// 
//
// 示例： 
//
// 输入：S = "ADOBECODEBANC", T = "ABC"
//输出："BANC" 
//
// 
//
// 提示： 
//
// 
// 如果 S 中不存这样的子串，则返回空字符串 ""。 
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window


package cn.sher6j.leetcode.editor.cn;

import java.util.HashMap;

//Java：最小覆盖子串
public class P76MinimumWindowSubstring{
    public static void main(String[] args) {
        Solution solution = new P76MinimumWindowSubstring().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>(); // t 中每个字符出现次数
        HashMap<Character, Integer> window = new HashMap<>(); // 滑动窗口中每个字符出现次数
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 滑动窗口的左编辑和右边界[left, right)，valid为窗口中满足need条件的字符个数
        int left = 0, right = 0, valid = 0;
        // 记录最小覆盖子串的起始索引和长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char cAdd = s.charAt(right);
            right++; //右移窗口
            // 窗口内的数据更新
            if (need.containsKey(cAdd)) {
                window.put(cAdd, window.getOrDefault(cAdd, 0) + 1);
                // 这里非常注意！！！Integer不能用==比较，要用compareTo
                // Integer缓存-128到127，这之间的数比较是相等的，
                // 超过这个范围，就会新建Integer对象，
                // 两个不同的对象的比较用==自然返回false，用equals也行
//                if (window.get(c) == need.get(c)) valid++;
                if (window.get(cAdd).compareTo(need.get(cAdd)) == 0) valid++;
            }
            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char removeC = s.charAt(left);
                left++; // 左移窗口
                // 窗口内的数据更新
                if (need.containsKey(removeC)) {
//                    if (window.get(removeC) == need.get(removeC)) valid--;
                    if (window.get(removeC).compareTo(need.get(removeC)) == 0) valid--;
                    window.put(removeC, window.get(removeC) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}