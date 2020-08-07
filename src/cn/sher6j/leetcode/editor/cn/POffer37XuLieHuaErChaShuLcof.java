//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
//inary-tree/ 
// Related Topics 树 设计


package cn.sher6j.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//Java：序列化二叉树
public class POffer37XuLieHuaErChaShuLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 37XuLieHuaErChaShuLcof().new Solution();
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "$,";
        String leftSerialized = serialize(root.left);
        String rightSerialized = serialize(root.right);
        return root.val + "," + leftSerialized + rightSerialized;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeValues = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < nodeValues.length; i++) {
            queue.offer(nodeValues[i]);
        }
        return deserialize(queue);
    }

    public TreeNode deserialize(Queue<String> queue) {
        String rootValue = queue.poll();
        if (rootValue.equals("$")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(rootValue));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}