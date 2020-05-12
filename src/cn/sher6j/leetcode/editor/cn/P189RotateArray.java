//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组


package cn.sher6j.leetcode.editor.cn;
//Java：旋转数组
public class P189RotateArray{
    public static void main(String[] args) {
        Solution solution = new P189RotateArray().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {

        /**
         * 暴力旋转
         */
//        int temp, previous;
//        for (int i = 0; i < k; i++) {
//            previous = nums[nums.length - 1];
//            for (int j = 0; j < nums.length; j++) {
//                temp = nums[j];
//                nums[j] = previous;
//                previous = temp;
//            }
//        }

        /**
         * 开辟新数组，空间复杂度为O(n)
         */
//        int[] temp = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            temp[(i + k) % nums.length] = nums[i];
//        }
////        nums = temp; //这样的话就会出错，因为调用函数是按值传递，方法得到的是所有参数值的一个副本
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = temp[i];
//        }

        /**
         * 环装替换法
         */
        int count = 0; //记录已经交换位置的元素个数，当count==nums.length时代表交换结束
        //start为最开始交换的位置，整个循环当count达到数组长度时结束
        //start++对应于经过一环交换最后一个元素来到了第一个元素的位置，即n%k==0
        for (int start = 0; count < nums.length; start++) {
            int current = start; //从0位置开始交换
            int pre = nums[current];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = pre;
                current = next;
                pre = temp;
                count ++;
            } while (start != current);
        }

    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}