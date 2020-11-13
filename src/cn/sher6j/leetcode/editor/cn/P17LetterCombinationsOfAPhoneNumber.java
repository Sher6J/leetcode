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

import java.util.*;

//Java：电话号码的字母组合
public class P17LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
//        return backtrackMethod(digits);
        LinkedList<String> res = new LinkedList<>();
        if (digits.isEmpty()) {
            return res;
        }
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int num = Character.getNumericValue(digits.charAt(i));
            while (res.peek().length() == i) {
                String prefix = res.removeFirst();
                for (char c : mapping[num].toCharArray()) {
                    res.addLast(prefix + c);
                }
            }
        }
        return res;
    }

    private List<String> backtrackMethod(String digits) {
        List<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(res, mapping, digits, 0, new StringBuilder());
        return res;
    }

    /**
     *
     * @param res 返回结果列表
     * @param mapping 选择列表
     * @param digits
     * @param idx
     * @param cur 路径
     */
    public void backtrack (List<String> res, String[] mapping, String digits, int idx, StringBuilder cur) {
        if (idx == digits.length()) {
            res.add(cur.toString());
            return;
        }
        int num = Character.getNumericValue(digits.charAt(idx));
        String letterMay = mapping[num];
        int countMay = letterMay.length();
        for (int i = 0; i < countMay; i++) {
            cur.append(letterMay.charAt(i));
            backtrack(res, mapping, digits, idx + 1, cur);
            cur.deleteCharAt(idx);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}