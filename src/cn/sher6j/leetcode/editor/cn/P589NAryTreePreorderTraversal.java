//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


package cn.sher6j.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

//Java：N叉树的前序遍历
public class P589NAryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P589NAryTreePreorderTraversal().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        /**
         * 解法一：递归
         */
//        List<Integer> list = new ArrayList<>();
//        help(root, list);
//        return list;

        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            list.add(current.val);
            if (current.children != null) {
                Collections.reverse(current.children);
                for (Node node : current.children) {
                    stack.push(node);
                }
            }
        }
        return list;
    }

    public void help(Node root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            if (root.children != null) {
                for (Node node : root.children) {
                    help(node, list);
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}