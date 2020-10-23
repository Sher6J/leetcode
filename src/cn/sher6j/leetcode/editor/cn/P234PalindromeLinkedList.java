//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针


package cn.sher6j.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：回文链表
public class P234PalindromeLinkedList{
    public static void main(String[] args) {
        Solution solution = new P234PalindromeLinkedList().new Solution();
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
    public boolean isPalindrome(ListNode head) {
        /**
         * 法一：转换为数组
         * 时间复杂度：O(n)
         * 空间负责度：O(n)
         */
//        List<Integer> list = new ArrayList<>();
//        ListNode currNode = head;
//        while (currNode != null) {
//            list.add(currNode.val);
//            currNode = currNode.next;
//        }
//        return isPalindrome(list);

        /**
         * 法二：快慢指针，
         * 将链表后半部分反转，然后将前半部分和后半部分比较（比较后最好将链表恢复原样）
         * 1.找到前半部分链表的尾节点。
         * 2.反转后半部分链表。
         * 3.判断是否为回文。
         * 4.恢复链表。
         * 5.返回结果。
         * 对于1.可以计算链表节点数量，但是用快慢指针更好：
         *    慢指针一次走一步，快指针一次走两步，快指针到达链表末尾，慢指针恰好到中间
         */
        if (head == null) return true;
        ListNode firstHalfEnd = endOfFisrtHalf(head); //找到链表前一半的尾结点
        ListNode secondHalfStart = reverseList(firstHalfEnd.next); //反转后半部分链表

        ListNode n1 = head;
        ListNode n2 = secondHalfStart;

        while (n2 != null) {
            if (n1.val != n2.val) {
                // 返回false之前要将链表还原
                firstHalfEnd.next = reverseList(secondHalfStart);
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        firstHalfEnd.next = reverseList(secondHalfStart); //将后半部分反转回原始状态
        return true;
    }

    /**
     * 找到链表前一半的尾结点，用于法二
     * @param head
     * @return
     */
    private ListNode endOfFisrtHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 反转链表，用于法二
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    /**
     * 判断一个数组是否为回文，用于法一
     * @param list
     * @return
     */
    public boolean isPalindrome(List<Integer> list) {
        int front = 0;
        int back = list.size() - 1;
        while (front < back) {
            if (!list.get(front).equals(list.get(back))) return false;
            front ++;
            back --;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}