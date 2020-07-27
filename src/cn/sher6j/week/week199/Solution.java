package cn.sher6j.week.week199;

/**
 * @author sher6j
 * @create 2020-07-12-10:29
 */
public class Solution {

    /**
     * 5472. 重新排列字符串
     * @param s
     * @param indices
     * @return
     */
    public String restoreString(String s, int[] indices) {
        char[] res = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            res[indices[i]] = s.charAt(i);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : res) {
            sb.append(c);
        }
        return sb.toString();
    }


    /**
     * 5473. 灯泡开关 IV
     * @param target
     * @return
     */
    public int minFlips(String target) {
        boolean isAllZero = true;
        if (target.charAt(0) != '0') isAllZero = false;
        int count = 1;
        for (int i = 1; i < target.length(); i++) {
            if (target.charAt(i) != '0') isAllZero = false;
            if (target.charAt(i) != target.charAt(i - 1)) {
                count ++;
            }
        }
        if (isAllZero == true) return 0; //目标全0需要0次
        if (target.charAt(0) == '0') {
            return count - 1;
        }
        return count;
    }
}
