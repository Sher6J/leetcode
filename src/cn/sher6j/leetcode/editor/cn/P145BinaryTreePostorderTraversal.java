//给定一个二叉树，返回它的 后序 遍历。 
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
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树


package cn.sher6j.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//Java：二叉树的后序遍历
public class P145BinaryTreePostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P145BinaryTreePostorderTraversal().new Solution();
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
    public List<Integer> postorderTraversal(TreeNode root) {
//        return recursive(root);
        return stackMethod(root);
    }

    /**
     * 解法二：迭代
     * @param root
     * @return
     */
    private List<Integer> stackMethod(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<TreeNode> reverseStack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            reverseStack.push(curr);
            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }
        while (!reverseStack.isEmpty()) list.add(reverseStack.pop().val);
        return list;
    }

    /**
     * 解法一：递归
     * @param root
     * @return
     */
    private List<Integer> recursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        help(root, list);
        return list;
    }

    private void help(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left != null) help(root.left, list);
            if (root.right != null) help(root.right, list);
            list.add(root.val);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}