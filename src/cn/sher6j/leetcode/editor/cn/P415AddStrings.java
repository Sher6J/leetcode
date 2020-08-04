//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 注意： 
//
// 
// num1 和num2 的长度都小于 5100. 
// num1 和num2 都只包含数字 0-9. 
// num1 和num2 都不包含任何前导零。 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。 
// 
// Related Topics 字符串


package cn.sher6j.leetcode.editor.cn;
//Java：字符串相加
public class P415AddStrings{
    public static void main(String[] args) {
        Solution solution = new P415AddStrings().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        int add = 0; //标志进位
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            res.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        res.reverse();
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}