//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学


package cn.sher6j.leetcode.editor.cn;
//Java：丑数
public class POffer49ChouShuLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 49ChouShuLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
//        return stupidMethod(n);
        return dpMethod(n);
    }

    /**
     * 法二：动态规划
     * @param n
     * @return
     */
    public int dpMethod(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }

    /**
     * 法一：暴力法     超时 通过 500/596 个测试用例
     * 遍历所有数字，直到找到第 n 个丑数
     * @param n
     * @return
     */
    public int stupidMethod(int n) {
        if (n == 1) return 1;
        int count = 1;
        int num = 1;
        while (count < n) {
            num++;
            if (isUglyNumber(num)) {
                count++;
            }
        }
        return num;
    }

    /**
     * 判断一个数是否为丑数
     * @param num
     * @return
     */
    public boolean isUglyNumber(int num) {
        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}