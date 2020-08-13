//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表


package cn.sher6j.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//Java：第一个只出现一次的字符
public class POffer50DiYiGeZhiChuXianYiCiDeZiFuLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 50DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
//        return hashTable1(s);
//        return hashTable2(s);
        //法三：有序哈希表
        Map<Character, Boolean> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), !map.containsKey(s.charAt(i)));
        }
        char res = ' ';
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                res = entry.getKey();
                break;
            }
        }
        return res;
    }

    /**
     * 法二：哈希表中存放字符是否出现一次————出现一次（true） / 不止出现一次（false）
     * 第一次遍历————哈希表统计字符是否只出现一次
     * 第二次遍历————找出第一个只出现一次的字符
     * @param s
     * @return
     */
    public char hashTable2(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), !map.containsKey(s.charAt(i)));
        }
        char res = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i))) {
                res = s.charAt(i);
                break;
            }
        }
        return res;
    }

    /**
     * 法一：哈希表中存放字符出现次数
     * 第一次遍历————哈希表统计字符出现次数
     * 第二次遍历————找出将第一个出现次数为 1 的字符
     * @param s
     * @return
     */
    public char hashTable1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (map.containsKey(currChar)) {
                map.put(currChar, map.get(currChar) + 1);
            } else {
                map.put(currChar, 1);
            }
        }
        char res = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                res = s.charAt(i);
                break;
            }
        }
        return res;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}