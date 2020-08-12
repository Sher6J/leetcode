//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 231 
// 
//


package cn.sher6j.leetcode.editor.cn;
//Java：把数字翻译成字符串
public class POffer46BaShuZiFanYiChengZiFuChuanLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 46BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int translateNum(int num) {
//        return recursiveMethod(num);
        if (num < 0) return 0;
        String str = String.valueOf(num);
        return translateNum(str);
    }

    /**
     * 法二：动态规划
     * dp[i]，数字的第 i 位尅是到最后一位的子部分的翻译方法数
     * base case： dp[n - 1] = 0, dp[n - 2] = 1
     * 对于 dp[i] ：
     *      ① 若 nums[i - i+1] 在 [10, 25] 则 dp[i] = dp[i + 1] + dp[i + 2]
     *      ② 否则 dp[i] = dp[i + 1]
     * return：dp[0]
     * @param str
     * @return
     */
    public int translateNum(String str) {
        int len = str.length();
        int dp[] = new int[len];
        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (i < len - 1) count = dp[i + 1];
            else count = 1;
            if (i < len - 1) {
                int digit1 = str.charAt(i) - '0';
                int digit2 = str.charAt(i + 1) - '0';
                int converted = digit1 * 10 + digit2;
                if (converted >= 10 && converted <= 25) {
                    if (i < len - 2) count += dp[i + 2];
                    else count += 1;
                }
            }
            dp[i] = count;
        }
        return dp[0];
    }

    /**
     * 法一：递归
     * @param num
     * @return
     */
    public int recursiveMethod(int num) {
        // 递归出口：num只有1位数，就只能产生一种翻译方式
        if (num <= 9) return 1;
        // 若数组为 uvwxyz， yz 为其最后两位
        int yz = num % 100;
        // 若 yz ≥ 26， 则必然不能分解为 uvwx 和 yz 的和
        if (yz <= 9 || yz >= 26) return translateNum(num / 10);
        else return translateNum(num / 10) + translateNum(num / 100);
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}