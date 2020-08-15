//请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都
//是O(1)。 
//
// 若队列为空，pop_front 和 max_value 需要返回 -1 
//
// 示例 1： 
//
// 输入: 
//["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
//[[],[1],[2],[],[],[]]
//输出: [null,null,null,2,1,2]
// 
//
// 示例 2： 
//
// 输入: 
//["MaxQueue","pop_front","max_value"]
//[[],[],[]]
//输出: [null,-1,-1]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= push_back,pop_front,max_value的总操作数 <= 10000 
// 1 <= value <= 10^5 
// 
// Related Topics 栈 Sliding Window


package cn.sher6j.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//Java：队列的最大值
public class POffer59IIDuiLieDeZuiDaZhiLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 59 - IIDuiLieDeZuiDaZhiLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MaxQueue {

    private Queue<Integer> data; // 存放数据的队列
    private Deque<Integer> maximums; // 记录最大值的双端队列，队头为当前最大值

    public MaxQueue() {
        this.data = new LinkedList<>();
        this.maximums = new LinkedList<>();
    }
    
    public int max_value() {
        return maximums.isEmpty() ? -1 : maximums.peekFirst();
    }
    
    public void push_back(int value) {
        data.offer(value);
        // 如果已有数字小于待存入数字，则这些数字从队尾出队，这里 >= 也可以通过
        while (!maximums.isEmpty() && value > maximums.peekLast()) maximums.pollLast();
        maximums.offerLast(value);
    }
    
    public int pop_front() {
        int tmp = data.isEmpty() ? -1 : data.poll();
        // 出队的元素是当前最大值，则将双端队列的队首也出队
        if (!maximums.isEmpty() && maximums.peekFirst() == tmp) maximums.pollFirst();
        return tmp;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
//leetcode submit region end(Prohibit modification and deletion)

}