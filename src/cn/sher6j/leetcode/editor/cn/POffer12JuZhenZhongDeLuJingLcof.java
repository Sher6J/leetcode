//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果
//一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。 
//
// [["a","b","c","e"], 
//["s","f","c","s"], 
//["a","d","e","e"]] 
//
// 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。 
//
// 
//
// 示例 1： 
//
// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "A
//BCCED"
//输出：true
// 
//
// 示例 2： 
//
// 输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 动态规划


package cn.sher6j.leetcode.editor.cn;
//Java：矩阵中的路径
public class POffer12JuZhenZhongDeLuJingLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 12JuZhenZhongDeLuJingLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    /**
     *
     * @param board 矩阵
     * @param word 给定字符串
     * @param i 矩阵中当前元素行
     * @param j 矩阵中当亲元素列
     * @param k 给定字符串当前字符索引
     * @return
     */
    public boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (i >= board.length || i < 0
        || j >= board[0].length || j < 0
        || board[i][j] != word.charAt(k)) return false;
        if (k == word.length() - 1) return true;
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i + 1, j, k + 1)
                    ||dfs(board, word, i - 1, j, k + 1)
                    ||dfs(board, word, i, j + 1, k + 1)
                    ||dfs(board, word, i, j - 1, k + 1);
        board[i][j] = tmp;
        return res;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}