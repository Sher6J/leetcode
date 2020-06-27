//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
//判断数组中是否含有该整数。 
//
// 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// [
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
//
// 
//
// 限制： 
//
// 0 <= n <= 1000 
//
// 0 <= m <= 1000 
//
// 
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 
// Related Topics 数组 双指针


package cn.sher6j.leetcode.editor.cn;
//Java：二维数组中的查找
public class POffer04ErWeiShuZuZhongDeChaZhaoLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 04ErWeiShuZuZhongDeChaZhaoLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 首先选取数组中右上角的数字
     * 若该数字等于要查找的数字，则查找过程结束
     * 若该数字大于要查找的数字，则剔除这个数字所在的列
     * 若该数字小于要查找的数字，则剔除这个数字所在的行
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int r = 0;
        int c = columns - 1;
        while (r < rows && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            }
            else if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}