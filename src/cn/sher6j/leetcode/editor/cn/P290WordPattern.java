//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表 
// 👍 274 👎 0


package cn.sher6j.leetcode.editor.cn;

import java.util.HashMap;

//Java：单词规律
public class P290WordPattern{
    public static void main(String[] args) {
        Solution solution = new P290WordPattern().new Solution();
        // TO TEST
        String s = "dog cat cat dog";
        String[] ss = s.split(" ");
        System.out.println(ss.length);
        for (String str : ss) {
            System.out.println(str);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] ss = s.split(" ");
        if (pattern.length() != ss.length) {
            return false;
        }
        HashMap<Character, String> charToString = new HashMap<>();
        HashMap<String, Character> stringToChar = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String str = ss[i];
            if (charToString.containsKey(c)) {
                if (!str.equals(charToString.get(c))) {
                    return false;
                }
            } else {
                charToString.put(c, str);
            }
            if (stringToChar.containsKey(str)) {
                if (! (c == stringToChar.get(str))) {
                    return false;
                }
            } else {
                stringToChar.put(str, c);
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}