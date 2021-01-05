package cn.sher6j;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sher6j
 * @create 2020-12-29-20:00
 */
public class Mianshi {

    public List<String> split (String s, int k) {
        String[] strs = s.split(" ");
        int[] lens = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            lens[i] = strs[i].length();
        }
        List<String> res = new LinkedList<>();
        int curLen = 0, curIdx = 0;
        while (curIdx < strs.length) {
            StringBuilder sb = new StringBuilder();
            while (curLen < k) {
                sb.append(strs[curIdx++]).append(" ");
                curLen += sb.length() + 1;
            }
            res.add(sb.toString());
        }
        return res;
    }
}
