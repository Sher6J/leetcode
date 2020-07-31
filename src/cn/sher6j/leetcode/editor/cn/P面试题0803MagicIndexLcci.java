//魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找
//出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。 
//
// 示例1: 
//
//  输入：nums = [0, 2, 3, 4, 5]
// 输出：0
// 说明: 0下标的元素为0
// 
//
// 示例2: 
//
//  输入：nums = [1, 1, 1]
// 输出：1
// 
//
// 说明: 
//
// 
// nums长度在[1, 1000000]之间 
// 此题为原书中的 Follow-up，即数组中可能包含重复元素的版本 
// 
// Related Topics 数组 二分查找


package cn.sher6j.leetcode.editor.cn;
//Java：魔术索引
public class P面试题0803MagicIndexLcci{
    public static void main(String[] args) {
//        Solution solution = new P面试题 08.03MagicIndexLcci().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMagicIndex(int[] nums) {
//        return stupidMethod(nums);
        return getRes(nums, 0, nums.length - 1);
    }

    /**
    * 二分搜索
    * @param nums
    * @param left
    * @param right
    * @return
    */
    public int getRes(int[] nums, int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        int leftRes = getRes(nums, left, mid - 1);
        if (leftRes != -1) {
            return leftRes;
        } else if (nums[mid] == mid) {
            return mid;
        } else {
            return getRes(nums, mid + 1, right);
        }
    }

    /**
     * 暴力解法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int stupidMethod(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) return i;
        }
        return -1;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}