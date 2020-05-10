//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
// 输出: [1,3,12,0,0]
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针


package cn.sher6j.leetcode.editor.cn;

import java.util.Arrays;

//Java：移动零
public class P283MoveZeroes{
    public static void main(String[] args) {
        Solution solution = new P283MoveZeroes().new Solution();
        // TO TEST
        int[] input = new int[]{0, 1, 0, 3, 12};
        solution.moveZeroes(input);
        System.out.println(Arrays.toString(input));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        /**
         * 解题思路
         * 遍历数组，将非零0的元素移动数组前方，用index下标记录。
         * 遍历结束，对index值后的元素统一设为0
         *//*
        int index = 0;
        for (int num : nums) {
            if (num != 0){
                nums[index++] = num;
            }
        }
//        for (int j = index; j < nums.length; j++){
//            nums[j] = 0;
//        }
        while (index < nums.length) {
            nums[index++] = 0;
        }*/


        /**
         * j用来记录每个非0元素最后的结果索引，然后将元素由原位置移动到结果位置，再将原位置元素置为0
         *//*
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j){
                    nums[i] = 0;
                }
                j++;
            }
        }*/

        /**
         * 所谓要把0移动到数组后面，
         * 其实就是把非0数给移动到数组前面，
         * 而每个非0数需要移动的步数其实就是这个非0数前面0的个数。
         */
        int count = 0; //用来记录某元素前的0元素个数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count ++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        for (int i = nums.length - count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}