//使用栈实现队列的下列操作： 
//
// 
// push(x) -- 将一个元素放入队列的尾部。 
// pop() -- 从队列首部移除元素。 
// peek() -- 返回队列首部的元素。 
// empty() -- 返回队列是否为空。 
// 
//
// 
//
// 示例: 
//
// MyQueue queue = new MyQueue();
//
//queue.push(1);
//queue.push(2);  
//queue.peek();  // 返回 1
//queue.pop();   // 返回 1
//queue.empty(); // 返回 false 
//
// 
//
// 说明: 
//
// 
// 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
// 
// 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。 
// 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。 
// 
// Related Topics 栈 设计


package cn.sher6j.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：用栈实现队列
public class P232ImplementQueueUsingStacks{
    public static void main(String[] args) {
//        Solution solution = new P232ImplementQueueUsingStacks().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MyQueue {
    /**
     * 一个栈作为压入栈，压入数据时只往这个栈中压入
     */
    private Deque<Integer> stackPush; //只负责入队的栈
    private Deque<Integer> stackPop; //只负责出队的栈
    /** Initialize your data structure here. */
    public MyQueue() {
        this.stackPush = new LinkedList<>();
        this.stackPop = new LinkedList<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stackPush.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (this.empty()) throw new RuntimeException("队列为空，队列中无元素");
        /**
         * 1.如果stackPush要往stackPop中压入数据，必须一次性将stackPush中的数据全部压入
         * 2.如果stackPop不为空，stackPush绝对不能向stackPop中压入数据
         */
        else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (this.empty()) throw new RuntimeException("队列为空，队列中无元素");
        /**
         * 1.如果stackPush要往stackPop中压入数据，必须一次性将stackPush中的数据全部压入
         * 2.如果stackPop不为空，stackPush绝对不能向stackPop中压入数据
         */
        else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackPush.isEmpty() && stackPop.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}