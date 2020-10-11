package cn.sher6j.week.week210;

import java.util.*;

/**
 * @author sher6j
 * @create 2020-10-11-10:30
 */
public class Solution {
    /**
     * 5535. 括号的最大嵌套深度
     * @param s
     * @return
     */
    public int maxDepth(String s) {
        int max = 0;
        int depth = 0;
        int len = s.length();
        if (len == 0 || len == 1) return 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                depth++;
                max = Math.max(depth, max);
            } else if (s.charAt(i) == ')') {
                depth--;
            }
        }
        return max;
    }

    /**
     * 5536. 最大网络秩
     * @param n
     * @param roads
     * @return
     */
    public int maximalNetworkRank(int n, int[][] roads) {
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        for (int i = 0; i < roads.length; i++) {
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = graph.get(i).size();
                int b = graph.get(j).size();
                int cur = (graph.get(i).contains(j) && graph.get(j).contains(i)) ? (a + b - 1) : (a + b);
                max = Math.max(max, cur);
            }
        }
        return max;
    }

    /**
     * 5537. 分割两个字符串得到回文串
     * @param a
     * @param b
     * @return
     */
    public boolean checkPalindromeFormation(String a, String b) {
        if (isPalindrome(a) || isPalindrome(b)) {
            return true;
        }
        int front = 0, back = a.length() - 1;
        while (front < back) {
            if (a.charAt(front) != b.charAt(back) && a.charAt(back) != b.charAt(front)) {
                return false;
            } else if (a.charAt(front) != b.charAt(back)) {
                while (front < back) {
                    if (a.charAt(back) != b.charAt(front)) {
                        return isPalindrome(b.substring(front, back + 1));
                    }
                    front++;
                    back--;
                }
            } else {
                while (front < back) {
                    if (a.charAt(front) != b.charAt(back)) {
                        return isPalindrome(a.substring(front, back + 1));
                    }
                    front++;
                    back--;
                }
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        int front = 0, back = s.length() - 1;
        while (front < back) {
            if (s.charAt(front) != s.charAt(back)) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
