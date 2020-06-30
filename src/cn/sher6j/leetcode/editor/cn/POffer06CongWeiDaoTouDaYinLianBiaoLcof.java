//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表


package cn.sher6j.leetcode.editor.cn;

import java.util.*;

//Java：从尾到头打印链表
public class POffer06CongWeiDaoTouDaYinLianBiaoLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 06CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
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
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        ListNode currNode = head;
        while (currNode!=null) {
            stack.push(currNode.val);
            currNode = currNode.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}