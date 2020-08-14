//输入两个链表，找出它们的第一个公共节点。 
//
// 如下面的两个链表： 
//
// 
//
// 在节点 c1 开始相交。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
//kipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 
//
// 示例 2： 
//
// 
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
// 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 
//
// 示例 3： 
//
// 
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
// 
//
// 
//
// 注意： 
//
// 
// 如果两个链表没有交点，返回 null. 
// 在返回结果后，两个链表仍须保持原有的结构。 
// 可假定整个链表结构中没有循环。 
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 
// 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lis
//ts/ 
// 
// Related Topics 链表


package cn.sher6j.leetcode.editor.cn;

import java.util.*;

//Java：两个链表的第一个公共节点
public class POffer52LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 52LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        return hashTableMethod(headA, headB);
//        return doubleStackMethod(headA, headB);
//        return doublePoint1(headA, headB);
        return doublePoint2(headA, headB);
    }

    /**
     * 法四：双指针法第二种
     * A走到末尾后指向B的头，B走向末尾后指向A的头，两者第一次相遇就为相交点
     * 可以理解成两个人速度一致，走过的路程一致。
     * 那么肯定会同一个时间点到达终点。
     * 如果到达终点的最后一段路两人都走的话，那么这段路上俩人肯定是肩并肩手牵手的。
     * 所以在相交点时两者就会相遇。
     * 时间复杂度：O(m + n)
     * 空间复杂度：O(1)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode doublePoint2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA != currB) {
            currA = currA == null ? headB : currA.next;
            currB = currB == null ? headA : currB.next;
        }
        return currA;
    }

    /**
     * 法三：双指针法第一种
     * 第一次遍历：分别遍历两个链表得到其长度并得到长的链表比短的链表多几个节点，即长度差 lenDif；
     * 第二次遍历：在较长的链表上先走 lenDif 个节点，然后两个链表同时走，遇到的第一个相同节点即为所求
     * @param headA
     * @param headB
     * @return
     */
    public ListNode doublePoint1(ListNode headA, ListNode headB) {
        ListNode nodeLong = headA, nodeShort = headB;
        int lenA = 0, lenB = 0;
        while (nodeLong != null) {
            lenA++;
            nodeLong = nodeLong.next;
        }
        while (nodeShort != null) {
            lenB++;
            nodeShort = nodeShort.next;
        }
        int lenDif = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            nodeLong = headA;
            nodeShort = headB;
        } else {
            nodeShort = headA;
            nodeLong = headB;
        }
        for (int i = 0; i < lenDif; i++) {
            nodeLong = nodeLong.next;
        }
        while (nodeLong != null && nodeShort != null && nodeLong != nodeShort) {
            nodeLong = nodeLong.next;
            nodeShort = nodeShort.next;
        }
        return nodeLong;
    }

    /**
     * 法二：双栈法
     * 将两个链表的节点分别放入两个栈中，则两个链表的节点在栈顶
     * 比较两个栈顶结点是否相同：
     *     相同：两栈栈顶弹出，比较下一栈顶
     *     不同：最后一个相同的节点即为所求
     * @param headA
     * @param headB
     * @return
     */
    public ListNode doubleStackMethod(ListNode headA, ListNode headB) {
        Deque<ListNode> stackA = new LinkedList<>();
        Deque<ListNode> stackB = new LinkedList<>();
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != null) {
            stackA.push(nodeA);
            nodeA = nodeA.next;
        }
        while (nodeB != null) {
            stackB.push(nodeB);
            nodeB = nodeB.next;
        }
        ListNode res = null;
        while (!stackA.isEmpty() && !stackB.isEmpty() && stackA.peek() == stackB.peek()) {
            res = stackA.pop();
            stackB.pop();
        }
        return res;
    }

    /**
     * 法一：哈希表
     * 遍历 A 链表：将 A 链表节点存放在哈希表中；
     * 遍历 B 链表：找到第一个在哈希表中已近存在的节点即为所求
     * @param headA
     * @param headB
     * @return
     */
    public ListNode hashTableMethod(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode nodeA = headA;
        while (nodeA != null) {
            set.add(nodeA);
            nodeA = nodeA.next;
        }
        ListNode nodeB = headB;
        while (nodeB != null) {
            if (set.contains(nodeB)) return nodeB;
            nodeB = nodeB.next;
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}