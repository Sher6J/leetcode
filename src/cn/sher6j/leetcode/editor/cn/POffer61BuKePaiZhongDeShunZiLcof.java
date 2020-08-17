//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任
//意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
//


package cn.sher6j.leetcode.editor.cn;

import java.util.Arrays;

//Java：扑克牌中的顺子
public class POffer61BuKePaiZhongDeShunZiLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 61BuKePaiZhongDeShunZiLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStraight(int[] nums) {
//        return method1(nums);
        return method2(nums);
    }

    /**
     * 法二：
     * ① 排序
     * ② 数组中除大小王有重复数字则返回false(相当于有对子不可能是顺子)
     * ③ 获取最大值和最小值，若 最大值 - 最小值 < 5 则返回true
     * @param nums
     * @return
     */
    public boolean method2(int[] nums) {
        int countOfZero = 0;
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) countOfZero++;
            else if (nums[i] == nums[i + 1]) return false;
        }
        return nums[4] - nums[countOfZero] < 5;
    }

    /**
     * 法一：
     * ① 排序
     * ② 统计数组 大小王即0 的个数 countOfZero
     * ③ 数组中除大小王有重复数字则返回false(相当于有对子不可能是顺子)
     * ④ 统计排序之后数组中相邻数字之间的空缺数 dif：
     *       若 countOfZero >= dif 则返回true
     * @param nums
     * @return
     */
    public boolean method1(int[] nums) {
        if (nums.length != 5) return false;
        Arrays.sort(nums);
        int countOfZero = 0;
        int dif = 0;
        if (nums[nums.length - 1] > 13) return false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) countOfZero++;
            if (nums[i] != 0 && nums[i] == nums[i + 1]) return false;
            if (nums[i] != 0 && nums[i + 1] != nums[i] + 1) {
                int curDif = nums[i + 1] - nums[i] - 1;
                dif += curDif;
            }
        }
        return countOfZero >= dif;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}