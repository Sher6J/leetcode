//给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。 
//
// 重复出现的子串要计算它们出现的次数。 
//
// 示例 1 : 
//
// 
//输入: "00110011"
//输出: 6
//解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
//
//请注意，一些重复出现的子串要计算它们出现的次数。
//
//另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
// 
//
// 示例 2 : 
//
// 
//输入: "10101"
//输出: 4
//解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
// 
//
// 注意： 
//
// 
// s.length 在1到50,000之间。 
// s 只包含“0”或“1”字符。 
// 
// Related Topics 字符串


package cn.sher6j.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：计数二进制子串
public class P696CountBinarySubstrings{
    public static void main(String[] args) {
        Solution solution = new P696CountBinarySubstrings().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countBinarySubstrings(String s) {
        return noSpaceOptimize(s);
    }

    /**
     * 将字符串按照 0 或 1 的连续段分组，存在 counts 数组中
     * 如 s = 00111011
     * 则 counts = {2, 3, 1, 2}
     * counts数组中相邻的两个数一定代表了不同的字符（分别为 0、1 或 1、0）
     * 设counts中相邻两个数组为 m、n，则可以贡献 min(m, n)个子串数目
     * @param s
     * @return
     */
    public int noSpaceOptimize(String s) {
        List<Integer> counts = new ArrayList<>();
        int p = 0, n = s.length();
        while (p < n) {
            char c = s.charAt(p);
            int count = 0;
            while (p < n && s.charAt(p) == c) {
                p++;
                count++;
            }
            counts.add(count);
        }
        int res = 0;
        for (int i = 1; i < counts.size(); i++) {
            res += Math.min(counts.get(i), counts.get(i - 1));
        }
        return res;
    }

    /**
     * 对于当前位置 i ，只关心 i-1 位置的counts值
     * 所以可以用 pre 维护前一个位置
     * 省去 counts 数组空间
     * @param s
     * @return
     */
    public int withSpaceOptimize(String s) {
        int p = 0, n = s.length(), pre = 0, res = 0;
        while (p < n) {
            char c = s.charAt(p);
            int count = 0;
            while (p < n && s.charAt(p) == c) {
                p++;
                count++;
            }
            res += Math.min(count, pre);
            pre = count;
        }
        return res;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}