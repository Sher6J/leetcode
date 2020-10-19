package cn.sher6j.CodingInterviewGuide;

/**
 * 将单链表按某值划分为左边小、中间相等、右边大的形式
 * 初阶问题：对调整后节点顺序没有要求
 * 进阶问题：
 *     1. 在左、中、右三部分内部顺序和原链表顺序相同
 *     2. 链表长度为 N，要求时间复杂度为 O(N)，空间复杂度为 O(1)
 * @author sher6j
 * @create 2020-10-19-16:43
 */
public class N019PatitionLinkedList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        ListNode head = n1;
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
        PatitionList patitionList = new PatitionList();
//        ListNode node = patitionList.patition1(n1, 3);
//        while (node != null) {
//            System.out.print(node.val + "->");
//            node = node.next;
//        }
        ListNode listNode = patitionList.patition2(n1, 3);
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }
}

class PatitionList {
    /**
     * 法一：将链表划分为左边小、中间相等、右边大的形式（左右部分不要求顺序）
     * 1. 遍历链表，得到长度 N
     * 2. 生成长度为 N 的节点数组 nodeArr，将节点依次放入
     * 3. 在 nodeArr 中将小于 pivot 放入左边，等于 pivot 的放入中间，大于 pivot 的放入右边
     * 4. 经过 3 后，nodeArr中顺序满足要求，将其中节点连在一起即可
     * @param head 链表头结点
     * @param pivot 中间值
     * @return
     */
    public ListNode patition1(ListNode head, int pivot) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        ListNode[] nodeArr = new ListNode[i];
        i = 0;
        cur = head;
        for (i = 0; i < nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPatition(nodeArr, pivot);
        for (i = 1; i < nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    /**
     * 将 nodeArr 中小于 pivot 的节点放在左边，相等的放在中间，大于的放在右边
     * @param nodeArr 节点数组
     * @param pivot 中间值
     */
    private void arrPatition(ListNode[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int idx = 0;
        while (idx < big) {
            if (nodeArr[idx].val < pivot) {
                swap(nodeArr, ++small, idx++);
            } else if (nodeArr[idx].val == pivot) {
                idx++;
            } else {
                swap(nodeArr, --big, idx);
            }
        }
    }

    /**
     * 交换节点数组中的节点
     * @param nodeArr
     * @param i
     * @param j
     */
    private void swap(ListNode[] nodeArr, int i, int j) {
        if (i == j) {
            return;
        }
        ListNode tmp = nodeArr[i];
        nodeArr[i] = nodeArr[j];
        nodeArr[j] = tmp;
    }

    /**
     * 法二：保持原顺序
     * 1. 将原链表划分为三个链表：
     *     > small 代表小于 pivot 的左边部分
     *     > equal 代表等于 pivot 的中间部分
     *     > big   代表大于 pivot 的右边部分
     * 2. 将 small、equal、big三个链表串起来即可
     * @param head
     * @param pivot
     * @return
     */
    public ListNode patition2(ListNode head, int pivot) {
        ListNode sH = null, sT = null; // 小的头尾
        ListNode eH = null, eT = null; // 等的头尾
        ListNode bH = null, bT = null; // 大的头尾
        ListNode cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = null;
            if (cur.val < pivot) {
                if (sH == null) {
                    sH = cur;
                    sT = cur;
                } else {
                    sT.next = cur;
                    sT = cur;
                }
            } else if (cur.val == pivot) {
                if (eH == null) {
                    eH = cur;
                    eT = cur;
                } else {
                    eT.next = cur;
                    eT = cur;
                }
            } else {
                if (bH == null) {
                    bH = cur;
                    bT = cur;
                } else {
                    bT.next = cur;
                    bT = cur;
                }
            }
            cur = next;
        }
        // 将小的和相等的链接
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT; // 若没有相等的则小的尾直接连接大的头
        }
        // 将相等的和大的链接
        if (eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH;
    }
}
