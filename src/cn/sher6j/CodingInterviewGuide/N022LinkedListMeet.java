package cn.sher6j.CodingInterviewGuide;

/**
 * 判断两个单链表是否相交
 * 单链表可能有环，也可能无环
 * 要求：时间复杂度达到 O(M + N)，空间复杂度达到O(1)
 * @author sher6j
 * @create 2020-10-20-10:30
 */
public class N022LinkedListMeet {
}

class MeetOrNot {
    /**
     * 判断一个链表是否有环，若有返回第一个进入环的节点，没有则返回null
     * @param head
     * @return
     */
    private ListNode getLoopNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode slow = head.next, fast = head.next.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    private ListNode noLoop(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA, curB = headB;
        int n = 0; // 两个链表的长度差
        while (curA.next != null) {
            n++;
            curA = curA.next;
        }
        while (curB.next != null) {
            n--;
            curB = curB.next;
        }
        if (curA != curB) {
            return null;
        }
        curA = n > 0 ? headA : headB;
        curB = curA == headA ? headB : headA;
        n = Math.abs(n);
        while (n > 0) {
            n--;
            curA = curA.next;
        }
        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}
