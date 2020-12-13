package cn.sher6j.week.week219;

/**
 * @author sher6j
 * @create 2020-12-13-10:29
 */
public class Solution {
    public int numberOfMatches(int n) {
        int res = 0;
        while (n > 1) {
            res += (n / 2);
            n = (n % 2 == 0) ? (n / 2) : (n / 2 + 1);
        }
        return res;
    }

    public int minPartitions(String n) {
        int max = 0;
        for (char c : n.toCharArray()) {
            if (c - '0' > max) {
                max = c - '0';
            }
        }
        return max;
    }


}
