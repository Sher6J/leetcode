package cn.sher6j.week.week213;

import org.junit.Test;

import java.util.*;

/**
 * @author sher6j
 * @create 2020-11-01-10:31
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(countVowelStrings(1));
    }

    /**
     * 5554. 能否连接形成数组
     * @param arr
     * @param pieces
     * @return
     */
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int len = arr.length;
        for(int[] cur : pieces) {
            int n = cur.length;
            int idx = find(arr, cur[0]);
            if (idx == -1) {
                return false;
            }
            if (idx < 0) idx = 0;
            for (int i = 0; i < n; i++, idx++) {
                if (idx >= len) {
                    return false;
                }
                if (cur[i] != arr[idx]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int find(int[] arr, int e) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == e) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 5555. 统计字典序元音字符串的数目
     * @param n
     * @return
     */
    public int countVowelStrings(int n) {
        // dp[i][j] ：长度为 i 以 （a, e, i, o, u）结尾的字符串个数
        int[][] dp = new int[n + 1][5];
        // base case
        for (int i = 0; i < 5; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            dp[i][4] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4]; // u
            dp[i][3] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]; // o
            dp[i][2] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]; // i
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1]; // e
            dp[i][0] = dp[i - 1][0]; // a
        }
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += dp[n][i];
        }
        return sum;
    }


    /**
     * 5556. 可以到达的最远建筑      优先队列 + 贪心
     * 用贪心的思路来想这个问题。
     * 「梯子」相当于一次性的无限量砖块，那么我们一定是把梯子用在刀刃上。
     * 也就是说，如果我们有 l 架梯子，那么我们会在 Δh 最大的那 l 次使用梯子，而在剩余的情况下使用砖块。
     *
     * 这样一来，我们就可以得到正确的算法了：
     * 我们使用优先队列实时维护不超过 l 个最大的 Δh，这些就是使用梯子的地方。
     * 对于剩余的 Δh，我们需要使用砖块，因此需要对它们进行累加，
     * 如果某一时刻这个累加值超过了砖块的数目 b，那么我们就再也无法移动了。
     *
     * @param heights
     * @param bricks
     * @param ladders
     * @return
     */
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int sumBlock = 0;
        for (int i = 1; i < n; i++) {
            int deltaH = heights[i] - heights[i - 1];
            if (deltaH > 0) {
                priorityQueue.offer(deltaH);
                if (priorityQueue.size() > ladders) {
                    sumBlock += priorityQueue.poll();
                }
                if (sumBlock > bricks) {
                    return i - 1;
                }
            }
        }
        return n - 1;
    }
}
