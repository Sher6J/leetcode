//给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。 
//
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。 
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。 
//
// 示例: 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[5,6]
// 
// Related Topics 数组 
// 👍 473 👎 0


package cn.sher6j.leetcode.editor.cn;

import java.util.*;

//Java：找到所有数组中消失的数字
public class P448FindAllNumbersDisappearedInAnArray{
    public static void main(String[] args) {
        Solution solution = new P448FindAllNumbersDisappearedInAnArray().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
//        return setMethod(nums);
        return negtiveMethod(nums);
    }

    /**
     * 出现的数字就将其位置变负
     * @param nums
     * @return
     */
    private List<Integer> negtiveMethod(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }
        List<Integer> res = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] > 0) {
                res.add(i);
            }
        }
        return res;
    }

    /**
     * 法一：哈希表法
     * 哈希表统计出现过的数字，没出现过的加入到结果集
     * @param nums
     * @return
     */
    private List<Integer> setMethod(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}