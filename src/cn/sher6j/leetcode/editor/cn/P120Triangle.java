//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划


package cn.sher6j.leetcode.editor.cn;

import java.util.List;

//Java：三角形最小路径和
public class P120Triangle{
    public static void main(String[] args) {
        Solution solution = new P120Triangle().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return dp1dMethod(triangle);
//        return dp2dMethod(triangle);
    }

    /**
     * 法二：动态规划 有空间优化
     * @param triangle
     * @return
     */
    public int dp1dMethod(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        if (triangle.size() == 1) return triangle.get(0).get(0);
        if (triangle.size() == 2)
            return triangle.get(0).get(0) + Math.min(triangle.get(1).get(0), triangle.get(1).get(1));
        int m = triangle.size(), n = triangle.get(m - 1).size();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(m - 1).get(i);
        }
        for (int i = m - 2; i >= 0; i--) {
            n--;
            for (int j = 0; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    /**
     * 法一：动态规划 没有空间优化
     * @param triangle
     * @return
     */
    public int dp2dMethod(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        if (triangle.size() == 1) return triangle.get(0).get(0);
        if (triangle.size() == 2)
            return triangle.get(0).get(0) + Math.min(triangle.get(1).get(0), triangle.get(1).get(1));
        int m = triangle.size(), n = triangle.get(m - 1).size();
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = triangle.get(m - 1).get(j);
        }
        for (int i = m - 2; i >= 0; i--) {
            n--;
            for (int j = 0; j < n; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}