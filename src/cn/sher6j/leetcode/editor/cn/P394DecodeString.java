//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 示例: 
//
// 
//s = "3[a]2[bc]", 返回 "aaabcbc".
//s = "3[a2[c]]", 返回 "accaccacc".
//s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
// 
// Related Topics 栈 深度优先搜索


package cn.sher6j.leetcode.editor.cn;

import java.util.LinkedList;

//Java：字符串解码
public class P394DecodeString{
    public static void main(String[] args) {
        Solution solution = new P394DecodeString().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeString(String s) {
        /**
         * 辅助栈法
         */
        int mul = 0;
        StringBuilder res = new StringBuilder();
        LinkedList<Integer> stack_mul = new LinkedList<>();
        LinkedList<String> string_mul = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_mul.addLast(mul);
                string_mul.addLast(res.toString());
                mul = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                int cur_mul = stack_mul.removeLast();
                String last_res = string_mul.removeLast();
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < cur_mul; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(last_res + tmp);
            } else if (c >= '0' && c <= '9') {
                //会存在数字多余1位的情况，比如某字符串重复34次或更多位数
                mul = mul * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}