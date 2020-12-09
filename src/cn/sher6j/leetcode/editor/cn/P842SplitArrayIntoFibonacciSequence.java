//给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。 
//
// 形式上，斐波那契式序列是一个非负整数列表 F，且满足： 
//
// 
// 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）； 
// F.length >= 3； 
// 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。 
// 
//
// 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。 
//
// 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。 
//
// 
//
// 示例 1： 
//
// 输入："123456579"
//输出：[123,456,579]
// 
//
// 示例 2： 
//
// 输入: "11235813"
//输出: [1,1,2,3,5,8,13]
// 
//
// 示例 3： 
//
// 输入: "112358130"
//输出: []
//解释: 这项任务无法完成。
// 
//
// 示例 4： 
//
// 输入："0123"
//输出：[]
//解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
// 
//
// 示例 5： 
//
// 输入: "1101111"
//输出: [110, 1, 111]
//解释: 输出 [11,0,11,11] 也同样被接受。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 字符串 S 中只含有数字。 
// 
// Related Topics 贪心算法 字符串 回溯算法 
// 👍 184 👎 0


package cn.sher6j.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//Java：将数组拆分成斐波那契序列
public class P842SplitArrayIntoFibonacciSequence{
    public static void main(String[] args) {
        Solution solution = new P842SplitArrayIntoFibonacciSequence().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        LinkedList<Integer> res = new LinkedList<>();
        int n = S.length();
        backtrack(res, S, n, 0, 0, 0);
        return res;
    }

    private boolean backtrack(LinkedList<Integer> res, String S, int len, int idx, int prevTwoSum, int prev) {
        if (idx == len) {
            return res.size() >= 3;
        }
        long cur = 0;
        for (int i = idx; i < len; i++) {
            if (i > idx && S.charAt(idx) == '0') {
                break;
            }
            cur = cur * 10 + S.charAt(i) - '0';
            if (cur > Integer.MAX_VALUE) {
                break;
            }
            int curNum = (int) cur;
            if (res.size() >= 2) {
                if (curNum < prevTwoSum) {
                    continue;
                }
                if (curNum > prevTwoSum) {
                    break;
                }
            }
            res.add(curNum);
            if (backtrack(res, S, len, i + 1, curNum + prev, curNum)) {
                return true;
            }
            res.removeLast();
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}