//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索


package cn.sher6j.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//Java：二叉树的所有路径
public class P257BinaryTreePaths{
    public static void main(String[] args) {
        Solution solution = new P257BinaryTreePaths().new Solution();
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        buildPath(res, "", root);
        return res;
    }

    public void buildPath(List<String> res, String path, TreeNode root) {
        if (root != null) {
            StringBuilder sb = new StringBuilder(path);
            sb.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {
                res.add(sb.toString());
            } else {
                sb.append("->");
                buildPath(res, sb.toString(), root.left);
                buildPath(res, sb.toString(), root.right);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}