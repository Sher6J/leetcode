package cn.sher6j.week.week201;

import java.util.LinkedList;

/**
 * @author sher6j
 * @create 2020-08-09-10:30
 */
class Solution {
    /**
     *
     * @param s
     * @return
     */
    public String makeGood(String s) {
        LinkedList<Character> res = new LinkedList<>();
        int i = 0;
        while (i < s.length()) {
            if ((i + 1 < s.length()) && Math.abs(s.charAt(i) - s.charAt(i + 1)) == 32) {
                i = i + 2;
            } else if (res.isEmpty()) {
                res.add(s.charAt(i));
                i++;
            } else if (!res.isEmpty() && Math.abs(res.getLast() - s.charAt(i)) == 32) {
                res.removeLast();
                i = i + 1;
            } else {
                res.add(s.charAt(i));
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < res.size(); j++) {
            sb.append(res.get(j));
        }
        return sb.toString();
    }

}
