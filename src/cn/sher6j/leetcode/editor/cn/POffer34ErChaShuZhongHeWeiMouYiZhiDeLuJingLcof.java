//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
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
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索


package cn.sher6j.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//Java：二叉树中和为某一值的路径
public class POffer34ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 34ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
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
        LinkedList<Integer> cur = new LinkedList<>();
        pathSum(root, sum, res, cur);
        return res;
    }

    public void pathSum(TreeNode root, int sum, List<List<Integer>> res, LinkedList<Integer> cur) {
        if (root == null) return;
        cur.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new LinkedList<>(cur));
            cur.removeLast();
            return;
        } else {
            pathSum(root.left, sum - root.val, res, cur);
            pathSum(root.right, sum - root.val, res, cur);
        }
        cur.removeLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}