//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。 
//
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
//
// 限制： 
//
// 
// 1 <= 树的结点个数 <= 10000 
// 
//
// 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/ 
//
// 
// Related Topics 树 深度优先搜索


package cn.sher6j.leetcode.editor.cn;
//Java：平衡二叉树
public class POffer55IIPingHengErChaShuLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 55 - IIPingHengErChaShuLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
//        return fromUpToDown(root);
        return recursive(root) != -1;
    }

    /**
     * 法二：自底下上————后序遍历
     * 判断当前节点孩子是否满足平衡树
     * 若孩子已经不平衡，则当前不可能平衡，可提前返回
     * @param root
     * @return
     */
    public int recursive(TreeNode root) {
        if (root == null) return 0;
        int left = recursive(root.left);
        if (left == -1) return -1;
        int right = recursive(root.right);
        if (right == -1) return -1;
        int depthDif = left - right;
        if (depthDif > 1 || depthDif < -1) return -1;
        return Math.max(left, right) + 1;
    }



    /**
     * 法一：自顶向下————先序遍历
     * 判断当前节点是否满足平衡树；
     * 再判断其左右孩子是否满足平衡树。
     * 缺点：孩子节点会被重复判断，有大量重复计算。
     * @param root
     * @return
     */
    public boolean fromUpToDown(TreeNode root) {
        if (root == null) return true;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        int depthDif = leftDepth - rightDepth;
        if (depthDif > 1 || depthDif < -1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}