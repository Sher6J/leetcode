//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，
//它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。 
//
// 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针


package cn.sher6j.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：链表中倒数第k个节点
public class POffer22LianBiaoZhongDaoShuDiKgeJieDianLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 22LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
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
    public ListNode getKthFromEnd(ListNode head, int k) {
        //双指针法
        if (head == null || k <= 0) return null;
        ListNode aheadNode = head;
        ListNode behindNode = head;
        for (int i = 0; i < k - 1; i++) {
            if (aheadNode.next != null) {
                aheadNode = aheadNode.next;
            } else {
                return null;
            }
        }
        while (aheadNode.next != null) {
            aheadNode = aheadNode.next;
            behindNode = behindNode.next;
        }
        return behindNode;
//        return stackMethod(head, k);
    }

    public ListNode stackMethod(ListNode head, int k) {
        Deque<ListNode> stack = new LinkedList<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        for (int i = 0; i < k - 1; i++) {
            ListNode pop = stack.pop();
        }
        return stack.pop();
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}