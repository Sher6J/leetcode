//给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 排序 
// 👍 434 👎 0


package cn.sher6j.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//Java：最大数
public class P179LargestNumber{
    public static void main(String[] args) {
        Solution solution = new P179LargestNumber().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] numToStr = new String[n];
        for (int i = 0; i < n; i++) {
            numToStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numToStr, new Comparator<String>() {
            // 本来想用数学方法算每个数的首位，若相同再递归比较第二位
            // 看了下面的比较方法直呼好家伙
            // 设 302 和 320： 320203 > 302320.....   666666
            @Override
            public int compare(String s1, String s2) {
                String order1 = s1 + s2;
                String order2 = s2 + s1;
                return order2.compareTo(order1);
            }
        });

        if (numToStr[0].equals("0")) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        for(String str : numToStr) {
            res.append(str);
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}