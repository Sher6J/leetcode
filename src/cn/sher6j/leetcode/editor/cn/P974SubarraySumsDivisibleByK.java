//给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。 
//
// 
//
// 示例： 
//
// 输入：A = [4,5,0,-2,-3,1], K = 5
//输出：7
//解释：
//有 7 个子数组满足其元素之和可被 K = 5 整除：
//[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 30000 
// -10000 <= A[i] <= 10000 
// 2 <= K <= 10000 
// 
// Related Topics 数组 哈希表


package cn.sher6j.leetcode.editor.cn;

import java.util.Arrays;

//Java：和可被 K 整除的子数组
public class P974SubarraySumsDivisibleByK{
    public static void main(String[] args) {
        Solution solution = new P974SubarraySumsDivisibleByK().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int length = A.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return (A[0] / K == 0) ? 1 : 0;
        }
        int[] preSum = new int[length + 1];
        int psum = 0;
        for (int i = 0; i < length; i++) {
            psum = psum + A[i];
            preSum[i + 1] = psum;
        }
        preSum[0] = 0;
        int count = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((preSum[j + 1] / K) == (preSum[i] / K)) {
                    count = count + 1;
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}