package cn.sher6j.week.week196;

import java.util.Arrays;

/**
 * @author sher6j
 * @create 2020-07-05-10:15
 */
public class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length == 2) return true;
        Arrays.sort(arr);
        int sub = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i-1] != sub) return false;
        }
        return true;
    }

    public int getLastMoment(int n, int[] left, int[] right) {
        return 1;
    }

    public int numSubmat(int[][] mat) {
        int rows = mat.length, columns = mat[0].length;
        //dp[er][ec][h][w]表示以(er,ec)为右下角，以w为宽，以h为长的巨型
        boolean[][][][] dp = new boolean[rows][columns][rows][columns];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                dp[i][j][0][0] = (mat[i][j] == 1);
                count += dp[i][j][0][0] ? 1 : 0;
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int h = 1; h <= i; h++) {
                    dp[i][j][h][0] = (mat[i][j] == 1) && dp[i - 1][j][h - 1][0];
                    count += dp[i][j][h][0] ? 1 : 0;
                }
            }
        }
        for (int j = 1; j < columns; j++) {
            for (int i = 0; i < rows; i++) {
                for (int w = 1; w <= j ; w++) {
                    dp[i][j][0][w] = (mat[i][j] == 1) && dp[i][j - 1][0][w - 1];
                    count += dp[i][j][0][w] ? 1 : 0;
                }
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                for (int h = 1; h <= i; h++) {
                    for (int w = 1; w <= j; w++) {
                        dp[i][j][h][w] = (mat[i][j] == 1 && dp[i - 1][j][h - 1][w] && dp[i][j -1][h][w - 1]);
                        if (dp[i][j][h][w]) count++;
                    }
                }
            }
        }
        return count;
    }

}
