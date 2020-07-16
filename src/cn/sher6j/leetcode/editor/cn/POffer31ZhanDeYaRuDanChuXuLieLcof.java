//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈
//的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。 
//
// 
//
// 示例 1： 
//
// 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//输出：true
//解释：我们可以按以下顺序执行：
//push(1), push(2), push(3), push(4), pop() -> 4,
//push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
// 
//
// 示例 2： 
//
// 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//输出：false
//解释：1 不能在 2 之前弹出。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= pushed.length == popped.length <= 1000 
// 0 <= pushed[i], popped[i] < 1000 
// pushed 是 popped 的排列。 
// 
//
// 注意：本题与主站 946 题相同：https://leetcode-cn.com/problems/validate-stack-sequences/ 
//


package cn.sher6j.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：栈的压入、弹出序列
public class POffer31ZhanDeYaRuDanChuXuLieLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 31ZhanDeYaRuDanChuXuLieLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        return byPushedMethod(pushed, popped);
//        return byPoppedMethod(pushed, popped);
    }

    /**
     * 题解2：根据压入序列思考
     * 入栈：按照压栈序列压入栈即可，但是没压入元素时都思考是否可以出栈
     * 出栈：每次入栈后，循环判断 栈顶元素=弹出序列当前元素 是否成立，
     *      将符合弹出序列的元素都进行弹出
     * @param pushed
     * @param popped
     * @return
     */
    public boolean byPushedMethod(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) return false;
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        for (int n : pushed) {
            stack.push(n);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 题解1：根据弹出序列思考
     * 1.若下一个弹出的数字刚好是栈顶数字，那么直接弹出；
     * 2.若下一个弹出的数字不在栈顶，则把压栈序列中还没有入栈的数字压入栈，
     *   直到把下一个需要弹出的数字压入栈顶为止；
     * 3.若所有数字都压入栈后仍然没有找到下一个弹出的数字，则该序列不可能是一个弹出序列
     * @param pushed
     * @param popped
     * @return
     */
    public boolean byPoppedMethod(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) return false;
        int len = pushed.length;
        Deque<Integer> stack = new LinkedList<>();
        int i = 0, j = 0;
        while (j < len || i < len) {
            while (stack.isEmpty() || stack.peek() != popped[j]) {
                if (i == len) return false;
                if (i == len - 1 && pushed[i] != popped[j]) return false;
                stack.push(pushed[i]);
                i++;
            }
            if (stack.peek() != popped[j]) return false;
            stack.pop();
            j++;
        }
        return stack.isEmpty();
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}