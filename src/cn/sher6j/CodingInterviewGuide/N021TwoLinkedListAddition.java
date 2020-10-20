package cn.sher6j.CodingInterviewGuide;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 两个单链表生成相加链表
 * 如： 链表1：9 -> 3 -> 7
 *      链表2：6 -> 3
 *      结果 ：1 -> 0 -> 0 -> 0
 * @author sher6j
 * @create 2020-10-20-10:13
 */
public class N021TwoLinkedListAddition {
}

class LinkedAddition {

    /**
     * 法一：利用栈
     * 1. 将两个链表分别从左到右遍历，将值压栈，生成两个链表的逆序栈
     * 2. 将两个栈弹出再相加，关注进位
     * @param h1
     * @param h2
     * @return
     */
    public ListNode addList1(ListNode h1, ListNode h2) {
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        ListNode c1 = h1, c2 = h2;
        while (c1 != null) {
            s1.push(c1.val);
            c1 = c1.next;
        }
        while (c2 != null) {
            s2.push(c2.val);
            c2 = c2.next;
        }
        int carry = 0, n1 = 0, n2 = 0, n = 0;
        ListNode node = null, pre = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            n1 = s1.isEmpty() ? 0 : s1.pop();
            n2 = s2.isEmpty() ? 0 : s2.pop();
            n = n1 + n2 + carry;
            pre = node;
            node = new ListNode(n % 10);
            node.next = pre;
            carry = n > 9 ? 1 : 0;
        }
        if (carry == 1) {
            pre = node;
            node = new ListNode(1);
            node.next = pre;
        }
        return node;
    }
}
