//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索


package cn.sher6j.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：从上到下打印二叉树 II
public class POffer32IICongShangDaoXiaDaYinErChaShuIiLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 32 - IICongShangDaoXiaDaYinErChaShuIiLcof().new Solution();
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> perLevel = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
//错误写法，虽然看似和上面相同，但是这种写法，queue.size()是变化的，并不是未遍历当前层时的queue大小
//            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                perLevel.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(perLevel);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}