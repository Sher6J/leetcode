//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 分治算法 动态规划


package cn.sher6j.leetcode.editor.cn;
//Java：连续子数组的最大和
public class POffer42LianXuZiShuZuDeZuiDaHeLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 42LianXuZiShuZuDeZuiDaHeLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
//        return noSpaceOptimize(nums);
        return withSpaceOptimize(nums);
    }

    /**
     * 动态规划：
     * 因为 dp[i] 只和 dp[i - 1] 有关
     * @param nums
     * @return
     */
    private int withSpaceOptimize(int[] nums) {
        int pre = nums[0];
        int max = pre;
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(pre + nums[i], nums[i]);
            pre = cur;
            max = Math.max(cur, max);
        }
        return max;
    }


    /**
     * 动态规划：
     * 当以第 i-1 个数字结尾的子数组中所有数组和小于0时，不如不加，干脆只用第 i 个数字自己
     * @param nums
     * @return
     */
    public int noSpaceOptimize(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}