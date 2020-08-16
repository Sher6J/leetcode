package cn.sher6j.week.week202;

import java.util.*;

/**
 * @author sher6j
 * @create 2020-08-16-10:27
 */
class Solution {
    /**
     * 5185. 存在连续三个奇数的数组
     * @param arr
     * @return
     */
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) count++;
            else count = 0;
            if (count == 3) return true;
        }
        return false;
    }

    /**
     * 5488. 使数组中所有元素相等的最小操作数
     * @param n
     * @return
     */
    public int minOperations(int n) {
        if (n % 2 == 1) {
            int count = 0;
            int i = 0;
            while (i < n / 2 + 1) {
                count += (2 * i);
                i++;
            }
            return count;
        } else {
            int count = 0;
            int i = 0;
            while (i < n / 2) {
                count += (2 * i + 1);
                i++;
            }
            return count;
        }
    }

    /**
     * 5489. 两球之间的磁力
     * @param position
     * @param m
     * @return
     */
//    public int maxDistance(int[] position, int m) {
//
//    }

    /**
     * 5490. 吃掉 N 个橘子的最少天数
     * @param n
     * @return
     */
    private Map<Integer,Integer> map=new HashMap<>();
    public int minDays(int n) {
        if(n<=1) return n;
        if (map.containsKey(n)){
            return map.get(n);
        }
        int a=n%3+minDays((n-n%3)/3)+1;
        int b=n%2+minDays((n-n%2)/2)+1;
        int min=Math.min(a,b);
        map.put(n,min);
        return min;
    }
}
