//给定一个链表，判断链表中是否有环。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//
// 你能用 O(1)（即，常量）内存解决此问题吗？ 
// Related Topics 链表 双指针


package cn.sher6j.leetcode.editor.cn;

import java.util.HashSet;

//Java：环形链表
public class P141LinkedListCycle{
    public static void main(String[] args) {
        Solution solution = new P141LinkedListCycle().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
//        return hashSetMethod(head);

        return twoPointMethod(head);
    }

    /**
     * 将访问过的节点存入到哈希集中，遍历链表，
     *          如果有节点的next出现在已将访问过的哈希集中，
     *          则构成回路，
     *          但是此方法由于创建了一个新的HashSet，所以空间复杂度为O(n)，
     *          虽然通过了，但是并不符合题目希望的空间复杂度O(1)
     * @param head
     * @return
     */
    private boolean hashSetMethod(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        HashSet<Object> set = new HashSet<>();
        ListNode current = head;
        while (current.next != null) {
            set.add(current);
            current = current.next;
            if (set.contains(current)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 快慢指针法：
     *     龟兔赛跑，加入兔子不睡觉，赛道有环，兔子一定会追上乌龟
     * @param head
     * @return
     */
    private boolean twoPointMethod(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}