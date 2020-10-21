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
     * 判断两个链表是否相交，若相交则返回第一个相交节点
     * 链表可能有环，也可能无环
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode loopA = getLoopNode(headA);
        ListNode loopB = getLoopNode(headB);
        if (loopA == null && loopB == null) {
            return noLoop(headA, headB);
        }
        if (loopA != null && loopB != null) {
            return bothLoop(headA, loopA, headB, loopB);
        }
        return null;
    }

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

    /**
     * 判断两个无环链表是否相交，相交则返回第一个相交的节点
     * @param headA A链表头节点
     * @param headB B链表头结点
     * @return 相交为第一个交点，否则为 null
     */
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

    /**
     * 判断两个有环链表是否相交，相交则返回第一个相交节点，否则返回 null
     * @param headA 链表A的头结点
     * @param loopA 链表A第一个进入环的节点
     * @param headB 链表B的头结点
     * @param loopB 链表B第一个进入环的节点
     * @return
     */
    private ListNode bothLoop(ListNode headA, ListNode loopA, ListNode headB, ListNode loopB) {
        ListNode curA = null;
        ListNode curB = null;
        if (loopA == loopB) {
            curA = headA;
            curB = headB;
            int n = 0;
            while (curA != loopA) {
                n++;
                curA = curA.next;
            }
            while (curB != loopB) {
                n--;
                curB = curB.next;
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
        } else {
            curA = loopA.next;
            while (curA != loopA) {
                if (curA == loopB) {
                    return loopA; // or return loopB
                }
                curA = curA.next;
            }
            return null;
        }
    }
}
