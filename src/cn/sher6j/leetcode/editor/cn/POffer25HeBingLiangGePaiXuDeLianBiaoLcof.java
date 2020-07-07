//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 分治算法


package cn.sher6j.leetcode.editor.cn;
//Java：合并两个排序的链表
public class POffer25HeBingLiangGePaiXuDeLianBiaoLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 25HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode currL1 = l1;
        ListNode currL2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (currL1 != null && currL2 != null) {
            if (currL1.val <= currL2.val) {
                curr.next = currL1;
                currL1 = currL1.next;
            } else {
                curr.next = currL2;
                currL2 = currL2.next;
            }
            curr = curr.next;
        }
        curr.next = currL1 != null ? currL1 : currL2;
//        if (currL1 != null) curr.next = currL1;
//        if (currL2 != null) curr.next = currL2;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}