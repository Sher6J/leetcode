//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下： 
//
// L   C   I   R
//E T O E S I I G
//E   D   H   N
// 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// string convert(string s, int numRows); 
//
// 示例 1: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
// 
//
// 示例 2: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G 
// Related Topics 字符串


package cn.sher6j.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：Z 字形变换
public class P6ZigzagConversion{
    public static void main(String[] args) {
        Solution solution = new P6ZigzagConversion().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        int len = chars.length;

        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        int i = 0;
        while (i < len) {
            // up to down
            for (int j = 0; j < numRows && i < len; j++) {
                sb[j].append(chars[i++]);
            }
            // down to up
            for (int j = numRows - 2; j >= 1 && i < len; j--) {
                sb[j].append(chars[i++]);
            }
        }

        for (int j = 1; j < numRows; j++) {
            sb[0].append(sb[j]);
        }

        return sb[0].toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}