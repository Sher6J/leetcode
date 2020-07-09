//二叉搜索树中的两个节点被错误地交换。 
//
// 请在不改变其结构的情况下，恢复这棵树。 
//
// 示例 1: 
//
// 输入: [1,3,null,null,2]
//
//   1
//  /
// 3
//  \
//   2
//
//输出: [3,1,null,null,2]
//
//   3
//  /
// 1
//  \
//   2
// 
//
// 示例 2: 
//
// 输入: [3,1,4,null,null,2]
//
//  3
// / \
//1   4
//   /
//  2
//
//输出: [2,1,4,null,null,3]
//
//  2
// / \
//1   4
//   /
//  3 
//
// 进阶: 
//
// 
// 使用 O(n) 空间复杂度的解法很容易实现。 
// 你能想出一个只使用常数空间的解决方案吗？ 
// 
// Related Topics 树 深度优先搜索


package cn.sher6j.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：恢复二叉搜索树
public class P99RecoverBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new P99RecoverBinarySearchTree().new Solution();
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
//    TreeNode x = null, y = null, pred = null;
    public void recoverTree(TreeNode root) {
//        findTwoSwapped(root);
//        swap(x, y);
        inorderMethod(root);
    }

    /**
     *
     * @param root
     */
    public void findTwoSwapped(TreeNode root) {
    }

    /**
     * 法一：由于二叉搜索树的中序遍历是有序的，所以！
     * 当我们对该树进行中序遍历时，
     *      中序遍历如果是有序的，则证明没有二叉搜索树中的节点被交换，直接返回即可
     *      若找到顺序不一致的两个下标i和j，将这两个节点的值互换即可
     * 如树中序遍历后为
     *      1 2 3 7 5 6 4
     *      则我们要找的 node1 为 7 ，node2 为 4，所以注意下面的node1和node2赋值的区别
     *      node1在第一次出现顺序不对时就赋值，而node2是在后一次出现时赋新值
     * @param root
     */
    public void inorderMethod(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        TreeNode node1 = null, node2 = null;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1).val < list.get(i).val) {
                node2 = list.get(i + 1);
                if (node1 == null) node1 = list.get(i);
            }
        }
        swap(node1, node2);
    }

    public void inorder(TreeNode node, List<TreeNode> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node);
        inorder(node.right, list);
    }
    public void swap(TreeNode node1, TreeNode node2) {
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}