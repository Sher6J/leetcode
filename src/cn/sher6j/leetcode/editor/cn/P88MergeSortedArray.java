//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针


package cn.sher6j.leetcode.editor.cn;
//Java：合并两个有序数组
public class P88MergeSortedArray{
    public static void main(String[] args) {
        Solution solution = new P88MergeSortedArray().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         * 新建一个数组用来存放num1的元素，然后在将新建的数组和nums2按序加入到nums1中
         * 时间复杂度为最优的O(m+n)
         * 但是犹豫开辟了新数组
         * 空间复杂度为O(m)
         */
//        int[] temp = new int[m];
//        System.arraycopy(nums1, 0, temp, 0, m); //将nums数组中有效数据copy到temp中
//
//        int p1 = 0; //代表temp数组的索引
//        int p2 = 0; //代表num2数组的索引
//        int p = 0; //代表num1数组的索引
//
//        while ((p1 < m) && (p2 < n) ) {
//            if (temp[p1] <= nums2[p2]) {
//                nums1[p] = temp[p1];
//                p++;
//                p1++;
//            } else {
//                nums1[p] = nums2[p2];
//                p++;
//                p2++;
//            }
//        }
//
//        if (p1 < m) {
//            System.arraycopy(temp, p1, nums1, p, m + n - p);
//        }
//        if (p2 < n) {
//            System.arraycopy(nums2, p2, nums1, p, m + n - p);
//        }

        /**
         * 上面的解法为什么需要开辟新的数组呢？可以怎么优化呢？
         * 因为是从小的数字开始填入nums1，这就要求必须有个临时数组暂存num1数组的值
         * 但是如果是从大的数字开始填入nums1呢，nums1的后面本来就是空白的，这样就不需要新建数组了
         * 时间复杂度不变，还是O(m+n)
         * 但是空间复杂度变为O(1)
         */
        int p1 = m-1; //索引执行nums1数组的最大值（最后一位）
        int p2 = n-1; //索引执行nums2数组的最大值（最后一位）
        int p = m + n - 1; //索引执行最终数组的最后一位（整个数组的最大值）

        while (p1 > -1 && p2 > -1) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p--;
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p--;
                p2--;
            }
        }

        //如果nums1还用数据，那剩下的一定是最小的，所以只需要考虑nums2
        if (p2 > -1) {
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}