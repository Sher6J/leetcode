//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
// Related Topics 排序 链表 
// 👍 788 👎 0


package cn.sher6j.leetcode.editor.cn;
//Java：排序链表
public class P148SortList{
    public static void main(String[] args) {
        Solution solution = new P148SortList().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
//        return selectSort(head);
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = endOfFisrtHalf(head);
        ListNode rightHead = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        return mergeTwoLists(left, right);
    }

    /**
     * 找到链表中间节点（左半区最后一个节点）
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

    /**
     * 合并两个有序单链表
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); //开辟节点表示新的链表
        ListNode pre = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = (l1 == null ? l2 : l1);
        return dummy.next;
    }

    /**
     * 法一：选择排序，超时 通过 26 / 28 个用例
     * 时间复杂度：O(n^2)
     * @param head
     * @return
     */
    private ListNode selectSort(ListNode head) {
        ListNode tail = null; // 排序部分尾部
        ListNode cur = head; // 未排序部分尾部
        ListNode smallPre = null; // 最小节点的前一个节点
        ListNode small = null; // 最小的节点
        while (cur != null) {
            small = cur;
            smallPre = getSmallestPreNode(cur);
            if (smallPre != null) {
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur = cur == small ? cur.next : cur;
            if (tail == null) {
                head = small;
            } else {
                tail.next = small;
            }
            tail = small;
        }
        return head;
    }

    /**
     * 得到当前最小节点的前一个节点
     * @param head
     * @return
     */
    private ListNode getSmallestPreNode(ListNode head) {
        ListNode smallPre = null;
        ListNode small = head;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val < small.val) {
                smallPre = pre;
                small = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}