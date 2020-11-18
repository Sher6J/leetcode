//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 581 👎 0


package cn.sher6j.leetcode.editor.cn;
//Java：反转链表 II
public class P92ReverseLinkedListIi{
    public static void main(String[] args) {
        Solution solution = new P92ReverseLinkedListIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy; // 开始反转链表节点的前一个节点
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }
        ListNode tail = prev; // 左侧未反转部分的尾结点
        ListNode start = prev.next;
        ListNode start1 = start; // 标记反转开始的节点
        ListNode next = null;
        // for循环后 start 指向右侧未反转部分的头结点
        for (int i = 0; i < n - m + 1; i++) {
            next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }
        start1.next = start; // 反转中的尾指向后侧未反转的头
        tail.next = prev; // 左侧未反转的尾指向反转后的头
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}