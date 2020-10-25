//我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”： 
//
// 
// B.length >= 3 
// 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B
//[B.length - 1] 
// 
//
// （注意：B 可以是 A 的任意子数组，包括整个数组 A。） 
//
// 给出一个整数数组 A，返回最长 “山脉” 的长度。 
//
// 如果不含有 “山脉” 则返回 0。 
//
// 
//
// 示例 1： 
//
// 输入：[2,1,4,7,3,2,5]
//输出：5
//解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
// 
//
// 示例 2： 
//
// 输入：[2,2,2]
//输出：0
//解释：不含 “山脉”。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= A.length <= 10000 
// 0 <= A[i] <= 10000 
// 
// Related Topics 双指针 
// 👍 115 👎 0


package cn.sher6j.leetcode.editor.cn;
//Java：数组中的最长山脉
public class P845LongestMountainInArray{
    public static void main(String[] args) {
        Solution solution = new P845LongestMountainInArray().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestMountain(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] lDP = new int[n]; // 当前左边最多的长度
        int[] rDP = new int[n]; // 当前右边最多的长度
        lDP[0] = 0;
        rDP[n - 1] = 0;
        for (int i = 1; i < n; i++) {
            lDP[i] = A[i - 1] < A[i] ? lDP[i - 1] + 1 : 0;
        }
        for (int i = n - 2; i >= 0; i--) {
            rDP[i] = A[i + 1] < A[i] ? rDP[i + 1] + 1 : 0;
        }
        int res = 0;
        // 枚举山顶
        for (int i = 0; i < n; i++) {
            if (lDP[i] > 0 && rDP[i] > 0) {
                res = Math.max(res, lDP[i] + rDP[i] + 1);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}