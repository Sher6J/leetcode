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
//        return recursiveMethod(root);
//        return loopMethod(root);
        return morrisMethod(root);
    }

    /**
     * 法三：Morris遍历
     * @param root
     * @return
     */
    private List<Integer> morrisMethod(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) { // 到达两次的节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur; // 第一次到的时候不打印
                    cur = cur.left;
                    continue;
                } else {
                    list.add(cur.val);
                    mostRight.right = null; // 第二次到的时候打印
                }
            } else { // 到达一次的节点
                list.add(cur.val);
            }
            cur = cur.right;
        }
        return list;
    }
    /**
     * 法二：迭代，用栈
     * @param root
     * @return
     */
    private List<Integer> loopMethod(TreeNode root) {
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

    /**
     * 法一：递归
     * @param root
     * @return
     */
    private List<Integer> recursiveMethod(TreeNode root) {
        List res = new ArrayList();
        help(root, res);
        return res;
    }

    public void help(TreeNode node, List list) {
//        if (root != null) {
//            if (root.left != null) {
//                help(root.left, res);
//            }
//            res.add(root.val);
//            if (root.right != null) {
//                help(root.right, res);
//            }
//        }
        if (node == null) return;
        help(node.left, list);
        list.add(node.val);
        help(node.right, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}