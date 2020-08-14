//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
//


package cn.sher6j.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//Java：数组中数字出现的次数
public class POffer56IShuZuZhongShuZiChuXianDeCiShuLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 56 - IShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumbers(int[] nums) {
//        return mapMethod(nums);
        return XORMethod(nums);
    }

    /**
     * 法二：异或法
     *      ① 对所有数字进行一次异或，得到 两个出现一次的数字 的异或值；
     *      ② 在异或结果中找到任意为 1 的一位；
     *      ③ 根据这一位将所有的数字进行分组为两组：
     *          一组为和这位异或结果为0（即该位为1）
     *          一组为和这位异或结果非0（即该位为0）；
     *      ④ 在每个组内进行异或操作，两组的结果即为所求；
     * 对于②，此处 lowbit = sum & (-sum) 取的为异或结果中的最低的1位，如：
     *            sum = 1 1 0 1 0 由于    取反 = 反码 + 1
     *           -sum = 0 0 1 0 1 + 1
     *                = 0 0 1 1 0
     *   sum & (-sum) = 0 0 0 1 0 得到异或结果的最低1位
     * @param nums
     * @return
     */
    private int[] XORMethod(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum = sum ^ n;
        }
        int lowbit = sum & (-sum);
        int a = 0, b = 0;
        for (int n : nums) {
            if ((n & lowbit) == 0) a = a ^ n;
            else b = b ^ n;
        }
        return new int[]{a, b};
    }

    /**
     * 法一：哈希表法
     * 用HashMap存放数字出现次数
     * 返回出现1次的即可
     * 时间复杂度满足要求O(n)
     * 但是空间复杂度为O(n)，不满足要求的O(1)
     * @param nums
     * @return
     */
    public int[] mapMethod(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], 2);
            }
        }
        int[] res = new int[2];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1) {
                res[idx] = nums[i];
                idx++;
            }
            if (idx == 2) break;
        }
        return res;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}