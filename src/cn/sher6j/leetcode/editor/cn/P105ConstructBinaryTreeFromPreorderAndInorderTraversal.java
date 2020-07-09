//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组


package cn.sher6j.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：从前序与中序遍历序列构造二叉树
public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
    private int[] preorder;
    private Map<Integer, Integer> map = new HashMap<>(); //存储元素在中序遍历中的索引
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursive(0, 0, inorder.length - 1);
    }

    /**
     *
     * @param pre_root_idx 当前根节点在前序中的索引
     * @param in_left_idx
     * @param in_right_idx
     * @return
     */
    public TreeNode recursive(int pre_root_idx, int in_left_idx, int in_right_idx) {
        if (in_left_idx > in_right_idx) return null;
        TreeNode root = new TreeNode(this.preorder[pre_root_idx]);
        int in_idx = map.get(this.preorder[pre_root_idx]); // 得到根节点在中序遍历中的索引
        root.left = recursive(pre_root_idx + 1, in_left_idx, in_idx - 1);
        root.right = recursive(pre_root_idx + (in_idx - in_left_idx + 1), in_idx + 1, in_right_idx);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}