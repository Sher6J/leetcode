package cn.sher6j.week.week212;

import java.util.*;

/**
 * @author sher6j
 * @create 2020-10-25-10:20
 */
public class Solution {

    /**
     * 5546.按键持续时间最长的键
     * @param releaseTimes
     * @param keysPressed
     * @return
     */
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int res = 0;
        int max = releaseTimes[0];
        for (int i = 1; i < keysPressed.length(); i++) {
            if (releaseTimes[i] - releaseTimes[i - 1] > max) {
                res = i;
                max = releaseTimes[i] - releaseTimes[i - 1];
            } else if (releaseTimes[i] - releaseTimes[i - 1] == max
                    && keysPressed.charAt(i) > keysPressed.charAt(res)) {
                res = i;
            }
        }
        return keysPressed.charAt(res);
    }

    /**
     * 5547. 等差子数组
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for(int i=0; i<l.length; i++){
            if(flag(nums, l[i], r[i]))
                res.add(true);
            else
                res.add(false);
        }
        return res;
    }
    public boolean flag(int []nums, int left, int right){
        int []temp = new int[right - left + 1];
        int k = 0;
        for(int j=left; j<=right; j++){
            temp[k++] = nums[j];
        }
        Arrays.sort(temp);
        for(int i=1; i<temp.length-1; i++){
            if(temp[i]*2 != temp[i-1] + temp[i+1]){
                return false;
            }
        }
        return true;
    }
}
