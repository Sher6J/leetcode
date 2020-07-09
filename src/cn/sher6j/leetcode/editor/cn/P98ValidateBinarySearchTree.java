//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索


package cn.sher6j.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：验证二叉搜索树
public class P98ValidateBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new P98ValidateBinarySearchTree().new Solution();
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
    public boolean isValidBST(TreeNode root) {
        /**
         * 法二 递归
         */
        return helper(root, null, null);
//        return inorderMethod(root);
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;
        int value = node.val;
        if (lower != null && value <= lower) return false;
        if (upper != null && value >= upper) return false;
        if (!helper(node.left, lower, value)) return false;
        if (!helper(node.right, value, upper)) return false;
        return true;
    }

    /**
     * 法一 由于二叉搜索树的中序遍历严格升序，
     * 所以如果其中序遍历不是升序，就不是一棵二叉搜索树
     * @param root
     * @return
     */
    public boolean inorderMethod(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        help(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) return false;
        }
        return true;
    }

    public void help(TreeNode node, List<Integer> list) {
        if (node == null) return;
        help(node.left, list);
        list.add(node.val);
        help(node.right, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}