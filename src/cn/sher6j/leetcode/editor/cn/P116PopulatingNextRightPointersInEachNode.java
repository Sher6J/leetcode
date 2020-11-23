//给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下： 
//
// struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 示例： 
//
// 
//
// 输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"ri
//ght":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right
//":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left"
//:null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":nu
//ll,"next":null,"right":null,"val":7},"val":3},"val":1}
//
//输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4
//","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next"
//:null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":
//null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":
//"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"va
//l":1}
//
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
// 
//
// 
//
// 提示： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
// Related Topics 树 深度优先搜索


package cn.sher6j.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//Java：填充每个节点的下一个右侧节点指针
public class P116PopulatingNextRightPointersInEachNode{
    public static void main(String[] args) {
        Solution solution = new P116PopulatingNextRightPointersInEachNode().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
    public Node connect(Node root) {
//        return method1Recursive(root);
//        return method2LevelOrder(root);
        if (root == null) {
            return root;
        }

        Node leftMost = root;

        while (leftMost.left != null) {
            Node cur = leftMost;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    /**
     * 法二：利用层序遍历
     * @param root
     * @return
     */
    public Node method2LevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                Node cur = queue.poll();
                if (i > 1) {
                    cur.next = queue.peek();
                }
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
        }
        return root;
    }

    /**
     * 法一：递归，也即深度优先
     * @param root
     * @return
     */
    public Node method1Recursive(Node root) {
        if (root == null) return null;
        // root.next 肯定为null，只需考虑连接其子节点
        connectTwoNode(root.left, root.right);
        return root;
    }

    /**
     * 连接两个相邻节点
     * @param n1
     * @param n2
     */
    public void connectTwoNode(Node n1, Node n2) {
        if (n1 == null || n2 == null) return;

        n1.next = n2;

        // 连接同父节点的子节点
        connectTwoNode(n1.left, n1.right);
        connectTwoNode(n2.left, n2.right);
        // 连接跨越父节点的两个子节点，如例图中的5、6节点
        connectTwoNode(n1.right, n2.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}