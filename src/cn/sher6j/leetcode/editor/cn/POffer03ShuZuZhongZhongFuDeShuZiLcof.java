//找出数组中重复的数字。 
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表


package cn.sher6j.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;

//Java：数组中重复的数字
public class POffer03ShuZuZhongZhongFuDeShuZiLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 03ShuZuZhongZhongFuDeShuZiLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findRepeatNumber(int[] nums) {
//        return sortMethod(nums);
//        return hashtableMethod(nums);
        return selfHash(nums);
    }

    /**
     * 法三：手动维护哈希表
     *
     * @param nums
     * @return
     */
    private int selfHash(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    /**
     * 交换数组指定位置的两个值，用于法三
     * @param nums 数组
     * @param i1 索引1
     * @param i2 索引2
     */
    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    /**
     * 法一：排序法
     * 将输入数组排序，然后从头到尾扫描排序后的数组即可
     * 时间复杂度：O(nlogn)   排序 -> O(nlogn)  扫描 -> O(n)
     * @param nums
     * @return
     */
    private int sortMethod(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return nums[i];
        }
        return -1;
    }

    /**
     * 法二：哈希表
     * 从头到尾按顺序扫描数组的每个数字，
     * 每扫描一个数字，判断哈希表中是否包含该数字，
     * 若哈希表中没有该数字，则将其加入哈希表，
     * 若包含该数字，则找到一个重复的数字，返回即可
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    private int hashtableMethod(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return nums[i];
            set.add(nums[i]);
        }
        return -1;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}