//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针


package cn.sher6j.leetcode.editor.cn;

import java.util.Arrays;

//Java：最接近的三数之和
public class P16ThreeSumClosest{
    public static void main(String[] args) {
        Solution solution = new P16ThreeSumClosest().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        return doublePointMethod(nums, target);
//        return stupidMethod(nums, target);
    }

    /**
     * 法一 双指针法
     * 固定一个指针，然后用两边夹逼遍历另两个指针
     * 时间复杂度：O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public int doublePointMethod(int[] nums, int target) {
        int sum = 0, res = Integer.MAX_VALUE / 2; //防止target为负数
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    sum = nums[i] + nums[left] + nums[right];
                    if (sum == target) return target;
                    if (Math.abs(sum - target) < Math.abs(res - target)) res = sum;
                    if (sum > target) {
                        while (left < right && nums[right - 1] == nums[right]) right--;
                        right--;
                    } else {
                        while (left < right && nums[left + 1] == nums[left]) left++;
                        left++;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 法一 暴力法
     * 时间复杂度：O(n^3)
     * @param nums
     * @param target
     * @return
     */
    public int stupidMethod(int[] nums, int target) {
        int sum = 0, distance = Integer.MAX_VALUE, res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(sum - target) < distance) {
                        res = sum;
                        distance = Math.abs(sum - target);
                    }
                }
            }
        }
        return res;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}