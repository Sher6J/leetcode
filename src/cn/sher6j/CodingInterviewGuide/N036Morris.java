package cn.sher6j.CodingInterviewGuide;

/**
 * @author sher6j
 * @create 2020-10-22-8:43
 */
public class N036Morris {
}

class ImplementOrderWithMorris {
    public void morris(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) { // 过程出口
            mostRight = cur.left;
            if (mostRight != null) { // cur有左子树
                // 找到cur左子树的最右节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // 如果mostRight.right == null，则让其指向cur
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left; // cur左移
                    continue; // 回到外层while循环
                } else { // mostRight == cur，则让其指向null
                    mostRight.right = null;
                }
            }
            // cur没有左子树或其左子树最右节点指向cur，均要将cur右移
            cur = cur.right;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}
