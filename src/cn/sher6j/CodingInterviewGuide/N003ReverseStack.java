package cn.sher6j.CodingInterviewGuide;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用递归函数和栈操作将一个栈逆序
 * @author sher6j
 * @create 2020-10-17-9:02
 */
public class N003ReverseStack {
    public static void main(String[] args) {

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }
        System.out.println("before reverse: " + stack.toString());
        ReverseStack.reverseStack(stack);
        System.out.println("after reverse: " + stack.toString());
    }
}

class ReverseStack {
    /**
     * 将栈stack的栈底元素返回并移除
     * @param stack
     * @return
     */
    public static int getAndRemoveLastElement(Deque<Integer> stack) {
        int res = stack.pop();
        if (stack.isEmpty()) {
            return res;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(res);
            return last;
        }
    }

    /**
     * 逆序反转一个栈的元素
     * @param stack
     */
    public static void reverseStack(Deque<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverseStack(stack);
        stack.push(i);
    }
}
