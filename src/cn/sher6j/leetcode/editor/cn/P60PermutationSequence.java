//给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 说明： 
//
// 
// 给定 n 的范围是 [1, 9]。 
// 给定 k 的范围是[1, n!]。 
// 
//
// 示例 1: 
//
// 输入: n = 3, k = 3
//输出: "213"
// 
//
// 示例 2: 
//
// 输入: n = 4, k = 9
//输出: "2314"
// 
// Related Topics 数学 回溯算法


package cn.sher6j.leetcode.editor.cn;
//Java：第k个排列
public class P60PermutationSequence{
    public static void main(String[] args) {
        Solution solution = new P60PermutationSequence().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n + 1]; // 记录数字是否使用过
        int[] factorial = new int[n + 1]; // 阶乘数组
        calculateFactorial(n, factorial);
        StringBuilder path = new StringBuilder();
        dfs(0, path, n, k, factorial, used);
        return path.toString();
    }

    /**
     *
     * @param idx 在这一步前已经选择的数字个数
     * @param path
     * @param n
     * @param k
     * @param factorial
     * @param used
     */
    public void dfs(int idx, StringBuilder path, int n, int k, int[] factorial, boolean[] used) {
        if (idx == n) return;
        // 计算还未确定（未被选择）的数字的全排列的个数，
        int cnt = factorial[n - 1 - idx];
        for (int i = 1; i <= n; i++) {
            if (used[i]) continue;
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            path.append(i);
            used[i] = true;
            dfs(idx + 1, path, n, k, factorial, used);
            return;
        }
    }

    public void calculateFactorial(int n, int[] factorial) {
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}