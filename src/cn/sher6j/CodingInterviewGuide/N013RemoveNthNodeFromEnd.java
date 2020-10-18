package cn.sher6j.CodingInterviewGuide;

/**
 * 在单链表和双链表中删除倒数第k个节点
 * @author sher6j
 * @create 2020-10-18-9:21
 */
public class N013RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        testSinglyNode();
    }

    /**
     * 测试单链表删除倒数第 2 个节点
     */
    private static void testSinglyNode() {
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
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
        RemoveNthNodeFromSinglyListEnd.removeLastNthNode(head, 2);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}

/**
 * 删除单链表的倒数第 n 个节点
 * 让链表从头开始走到尾，每移动一步，就让 n 减一
 * 当链表走到结尾时：
 *     > k > 0，则不用调整链表，因为链表根本没有倒数第 k 个节点
 *     > k = 0，则说明链表倒数第 k 个节点就是头结点，直接返回 head.next
 *     > k < 0：
 *          1. 重新从头节点开始走，每移动一步，就让 k 值加一
 *          2. 当 k = 0 时，移动停止，移动到的节点就是要删除的前一个节点
 */
class RemoveNthNodeFromSinglyListEnd {
    public static ListNode removeLastNthNode(ListNode head, int n) {
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
        } else if (n < 0) {
            cur = head;
            while (++n < 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}