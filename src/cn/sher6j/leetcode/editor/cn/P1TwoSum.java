//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


package cn.sher6j.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author sher6j
 */ //Java：两数之和
public class P1TwoSum{
    public static void main(String[] args) {
        Solution solution = new P1TwoSum().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {

        /**
         * 一：两遍哈希
         * 说明：两遍哈希没问题。
         * 考虑{2,2,3,4,5} target == 4,这种情况，
         * map中只有【2,1】的键值对，而没有【2,0】的键值对。
         * 但是我们第二次遍历的时候，遍历的并不是哈希表，而是原数组。
         * 例如遍历到下标为0的数组元素时，从map中得到的值为1,1不等于0，所以就找到了。
         * 总之，不管map中存的是【2,0】还是【2,1】，我们遍历原始数组的时候，
         * 总会找到一个和map中值不一样的下标，从而凑成一对。
         */
//        //创建HashMap保存索引和值
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int num = target - nums[i];
//            if (map.containsKey(num) && map.get(num) != i) {
//                return new int[] {i, map.get(num)};
//            }
//        }
//        return new int[0];

        /**
         * 法二：一遍哈希
         * 优化：在迭代将元素插入到表中的同时，我们还会回过头来
         * 检查表中是否已经存在当前元素所对应的元素，
         * 如果存在则可以直接返回结果
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[] {map.get(num), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];

    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}