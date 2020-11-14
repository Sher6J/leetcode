//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 442 👎 0


package cn.sher6j.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Java：组合总和 II
public class P40CombinationSumIi{
    public static void main(String[] args) {
        Solution solution = new P40CombinationSumIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(res, new LinkedList<>(), candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, LinkedList<Integer> path, int[] candidates, int remain, int start) {
        if (remain < 0) {
            return;
        }

        if (remain == 0) {
            res.add(new ArrayList<>(path));
        }

        for (int i = start; i < candidates.length; i++) {
            // skip duplications
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            backtrack(res, path, candidates, remain - candidates[i], i + 1);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}