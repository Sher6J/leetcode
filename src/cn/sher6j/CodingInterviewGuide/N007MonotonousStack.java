package cn.sher6j.CodingInterviewGuide;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 给定一个不含有重复值的数组，
 * 找到每一个位置 i 左边和右边离 i 位置最近且值比 nums[i] 小的位置
 * @author sher6j
 * @create 2020-10-18-13:25
 */
public class N007MonotonousStack {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 1, 5, 6, 2, 7};
        MonotonousStack solution = new MonotonousStack();
        int[][] res1 = solution.method1(nums);
        int[][] res2 = solution.getNearLessNoRepeat(nums);
        for (int[] cur : res1) {
            System.out.println(Arrays.toString(cur));
        }
        System.out.println("===============");
        for (int[] cur : res2) {
            System.out.println(Arrays.toString(cur));
        }
    }
}

class MonotonousStack {
    /**
     * 法一：每个位置分别向左和向右遍历即可
     * 时间复杂度：O(N^2)
     * @param nums
     * @return
     */
    public int[][] method1(int[] nums) {
        int[][] res = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            int left = -1, right = -1;
            int cur = i - 1;
            while (cur >= 0) {
                if (nums[i] > nums[cur]) {
                    left = cur;
                    break;
                }
                cur--;
            }
            cur = i + 1;
            while (cur < nums.length) {
                if (nums[i] > nums[cur]) {
                    right = cur;
                    break;
                }
                cur++;
            }
            res[i][0] = left;
            res[i][1] = right;
        }
        return res;
    }

    /**
     * 法二：单调栈解法
     * 栈中存放元素是数组的位置，开始时栈为空
     * 因为是找到每个位置左边和右边离该位置最近且值比 nums[i] 小的位置
     * 所以需要让单调栈从顶到底所代表的值严格递减
     * 当 x 位置被弹出时：
     *      在栈中位于 x 位置下面的位置，就是 x 位置左边离其最近且小于 nums[x] 的位置
     *      当前遍历到的位置就是 x 位置右边离 x 位置最近且小于 nums[x] 的位置
     * @param nums
     * @return
     */
    public int[][] getNearLessNoRepeat(int[] nums) {
        int[][] res = new int[nums.length][2];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int popIdx = stack.pop();
                int leftLessIdx = stack.isEmpty() ? -1 : stack.peek();
                res[popIdx][0] = leftLessIdx;
                res[popIdx][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int popIdx = stack.pop();
            int leftLessIdx = stack.isEmpty() ? -1 : stack.peek();
            res[popIdx][0] = leftLessIdx;
            res[popIdx][1] = -1;
        }
        return res;
    }
}
