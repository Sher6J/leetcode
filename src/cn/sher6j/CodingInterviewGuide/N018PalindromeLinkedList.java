package cn.sher6j.CodingInterviewGuide;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sher6j
 * @create 2020-10-19-14:46
 */
public class N018PalindromeLinkedList {
}

class PalindromeList {
    /**
     * 法一：利用栈
     * 从左到右遍历链表，遍历过程中把每个节点依次压栈
     * 从栈顶到栈底的节点值顺序为原链表逆序
     * 若为回文结构，则逆序次序相同
     * 若非回文结构，则逆序次序不同
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            ListNode pop = stack.pop();
            if (pop.val != cur.val) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    /**
     * 法二：利用栈
     * 思路和法一一样，但是只需要压入一半的数据
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode right = head.next;
        ListNode cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Deque<ListNode> stack = new ArrayDeque<>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        cur = head;
        while (!stack.isEmpty()) {
            if (cur.val != stack.pop().val) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    /**
     * 将链表右半区反转，然后比较左半区和右半区是否相等
     * 最后需要将链表复原
     * @param head
     * @return
     */
    public boolean isPalindrome3(ListNode head) {
        if (head == null) return true;
        ListNode firstHalfEnd = endOfFisrtHalf(head); //找到链表前一半的尾结点
        ListNode secondHalfStart = reverseList(firstHalfEnd.next); //反转后半部分链表

        ListNode n1 = head;
        ListNode n2 = secondHalfStart;

        while (n2 != null) {
            if (n1.val != n2.val) {
                firstHalfEnd.next = reverseList(secondHalfStart);
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        firstHalfEnd.next = reverseList(secondHalfStart); //将后半部分反转回原始状态
        return true;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {
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

    /**
     * 返回链表左半区的最后一个节点
     * @param head
     * @return
     */
    private ListNode endOfFisrtHalf(ListNode head) {
        ListNode left = head;
        ListNode cur = head;
        while (cur.next != null && cur.next.next != null) {
            left = left.next;
            cur = cur.next.next;
        }
        return left;
    }


}
