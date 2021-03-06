//给定两个数组，编写一个函数来计算它们的交集。 
//
// 示例 1: 
//
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2,2]
// 
//
// 示例 2: 
//
// 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出: [4,9] 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶: 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找


package cn.sher6j.leetcode.editor.cn;

import java.util.*;

//Java：两个数组的交集 II
public class P350IntersectionOfTwoArraysIi{
    public static void main(String[] args) {
        Solution solution = new P350IntersectionOfTwoArraysIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        return hashMapMethod(nums1, nums2);
        //        return sortedMethod(nums1, nums2);
    }

    /**
     * 法一：用HashMap存储每个元素的个数
     * 为了空间优化，HashMap的大小由较短的数组长度限制
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] hashMapMethod(int[] nums1, int[] nums2) {
        //保证第一个参数的数组长度小
        if (nums1.length > nums2.length) return intersect(nums2, nums1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            int count = map.getOrDefault(n, 0) + 1;
            map.put(n, count);
        }
        int[] res = new int[nums1.length];
        int index = 0;
        for (int n : nums2) {
            int count = map.getOrDefault(n, 0);
            if (count > 0) {
                res[index++] = n;
                count--;
                if (count > 0) map.put(n, count);
                else map.remove(n);
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }

    /**
     * 法二，先排序，然后双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] sortedMethod(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int size = list.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}