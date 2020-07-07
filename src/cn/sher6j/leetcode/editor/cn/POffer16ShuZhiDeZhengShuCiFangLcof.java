//实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数
//问题。 
//
// 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归


package cn.sher6j.leetcode.editor.cn;
//Java：数值的整数次方
public class POffer16ShuZhiDeZhengShuCiFangLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 16ShuZhiDeZhengShuCiFangLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }

//    public double pow(double x, int n) {
//        if (n == 0) return 1;
//        if (n == 1) return x;
//        else if (n % 2 == 0) return pow(x, n / 2) * pow(x, n / 2);
//        else return pow(x, (n - 1) / 2) * pow(x, (n - 1) / 2) * x;
//    }


    public double pow(double x, int n) {
        double res = 1;
        for (int i = 0; i < n; i++) {
            res *= x;
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}