//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组


package cn.sher6j.leetcode.editor.cn;

import java.util.Arrays;

//Java：柱状图中最大的矩形
public class P84LargestRectangleInHistogram{
    public static void main(String[] args) {
        Solution solution = new P84LargestRectangleInHistogram().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        int[] left_i = new int[heights.length];
        int[] right_i = new int[heights.length];
        left_i[0] = -1;
        right_i[heights.length-1] = heights.length;
//        int res[] = new int[heights.length];
        int res = 0;
        for (int i = 1; i < heights.length; i++) {
            int l = i - 1;
            while ((l >= 0) && (heights[l] >= heights[i])) {
                l = left_i[l];
            }
            left_i[i] = l;
        }
        for (int i = heights.length - 2; i >-1; i--) {
            int r = i + 1;
            while ((r <= heights.length - 1) && (heights[r] >= heights[i])) {
                r = right_i[r];
            }
            right_i[i] = r;
        }
//        for (int i = 0; i < heights.length; i++) {
//            res[i] = heights[i] * (right_i[i] - left_i[i] - 1);
//        }
//        Arrays.sort(res);
//        return res[heights.length - 1];
        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, heights[i] * (right_i[i] - left_i[i] - 1));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}