//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 522 👎 0


package cn.sher6j.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Java：全排列 II
public class P47PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new P47PermutationsIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[n];
        backtrack(res, new LinkedList<>(), nums, visited);
        return res;
    }

    private void backtrack(List<List<Integer>> res, LinkedList<Integer> path, int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if ((i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) || visited[i] ==true) {
                continue;
            }

            visited[i] = true;
            path.addLast(nums[i]);

            backtrack(res, path, nums, visited);

            visited[i] = false;
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}