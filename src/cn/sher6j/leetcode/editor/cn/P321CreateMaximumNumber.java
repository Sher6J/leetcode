//给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接
//成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。 
//
// 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。 
//
// 说明: 请尽可能地优化你算法的时间和空间复杂度。 
//
// 示例 1: 
//
// 输入:
//nums1 = [3, 4, 6, 5]
//nums2 = [9, 1, 2, 5, 8, 3]
//k = 5
//输出:
//[9, 8, 6, 5, 3] 
//
// 示例 2: 
//
// 输入:
//nums1 = [6, 7]
//nums2 = [6, 0, 4]
//k = 5
//输出:
//[6, 7, 6, 0, 4] 
//
// 示例 3: 
//
// 输入:
//nums1 = [3, 9]
//nums2 = [8, 9]
//k = 3
//输出:
//[9, 8, 9] 
// Related Topics 贪心算法 动态规划 
// 👍 189 👎 0


package cn.sher6j.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：拼接最大数
public class P321CreateMaximumNumber{
    public static void main(String[] args) {
        Solution solution = new P321CreateMaximumNumber().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] res = new int[k];
        // minLen/maxLen：nums1中取的最短/长子序列长度
        int minLen = Math.max(0, k - n), maxLen = Math.min(k, m);
        for (int i = minLen; i <= maxLen; i++) {
            int[] subsequence1 = maxSubsequence(nums1, i);
            int[] subsequence2 = maxSubsequence(nums2, k - i);
            int[] curRes = merge(subsequence1, subsequence2);
            if (compare(curRes, 0, res, 0) > 0) {
                System.arraycopy(curRes, 0, res, 0, k);
            }
        }
        return res;
    }

    /**
     * 对 nums 保留 k 个数取最大子序列
     * @param nums
     * @param k
     * @return
     */
    private int[] maxSubsequence(int[] nums, int k) {
        int[] res = new int[k];
        // 要从数组中去除的元素数
        int remain = nums.length - k;

        Deque<Integer> deque = new LinkedList<>();
        for (int n : nums) {
            while (!deque.isEmpty() && remain > 0 && deque.peekLast() < n) {
                deque.pollLast();
                remain--;
            }
            deque.offerLast(n);
        }
        while (remain > 0) {
            deque.pollLast();
            remain--;
        }

        // 从单调递减栈中依次取出元素得到结果数组
        int idx = 0;
        while (!deque.isEmpty()) {
            res[idx++] = deque.pollFirst();
        }
        return res;
    }

    /**
     * 合并两个数组的最大子序列得到全局最大子序列
     * @param sequence1
     * @param sequence2
     * @return
     */
    private int[] merge(int[] sequence1, int[] sequence2) {
        int m = sequence1.length, n = sequence2.length;
        if (m == 0) {
            return sequence2;
        }
        if (n == 0) {
            return sequence1;
        }

        int[] res = new int[m + n];
        int idx1 = 0, idx2 = 0;

        for (int i = 0; i < (m + n); i++) {
            if (compare(sequence1, idx1, sequence2, idx2) > 0) {
                res[i] = sequence1[idx1++];
            } else {
                res[i] = sequence2[idx2++];
            }
        }

        return res;
    }

    /**
     * 比较 x 从 idx1 索引到结尾的子数组
     *   与 y 从 idx2 索引到结尾的子数组的大小
     * 如：
     *   x = [4, 6, 7, 2] , y = [4, 6, 7], 则 x > y;
     *   x = [4, 5, 7], y = [4, 6, 7], 则 x < y...
     * @param x
     * @param idx1
     * @param y
     * @param idx2
     * @return
     */
    private int compare(int[] x, int idx1, int[] y, int idx2) {
        int m = x.length, n = y.length;
        while (idx1 < m && idx2 < n) {
            int diff = x[idx1] - y[idx2];
            if (diff != 0) {
                return diff;
            }
            idx1++;
            idx2++;
        }
        if (idx1 == m && idx1 == n) {
            return 0;
        } else if (idx1 == m){
            return -1;
        } else {
            return 1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}