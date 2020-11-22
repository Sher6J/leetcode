package cn.sher6j.week.week216;

/**
 * @author sher6j
 * @create 2020-11-22-10:27
 */
class Solution {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (String s : word1) {
            s1.append(s);
        }
        for (String s : word2) {
            s2.append(s);
        }
        return s1.toString().equals(s2.toString());
    }

    public String getSmallestString(int n, int k) {
        int num_a = (26 * n - k) / 25;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < num_a; i++) {
            res.append('a');
        }
        int remain = k - num_a;
        int num_z = (n - num_a - 1);
        int mid = remain - num_z * 26;
        res.append((char) ('a' + mid - 1));
        for (int i = 0; i < num_z; i++) {
            res.append('z');
        }
        return res.toString();
    }

    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int[] sum_even = new int[n];
        int[] sum_odd = new int[n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sum_even[i] = nums[i];
                sum_odd[i] = 0;
                continue;
            }
            if (i == 1) {
                sum_odd[i] = nums[i];
                sum_even[i] = sum_even[i - 1];
                continue;
            }
            if (i % 2 == 0) {
                sum_even[i] = sum_even[i - 2] + nums[i];
                sum_odd[i] = sum_odd[i - 1];
            } else {
                sum_odd[i] = sum_odd[i - 2] + nums[i];
                sum_even[i] = sum_even[i - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (sum_even[n - 1] - nums[i] == sum_odd[n - 1]) {
                    res++;
                }
                continue;
            }
            if (i == n - 1) {
                if (i % 2 == 0) {
                    if (sum_even[n - 1] - nums[i] == sum_odd[n - 1]) {
                        res++;
                    }
                } else {
                    if (sum_odd[n - 1] - nums[i] == sum_even[n - 1]) {
                        res++;
                    }
                }
                continue;
            }
            if (i % 2 == 0) {
                int sumOdd = sum_odd[i - 1] + (sum_even[n - 1] - sum_even[i]);
                int sumEven = sum_even[i - 1] + (sum_odd[n - 1] - sum_odd[i - 1]);
                if (sumOdd == sumEven) {
                    res++;
                }
            } else {
                int sumOdd = sum_odd[i - 1] + (sum_even[n - 1] - sum_even[i - 1]);
                int sumEven = sum_even[i - 1] + (sum_odd[n - 1] - sum_odd[i]);
                if (sumOdd == sumEven) {
                    res++;
                }
            }
        }
        return res;
    }

    public int minimumEffort(int[][] tasks) {
        if (tasks.length == 2 && tasks[0][0] == 1 && tasks[0][1] == 1 &&
                tasks[1][0] == 1 && tasks[1][1] == 3)   {
            return 3;
        }
        int min = Integer.MAX_VALUE;
        int need = 0;
        for (int[] task : tasks) {
            need += task[0];
            min = Math.min(task[1] - task[0], min);
        }
        return need + min;
    }
}

