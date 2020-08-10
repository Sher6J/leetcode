//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法


package cn.sher6j.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Java：N皇后
public class P51NQueens{
    public static void main(String[] args) {
        Solution solution = new P51NQueens().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) return null;
        List<List<String>> res = new LinkedList<>();
        // 棋盘用二维char数组表示，明显更好处理，这里学习这种思想：
        // 整体数据结构不好处理时，将其子结构换个数据结构，然后进行整体转换
        char[][] board = new char[n][n];
        for (char[] perRow : board) Arrays.fill(perRow, '.');
        backtrack(board, 0, res);
        return res;
    }

    // 路径：board中小于row的那些行都已经适当的放置了皇后
    // 选择列表：第row行的所有列col都可以放置皇后，但要判断放置后是否冲突
    // 结束条件：row超过棋盘board的最后一行
    public void backtrack(char[][] board, int row, List<List<String>> res) {
        // if 满足结束条件 return
        if (row == board.length) {
            res.add(charToString(board));
            return;
        }
        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) continue; // 去掉不合法选择
            // 做选择
            board[row][col] = 'Q';
            // 回溯
            backtrack(board, row + 1, res);
            // 撤销选择
            board[row][col] = '.';
        }
    }

    /**
     * 判断是否可以在 board[row][col]放置皇后
     * @param board 棋盘
     * @param row 当前要放皇后的行
     * @param col 当前要放皇后的列
     * @return
     */
    public boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // 检查列上是否有冲突
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        // 检查副对角线是否有冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        // 检查对角线是否有冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    public List<String> charToString(char[][] board) {
        List<String> curRes = new LinkedList<>();
        for (char[] perRow : board) {
            curRes.add(String.valueOf(perRow));
        }
        return curRes;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}