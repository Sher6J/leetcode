//给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。 
//
// 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。 
//
// 返回一对观光景点能取得的最高分。 
//
// 
//
// 示例： 
//
// 输入：[8,1,5,2,6]
//输出：11
//解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
// 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length <= 50000 
// 1 <= A[i] <= 1000 
// 
// Related Topics 数组


package cn.sher6j.leetcode.editor.cn;
//Java：最佳观光组合
public class P1014BestSightseeingPair{
    public static void main(String[] args) {
        Solution solution = new P1014BestSightseeingPair().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        /**
         * 法一：暴力枚举，但是超时
         */
//        return timeLimitExceeded(A);

        /**
         * 法二： 在遍历时拆分为 A[i]+i 和 A[j]-j 两部分
         * 如果遍历 j 的时候，A[j]-j 是不变的，同时可以维护 A[i]+i
         */
        int max = Integer.MIN_VALUE;
        int iSum = A[0] + 0;
        for (int j = 1; j < A.length; j++) {
            max = Math.max(max, A[j] - j + iSum);
            iSum = Math.max(iSum, A[j] + j);
        }
        return max;
    }

    /**
     * 非常快的写出了暴力枚举，然后非常快的超时
     * @param A
     * @return
     */
    private int timeLimitExceeded(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                max = Math.max(max, A[i] + A[j] + i - j);
            }
        }
        return max;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}