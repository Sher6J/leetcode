//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组 
// 👍 749 👎 0


package cn.sher6j.leetcode.editor.cn;
//Java：跳跃游戏 II
public class P45JumpGameIi{
    public static void main(String[] args) {
        Solution solution = new P45JumpGameIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int cur = n - 1;
        int steps = 0;
        while (cur > 0) {
            for (int i = 0; i < n; i++) {
                if (i + nums[i] >= cur) {
                    cur = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}