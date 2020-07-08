//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组


package cn.sher6j.leetcode.editor.cn;
//Java：顺时针打印矩阵
public class POffer29ShunShiZhenDaYinJuZhenLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 29ShunShiZhenDaYinJuZhenLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;
        int x = 0;
        int[] res = new int[matrix[0].length * matrix.length];
        while (true) {
            for (int i = left; i <= right; i++) {
                res[x++] = matrix[up][i];
            }
            if (++up > down) break;
            for (int i = up; i <= down; i++) {
                res[x++] = matrix[i][right];
            }
            if (--right < left) break;
            for (int i = right; i >= left ; i--) {
                res[x++] = matrix[down][i];
            }
            if (--down < up) break;
            for (int i = down; i >= up ; i--) {
                res[x++] = matrix[i][left];
            }
            if (++left > right) break;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}