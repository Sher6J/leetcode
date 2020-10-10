//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 说明：不允许修改给定的链表。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：tail connects to node index 1
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：tail connects to node index 0
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：no cycle
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//你是否可以不用额外空间解决此题？ 
// Related Topics 链表 双指针


package cn.sher6j.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

//Java：环形链表 II
public class P142LinkedListCycleIi{
    public static void main(String[] args) {
        Solution solution = new P142LinkedListCycleIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        /**
         * 利用HashMap，将访问过的节点及其对应的索引存入到HashMap中
         * 但是发现力扣上只需要返回节点值即可，输出打印语句其主方法里已经写好了
         */
//        return hashMapMethod(head);

        /**
         * 哈希集
         */
//        return hashSetMethod(head);

        /**
         * 快慢指针法
         */
        return twoPointMethod(head);
    }

    private ListNode twoPointMethod(ListNode head) {
        ListNode fast = head, slow = head; //起始快慢指针均指向头结点
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break; //确定了链表有环路，完成第一步，退出循环
        }
        fast = head; //令快指针从头开始走，并变为每步走1步
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    private ListNode hashSetMethod(ListNode head) {
        ListNode curr = head;
        HashSet<ListNode> set = new HashSet<>();
        while (curr != null) {
            if (set.contains(curr)) {
                return curr;
            }
            set.add(curr);
            curr = curr.next;
        }
        return null;
    }

    private ListNode hashMapMethod(ListNode head) {
        if (head == null || head.next == null) {
            System.out.println("no cycle");
            return null;
        }
        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode current = head;
        int index = 0;
        while (current.next != null) {
            map.put(current, index);
            current = current.next;
            index ++;
            if (map.keySet().contains(current)) {
                System.out.println("tail connects to node index " + map.get(current));
                return current;
            }
        }
        System.out.println("no cycle");
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}