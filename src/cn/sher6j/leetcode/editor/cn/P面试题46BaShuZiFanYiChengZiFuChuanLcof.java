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
public class P面试题46BaShuZiFanYiChengZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new P面试题46BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int translateNum(int num) {
        //递归出口是num只有1位数，就只能产生一种翻译字母的方式
        if (num <= 9) return 1;
        //以数字uvwxyz为例，yz为其最后两位数（十位和个位）
        int yz = num % 100;
        //如果yz ≥ 26，则必然不能分解为translateNum(uvwxy)和translateNum(uvwx)的和
        if (yz <= 9 || yz >= 26) return translateNum(num / 10);
        else return translateNum(num / 10) + translateNum(num / 100);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}