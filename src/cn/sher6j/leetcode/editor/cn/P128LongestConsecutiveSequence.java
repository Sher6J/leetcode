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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
//        return hashMethod(nums);
        return ufMethod(nums);
    }

    private int ufMethod(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        UnionFind uf = new UnionFind(nums);
        for (int num : nums) {
            uf.union(num, num + 1);
        }
        int max = 1;
        for (int num : nums) {
            max = Math.max(max, uf.find(num) - num + 1);
        }
        return max;
    }

    private class UnionFind {
        private Map<Integer, Integer> parent;

        public UnionFind(int[] nums) {
            int n = nums.length;
            parent = new HashMap<>(n);
            for (int i = 0; i < n; i++) {
                parent.put(nums[i], nums[i]);
            }
        }

        public void union(int x, int y) {
            Integer rootX = find(x);
            Integer rootY = find(y);
            if (rootX == null || rootY == null) {
                return;
            }
            if (rootX.equals(rootY)) {
                return;
            }
            parent.put(rootX, rootY);
        }

        public Integer find(int x) {
            if (!parent.containsKey(x)) {
                return null;
            }
            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }


        private int hashMethod(int[] nums) {
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
                        currLength++;
                    }

                    longestLength = Math.max(longestLength, currLength);
                }
            }
            return longestLength;
        }
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}