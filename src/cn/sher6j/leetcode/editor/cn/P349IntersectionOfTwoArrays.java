//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找


package cn.sher6j.leetcode.editor.cn;

import java.util.*;

//Java：两个数组的交集
public class P349IntersectionOfTwoArrays{
    public static void main(String[] args) {
        Solution solution = new P349IntersectionOfTwoArrays().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //350题更为通用，此题可以看做是350的特殊化即可
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int size = set.size();
        int[] res = new int[size];
        Iterator<Integer> iterator = set.iterator();
        int i = 0;
        while (iterator.hasNext()) res[i++] = iterator.next();
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}