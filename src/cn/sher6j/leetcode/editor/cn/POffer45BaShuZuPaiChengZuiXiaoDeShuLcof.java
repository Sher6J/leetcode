//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 排序


package cn.sher6j.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Random;

//Java：把数组排成最小的数
public class POffer45BaShuZuPaiChengZuiXiaoDeShuLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 45BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
//        quickSort(strs, 0, strs.length - 1);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }

    public void quickSort(String[] strs, int left, int right) {
        if (right <= left) return;
        int pivotIdx = partition(strs, left, right);
        quickSort(strs, left, pivotIdx - 1);
        quickSort(strs, pivotIdx + 1, right);
    }

    public int partition(String[] strs, int left, int right) {
        int randomIdx = new Random().nextInt(right - left + 1) + left;
        swap(strs, left, randomIdx);
        int i = left + 1, j = right;
        String pivot = strs[left];
        while (true) {
            while (i <= right && (strs[i] + pivot).compareTo(pivot + strs[i]) < 0) {
                i++;
            }
            while (j > left && (strs[j] + pivot).compareTo(pivot + strs[j]) > 0) {
                j--;
            }
            if (i >= j) break;
            swap(strs, i, j);
            i++;
            j--;
        }
        swap(strs, left, j);
        return j;
    }

    public void swap(String[] strs, int i, int j) {
        String tmp = strs[i];
        strs[i] = strs[j];
        strs[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}