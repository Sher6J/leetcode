//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。 
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
// Related Topics 树 深度优先搜索


package cn.sher6j.leetcode.editor.cn;

import com.oracle.net.Sdp;

//Java：平衡二叉树
public class P110BalancedBinaryTree{
    public static void main(String[] args) {
        Solution solution = new P110BalancedBinaryTree().new Solution();
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
//        return fromUptoDown(root);
        return fromDowntoUp(root);
    }

    /**
     * 法二 自底向上递归
     * 当有下面的子树不平衡时，直接返回-1，然后false
     * @param root
     * @return
     */
    public boolean fromDowntoUp(TreeNode root) {
        return recursive(root) != -1;
    }

    public int recursive(TreeNode node) {
        if (node == null) return 0;
        int left = recursive(node.left);
        if (left == -1) return -1;
        int right = recursive(node.right);
        if (right == -1) return -1;
        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }

    /**
     * 法一 从顶至底递归
     * 容易想到，但是有大量重复计算，费时
     * 也就是说即使在底层已经出现了不是平衡树的树，但是算法还是会递归整个树
     * @param root
     * @return
     */
    public boolean fromUptoDown(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1
                && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}