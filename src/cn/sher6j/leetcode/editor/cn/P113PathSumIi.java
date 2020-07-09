//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索


package cn.sher6j.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//Java：路径总和 II
public class P113PathSumIi{
    public static void main(String[] args) {
        Solution solution = new P113PathSumIi().new Solution();
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        pathSum(root, sum, res, cur);
        return res;
    }
    public void pathSum(TreeNode root, int sum, List<List<Integer>> res, List<Integer> cur) {
        if (root == null) return; // 得到结果向上返回
        cur.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new LinkedList<>(cur));
            cur.remove(cur.size() - 1); //去掉当前结果中的最后一个，然后进行下一个回溯
            return; // 得到结果向上返回
        } else {
            pathSum(root.left, sum - root.val, res, cur);
            pathSum(root.right, sum - root.val, res, cur);
        }
        cur.remove(cur.size() - 1); //当前不对也去掉最后一个，尝试下一个回溯
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}