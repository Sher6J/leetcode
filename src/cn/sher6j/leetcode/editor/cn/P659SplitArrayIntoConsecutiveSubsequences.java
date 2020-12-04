//给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。 
//
// 如果可以完成上述分割，则返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入: [1,2,3,3,4,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3
//3, 4, 5
// 
//
// 
//
// 示例 2： 
//
// 输入: [1,2,3,3,4,4,5,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3, 4, 5
//3, 4, 5
// 
//
// 
//
// 示例 3： 
//
// 输入: [1,2,3,4,4,5]
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 输入的数组长度范围为 [1, 10000] 
// 
//
// 
// Related Topics 堆 贪心算法 
// 👍 143 👎 0


package cn.sher6j.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

//Java：分割数组为连续子序列
public class P659SplitArrayIntoConsecutiveSubsequences{
    public static void main(String[] args) {
        Solution solution = new P659SplitArrayIntoConsecutiveSubsequences().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPossible(int[] nums) {
        return hashMethod(nums);
    }

    /**
     * Map的键为子序列的最后一个数字
     *      值为最小堆，用于存储所有的子序列长度
     * 遍历到 x 时：
     * - 若哈希表中存在 x-1（有以 x-1 结尾的子序列），取出 x-1 结尾的最小长度 preLen       ①
     *   将 preLen 加 1 后作为以 x 结尾的子序列长度。        ②
     *   此时以 x-1 结尾的子序列减少一个，以 x 结尾的子序列增加一个
     * - 若哈希表中不存在 x-1，则以 x 结尾的子序列长度初始为 1            ③
     * @param nums
     * @return
     */
    private boolean hashMethod(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                map.put(n, new PriorityQueue<>());
            }
            if (map.containsKey(n - 1)) {
                int preLen = map.get(n - 1).poll(); // ①
                if (map.get(n - 1).isEmpty()) {
                    map.remove(n - 1);
                }
                map.get(n).offer(preLen + 1);    // ②
            } else {
                map.get(n).offer(1);             // ③
            }
        }
        Set<Integer> keys = map.keySet();
        for (int key : keys) {
            PriorityQueue<Integer> lens = map.get(key);
            if (lens.peek() < 3) {
                return false;
            }
        }
        return true;
    }


    }
//leetcode submit region end(Prohibit modification and deletion)

}