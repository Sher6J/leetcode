//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
//
// 示例 1： 
//
// 输入：[3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 输入：[2,2,2,0,1]
//输出：0
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/ 
// Related Topics 二分查找


package cn.sher6j.leetcode.editor.cn;
//Java：旋转数组的最小数字
public class POffer11XuanZhuanShuZuDeZuiXiaoShuZiLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 11XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        int midIdx = 0;
        while (numbers[left] >= numbers[right]) {
            if (right - left == 1) {
                midIdx = right;
                break;
            }
            midIdx = (left + right) / 2;
            //如果下标为left,right,midInx的三个数相等，则只能顺序查找
            if (numbers[left] == numbers[right] && numbers[left] == numbers[midIdx]) {
                return minInOrder(numbers, left, right);
            } else if (numbers[left] <= numbers[midIdx]) {
                left = midIdx;
            } else if (numbers[right] >= numbers[midIdx]) {
                right = midIdx;
            }
        }
        return numbers[midIdx];
//        return forLoop(numbers);
    }


    public int minInOrder(int[] numbers, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            if (numbers[i] < numbers[i - 1]) return numbers[i];
        }
        return numbers[left];
    }


    /**
     * 法一：遍历数组
     * 时间复杂度：O(n)
     * @param numbers
     * @return
     */
    public int forLoop(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i - 1]) return numbers[i];
        }
        return numbers[0];
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}