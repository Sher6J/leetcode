//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window


package cn.sher6j.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

//Java：滑动窗口最大值
public class P239SlidingWindowMaximum{
    public static void main(String[] args) {
        Solution solution = new P239SlidingWindowMaximum().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /**
         * 法一：暴力解法
         */
//        return slow(nums, k);



        /**
         * 法二：双端队列
         */
        if (nums == null || nums.length * k == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int index = 0; //存放res数组索引
        for (int i = 0; i < nums.length; i++) {
            //队尾元素小于等于要入队的，队尾元素都出队
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) deque.pollLast();
            deque.addLast(i);
            //队头元素已经不再窗口范围内，需要出队
            if (deque.peekFirst() == i - k) deque.pollFirst();
            if (i >= k - 1) res[index++] = nums[deque.peekFirst()];
        }
        return res;
    }

    /**
     * 暴力解法：执行耗时:2404 ms,击败了5.00% 的Java用户，哈哈哈菜死了
     *      时间复杂度：O(Nk)，N为数组长度
     *      空间复杂度：O(N-k+1)，拥有输出数组
     * @param nums
     * @param k
     * @return
     */
    private int[] slow(int[] nums, int k) {
        //数组长度为0或k为0时直接返回0元素的数组
        if (nums == null || nums.length * k == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}