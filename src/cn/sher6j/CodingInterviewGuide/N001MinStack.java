package cn.sher6j.CodingInterviewGuide;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 最小栈
 * 实现一个特殊的栈，在栈的基本功能上，再实现返回栈的最小元素的操作
 * 要求：pop、push、getMin操作的时间复杂度都是O(1)
 * 两个栈：
 *      一个保存栈的元素——stackData
 *      一个保存每一步的最小值——stackMin
 * @author sher6j
 * @create 2020-10-16-20:46
 */
public class N001MinStack {
}

/**
 * 法一：
 * 压栈规则：
 *     当前数据为newNum，先将其压入stackData，判断stackMin是否为空：
 *         > 为空，则newNun也压入stackMin
 *         > 非空，比较newNum和stackMin栈顶元素：
 *              > 若newNum更小或两者相等，则newNum也压入stackMin
 *              > 若stackMin栈顶元素更小，则stackMin不压入任何内容
 * 弹栈规则：
 *     stackData弹出栈顶元素为value，比较当前stackMin栈顶元素和value：
 *         > value等于stackMin栈顶元素，stackMin弹出栈顶元素
 *         > value大于stackMin栈顶元素，stackMin不弹出栈顶元素
 * getMin：
 *     stackMin的栈顶元素即为当前最小值
 */
class MinStack1 {
    private Deque<Integer> stackData;
    private Deque<Integer> stackMin;

    public MinStack1() {
        this.stackData = new ArrayDeque<>();
        this.stackMin = new ArrayDeque<>();
    }

    /**
     * 向栈中压入元素
     * @param newNum 压入的新元素
     */
    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.getMin()) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    /**
     * 从栈顶弹出元素
     * @return 弹出的栈顶元素
     */
    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        int value = this.stackData.pop();
        if (value == this.getMin()) {
            this.stackMin.pop();
        }
        return value;
    }

    /**
     * 查看栈顶元素
     * @return 栈顶元素
     */
    public int top() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return this.stackData.peek();
    }

    /**
     * 获取栈中最小值
     * @return 栈中的最小值
     */
    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return this.stackMin.peek();
    }
}

/**
 * 法二：
 * 压栈规则：
 *     当前数据为newNum，先将其压入stackData，判断stackMin是否为空：
 *         > 为空，则newNun也压入stackMin
 *         > 非空，比较newNum和stackMin栈顶元素：
 *              > 若newNum更小或两者相等，则newNum也压入stackMin
 *              > 若stackMin栈顶元素更小，则把stackMin栈顶元素重复压入stackMin
 * 弹栈规则：
 *     stackData弹出栈顶元素且stackMin弹出栈顶元素
 * getMin：
 *     stackMin的栈顶元素即为当前最小值
 */
class MinStack2 {
    private Deque<Integer> stackData;
    private Deque<Integer> stackMin;

    public MinStack2() {
        this.stackData = new ArrayDeque<>();
        this.stackMin = new ArrayDeque<>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum < this.getMin()) {
            this.stackMin.push(newNum);
        } else {
            int curMin = this.stackMin.peek();
            this.stackMin.push(curMin);
        }
        this.stackData.push(newNum);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public int top() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return this.stackData.peek();
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return this.stackMin.peek();
    }
}
