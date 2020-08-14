//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//


package cn.sher6j.leetcode.editor.cn;
//Java：数组中的逆序对
public class POffer51ShuZuZhongDeNiXuDuiLcof{
    public static void main(String[] args) {
//        Solution solution = new P剑指 Offer 51ShuZuZhongDeNiXuDuiLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reversePairs(int[] nums) {
//        return stupidMethod(nums);
        int len = nums.length;
        if (len < 2) return 0;
        int[] tmp = new int[len];
        int count = mergeSort(nums, 0, len - 1, tmp);
        return count;
    }

    public int mergeSort(int[] nums, int left, int right, int[] tmp) {
        if (right <= left) return 0;
        int mid = left + (right - left) / 2;
        int leftCount = mergeSort(nums, left, mid, tmp);
        int rightCount = mergeSort(nums, mid + 1, right, tmp);
        if (nums[mid] <= nums[mid + 1]) return leftCount + rightCount;
        int crossCount = mergeTwoSortedArrayAndGetCount(nums, left, mid, right, tmp);
        return leftCount + crossCount + rightCount;
    }

    /**
     * 从前往后归并
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param tmp
     * @return
     */
    public int mergeTwoSortedArrayAndGetCount(int[] nums, int left, int mid, int right, int[] tmp) {
        System.arraycopy(nums, left, tmp, left, right - left + 1);
        int i = left, j = mid + 1, count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = tmp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = tmp[i];
                i++;
            } else if (tmp[i] <= tmp[j]) {
                nums[k] = tmp[i];
                i++;
            } else {
                nums[k] = tmp[j];
                count = count + mid - i + 1;
                j++;
            }
        }
        return count;
    }

    /**
     * 从后往前归并
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param tmp
     * @return
     */
    public int mergeTwoSortedArrayAndGetCount2(int[] nums, int left, int mid, int right, int[] tmp) {
        System.arraycopy(nums, left, tmp, left, right - left + 1);
        int i = mid;
        int j = right;
        int count = 0;
        for (int k = right; k >= left; k--) {
            if (i == left - 1) {
                if (nums[j] < nums[left]) {
                    count = count + j - mid;
                }
                nums[k] = tmp[j];
                j--;
            }
            else if (j == mid) {
                nums[k] = tmp[i];
                i--;
            }
            else if (tmp[i] > tmp[j]) {
                count = count + j - mid;
                nums[k] = tmp[i];
                i--;
            } else {
                nums[k] = tmp[j];
                j--;
            }
        }
        return count;
    }

    /**
     * 法一：暴力法
     * 超时
     * @param nums
     * @return
     */
    private int stupidMethod(int[] nums) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j]) count++;
            }
        }
        return count;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}