//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针 
// 👍 273 👎 0


package cn.sher6j.leetcode.editor.cn;
//Java：分隔链表
public class P86PartitionList{
    public static void main(String[] args) {
        Solution solution = new P86PartitionList().new Solution();
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
    public ListNode partition(ListNode head, int x) {
        ListNode sH = null, sT = null; // 小的头尾
        ListNode ebH = null, ebT = null; // 不小的头尾
        ListNode cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = null;
            if (cur.val < x) {
                if (sH == null) {
                    sH = cur;
                } else {
                    sT.next = cur;
                }
                sT = cur;
            } else {
                if (ebH == null) {
                    ebH = cur;
                } else {
                    ebT.next = cur;
                }
                ebT = cur;
            }
            cur = next;
        }
        // 小的和大于等于的相连
        if (sT != null) {
            sT.next = ebH;
        }
        return sH != null ? sH : ebH;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}