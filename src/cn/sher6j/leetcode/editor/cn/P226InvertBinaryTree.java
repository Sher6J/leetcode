//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树


package cn.sher6j.leetcode.editor.cn;
//Java：翻转二叉树
public class P226InvertBinaryTree{
    public static void main(String[] args) {
        Solution solution = new P226InvertBinaryTree().new Solution();
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
    public TreeNode invertTree(TreeNode root) {
//        return method1(root);
        return method2(root);
    }

    /**
     * 递归二：利用前序遍历
     * @param root
     * @return
     */
    public TreeNode method2(TreeNode root) {
        // base case
        if (root == null) return null;

        // 只考虑当前节点情况，且为前序遍历
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left); // 左子树递归
        invertTree(root.right); // 右子树递归

        return root;
    }


    /**
     * 递归法一：利用后续遍历
     * @param root
     * @return
     */
    public TreeNode method1(TreeNode root) {
        // base case
        if (root == null) return null;

        TreeNode left = invertTree(root.left); // 递归左子树
        TreeNode right = invertTree(root.right); // 递归右子树

        // 当前递归逻辑，且为后续遍历
        root.left = right;
        root.right = left;

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}