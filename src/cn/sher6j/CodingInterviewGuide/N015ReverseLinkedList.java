package cn.sher6j.CodingInterviewGuide;

/**
 * 反转单链表或双向链表
 * @author sher6j
 * @create 2020-10-18-19:10
 */
public class N015ReverseLinkedList {
}

class ReverseList {
    /**
     * 反转单链表
     * @param head
     * @return
     */
    public ListNode reverseSinglyList(ListNode head) {
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
     * 反转双向链表
     * @param head
     * @return
     */
    public DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}

/**
 * 双向链表节点
 */
class DoubleNode {
    int val;
    DoubleNode last;
    DoubleNode next;

    public DoubleNode(int val) {
        this.val = val;
    }
}


