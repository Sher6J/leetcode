//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//
//       1
//      / \
//     2   3
//
//输出: 6
// 
//
// 示例 2: 
//
// 输入: [-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出: 42 
// Related Topics 树 深度优先搜索


package cn.sher6j.leetcode.editor.cn;
//Java：二叉树中的最大路径和
public class P124BinaryTreeMaximumPathSum{
    public static void main(String[] args) {
        Solution solution = new P124BinaryTreeMaximumPathSum().new Solution();
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
    // 贡献值为从当前节点一直走到叶节点的路径的最大值
    // 结果为最大可折线路径的最大值

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return res;
    }

    public int maxGain(TreeNode node) {
        if (node == null) return 0; // 空节点贡献值为0
        int leftGain = Math.max(maxGain(node.left), 0); // 左孩子节点，若是负的干脆不走
        int rightGain = Math.max(maxGain(node.right),  0); // 右孩子节点

        // 以当前节点为折点的最大路径取决于该节点的值和该节点左右子节点的贡献值
        int currPrice = node.val + leftGain + rightGain;

        res = Math.max(res, currPrice);

        // 节点的最大贡献值，非空节点的最大贡献值等于该节点值与其子节点中的最大贡献值之和
        // 当本节点为叶节点时，其左孩子右孩子均为空，即leftGain = rightGain = 0
        // 对应 对于叶节点而言，最大贡献值等于节点值
        return node.val + Math.max(leftGain, rightGain); // 本节点 ---- 后序遍历
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}