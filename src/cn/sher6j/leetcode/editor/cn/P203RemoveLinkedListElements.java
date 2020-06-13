//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表


package cn.sher6j.leetcode.editor.cn;
//Java：移除链表元素
public class P203RemoveLinkedListElements{
    public static void main(String[] args) {
        Solution solution = new P203RemoveLinkedListElements().new Solution();
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
    public ListNode removeElements(ListNode head, int val) {
        //记得用哨兵！！！
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prevNode = dummyNode;
        ListNode currNode = head;
        while (currNode != null) {
            if (currNode.val == val) prevNode.next = currNode.next;
            else prevNode = prevNode.next;
            currNode = currNode.next;
        }
        return dummyNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}