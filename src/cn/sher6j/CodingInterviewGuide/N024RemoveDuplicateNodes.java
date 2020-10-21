package cn.sher6j.CodingInterviewGuide;

import java.util.HashSet;

/**
 * @author sher6j
 * @create 2020-10-21-15:21
 */
public class N024RemoveDuplicateNodes {
}

class RemoveDuplicateNodes {
    /**
     * 删除链表中的重复值节点
     * @param head
     */
    public void removeNodes(ListNode head) {
        if (head == null) {
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        ListNode pre = head, cur = head.next;
        set.add(head.val);
        while (cur != null) {
            if (set.contains(cur.val)) {
                pre.next = cur.next;
            } else {
                set.add(cur.val);
                pre = cur;
            }
            cur = cur.next;
        }
    }
}
