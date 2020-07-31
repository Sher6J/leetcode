//给定一个整数矩阵，找出最长递增路径的长度。 
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。 
//
// 示例 1: 
//
// 输入: nums = 
//[
//  [9,9,4],
//  [6,6,8],
//  [2,1,1]
//] 
//输出: 4 
//解释: 最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2: 
//
// 输入: nums = 
//[
//  [3,4,5],
//  [3,2,6],
//  [2,2,1]
//] 
//输出: 4 
//解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
// Related Topics 深度优先搜索 拓扑排序 记忆化


package cn.sher6j.leetcode.editor.cn;
//Java：矩阵中的最长递增路径
public class P329LongestIncreasingPathInAMatrix{
    public static void main(String[] args) {
        Solution solution = new P329LongestIncreasingPathInAMatrix().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //记录图中节点运动的方向  {a, b}分别对应行和列
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int rows, columns;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        rows = matrix.length;
        columns = matrix[0].length;
        int[][] memo = new int[rows][columns]; //记忆化数组，记忆每个节点的最长递增路径
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                res = Math.max(res, dfs(matrix, i, j, memo));
            }
        }
        return res;
    }

    public int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) return memo[i][j];//记忆化数组免去重复搜索
        memo[i][j]++;
        for (int[] dir : dirs) {
            int newRow = i + dir[0], newCol = j + dir[1];
            if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < columns &&
                    matrix[newRow][newCol] > matrix[i][j]) {
                memo[i][j] = Math.max(memo[i][j], dfs(matrix, newRow, newCol, memo) + 1);
            }
        }
        return memo[i][j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}