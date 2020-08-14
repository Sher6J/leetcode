//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树


package cn.sher6j.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：二叉搜索树的第k大节点
public class POffer54ErChaSouSuoShuDeDiKdaJieDianLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 54ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
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

    private int count;
    private int res = -1;

    public int kthLargest(TreeNode root, int k) {
        return partInorderMethod(root, k);
//        return wholeInorderMethod(root, k);
    }

    /**
     * 法二：逆中序遍历，遍历过程中遇到遍历的第 k 个节点，直接返回，不继续遍历
     * 注意，这里 count 一定要用 this
     * 否则在递归栈中 count 不好控制
     * @param root
     * @param k
     * @return
     */
    public int partInorderMethod(TreeNode root, int k) {
        this.count = k;
        inorder(root);
        return this.res;
    }

    public void inorder(TreeNode root) {
        if (root ==  null) return;
        inorder(root.right);
        if (this.count == 1) {
            this.res = root.val;
            this.count--;
            return;
        }
        count--;
        inorder(root.left);
    }

    /**
     * 法一：得到整个遍历的中序遍历/逆中序遍历
     * 中序：左中右，升序，返回第 len-k 个元素
     * 逆中序：右中左，降序，返回第 k-1 个元素
     * @param root
     * @param k
     * @return
     */
    public int wholeInorderMethod(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;
        inorder(node, list);
        int len = list.size();
        return list.get(len - k);
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}