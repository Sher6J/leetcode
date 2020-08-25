//给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。 
//
// 示例: 
//
// 
//输入: [4, 6, 7, 7]
//输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7
//]] 
//
// 说明: 
//
// 
// 给定数组的长度不会超过15。 
// 数组中的整数范围是 [-100,100]。 
// 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。 
// 
// Related Topics 深度优先搜索


package cn.sher6j.leetcode.editor.cn;

import java.util.*;

//Java：递增子序列
public class P491IncreasingSubsequences{
    public static void main(String[] args) {
        Solution solution = new P491IncreasingSubsequences().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, new ArrayList<>(), -1);
        return res;
    }

    public void backtrack(List<List<Integer>> res, int[] nums, List<Integer> path, int idx) {
        if (path.size() > 1) res.add(new ArrayList<>(path));
        Set<Integer> set = new HashSet<>();
        for (int i = idx + 1; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            if (idx == -1 || nums[i] >= nums[idx]) {
                path.add(nums[i]);
                backtrack(res, nums, path, i);
                path.remove(path.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}