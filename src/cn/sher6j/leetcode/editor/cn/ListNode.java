package cn.sher6j.leetcode.editor.cn;

/**
 * 单链表的节点
 * @author sher6j
 * @create 2020-05-10-20:05
 */
public class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
