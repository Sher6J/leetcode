//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix.length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 哈希表 动态规划 
// 👍 649 👎 0


package cn.sher6j.leetcode.editor.cn;
//Java：最大矩形
public class P85MaximalRectangle{
    public static void main(String[] args) {
        Solution solution = new P85MaximalRectangle().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n];
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int n = heights.length;
        int[] leftLess = new int[n];
        int[] rightLess = new int[n];
        leftLess[0] = -1;
        rightLess[n - 1] = n;
        int res = 0;

        for (int i = 1; i < n; i++) {
            int l = i - 1;
            while (l >= 0 && heights[l] >= heights[i]) {
                l = leftLess[l];
            }
            leftLess[i] = l;
        }

        for (int i = n - 2; i >= 0; i--) {
            int r = i + 1;
            while (r < n && heights[r] >= heights[i]) {
                r = rightLess[r];
            }
            rightLess[i] = r;
        }

        for (int i = 0; i < n; i++) {
            res = Math.max(res, heights[i] * (rightLess[i] - leftLess[i] - 1));
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}