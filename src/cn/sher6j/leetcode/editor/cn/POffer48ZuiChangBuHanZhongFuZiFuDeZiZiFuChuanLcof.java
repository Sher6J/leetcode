//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-rep
//eating-characters/ 
// Related Topics 哈希表 双指针 Sliding Window


package cn.sher6j.leetcode.editor.cn;

import java.util.HashMap;

//Java：最长不含重复字符的子字符串
public class POffer48ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 48ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
//        return dpNoSpaceOptimize(s);
        return dpWithSpaceOptimize(s);
    }

    /**
     * 动态规划带空间优化
     * @param s
     * @return
     */
    public int dpWithSpaceOptimize(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>(26);
        int last = 1, curr, max = 1;
        map.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            int lastIdx = map.getOrDefault(s.charAt(i), -1);
            map.put(s.charAt(i), i);
            int distance = i - lastIdx;
            if (distance <= last) {
                curr = distance;
            } else {
                curr = last + 1;
            }
            last = curr;
            max = Math.max(max, curr);
        }
        return max;
    }

    /**
     * 法一：动态规划
     * dp[i]：以第 i个字符为结尾的不包含重复字符的子字符串的最长长度
     * base case：dp[0] = 1
     * return：max(dp[i])
     * 对于 dp[i]：记第 i 个字符距上一次出现位置为 d
     *      ① d <= dp[i - 1]：dp[i] = d
     *      ② d > dp[i - 1]: dp[i] = dp[i - 1] + 1
     * @param s
     * @return
     */
    public int dpNoSpaceOptimize(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int dp[] = new int[n]; // dp[i]为从字符串开始到第i个字符的最长子字符串长度
        HashMap<Character, Integer> map = new HashMap<>(26);
        dp[0] = 1;
        int max = dp[0];
        map.put(s.charAt(0), 0);
        for (int i = 1; i < n; i++) {
//            int lastIdx = map.containsKey(s.charAt(i)) ? map.get(s.charAt(i)) : -1;
            int lastIdx = map.getOrDefault(s.charAt(i), -1);
            map.put(s.charAt(i), i);
            int distance = i - lastIdx;
            if (distance <= dp[i - 1]) {
                dp[i] = distance;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}