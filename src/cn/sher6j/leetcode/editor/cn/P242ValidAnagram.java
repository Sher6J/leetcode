//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表


package cn.sher6j.leetcode.editor.cn;

import java.util.Arrays;

//Java：有效的字母异位词
//字母异位词：同一字母出现字数相同，只不过字母间顺序不同
public class P242ValidAnagram{
    public static void main(String[] args) {
        Solution solution = new P242ValidAnagram().new Solution();
        // TO TEST
        String s = "anagram";
        String t = "nagaram";
        System.out.println(solution.isAnagram(s, t));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        /**
         * 解法一：暴力
         */
//        char[] schar = s.toCharArray();
//        char[] tchar = t.toCharArray();
//        Arrays.sort(schar);
//        Arrays.sort(tchar);
//        return Arrays.equals(schar, tchar);

        /**
         * 解法二：哈希表
         */
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            counts[c - 'a']--;
        }
        for (int i : counts) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}