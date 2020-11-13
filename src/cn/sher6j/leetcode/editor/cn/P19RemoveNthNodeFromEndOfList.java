//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针


package cn.sher6j.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：删除链表的倒数第N个节点————>倒数，我第一时间想到的就是栈
public class P19RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
        // TO TEST
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
        solution.removeNthFromEnd(head, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
//        return stackMethod(head, n);
//        return doublePointMethod(head, n);

        // 快慢指针最优解
        ListNode dummy = new ListNode(-1, head);

        ListNode fast = head;
        ListNode slow = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    /**
     * 法二：指针法
     * @param head
     * @param n
     * @return
     */
    private ListNode doublePointMethod(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        ListNode cur = head;
        while (cur != null) {
            n--;
            cur = cur.next;
        }
        if (n == 0) {
            head = head.next;
        } else if (n > 0) {
        } else if (n < 0) {
            cur = head;
            while (++n < 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    /**
     * 法一：用栈实现倒排
     * @param head
     * @param n
     * @return
     */
    private ListNode stackMethod(ListNode head, int n) {
        Deque<ListNode> stack = new LinkedList<>();
        ListNode temp = head;
        if (head == null) return head;
        //使用一个哑结点，防止删除的节点为头结点！
        ListNode dummy = new ListNode(-1);
        stack.addLast(dummy);
        while (temp != null) {
            stack.addLast(temp);
            temp = temp.next;
        }
        ListNode del = null;
        for (int i = 0; i < n; i++) {
            del = stack.pollLast();
        }
        ListNode pre = stack.pollLast();
        pre.next = del.next;
        if (stack.isEmpty()) {
            return dummy.next;
        }
        return head;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}