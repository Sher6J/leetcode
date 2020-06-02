//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表


package cn.sher6j.leetcode.editor.cn;

import sun.security.util.AuthResources_it;

//Java：删除排序链表中的重复元素 II
public class P82RemoveDuplicatesFromSortedListIi{
    public static void main(String[] args) {
        Solution solution = new P82RemoveDuplicatesFromSortedListIi().new Solution();
        // TO TEST
        ListNode node7 = new ListNode(5);
        ListNode node6 = new ListNode(4, node7);
        ListNode node5 = new ListNode(4, node6);
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        solution.deleteDuplicates(node1);
        ListNode temp = node1;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curr = dummyNode;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.next.val == curr.next.val) {
                ListNode temp = curr.next;
                while (temp != null && temp.next != null && temp.next.val == temp.val) {
                    temp = temp.next;
                }
                curr.next = temp.next;//此时temp为当前有相同val的节点中的最后一个
            } else {
                curr = curr.next;
            }
        }
        return dummyNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}