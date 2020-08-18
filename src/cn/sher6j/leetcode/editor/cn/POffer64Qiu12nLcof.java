//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。 
//
// 
//
// 示例 1： 
//
// 输入: n = 3
//输出: 6
// 
//
// 示例 2： 
//
// 输入: n = 9
//输出: 45
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10000 
// 
//


package cn.sher6j.leetcode.editor.cn;
//Java：求1+2+…+n
public class POffer64Qiu12nLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 64Qiu12nLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumNums(int n) {
        return n == 0 ? 0 : n + sumNums(n - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}