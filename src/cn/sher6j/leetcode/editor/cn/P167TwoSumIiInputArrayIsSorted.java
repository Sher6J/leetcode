//给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。 
//
// 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。 
//
// 说明: 
//
// 
// 返回的下标值（index1 和 index2）不是从零开始的。 
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。 
// 
//
// 示例: 
//
// 输入: numbers = [2, 7, 11, 15], target = 9
//输出: [1,2]
//解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。 
// Related Topics 数组 双指针 二分查找


package cn.sher6j.leetcode.editor.cn;

import java.util.HashMap;

//Java：两数之和 II - 输入有序数组
public class P167TwoSumIiInputArrayIsSorted{
    public static void main(String[] args) {
        Solution solution = new P167TwoSumIiInputArrayIsSorted().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        return twoPointMethod(numbers, target);
//        return binarySearchMethod(numbers, target);
    }

    /**
     * 法二：二分查找
     * 时间复杂度：O(nlogn)
     * @param numbers
     * @param target
     * @return
     */
    public int[] binarySearchMethod(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1, right = numbers.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (numbers[mid] == target - numbers[i])
                    return new int[] {i + 1, mid + 1};
                else if (numbers[mid] > target - numbers[i]) right = mid - 1;
                else left = mid + 1;
            }
        }
        return new int[0];
    }

    /**
     * 法一：双指针
     * 时间复杂度：O(n)
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoPointMethod(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        for (;i < j; ) {
            if (numbers[i] + numbers[j] > target) j--;
            else if (numbers[i] + numbers[j] < target) i++;
            else return new int[] {i + 1, j + 1};
        }
        return new int[0];
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}