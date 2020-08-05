//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。 
//
// 
//
// 为了让您更好地理解问题，以下面的二叉搜索树为例： 
//
// 
//
// 
//
// 
//
// 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是
//第一个节点。 
//
// 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。 
//
// 
//
// 
//
// 
//
// 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。 
//
// 
//
// 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-
//to-sorted-doubly-linked-list/ 
//
// 注意：此题对比原题有改动。 
// Related Topics 分治算法


package cn.sher6j.leetcode.editor.cn;

import java.util.ArrayList;

//Java：二叉搜索树与双向链表
public class POffer36ErChaSouSuoShuYuShuangXiangLianBiaoLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 36ErChaSouSuoShuYuShuangXiangLianBiaoLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
//        if (root == null) return null;
//        if (root.right == null && root.left == null) {
//            root.right = root;
//            root.left = root;
//            return root;
//        }
//        ArrayList<Node> list = new ArrayList<>();
//        inorder(list, root);
//        Node head = list.get(0);
//        Node tail = list.get(list.size() - 1);
//        head.left = tail;
//        head.right = list.get(1);
//        tail.right = head;
//        tail.left = list.get(list.size() - 2);
//        for (int i = 1; i < list.size() - 1; i++) {
//            Node node = list.get(i);
//            node.left = list.get(i - 1);
//            node.right = list.get(i + 1);
//        }
//        return head;
        return root; //因数据结构冲突故将代码注释，注释的代码为题解
    }

    public void inorder(ArrayList<Node> list, Node root) {
//        if (root != null) {
//            if (root.left != null) inorder(list, root.left);
//            list.add(root);
//            if (root.right != null) inorder(list, root.right);
//        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}