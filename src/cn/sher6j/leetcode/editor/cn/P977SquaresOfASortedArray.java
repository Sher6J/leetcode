//给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。 
//
// 
//
// 示例 1： 
//
// 输入：[-4,-1,0,3,10]
//输出：[0,1,9,16,100]
// 
//
// 示例 2： 
//
// 输入：[-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// -10000 <= A[i] <= 10000 
// A 已按非递减顺序排序。 
// 
// Related Topics 数组 双指针 
// 👍 147 👎 0


package cn.sher6j.leetcode.editor.cn;

import java.util.Arrays;

//Java：有序数组的平方
public class P977SquaresOfASortedArray{
    public static void main(String[] args) {
        Solution solution = new P977SquaresOfASortedArray().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] A) {
//        return sortMethod(A);
//        return doublePointMergeMethod(A);
        return doublePointMethod2(A);
    }

    /**
     * 法三：仍然双指针
     * 但是双指针从两边向中间移动
     * @param A
     * @return
     */
    private int[] doublePointMethod2(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        int idx = n - 1, i = 0, j = n - 1;
        while (i <= j) {
            if (A[i] * A[i] < A[j] * A[j]) {
                res[idx] = A[j] * A[j];
                j--;
            } else {
                res[idx] = A[i] * A[i];
                i++;
            }
            idx--;
        }
        return res;
    }

    /**
     * 法二：利用双指针模拟归并排序
     * 由于原数组有序，所以可以找到正数与负数的交界
     * @param A
     * @return
     */
    private int[] doublePointMergeMethod(int[] A) {
        int n = A.length;
        int neg = -1;
        for (int i = 0; i < n; i++) {
            if (A[i] < 0) {
                neg = i;
            } else {
                break;
            }
        }
        int[] res = new int[n];
        int idx = 0, left = neg, right = neg + 1;
        while (left >= 0 || right < n) {
            if (left < 0) {
                res[idx] = A[right] * A[right];
                right++;
            } else if (right >= n) {
                res[idx] = A[left] * A[left];
                left--;
            } else if (A[left] * A[left] < A[right] * A[right]) {
                res[idx] = A[left] * A[left];
                left--;
            } else {
                res[idx] = A[right] * A[right];
                right++;
            }
            idx++;
        }
        return res;
    }

    /**
     * 法一：直接将原数组平方，然后将平方后的数组排序
     * 时间复杂度：O(NlogN)
     * @param A
     * @return
     */
    private int[] sortMethod(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = A[i] * A[i];
        }
        Arrays.sort(res);
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}