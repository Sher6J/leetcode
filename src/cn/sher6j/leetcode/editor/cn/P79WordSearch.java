//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法


package cn.sher6j.leetcode.editor.cn;
//Java：单词搜索
public class P79WordSearch{
    public static void main(String[] args) {
        Solution solution = new P79WordSearch().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int m;
    private int n;
    public boolean exist(char[][] board, String word) {
        if (board == null) return false;
        m = board.length;
        if (m == 0) return false;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(i, j, 0, visited, word, board)) return true;
            }
        }
        return false;
    }

    /**
     *
     * @param i
     * @param j
     * @param start
     * @param visited
     * @param word
     * @param board
     * @return
     */
    public boolean backtrack(int i, int j, int start, boolean[][] visited, String word, char[][] board) {
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }
        if (board[i][j] == word.charAt(start)) {
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newRow = i + direction[k][0];
                int newCol = j + direction[k][1];
                if (inArea(newRow, newCol) && !visited[newRow][newCol]) {
                    if (backtrack(newRow, newCol, start + 1, visited, word, board))
                        return true;
                }
            }
            visited[i][j] = false;
        }
        return false;
    }

    /**
     *
     * @param row
     * @param col
     * @return
     */
    public boolean inArea(int row, int col) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}