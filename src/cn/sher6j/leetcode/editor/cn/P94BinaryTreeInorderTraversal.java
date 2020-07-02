//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表


package cn.sher6j.leetcode.editor.cn;

import java.util.*;

//Java：二叉树的中序遍历
public class P94BinaryTreeInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
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
    public List<Integer> inorderTraversal(TreeNode root) {
        /**
         * 解法1：递归
         */
//        List res = new ArrayList();
//        help(root, res);
//        return res;

        /**
         * 解法2：迭代
         */
        List res = new ArrayList();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            //将节点及其左孩子一条线都入栈
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            //将栈顶元素弹出
            current = stack.pop();
            res.add(current.val);
            current = current.right;
        }
        return res;
    }

    public void help(TreeNode root, List res) {
        if (root != null) {
            if (root.left != null) {
                help(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                help(root.right, res);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}