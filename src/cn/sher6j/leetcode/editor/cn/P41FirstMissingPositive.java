//给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,0]
//输出: 3
// 
//
// 示例 2: 
//
// 输入: [3,4,-1,1]
//输出: 2
// 
//
// 示例 3: 
//
// 输入: [7,8,9,11,12]
//输出: 1
// 
//
// 
//
// 提示： 
//
// 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。 
// Related Topics 数组


package cn.sher6j.leetcode.editor.cn;

import java.util.HashSet;

//Java：缺失的第一个正数
public class P41FirstMissingPositive{
    public static void main(String[] args) {
        Solution solution = new P41FirstMissingPositive().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {
//        return setMothod(nums);
        /**
         * 法二 时间复杂度为O(n)，空间复杂度O(1)
         */
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            while (nums[i] >= 1 && nums[i] <= l && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < l; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return l + 1;
    }

    /**
     * 交换数组两个位置的元素，用于法二
     * @param nums
     * @param i1
     * @param i2
     */
    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

        /**
     * 法一
     * 将数组中的正整数放入到哈希集中，然后从1遍历正整数，第一个不在集合中的数即为返回值
     * 时间复杂度满足附加条件为O(n)
     * 但是空间复杂度并没有满足条件O(1)，而是O(n)
     * @param nums
     * @return
     */
    private int setMothod(int[] nums) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                set.add(nums[i]);
                count ++;
            }
        }
        for (int i = 1; i < count + 1; i++) {
            if (!set.contains(i)) return i;
        }
        return count + 1;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}