package cn.sher6j.CodingInterviewGuide;

/**
 * 打印两个有序链表的公共部分
 * @author sher6j
 * @create 2020-10-18-14:25
 */
public class N012PrintCommonOfTwoLinkedLists {
    public static void main(String[] args) {

    }
}

class PrintCommonPart {
    /**
     * 打印两个有序链表的公共部分
     * @param head1
     * @param head2
     */
    public void print(ListNode head1, ListNode head2) {
        System.out.println("Common Part:");
        ListNode cur1 = head1, cur2 = head2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                cur1 = cur1.next;
            } else if (cur1.val > cur2.val) {
                cur2 = cur2.next;
            } else {
                System.out.print(cur1.val + " ");
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
        }
        System.out.println();
    }
}
