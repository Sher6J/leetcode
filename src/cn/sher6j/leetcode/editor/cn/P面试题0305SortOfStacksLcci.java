//栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：pu
//sh、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。 
//
// 示例1: 
//
//  输入：
//["SortedStack", "push", "push", "peek", "pop", "peek"]
//[[], [1], [2], [], [], []]
// 输出：
//[null,null,null,1,null,2]
// 
//
// 示例2: 
//
//  输入： 
//["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
//[[], [], [], [1], [], []]
// 输出：
//[null,null,null,null,null,true]
// 
//
// 说明: 
//
// 
// 栈中的元素数目在[0, 5000]范围内。 
// 
// Related Topics 设计


package cn.sher6j.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：栈排序
public class P面试题0305SortOfStacksLcci{
    public static void main(String[] args) {
//        Solution solution = new P面试题 03.05SortOfStacksLcci().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class SortedStack {

    private Deque<Integer> stack;
    private Deque<Integer> helpStack;

    public SortedStack() {
        this.stack = new LinkedList<>();
        this.helpStack = new LinkedList<>();
    }

    public void push(int val) {
        if (this.stack.isEmpty()) this.stack.push(val);
        else {
            while (!this.stack.isEmpty() && this.stack.peek() < val) {
                this.helpStack.push(this.stack.pop());
            }
            this.stack.push(val);
            while (!this.helpStack.isEmpty()) {
                this.stack.push(this.helpStack.pop());
            }
        }
    }

    public void pop() {
        if (this.isEmpty()) return;
        this.stack.pop();
    }

    public int peek() {
        if (this.isEmpty()) return -1;
        return this.stack.peek();
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }
}

/**
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack obj = new SortedStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.isEmpty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}