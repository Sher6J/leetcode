package cn.sher6j.week.doubleweek29;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author sher6j
 * @create 2020-06-27-22:55
 */

class Solution {

    /**
     * 5432. 去掉最低工资和最高工资后的工资平均值
     * @param salary
     * @return
     */
    public double average(int[] salary) {
        double sum = 0;
        double max = Integer.MIN_VALUE;
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < salary.length; i++) {
            if (salary[i] > max) max = salary[i];
            if (salary[i] < max) min = salary[i];
            sum += salary[i];
        }
        return (sum - max - min) / (salary.length - 2);
    }

    /**
     * 5433. n 的第 k 个因子 显示英文描述
     * @param n
     * @param k
     * @return
     */
    public int kthFactor(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            if (n % i == 0) list.add(i);
        }
        if (list.size() < k) return -1;
        return list.get(k - 1);
    }
}
