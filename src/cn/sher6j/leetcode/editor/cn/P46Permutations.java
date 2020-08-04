//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法


package cn.sher6j.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//Java：全排列
public class P46Permutations{
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>(); //路径
        int[] visited = new int[nums.length];
        backtrack(track, nums, res, visited);
        return res;
    }

    /**
     * 回溯
     * @param track 路径
     * @param nums 选择列表
     * @param res 结果
     * @param visited 访问数组，用来记录选择列表中的选择为否被选择，这样只需要O(1)就能判断是否访问
     */
    public void backtrack(LinkedList<Integer> track, int[] nums, List<List<Integer>> res, int[] visited) {
        //若满足结束条件，结果中添加路径，返回
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        //在选择列表中进行选择
        for (int i = 0; i < nums.length; i++) {
//            if (track.contains(nums[i])) continue;
            if (visited[i] == 1) continue; //用访问数组记录不需要像上面注释掉的代码一样进行O(n)的遍历
            visited[i] = 1;
            track.add(nums[i]);//做选择
            backtrack(track, nums, res, visited);//递归
            visited[i] = 0;
            track.removeLast();//撤销选择
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}