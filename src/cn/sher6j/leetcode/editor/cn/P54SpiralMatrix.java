//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。 
//
// 示例 1: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2: 
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组 
// 👍 543 👎 0


package cn.sher6j.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//Java：螺旋矩阵
public class P54SpiralMatrix{
    public static void main(String[] args) {
        Solution solution = new P54SpiralMatrix().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();

        if (matrix == null || matrix.length == 0) {
            return res;
        }

        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        int numCount = m * n;

        while (numCount >= 1) {
            for (int i = left; i <= right && numCount >= 1; i++) {
                res.add(matrix[top][i]);
                numCount--;
            }
            top++;

            for (int i = top; i <= bottom && numCount >= 1; i++) {
                res.add(matrix[i][right]);
                numCount--;
            }
            right--;

            for (int i = right; i >= left && numCount >= 1; i--) {
                res.add(matrix[bottom][i]);
                numCount--;
            }
            bottom--;

            for (int i = bottom; i >= top && numCount >= 1; i--) {
                res.add(matrix[i][left]);
                numCount--;
            }
            left++;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}