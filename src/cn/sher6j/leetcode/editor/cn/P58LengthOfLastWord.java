//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。 
//
// 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串


package cn.sher6j.leetcode.editor.cn;
//Java：最后一个单词的长度
public class P58LengthOfLastWord{
    public static void main(String[] args) {
        Solution solution = new P58LengthOfLastWord().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {
//        return myMethod(s);
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }

    public int myMethod(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = 0;
        int idx = s.length() - 1;
        while (s.charAt(idx) == ' ') {
            if (idx == 0) return 0;
            idx--;
        }
        for (int i = idx; i >= 0; i--) {
            if (s.charAt(i) == ' ') break;
            len++;
        }
        return len;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}