//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//] 
// Related Topics 数组 
// 👍 263 👎 0


package cn.sher6j.leetcode.editor.cn;
//Java：螺旋矩阵 II
public class P59SpiralMatrixIi{
    public static void main(String[] args) {
        Solution solution = new P59SpiralMatrixIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int max = n * n, num = 1;
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        while (num <= max) {
            for (int i = left; i <= right && num <= max; i++) {
                matrix[top][i] = num++;
            }
            top++;

            for (int i = top; i <= bottom && num <= max; i++) {
                matrix[i][right] = num++;
            }
            right--;

            for (int i = right; i >= left && num <= max; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;

            for (int i = bottom; i >= top && num <= max; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }

        return matrix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}