package cn.sher6j.week.doubleweek31;

import java.util.ArrayList;

/**
 * @author sher6j
 * @create 2020-06-27-22:55
 */

class Solution {

    /**
     * 5456. 在区间范围内统计奇数数目
     * @param low
     * @param high
     * @return
     */
    public int countOdds(int low, int high) {
        if (low % 2 == 0 && high % 2 == 0) {
            return (high - low) / 2;
        } else {
            return (high - low) / 2 + 1;
        }
    }
}
