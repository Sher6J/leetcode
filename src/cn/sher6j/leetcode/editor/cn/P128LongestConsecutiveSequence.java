//给定一个未排序的整数数组，找出最长连续序列的长度。 
//
// 要求算法的时间复杂度为 O(n)。 
//
// 示例: 
//
// 输入: [100, 4, 200, 1, 3, 2]
//输出: 4
//解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。 
// Related Topics 并查集 数组


package cn.sher6j.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：最长连续序列
public class P128LongestConsecutiveSequence{
    public static void main(String[] args) {
        Solution solution = new P128LongestConsecutiveSequence().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestLength = 0;
        for (int num : set) {
            // 跳过所有不是连续数字开头的数组
            if (!set.contains(num - 1)) {
                int currNum = num; //当前数字
                int currLength = 1;

                while (set.contains(currNum + 1)) {
                    currNum += 1;
                    currLength ++;
                }

                longestLength = Math.max(longestLength, currLength);
            }
        }
        return longestLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}