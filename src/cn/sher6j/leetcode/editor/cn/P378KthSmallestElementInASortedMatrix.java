//给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。 
//请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例： 
//
// matrix = [
//   [ 1,  5,  9],
//   [10, 11, 13],
//   [12, 13, 15]
//],
//k = 8,
//
//返回 13。
// 
//
// 
//
// 提示： 
//你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。 
// Related Topics 堆 二分查找


package cn.sher6j.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

//Java：有序矩阵中第K小的元素
public class P378KthSmallestElementInASortedMatrix{
    public static void main(String[] args) {
        Solution solution = new P378KthSmallestElementInASortedMatrix().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
//        return to1DArray(matrix, k);
        return maxHeap(matrix, k);
    }

    /**
     * 法二：
     * 利用大根堆，在优先队列中只保存整个数组中k个最小的数，
     * 然后优先队列队头元素就是这k个元素中最大的数，即第k小的数
     * 时间复杂度：O(n^2·logk)
     * 空间复杂度：O(k)
     * @param matrix
     * @param k
     * @return
     */
    private int maxHeap(int[][] matrix, int k) {
        //优先队列默认调用remove方法，获取当前优先队列中最小的元素，即默认为小根堆，这里需要用大根堆
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                /**
                 * 优先队列中只保存k个数，且这k个数是所有数中k个较小的数
                 * 这样优先队列队头的数就是k个较小数中最大的数
                 * 也就是第k小的数
                 */
                if (maxPQ.size() == k && matrix[i][j] > maxPQ.peek()) break;
                maxPQ.add(matrix[i][j]);
                if (maxPQ.size() > k) maxPQ.remove();
            }
        }
        return maxPQ.remove();
    }

    /**
     * 法一：将二维数组转化为一维数组，然后排序即可
     * 时间复杂度：O(n^2·logn) 对n^2个数进行排序
     * 空间复杂度：O(n^2)
     * @param matrix
     * @param k
     * @return
     */
    private int to1DArray(int[][] matrix, int k) {
        int rows = matrix.length, columns = matrix[0].length;
        int[] sorted = new int[rows * columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sorted[i * columns + j] = matrix[i][j];
            }
        }
        Arrays.sort(sorted);
        return sorted[k - 1];
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}