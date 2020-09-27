//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
// Related Topics 树


package cn.sher6j.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：二叉搜索树的最近公共祖先
public class P235LowestCommonAncestorOfABinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new P235LowestCommonAncestorOfABinarySearchTree().new Solution();
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        return twoTraversal(root, p, q);
        return oneTraversal(root, p, q);
    }

    /**
     * 法二：一次遍历
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode oneTraversal(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = root;
        while (true) {
            if (p.val < res.val && q.val < res.val) {
                res = res.left;
            } else if (p.val > res.val && q.val > res.val) {
                res = res.right;
            } else {
                break;
            }
        }
        return res;
    }

    /**
     * 法一：两次遍历
     * 先获得从根节点到两个节点的路径，然后两个路径第一个分叉节点即为所求
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode twoTraversal(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = getPath(p, root);
        List<TreeNode> pathQ = getPath(q, root);
        int m = pathP.size(), n = pathQ.size();
        TreeNode res = null;
        for (int i = 0; i < m && i < n; i++) {
            if (pathP.get(i) == pathQ.get(i)) {
                res = pathP.get(i);
            } else {
                break;
            }
        }
        return res;
    }

    /**
     * 获取从根节点到目标节点的路径
     * @param target
     * @param root
     * @return
     */
    public List<TreeNode> getPath(TreeNode target, TreeNode root) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            if (target.val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        path.add(node);
        return path;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}