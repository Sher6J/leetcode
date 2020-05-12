package cn.sher6j.leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author sher6j
 * @create 2020-05-12-9:38
 */
public class Test {
    public static void main(String[] args) {
        int[] num1 = new int[]{1, 3, 4, 5};
        rotate(num1, 2);
        System.out.println(Arrays.toString(num1));
    }
    public static void rotate(int[] nums, int k) {
        /**
         * 开辟新数组，空间复杂度为O(n)
         */
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i];
        }
//        nums = temp; //这样的话就会出错，没想明白为什么，需要下面重新复制
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
}
