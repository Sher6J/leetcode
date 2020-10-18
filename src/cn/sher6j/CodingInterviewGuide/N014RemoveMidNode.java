package cn.sher6j.CodingInterviewGuide;

/**
 * 删除链表的中间节点和 a/b 处的节点
 * @author sher6j
 * @create 2020-10-18-18:45
 */
public class N014RemoveMidNode {
}

class RemoveMidNode {
    /**
     * 删除链表的中间节点：
     * 链表长度每增加2，要删除的节点就后移一个节点
     * @param head
     * @return
     */
    public ListNode removeMidNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        ListNode pre = head;
        ListNode cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
