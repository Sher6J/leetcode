//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 位运算 分治算法


package cn.sher6j.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//Java：数组中出现次数超过一半的数字
public class POffer39ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 39ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
//        return hashMethod(nums);
//        return sortMethod(nums);
        /**
         * 法三：投票法
         */
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }

    /**
     * 法二：排序法
     * 将数组 nums 排序，由于众数的数量超过数组长度一半，
     * 因此 数组中点的元素 一定为众数。
     * 此方法时间复杂度 O(N · log2 N)
     * @param nums
     * @return
     */
    public int sortMethod(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 法一：哈希表统计法
     * 遍历数组 nums ，用 HashMap 统计各数字的数量，
     * 最终超过数组长度一半的数字则为众数。
     * 此方法时间和空间复杂度均为 O(N)O(N)
     * @param nums
     * @return
     */
    public int hashMethod(int[] nums) {
        if (nums.length == 1 || nums.length == 2) return nums[0];
        int len = nums.length;
        //<key, value> ---- <数字，数字出现次数>
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int count = map.get(nums[i]);
                count++;
                if (count > len / 2) return nums[i];
                map.put(nums[i], count);
            }
        }
        return -1; //无众数时返回0
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}