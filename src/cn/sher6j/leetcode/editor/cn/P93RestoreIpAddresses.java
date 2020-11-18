//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。 
//
// 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。 
//
// 
//
// 示例: 
//
// 输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"] 
// Related Topics 字符串 回溯算法


package cn.sher6j.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//Java：复原IP地址
public class P93RestoreIpAddresses{
    public static void main(String[] args) {
        Solution solution = new P93RestoreIpAddresses().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static final int LENGTH_PER_ADD = 3;
    public static final int NUM_OF_SEGMENT = 4;
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        LinkedList<String> res = new LinkedList<>();
        if (len < NUM_OF_SEGMENT || len > NUM_OF_SEGMENT * LENGTH_PER_ADD) return res;
        LinkedList<String> track = new LinkedList<>();
        int split = 0;
        backtrack(track, s, split, len, 0, res);
        return res;
    }

    /**
     * 回溯进行选择
     * @param track 路径
     * @param s 字符串即选择列表
     * @param split 已划分的ip段数目
     * @param len 字符串长度
     * @param begin 当前回溯开始划分的起点索引
     * @param res 结果
     */
    public void backtrack(LinkedList<String> track, String s, int split, int len,
                          int begin, LinkedList<String> res) {
        // 回溯框架 ———— 满足结束条件：res.add(路径);return；
        if (begin == len) {
            if (split == NUM_OF_SEGMENT) {
                res.add(String.join(".", track));
            }
            return;
        }

        // 剩余的字符串的字符数无法构成剩余位置的IP地址
        if (len - begin < (NUM_OF_SEGMENT - split) || len - begin > LENGTH_PER_ADD * (NUM_OF_SEGMENT - split)) return;

        // 回溯框架 ———— for 选择 in 选择列表
        // 共三种选择，将当前的1/2/3位字符作为下一段IP
        for (int i = 0; i < LENGTH_PER_ADD; i++) {
            if (begin + i >= len) break;

            int ipSegment = ifCanBeIpSegment(s, begin, begin + i);

            if (ipSegment != -1) {
                track.add(ipSegment + ""); // 回溯框架 ———— 做选择
                // 注意下面的参数split，必须写split + 1，而不能写split++或者++split！！！
                backtrack(track, s, split + 1, len, begin + i + 1, res); // 回溯框架 ———— 回溯
                track.removeLast(); // 回溯框架 ———— 撤销选择
            }
        }
    }

    /**
     * 判断字符串s的子区间 [left, right] 是否可以成为一个IP段
     * @param s 字符串
     * @param left 左区间，inclusive
     * @param right 右区间，inclusive
     * @return 若可以构成IP段，返回IP段的值，否则返回-1
     */
    public int ifCanBeIpSegment(String s, int left, int right) {
        int len = right - left + 1;

        // 当前IP段若长度大于1则不能以0开头
        if (len > 1 && s.charAt(left) == '0') return -1;

        int curIpValue = 0;
        for (int i = left; i <= right; i++) {
            curIpValue = curIpValue * 10 + s.charAt(i) - '0';
        }

        if (curIpValue > 255) return -1;
        return curIpValue;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}