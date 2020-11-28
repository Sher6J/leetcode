//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表


package cn.sher6j.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

//Java：重排链表
public class P143ReorderList{
    public static void main(String[] args) {
        Solution solution = new P143ReorderList().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
//        stackMethod1(head);
//        stackPartMethod(head);
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = findLastOfLeftHalf(head);
        ListNode n1 = head;
        ListNode n2 = mid.next;
        mid.next = null;
        n2 = reverse(n2);
        merge(n1, n2);
    }

    private ListNode findLastOfLeftHalf(ListNode head) {
        ListNode left = head;
        ListNode cur = head;
        while (cur.next != null && cur.next.next != null) {
            left = left.next;
            cur = cur.next.next;
        }
        return left;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private void merge(ListNode n1, ListNode n2) {
        ListNode cur1 = n1;
        ListNode cur2 = n2;
        while (cur1 != null && cur2 != null) {
            ListNode tmp1 = cur1.next;
            ListNode tmp2 = cur2.next;

            cur1.next = cur2;
            cur1 = tmp1;

            cur2.next = cur1;
            cur2 = tmp2;
        }
    }

    /**
     * 法二：对法一进行空间改进，只讲右半区的数据放入栈中
     * @param head
     */
    private void stackPartMethod(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode right = head.next;
        ListNode cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        // right此时为链表右半区的第一个节点
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        cur = head;
        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            pop.next = cur.next;
            cur.next = pop;
            cur = cur.next.next;
        }
        if (cur != null) cur.next = null;
    }

    /**
     * 法一：将链表的全部数据放入栈中
     * @param head
     */
    private void stackMethod1(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        int total = 0;
        ListNode curr = head;
        while (curr != null) {
            total ++;
            stack.addLast(curr);
            curr = curr.next;
        }
        curr = head;
        for (int i = 0; i < total / 2; i++) {
            ListNode next = stack.pollLast();
            next.next = curr.next;
            curr.next = next;
            curr = curr.next.next;
        }
        if (curr != null) curr.next = null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}