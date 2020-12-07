//有一个二维矩阵 A 其中每个元素的值为 0 或 1 。 
//
// 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。 
//
// 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。 
//
// 返回尽可能高的分数。 
//
// 
//
// 
// 
//
// 示例： 
//
// 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
//输出：39
//解释：
//转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
//0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20 
// 1 <= A[0].length <= 20 
// A[i][j] 是 0 或 1 
// 
// Related Topics 贪心算法 
// 👍 94 👎 0


package cn.sher6j.leetcode.editor.cn;
//Java：翻转矩阵后的得分
public class P861ScoreAfterFlippingMatrix{
    public static void main(String[] args) {
        Solution solution = new P861ScoreAfterFlippingMatrix().new Solution();
        int[] A = {1, 1, 1, 1};
        System.out.println(solution.sum(A));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 贪心：
     * 为了得到最高的分数，矩阵的每一行的最左边的数都必须为 1。
     * 为了做到这一点，我们可以翻转那些最左边的数不为 1 的那些行，而其他的行则保持不动。
     *
     * 当将每一行的最左边的数都变为 1 之后，就只能进行列翻转了。
     * 为了使得总得分最大，我们要让每个列中 1 的数目尽可能多。
     * 因此，我们扫描除了最左边的列以外的每一列，如果该列 0 的数目多于 1 的数目，就翻转该列，
     * 其他的列则保持不变。
     * @param A
     * @return
     */
    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = (A[i][j] == 0) ? 1 : 0;
                }
            }
        }
        int[] zeroInColumn = count(A);
        for (int j = 0; j < n; j++) {
            if (zeroInColumn[j] > m / 2) {
                for (int i = 0; i < m; i++) {
                    A[i][j] = (A[i][j] == 0) ? 1 : 0;
                }
            }
        }
        return sum(A);
    }

    private int[] count(int[][] A) {
        int[] res = new int[A[0].length];
        for (int j = 0; j < A[0].length; j++) {
            int cur = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i][j] == 0) {
                    cur++;
                }
            }
            res[j] = cur;
        }
        return res;
    }

    private int sum(int[][] A) {
        int res = 0;
        for (int[] a : A) {
            res += sum(a);
        }
        return res;
    }

    private int sum(int[] A) {
        int res = 0;
        for (int n : A) {
            res = (res << 1) + n;
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}