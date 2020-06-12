//给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下： 
//
// 
// 二叉树的根是数组中的最大元素。 
// 左子树是通过数组中最大值左边部分构造出的最大二叉树。 
// 右子树是通过数组中最大值右边部分构造出的最大二叉树。 
// 
//
// 通过给定的数组构建最大二叉树，并且输出这个树的根节点。 
//
// 
//
// 示例 ： 
//
// 输入：[3,2,1,6,0,5]
//输出：返回下面这棵树的根节点：
//
//      6
//    /   \
//   3     5
//    \    / 
//     2  0   
//       \
//        1
// 
//
// 
//
// 提示： 
//
// 
// 给定的数组的大小在 [1, 1000] 之间。 
// 
// Related Topics 树


package cn.sher6j.leetcode.editor.cn;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

//Java：最大二叉树
public class P654MaximumBinaryTree{
    public static void main(String[] args) {
        Solution solution = new P654MaximumBinaryTree().new Solution();
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        /**
         * 法一：递归
         */
//        return construct(nums, 0, nums.length);

        /**
         * 法二：单调栈
         */
        TreeNode[] treeNodes = new TreeNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            treeNodes[i] = new TreeNode(nums[i]);
        }
        Deque<TreeNode> stack = new LinkedList<>();
        HashMap<TreeNode, TreeNode> leftBigMap = new HashMap<>(); //存储节点左边第一个比节点大的节点
        HashMap<TreeNode, TreeNode> rightBigMap = new HashMap<>(); //存储节点右边第一个比节点大的节点
        for (int i = 0; i < nums.length; i++) {
            TreeNode currNode = treeNodes[i];
            while (!stack.isEmpty() && stack.peek().val < currNode.val) {
                popStackAndSetMap(stack, leftBigMap);
            }
            stack.push(currNode);
        }
        while (!stack.isEmpty()) {
            popStackAndSetMap(stack, leftBigMap);
        }
        for (int i = nums.length - 1; i > -1 ; i--) {
            TreeNode currNode = treeNodes[i];
            while (!stack.isEmpty() && stack.peek().val < currNode.val) {
                popStackAndSetMap(stack, rightBigMap);
            }
            stack.push(currNode);
        }
        while (!stack.isEmpty()) {
            popStackAndSetMap(stack, rightBigMap);
        }
        TreeNode head = null;
        for (int i = 0; i < nums.length; i++) {
            TreeNode currNode = treeNodes[i];
            TreeNode left = leftBigMap.get(currNode);
            TreeNode right = rightBigMap.get(currNode);
            if (left == null && right == null) head = currNode;
            else if (left == null) {
                right.left = currNode;
            } else if (right == null) {
                left.right = currNode;
            } else {
                TreeNode parent = null;
                boolean flag = left.val < right.val;
                if (flag) {
                    parent = left;
                    parent.right = currNode;
                } else {
                    parent = right;
                    parent.left = currNode;
                }
            }
        }
        return head;
    }

    /**
     * 出栈并设置相应的HashMap，用于法二
     * @param stack
     * @param map
     */
    private void popStackAndSetMap(Deque<TreeNode> stack, HashMap<TreeNode, TreeNode> map) {
        TreeNode pop = stack.pop();
        if (stack.isEmpty()) map.put(pop, null);
        else map.put(pop, stack.peek());
    }

    /**
     * 构建数组指定部分的最大树，用于法一
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private TreeNode construct(int[] nums, int left, int right) {
        if (left >= right) return null;
        int max_index = maxIndex(nums, left, right);
        TreeNode root = new TreeNode(nums[max_index]);
        root.left = construct(nums, left, max_index);
        root.right = construct(nums, max_index + 1, right);
        return root;
    }

    /**
     * 在数组指定部分得到其最大值对应索引，用于法一
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int maxIndex(int[] nums, int left, int right) {
        int max_index = left;
        for (int i = left; i < right; i++) {
            if (nums[max_index] < nums[i]) max_index = i;
        }
        return max_index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}