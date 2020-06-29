package cn.sher6j.week.week195;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sher6j
 * @create 2020-06-28-10:31
 */
public class Solution {
    /**
     * 5448. 判断路径是否相交
     * @param path
     * @return
     */
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        String p = x + "," + y;
        HashSet<String> set = new HashSet<>();
        set.add(p);
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'N') {
                x++;
            } else if (path.charAt(i) == 'E') {
                y++;
            } else if (path.charAt(i) == 'S') {
                x--;
            } else {
                y--;
            }
            if (set.contains(x + "," + y)) return true;
            set.add(x + "," + y);
        }
        return false;
    }

    /**
     * 5449. 检查数组对是否可以被 k 整除
     * @param arr
     * @param k
     * @return
     */
    public boolean canArrange(int[] arr, int k) {
        List<Integer> list = new LinkedList<>();
        for (int n : arr) list.add(n);
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if ((list.get(i) + list.get(j)) % k == 0) {
                    list.remove(i);
                    list.remove(j);
                    i = 0;
                }
            }
        }
        if (list.size() == 0) return true;
        return false;
    }

    /**
     * 5450. 满足条件的子序列数目
     * @param nums
     * @param target
     * @return
     */
//    public int numSubseq(int[] nums, int target) {
//        Arrays.sort(nums);
//        int res = 0;
//        int sum = 0;
//        int start = 0, end = 0;
//        while (end < nums.length) {
//            sum = nums[start] + nums[end];
//            if (sum <= sum)
//
//        }
//
//    }
}
