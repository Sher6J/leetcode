//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 递归


package cn.sher6j.leetcode.editor.cn;
//Java：青蛙跳台阶问题
public class POffer10IIQingWaTiaoTaiJieWenTiLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 10- IIQingWaTiaoTaiJieWenTiLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numWays(int n) {
        if (n == 0 || n == 1) return  1;
        int ppre = 1, pre = 1, res = 0;
        for (int i = 2; i <= n ; i++) {
            res = (ppre + pre) % 1000000007;
            ppre = pre;
            pre = res;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}