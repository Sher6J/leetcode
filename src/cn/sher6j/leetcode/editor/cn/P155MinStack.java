//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计


package cn.sher6j.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：最小栈
public class P155MinStack{
    public static void main(String[] args) {
//        Solution solution = new P155MinStack().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    /**
     * 下面代码实现的是法一，法二同理可以实现，如压入数据 [3 4 5 1 2 1]
     * 法一：存放最小值的栈在压栈的时候：
     *      只有在数据栈中出现新的较小值（包括等于当前最小值的值）时再压栈
     *          1               1
     *          2              无
     *          1               1
     *          5              无
     *          4              无
     *          3               3
     *      stackData        stackMin
     *
     * 法二：每在数据栈中添加元素就在最小值栈中压入当前最小值，即重复压入最小值
     *          1               1
     *          2               1
     *          1               1
     *          5               3
     *          4               3
     *          3               3
     *      stackData        stackMin
      */
    private Deque<Integer> stackData; //存放数据的栈
    private Deque<Integer> stackMin; //存放最小值的栈

    /** initialize your data structure here. */
    public MinStack() {
        this.stackData = new LinkedList<>();
        this.stackMin = new LinkedList<>();
    }
    
    public void push(int x) {
        //当前元素小于等于最小值时才入最小值栈
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(x);
        } else if (x <= this.getMin()) {
            this.stackMin.push(x);
        }
        this.stackData.push(x);
    }
    
    public void pop() {
        if (this.stackData.isEmpty()) throw new RuntimeException("栈空，栈中无元素");
        int value = this.stackData.pop();
        if (value == this.getMin()) {
            this.stackMin.pop();
        }
    }
    
    public int top() {
        if (this.stackData.isEmpty()) throw new RuntimeException("栈空，栈中无元素");
        int top = this.stackData.peek();
        return top;
    }
    
    public int getMin() {
        if (this.stackMin.isEmpty()) throw new RuntimeException("栈空，栈中无元素");
        return this.stackMin.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}