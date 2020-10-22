//给定一个二叉树，返回它的 前序 遍历。 
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
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树


package cn.sher6j.leetcode.editor.cn;

import java.util.*;

//Java：二叉树的前序遍历
public class P144BinaryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P144BinaryTreePreorderTraversal().new Solution();
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
    public List<Integer> preorderTraversal(TreeNode root) {
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
                    mostRight.right = cur;
                    list.add(cur.val); // 第一次到的时候打印
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null; // 第二次到的时候不打印
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
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            list.add(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return list;
    }

    /**
     * 法一：递归
     * @param root
     * @return
     */
    private List<Integer> recursiveMethod(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        help(root, list);
        return list;
    }

    public void help(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            if (root.left != null) {
                help(root.left, list);
            }
            if (root.right != null) {
                help(root.right, list);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}