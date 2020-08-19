//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 示例1: 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 
//
// 示例2: 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 注意： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window


package cn.sher6j.leetcode.editor.cn;

import java.util.HashMap;

//Java：字符串的排列
public class P567PermutationInString{
    public static void main(String[] args) {
        Solution solution = new P567PermutationInString().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
//        return wrongMethod(s1, s2);
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        while (right < s2.length()) {
            char cAdd = s2.charAt(right);
            right++;
            if (need.containsKey(cAdd)) {
                window.put(cAdd, window.getOrDefault(cAdd, 0) + 1);
                if (window.get(cAdd).compareTo(need.get(cAdd)) == 0) valid++;
            }
            // 控制滑动窗口长度为s1的长度
//            while (right - left >= s1.length()) {
//                if (valid == need.size()) return true;
//                char cRemove = s2.charAt(left);
//                left++;
//                if (need.containsKey(cRemove)) {
//                    if (window.get(cRemove).compareTo(need.get(cRemove)) == 0) valid--;
//                    window.put(cRemove, window.get(cRemove) - 1);
//                }
//            }

            // 和注释等价
            while (right - left > s1.length()) {
                char cRemove = s2.charAt(left);
                left++;
                if (need.containsKey(cRemove)) {
                    if (window.get(cRemove).compareTo(need.get(cRemove)) == 0) valid--;
                    window.put(cRemove, window.get(cRemove) - 1);
                }
            }
            if (valid == need.size()) return true;
        }
        return false;
    }

    /**
     * 错误解法！！！
     * 滑动窗口只控制右边界，我以为就可以
     * 但是 100 / 103 个通过测试用例，当输入如下时出错：
     *      "hello"
     *      "ooolleoooleh"
     * 因为，s2中的每个字符都在s1中，所以下面的 if 判断永远没有进入 else，造成valid和window一直没有清0
     * 所以本题必须控制滑动窗口的长度
     * @param s1
     * @param s2
     * @return
     */
    public boolean wrongMethod(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int right = 0, valid = 0;
        while (right < s2.length()) {
            char cAdd = s2.charAt(right);
            right++;
            if (need.containsKey(cAdd)) {
                window.put(cAdd, window.getOrDefault(cAdd, 0) + 1);
                if (window.get(cAdd).compareTo(need.get(cAdd)) == 0) valid++;
                if (valid == need.size()) return true;
            } else {
                window.clear();
                valid = 0;
            }
        }
        return false;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}