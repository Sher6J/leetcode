//编写一个程序，通过已填充的空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// Note: 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法


package cn.sher6j.leetcode.editor.cn;
//Java：解数独
public class P37SudokuSolver{
    public static void main(String[] args) {
        Solution solution = new P37SudokuSolver().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    /**
     * 回溯
     * @param board 数独盘
     * @param row 起始行
     * @param col 起始列
     * @return
     */
    public boolean backtrack(char[][] board, int row, int col) {
        int m = 9, n = 9;
        // 若该行回溯完则转到下一行的第一列
        if (col == n) {
            return backtrack(board, row + 1, 0);
        }
        if (row == m) {
            // 找到一个可行解，触发base case
            return true;
        }
        for (int i = row; i < m; i++) {
            for (int j = col; j < n; j++) {
                if (board[i][j] != '.') {
                    return backtrack(board, i, j + 1);
                }
                for (char c = '1'; c <= '9'; c++) {
                    if (!isValid(board, i, j, c)) continue;
                    board[i][j] = c; // 进行选择
                    if (backtrack(board, i, j + 1)) return true;
                    board[i][j] = '.'; // 撤销选择
                }
                return false;
            }
        }
        return false;
    }

    /**
     * 判断要插入的字符是否合法
     * @param board 数独盘
     * @param row 要插入的行
     * @param col 要插入的列
     * @param c 要插入的字符
     * @return
     */
    public boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // 判断所在行是否已存在该字符
            if (board[row][i] == c) return false;
            // 判断所在列是否已存在该字符
            if (board[i][col] == c) return false;
            // 判断所在9宫格是否已存在该字符
            if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == c) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}