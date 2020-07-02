//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
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
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归


package cn.sher6j.leetcode.editor.cn;

import java.util.HashMap;

//Java：重建二叉树
public class POffer07ZhongJianErChaShuLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 07ZhongJianErChaShuLcof().new Solution();
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

    int[] preorder;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            this.map.put(inorder[i], i);
        }
        return recursive(0, 0, inorder.length - 1);
    }

    /**
     *
     * @param pre_root_idx 该递归层中的根节点对应于先序遍历的索引
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