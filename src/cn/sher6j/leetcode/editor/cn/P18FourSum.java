//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针


package cn.sher6j.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：四数之和
public class P18FourSum{
    public static void main(String[] args) {
        Solution solution = new P18FourSum().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                for (int j = nums.length - 1; j > 2 ; j--) {
                    if (j == nums.length - 1 || (j < nums.length - 1 && nums[j] != nums[j + 1])) {
                        int sum = target - nums[i] - nums[j];
                        int left = i + 1, right = j - 1;
                        while (left < right) {
                            if (nums[left] + nums[right] == sum) {
                                res.add(Arrays.asList(nums[i], nums[left], nums[right], nums[j]));
                                while (left < right && nums[left + 1] == nums[left]) left++;
                                while (left < right && nums[right - 1] == nums[right]) right--;
                                left++;
                                right--;
                            } else if (nums[left] + nums[right] > sum) {
                                right--;
                            } else {
                                left++;
                            }
                        }
                    }

                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}