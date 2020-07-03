//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
//


package cn.sher6j.leetcode.editor.cn;
//Java：排序数组
public class P912SortAnArray{
    public static void main(String[] args) {
        Solution solution = new P912SortAnArray().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
//        return bubbleSort(nums);
//        return selectionSort(nums);
//        return insertionSort(nums);
        mergeSort(nums, 0, nums.length - 1, temp);
        nums = temp;
        return nums;
    }

    public void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) return;
        int mid = (left + right) >> 1;
        mergeSort(nums, 1, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        int i = left, j = mid + 1;
        int tempIdx = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) temp[tempIdx++] = nums[i++];
            else temp[tempIdx++] = nums[j++];
        }
        while (i <= mid) temp[tempIdx++] = nums[i++];
        while (j <= right) temp[tempIdx++] = nums[j++];
    }

    /**
     * 冒泡排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int[] bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i > -1; i--) {
            //若内层循环中一次交换都没有进行，证明数组已经是升序数组
            boolean isSorted = true;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    isSorted = false;
                }
            }
            if (isSorted) break;
        }
        return nums;
    }

    /**
     * 交换数组中两个元素
     * @param nums
     * @param i1
     * @param i2
     */
    public void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    /**
     * 选择排序
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * @param nums
     * @return
     */
    public int[] selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            swap(nums, i, minIdx);
        }
        return nums;
    }

    /**
     * 插入排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int[] insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}