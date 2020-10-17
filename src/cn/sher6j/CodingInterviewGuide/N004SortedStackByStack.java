package cn.sher6j.CodingInterviewGuide;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

/**
 * 用栈实现一个排序栈，对栈进行排序使最小元素位于栈顶
 * @author sher6j
 * @create 2020-10-17-9:54
 */
public class N004SortedStackByStack {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            stack.push(random.nextInt(20));
        }
        System.out.println("before sort: " + stack.toString());
        SortedStack.sortStackByStack(stack);
        System.out.println("after sort: " + stack.toString());
    }
}

/**
 * 在stack上执行pop操作，弹出元素为cur
 *      > 若cur ≥ help的栈顶元素，则cur直接压入help
 *      > 若cur < help的栈顶元素，则将help元素逐一弹栈并压入stack，
 *        直到cur ≥ help的栈顶元素，再将cur压入help
 * 执行上述操作后，将help中的所有元素逐一压入stack，完成排序
 */
class SortedStack {
    public static void sortStackByStack(Deque<Integer> stack) {
        Deque<Integer> help = new ArrayDeque<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() > cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
