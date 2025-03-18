package org.example.Striver_SDE_Sheet.Day_3_Arrays_Part_III._62_Unique_Paths;

import java.util.Arrays;

// Brute Force
// class Solution {
//    private boolean validIndex(int m, int n, int i, int j) {
//        return (i < m && j < n);
//    }

//    private int uniquePathsHelper(int m, int n, int i, int j) {
//        if (!validIndex(m, n, i, j)) {
//            return 0;
//        }
//        if ((i == (m - 1)) && (j == (n - 1))) {
//            return 1;
//        }
//        int countDown = uniquePathsHelper(m, n, i + 1, j);
//        int countRight = uniquePathsHelper(m, n, i, j + 1);
//        return countDown + countRight;
//    }

//    public int uniquePaths(int m, int n) {
//        return uniquePathsHelper(m, n, 0, 0);
//    }
// }


// Memoization
// class Solution {
//    private boolean validIndex(int m, int n, int i, int j) {
//        return (i < m && j < n);
//    }

//    private int uniquePathsHelper(int m, int n, int i, int j, int[][] dp) {
//        if (!validIndex(m, n, i, j)) {
//            return 0;
//        }
//        if ((i == (m - 1)) && (j == (n - 1))) {
//            return 1;
//        }
//        if (dp[i][j] != -1) {
//            return dp[i][j];
//        }
//        int countDown = uniquePathsHelper(m, n, i + 1, j, dp);
//        int countRight = uniquePathsHelper(m, n, i, j + 1, dp);
//        dp[i][j] = countDown + countRight;
//        return countDown + countRight;
//    }

//    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return uniquePathsHelper(m, n, 0, 0, dp);
//    }
// }

//DP
 class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1;
        // Traverse In Last Row
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = 1;
        }
        // Traverse In Last Column
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }

        return dp[0][0];
    }
 }

// Combinatorics
//class Solution {
//    public int uniquePaths(int m, int n) {
//        int minCount = Math.min(m, n) - 1;
//        int total_moves = m + n - 2;
//
//        long answer = 1;
//
//        for (int i = 1; i <= minCount; i++) {
//            answer = ((answer * (total_moves - i + 1)) / i);
//        }
//
//        return (int)answer;
//    }
//}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3, 7));
    }
}
