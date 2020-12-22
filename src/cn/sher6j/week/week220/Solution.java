package cn.sher6j.week.week220;

import java.util.*;

/**
 * @author sher6j
 * @create 2020-12-20-10:24
 */
public class Solution {
    public static void main(String[] args) {
        Main main = new Main();
        double sum = 100;
        int n = 10;
        System.out.println(main.red(100, 10));
    }
}
class Main {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> idx = new HashMap<>();
        int curSum = 0;
        int max = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            int cur = nums[right];
            int count = map.getOrDefault(cur, 0);
            if (count == 0) {
                map.put(cur, 1);
                idx.put(cur, right);
                curSum += cur;
                max =Math.max(curSum, max);
                right++;
            } else {
                map.put(cur, 0);
                while (left <= idx.get(cur)) {
                    curSum -= nums[left];
                    left++;
                }
                map.put(cur, right);
            }
        }
        return max;
    }

    public List<Double> red (double sum, int n) {
        Random random  = new Random();
        List<Double> res = new LinkedList<>();
        double sumMoney = sum;
        int count = 0;
        while (count < 10) {
            double max = sum * 0.9;
            double r = random.nextDouble();
            double curMoney = r * max;
            curMoney = (curMoney < 0) ? 0.01 : curMoney;
            res.add(curMoney);
            count++;
            sumMoney -= curMoney;
        }
        return res;
    }
}
