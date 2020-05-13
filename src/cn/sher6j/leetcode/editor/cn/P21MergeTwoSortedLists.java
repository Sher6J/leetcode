//将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表


package cn.sher6j.leetcode.editor.cn;
//Java：合并两个有序链表
public class P21MergeTwoSortedLists{
    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
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
        /**
         * 递归
         * 时间复杂度：O(n + m)，其中 n 和 m 分别为两个链表的长度。
         *      因为每次调用递归都会去掉 l1 或者 l2 的头节点（直到至少有一个链表为空），
         *      函数 mergeTwoList 至多只会递归调用每个节点一次。
         *      因此，时间复杂度取决于合并后的链表长度，即 O(n+m)。
         * 空间复杂度：O(n + m)，其中 n 和 m 分别为两个链表的长度。
         *      递归调用 mergeTwoLists 函数时需要消耗栈空间，
         *      栈空间的大小取决于递归调用的深度。
         *      结束递归调用时 mergeTwoLists 函数最多调用 n+m 次，
         *      因此空间复杂度为 O(n+m)。
         */
//        if (l1 == null) { //递归出口
//            return l2;
//        } else if (l2 == null) { //递归出口
//            return l1;
//        } else if (l1.val < l2.val) {
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        } else {
//            l2.next = mergeTwoLists(l2.next, l1);
//            return l2;
//        }

        /**
         * 迭代
         */
        ListNode temp = new ListNode(0); //开辟节点表示新的链表
        ListNode pre = temp;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                pre = pre.next;
                l1 = l1.next;
            } else {
                pre.next = l2;
                pre = pre.next;
                l2 = l2.next;
            }
        }
        //当有一放还有剩余元素时，
        //那剩下的值一定大于等于链表中已有的值，并且是有序的，
        //直接连接在链表尾部即可
        pre.next = (l1 == null ? l2 : l1);
        return temp.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}