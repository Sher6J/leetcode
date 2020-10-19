package cn.sher6j.CodingInterviewGuide;

/**
 * 约瑟夫环形链表问题
 * 输入一个环形链表的头结点head和报数的值m
 * 输出最后生存下来的节点
 * @author sher6j
 * @create 2020-10-19-14:40
 */
public class N017JosephusProblem {
}

class Josephus {
    /**
     *
     * @param head 环形链表的头
     * @param m 报数的最大值
     * @return 存活下来的节点
     */
    public ListNode josuphusKill(ListNode head, int m) {
        if (head == null || head.next == head || m < 1) {
            return head;
        }
        ListNode last = head;
        // 找到头结点的上一个节点
        while (last.next != head) {
            last = last.next;
        }
        int cnt = 0;
        while (head != last) {
            if (++cnt == m) {
                last.next = head.next;
                cnt = 0;
            } else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }
}
