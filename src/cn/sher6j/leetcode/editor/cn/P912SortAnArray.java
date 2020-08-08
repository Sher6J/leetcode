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

import java.util.Random;

//Java：排序数组
public class P912SortAnArray{
    public static void main(String[] args) {
        Solution solution = new P912SortAnArray().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 列表长度 ≤ 该长度 时，不用速度快的排序而是用插入排序
    private static final int INSERTION_SORT_THRESHOLD = 7;

    public int[] sortArray(int[] nums) {
//        int len = nums.length;
//        quickSort(nums, 0, len - 1);
//        int[] tmp = new int[len];
//        mergeSort(nums, 0, len - 1, tmp);
        return heapSort(nums);
//        return nums;
    }

    /**
     * 堆排序
     * @param nums
     * @return
     */
    public int[] heapSort(int[] nums) {
        int len = nums.length;
        heapInitial(nums); // 初始建堆
        for (int i = len - 1; i >= 1;) {
            // 堆顶元素（最大元素）交换到数组末尾
            swap(nums, 0, i);
            i--; // 堆有效部分减少
            // 新堆顶元素下沉，使得区间[0, i]堆有序
            sink(nums, 0, i);
        }
        return nums;
    }

    /**
     * 初始建堆
     * @param nums
     */
    public void heapInitial(int[] nums) {
        int len = nums.length;
        // 大小为1的堆直接被跳过
        for (int i = (len - 1) / 2; i >= 0; i--) {
            sink(nums, i, len - 1);
        }
    }

    /**
     * 由上至下的堆有序化（下沉）
     * @param nums
     * @param k 当前要下沉元素索引
     * @param end 最坏情况下下沉到的索引，即[0, end]为nums的有效部分
     */
    public void sink(int[] nums, int k, int end) {
        while (2 * k + 1 <= end) {
            int j = 2 * k + 1;
            // j为两个子节点中较大者的索引
            if (j + 1 <= end && nums[j + 1] > nums[j]) j++;
            if (!(nums[j] > nums[k])) break;
            swap(nums, j, k);
            k = j;
        }
    }

    /**
     * 归并排序，对数组区间 [left, right] 归并排序
     * @param nums
     * @param left
     * @param right
     * @param tmp
     */
    public void mergeSort(int[] nums, int left, int right, int[] tmp) {
        if (right <= left) return; // 分片只有一个元素时无需排序
        // 分片元素少时用插入排序
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(nums, left, mid, tmp);
        mergeSort(nums, mid + 1, right, tmp);

        // 数组的两个子数组本身有序，即左半子数组元素全部小于右半子数组元素，无需归并
        if (nums[mid] <= nums[mid +1]) return;

        mergeTowSortedArray(nums, left, mid, right, tmp);
    }

    /**
     * 合并数组的两个有序子数组
     * 左半数组为[left, mid]， 右半数组为[mid + 1, right]
     * @param nums
     * @param left
     * @param mid [left, mid]、[mid + 1, right]分别有序
     * @param right
     * @param tmp 全局使用的临时数组
     */
    public void mergeTowSortedArray(int[] nums, int left, int mid, int right, int[] tmp) {
        System.arraycopy(nums, left, tmp, left, right - left + 1);

        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            // 左数组已经归并完毕，只将右数组剩余元素填入即可
            if (i == mid + 1) {
                nums[k] = tmp[j];
                j++;
            }
            // 右数组已经归并完毕，只将左数组剩余元素填入即可
            else if (j == right + 1) {
                nums[k] = tmp[i];
                i++;
            }
            // 这里用 <= 为了维持排序的稳定性
            else if (tmp[i] <= tmp[j]) {
                nums[k] = tmp[i];
                i++;
            } else {
                nums[k] = tmp[j];
                j++;
            }
        }
    }

    /**
     * 快速排序，对数组区间 [left, right] 快排
     * 时间复杂度：O(N·logN)
     * 空间复杂度：O(logN) -- 递归函数的栈空间
     * @param nums
     * @param left
     * @param right
     */
    public void quickSort(int[] nums, int left, int right) {
        if (right <= left) return; // 分片只有一个元素时无需排序
        // 分片元素少时用插入排序
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }
        // 切分元素索引
        int pivotIdx = partition(nums, left, right);
        quickSort(nums, left, pivotIdx - 1);
        quickSort(nums, pivotIdx + 1, right);
    }

    /**
     * 对数组子区间 [left, right] 使用插入排序
     * @param nums
     * @param left
     * @param right
     */
    public void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int tmp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > tmp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = tmp;
        }
    }

    /**
     * 返回切分元素的索引，数组中切分元素左侧均小于等于切分元素，右侧均大于等于切分元素
     * @param nums
     * @param left inclusive
     * @param right inclusive
     * @return 切分元素索引
     */
    public int partition(int[] nums, int left, int right) {
        int randomIdx = new Random().nextInt(right - left + 1) + left;
        swap(nums, left, randomIdx);
        int i = left + 1, j = right;
        int pivot = nums[left];
        while (true) {
            while (i <= right && nums[i] < pivot) {
                i++;
            }
            while (j > left && nums[j] > pivot) {
                j--;
            }
            if (i >= j) break;
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, left, j); // 这里必须是j, j才是左子数组最右侧的元素
        return j;
    }

    /**
     * 冒泡排序 -- 力扣通过不了，超时 通过 10/11
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