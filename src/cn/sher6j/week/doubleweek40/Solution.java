package cn.sher6j.week.doubleweek40;

import cn.sher6j.leetcode.editor.cn.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author sher6j
 * @create 2020-11-28-22:29
 */
public class Solution {
    /**
     * 5557. 最大重复子字符串
     * @param sequence
     * @param word
     * @return
     */
    public int maxRepeating(String sequence, String word) {
        int res = 0;
        StringBuilder sb = new StringBuilder();
        while (sequence.contains(sb.toString())) {
            sb.append(word);
            res++;
        }
        return res;
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        int count = 0;
        ListNode n1 = null;
        ListNode n2 = null;
        while (head != null) {
            if (count == a - 1) {
                n1 = head;
            }
            if (count == b + 1) {
                n2 = head;
                break;
            }
            head = head.next;
            count++;
        }

        ListNode n3 = list2;
        while (n3.next != null) {
            n3 = n3.next;
        }
        n1.next = list2;
        n3.next = n2;
        return list1;
    }


}

class FrontMiddleBackQueue {
    LinkedList<Integer> deque;
    int size = 0;

    public FrontMiddleBackQueue() {
        deque = new LinkedList<>();
    }

    public void pushFront(int val) {
        deque.offerFirst(val);
        size++;
    }

    public void pushMiddle(int val) {
        int idx = size / 2;
        deque.add(idx, val);
        size++;
    }

    public void pushBack(int val) {
        deque.offerLast(val);
        size++;
    }

    public int popFront() {
        if (size == 0) {
            return -1;
        }
        size--;
        return deque.pollFirst();
    }

    public int popMiddle() {
        if (size == 0) {
            return -1;
        }
        int idx = size / 2;
        idx = size % 2 == 0 ? idx - 1 : idx;
        Integer remove = deque.remove(idx);
        size--;
        return remove;
    }

    public int popBack() {
        if (size == 0) {
            return -1;
        }
        size--;
        return deque.pollLast();
    }
}