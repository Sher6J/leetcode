//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 进阶： 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
// 
// Related Topics 链表


package cn.sher6j.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//Java：两数相加 II
public class P445AddTwoNumbersIi{
    public static void main(String[] args) {
        Solution solution = new P445AddTwoNumbersIi().new Solution();
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //记录l1和l2各节点值的栈
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        //辅助节点以免破坏原链表结构
        ListNode p = l1;
        ListNode q = l2;
        ListNode res = null;
        while (p != null) {
            stack1.addLast(p.val); //push
            p = p.next;
        }
        while (q != null) {
            stack2.addLast(q.val);
            q = q.next;
        }
        int carry = 0; //记录进位
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int x = 0, y = 0;
            if (!stack1.isEmpty()) x = stack1.pollLast(); //pop
            if (!stack2.isEmpty()) y = stack2.pollLast();
            ListNode new_node = new ListNode((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
            //头插法
            new_node.next = res;
            res = new_node;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}