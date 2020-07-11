//给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 num
//s[i] 的元素的数量。 
//
// 示例: 
//
// 输入: [5,2,6,1]
//输出: [2,1,1,0] 
//解释:
//5 的右侧有 2 个更小的元素 (2 和 1).
//2 的右侧仅有 1 个更小的元素 (1).
//6 的右侧有 1 个更小的元素 (1).
//1 的右侧有 0 个更小的元素.
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法


package cn.sher6j.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//Java：计算右侧小于当前元素的个数
public class P315CountOfSmallerNumbersAfterSelf{
    public static void main(String[] args) {
        Solution solution = new P315CountOfSmallerNumbersAfterSelf().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        return stupidMethod(nums);
    }

    /**
     * 法一：暴力法，但是超时 ———— 15 / 16 个通过测试用例
     * @param nums
     * @return
     */
    private List<Integer> stupidMethod(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        if (nums.length == 0) return res;
        res.addFirst(0);
        if (nums.length == 1) return res;
        for (int i = nums.length - 2; i >= 0; i--) {
            int count = 0;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[i]) count++;
            }
            res.addFirst(count);


        }
        return res;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}