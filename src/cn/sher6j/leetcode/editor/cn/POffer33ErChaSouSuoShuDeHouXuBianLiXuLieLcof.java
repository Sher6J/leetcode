//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
//


package cn.sher6j.leetcode.editor.cn;
//Java：二叉搜索树的后序遍历序列
public class POffer33ErChaSouSuoShuDeHouXuBianLiXuLieLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 33ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorder(int[] order, int left, int right) {
        if (left >= right) return true;
        int mid = left;
        while (order[mid] < order[right]) mid++;
        int p = mid;
        while (order[p] > order[right]) p++;
        return p == right && verifyPostorder(order, left, mid - 1) && verifyPostorder(order, mid, right - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}