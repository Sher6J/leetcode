//根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
//, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表


package cn.sher6j.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：每日温度
public class P739DailyTemperatures{
    public static void main(String[] args) {
        Solution solution = new P739DailyTemperatures().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        /**
         * 法一：暴力
         */
//        return On2(T);


        /**
         * 法二：单调栈
         */
//        return stackMethod(T);

        /**
         * 法三：单调栈模板法
         */
        int[] res = new int[T.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = T.length - 1; i >= 0 ; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }
        return res;
    }

    /**
     * 单调栈
     * @param T
     * @return
     */
    public int[] stackMethod(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int top = stack.removeFirst(); //pop
                res[top] = i - top;
            }
            stack.addFirst(i); //push
        }
        return res;
    }

    /**
     * 解法一：暴力解法，两重循环，
     * 时间复杂度：O(n^2)
     * @param T
     * @return
     */
    private int[] On2(int[] T) {
        int[] res = new int[T.length];
        res[T.length - 1] = 0;
        for (int i = 0; i < T.length - 1; i++) {
            int count = 1;
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] <= T[i]) count ++;
                else {
                    res[i] = count;
                    break;
                }
            }
        }
        return res;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}