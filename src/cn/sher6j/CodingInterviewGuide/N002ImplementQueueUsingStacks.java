package cn.sher6j.CodingInterviewGuide;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 由两个栈实现队列
 * @author sher6j
 * @create 2020-10-17-8:42
 */
public class N002ImplementQueueUsingStacks {
}

/**
 * 用两个栈：
 *     > 一个栈作为压入栈，在数据入队时压入这个栈，为stackPush
 *     > 一个栈作为弹出栈，在数据出队时从这个栈弹出，为stackPop
 * 注意两点：
 *     > 若stackPush要往stackPop中压入数据，则必须一次性将stackPush中数据全部压入
 *     > 若stackPop非空，则stackPush绝对不能向stackPop中压入数据
 */
class MyQueue {
    private Deque<Integer> stackPush;
    private Deque<Integer> stackPop;

    public MyQueue() {
        this.stackPush = new ArrayDeque<>();
        this.stackPop = new ArrayDeque<>();
    }

    /**
     * 向队列的队尾插入数据
     * @param x
     */
    public void push(int x) {
        stackPush.push(x);
        stackPushToPop();
    }

    /**
     * 从队列的对头取出数据
     * @return 出队的元素
     */
    public int pop() {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        stackPushToPop();
        return stackPop.pop();
    }

    /**
     * 查看对头元素
     * @return 对头元素
     */
    public int peek() {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        stackPushToPop();
        return stackPop.peek();
    }

    /**
     * 查看队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return stackPop.isEmpty() && stackPush.isEmpty();
    }

    /**
     * push栈向pop栈中倒入数据
     */
    private void stackPushToPop() {
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }
}
