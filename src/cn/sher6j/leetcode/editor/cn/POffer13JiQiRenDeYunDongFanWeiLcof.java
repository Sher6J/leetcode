//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
//


package cn.sher6j.leetcode.editor.cn;
//Java：机器人的运动范围
public class POffer13JiQiRenDeYunDongFanWeiLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 13JiQiRenDeYunDongFanWeiLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int movingCount(int m, int n, int k) {
        if (k < 0 || m <= 0 || n <= 0) return 0;
        boolean[] visited = new boolean[m * n];
        int count = movingCountCore(k, m, n, 0, 0, visited);
        return count;
    }

    public int movingCountCore(int k, int rows, int columns, int r, int c, boolean[] visited) {
        int count = 0;
        if (check(k, rows, columns, r, c, visited)) {
            visited[r * columns + c] = true;
            count = 1 + movingCountCore(k, rows, columns, r - 1, c, visited)
                      + movingCountCore(k, rows, columns, r + 1, c, visited)
                      + movingCountCore(k, rows, columns, r, c - 1, visited)
                      + movingCountCore(k, rows, columns, r, c + 1, visited);
        }
        return count;
    }

    boolean check(int k, int rows, int columns, int r, int c, boolean[] visited) {
        if (r >= 0 && r < rows && c >= 0 && c < columns
        && getDigitSum(r) + getDigitSum(c) <= k && !visited[r * columns + c]) {
            return true;
        }
        return false;
    }

    public int getDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}