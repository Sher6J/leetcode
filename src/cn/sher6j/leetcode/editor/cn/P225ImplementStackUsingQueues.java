//使用队列实现栈的下列操作： 
//
// 
// push(x) -- 元素 x 入栈 
// pop() -- 移除栈顶元素 
// top() -- 获取栈顶元素 
// empty() -- 返回栈是否为空 
// 
//
// 注意: 
//
// 
// 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合
//法的。 
// 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。 
// 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。 
// 
// Related Topics 栈 设计


package cn.sher6j.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//Java：用队列实现栈
public class P225ImplementStackUsingQueues{
    public static void main(String[] args) {
//        Solution solution = new P225ImplementStackUsingQueues().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 法一:
     * 新元素永远从 inQueue 的后端入队，同时 inQueue 的后端也是栈的 栈顶（top）元素
      */
//class MyStack {
//    private Queue<Integer> inQueue; //该队列中始终保存栈的元素，其队尾为栈顶元素
//    private Queue<Integer> helpQueue; //辅助队列
//    private int top; //记录栈顶元素
//
//    /** Initialize your data structure here. */
//    public MyStack() {
//        this.inQueue = new LinkedList<>();
//        this.helpQueue = new LinkedList<>();
//    }
//
//    /** Push element x onto stack. */
//    public void push(int x) {
//        this.inQueue.add(x);
//        this.top = x;
//    }
//
//    /** Removes the element on top of the stack and returns that element. */
//    public int pop() {
//        /**
//         * 将inQueue中的元素只留一个，留下的元素即为要出栈的栈顶元素，
//         * 同时更新新栈顶元素为留下栈顶元素的前一个元素
//         */
//        while (inQueue.size() > 1) {
//            this.top = inQueue.remove();
//            helpQueue.add(top);
//        }
//        int res = inQueue.remove();
//        Queue<Integer> temp = inQueue;
//        inQueue = helpQueue;
//        helpQueue = temp;
//        return res;
//    }
//
//    /** Get the top element. */
//    public int top() {
//        return this.top;
//    }
//
//    /** Returns whether the stack is empty. */
//    public boolean empty() {
//        return inQueue.isEmpty();
//    }
//}

    /**
     * 法二：
     * 每一个新元素从 q2 入队，同时把这个元素作为栈顶元素保存。
     * 当 q1 非空（也就是栈非空），我们让 q1 中所有的元素全部出队，
     * 再将出队的元素从 q2 入队。
     * 通过这样的方式，新元素（栈中的栈顶元素）将会在 q2 的前端。
     * 通过将 q1， q2 互相交换的方式来避免把 q2 中的元素往 q1 中拷贝。
      */
//class MyStack {
//
//    private Deque<Integer> q1;
//    private Deque<Integer> q2;
//    private int top;
//
//    /** Initialize your data structure here. */
//    public MyStack() {
//        this.q1 = new LinkedList<>();
//        this.q2 = new LinkedList<>();
//    }
//
//    /** Push element x onto stack. */
//    public void push(int x) {
//        q2.add(x);
//        this.top = x;
//        while (!q1.isEmpty()) {
//            q2.add(q1.remove());
//        }
//        //在新加入元素之前，q2始终为空队列，所以加入元素到q2即为栈顶元素
//        Deque<Integer> temp = q1;
//        q1 = q2;
//        q2 = temp;
//    }
//
//    /** Removes the element on top of the stack and returns that element. */
//    public int pop() {
//        int res = q1.remove();
//        if (!q1.isEmpty()) this.top = q1.peek();
//        return res;
//    }
//
//    /** Get the top element. */
//    public int top() {
//        return this.top;
//    }
//
//    /** Returns whether the stack is empty. */
//    public boolean empty() {
//        return q1.isEmpty();
//    }
//}

    /**
     * 法三：
     * 当我们将一个元素从队列入队的时候，根据队列的性质这个元素会存在队列的后端。
     * 但当我们实现一个栈的时候，最后入队的元素应该在前端，而不是在后端。
     * 为了实现这个目的，每当入队一个新元素的时候，我们可以把队列的顺序反转过来。
     */
class MyStack {
    private Queue<Integer> queue;
    private int top;

    /** Initialize your data structure here. */
    public MyStack() {
        this.queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        while (size > 1) {
            queue.add(queue.remove());
            size--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int res = queue.remove();
        return res;
    }

    /** Get the top element. */
    public int top() {
        return this.queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}