package cn.sher6j.CodingInterviewGuide;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 生成窗口最大值数组
 * @author sher6j
 * @create 2020-10-18-10:30
 */
public class N005MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = new int[] {4, 3, 5, 4, 3, 3, 6, 7};
        int[] res = MaxSlidingWindow.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(res));
    }
}

/**
 * 利用双端队列实现窗口最大值的更新，双端队列 deque 中存放数组中的下标
 * 假设遍历到nums[i]，deque放入规则为：
 *     > 若 deque 为空，直接把下标 i 放进 deque，放入过程结束
 *     > 若 deque 不为空，取出当前 deque 队尾存放的下标，设为 j：
 *          > 若 nums[j] > nums[i]，说明 nums[j] 还可能为窗口中的最大值，
 *            则直接把下标 i 放进 deque 的队尾，放入过程结束；
 *          > 若 nums[j] ≤ nums[i]，说明 nums[j] 已经不可能为窗口中的最大值，
 *            把 j 从 deque 中弹出，重复 deque 的放入规则
 * 假设遍历到nums[i]，deque弹出规则为：
 *     若 deque 对头下标等于 i-k，证明该下标已不再滑动窗口中（过期），直接弹出
 */
class MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            return null;
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            if (i >= k - 1) {
                res[idx++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
