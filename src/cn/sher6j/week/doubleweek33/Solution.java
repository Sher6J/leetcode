package cn.sher6j.week.doubleweek33;

import java.util.List;

/**
 * @author sher6j
 * @create 2020-08-22-22:24
 */
class Solution {
    public String thousandSeparator(int n) {
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        int bits = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
            bits++;
            if (bits % 3 == 0) sb.append('.');
        }
        String s1 = sb.reverse().toString();
        return s1.charAt(0) == '.' ? s1.substring(1, s1.length()) : s1;
    }


}
