//给定一个二叉树，原地将它展开为一个单链表。 
//
// 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索


package cn.sher6j.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：二叉树展开为链表
public class P114FlattenBinaryTreeToLinkedList{
    public static void main(String[] args) {
        Solution solution = new P114FlattenBinaryTreeToLinkedList().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        changeNode(root);
//        preOrder(root);
    }

    /**
     * 法二：
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     *
     * //将 1 的左子树插入到右子树的地方
     *     1
     *      \
     *       2         5
     *      / \         \
     *     3   4         6
     * //将原来的右子树接到左子树的最右边节点
     *     1
     *      \
     *       2
     *      / \
     *     3   4
     *          \
     *           5
     *            \
     *             6
     *
     *  //将 2 的左子树插入到右子树的地方
     *     1
     *      \
     *       2
     *        \
     *         3       4
     *                  \
     *                   5
     *                    \
     *                     6
     *
     *  //将原来的右子树接到左子树的最右边节点
     *     1
     *      \
     *       2
     *        \
     *         3
     *          \
     *           4
     *            \
     *             5
     *              \
     *               6
     *
     *   ......
     * @param root
     */
    private void changeNode(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            //左子树为空，直接考虑下一个节点
            if (cur.left == null) cur = cur.right;
            //左子树不为空
            else {
                TreeNode rightestNode = cur.left;
                //找到左子树的最右边节点
                while (rightestNode.right != null) rightestNode = rightestNode.right;
                //将原来的右子树接到左子树的最右边节点
                rightestNode.right = cur.right;
                //将左子树插到原来右子树的地方
                cur.right = cur.left;
                cur.left = null;
                cur = cur.right;
            }
        }
    }

    /**
     * 法一：结果的树其实就是二叉树的先序遍历，所以我们可以得到二叉树的先序遍历
     * 然后利用先序遍历重排二叉树，注意需要将二叉树节点的左孩子置为空！
     * @param root
     */
    public void preOrder(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        List<TreeNode> list = new ArrayList<>();
        help(root, list);
        TreeNode cur = root;
        cur.left = null;
        for (int i = 1; i < list.size(); i++) {
            TreeNode node = list.get(i);
            node.left = null;
            cur.right = node;
            cur = cur.right;
        }
    }

    public void help(TreeNode node, List<TreeNode> list) {
        if (node == null) return;
        list.add(node);
        help(node.left, list);
        help(node.right, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}