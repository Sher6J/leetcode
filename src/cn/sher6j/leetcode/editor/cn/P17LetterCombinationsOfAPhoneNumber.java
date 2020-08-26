//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法


package cn.sher6j.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：电话号码的字母组合
public class P17LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        Map<Character, String> numCharMap = new HashMap<>();
        numCharMap.put('2', "abc");
        numCharMap.put('3', "def");
        numCharMap.put('4', "ghi");
        numCharMap.put('5', "jkl");
        numCharMap.put('6', "mno");
        numCharMap.put('7', "pqrs");
        numCharMap.put('8', "tuv");
        numCharMap.put('9', "wxyz");
        backtrack(res, numCharMap, digits, 0, new StringBuilder());
        return res;
    }

    public void backtrack (List<String> res, Map<Character, String> map, String digits, int idx, StringBuilder cur) {
        if (idx == digits.length()) {
            res.add(cur.toString());
            return;
        }
        char digit = digits.charAt(idx);
        String letterMay = map.get(digit);
        int countMay = letterMay.length();
        for (int i = 0; i < countMay; i++) {
            cur.append(letterMay.charAt(i));
            backtrack(res, map, digits, idx + 1, cur);
            cur.deleteCharAt(idx);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}