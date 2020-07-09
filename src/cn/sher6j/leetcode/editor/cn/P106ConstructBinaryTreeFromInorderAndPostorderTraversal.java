//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组


package cn.sher6j.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：从中序与后序遍历序列构造二叉树
public class P106ConstructBinaryTreeFromInorderAndPostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
    private int[] postorder;
    private Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursive(postorder.length - 1, 0, inorder.length - 1);
    }

    /**
     *
     * @param post_root_idx 根节点在后序遍历中的索引
     * @param in_left_idx
     * @param in_right_idx
     * @return
     */
    public TreeNode recursive(int post_root_idx, int in_left_idx, int in_right_idx) {
        if (in_left_idx > in_right_idx) return null;
        TreeNode root = new TreeNode(this.postorder[post_root_idx]);
        int in_idx = map.get(this.postorder[post_root_idx]);
        root.right = recursive(post_root_idx - 1, in_idx + 1, in_right_idx);
        root.left = recursive(post_root_idx - (in_right_idx - in_idx + 1), in_left_idx, in_idx - 1);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}