package org.example.Striver_Youtube.DP._8;

// https://leetcode.com/problems/unique-paths/description/
public class _62_Unique_Paths {

    public int uniquePaths(int m, int n) {

        if (m == 1 || n == 1) {
            return 1;
        }

        long answer = 1;

        for (int i = 1; i <= Math.min(m, n) - 1; i++) {
            answer = (answer * ((m + n - 2) - i + 1)) / i;
        }

        return (int) answer;
    }

//    public int uniquePaths(int m, int n) {
//        int[] previousDp = new int[n];
//        Arrays.fill(previousDp, 1);
//
//        for (int i = m - 2; i >= 0; i--) {
//            int[] currentDp = new int[n];
//            currentDp[n - 1] = 1;
//            for (int j = n - 2; j >= 0; j--) {
//                currentDp[j] = previousDp[j] + currentDp[j + 1];
//            }
//            previousDp = currentDp;
//        }
//
//        return previousDp[0];
//    }

//    public int uniquePaths(int m, int n) {
//        int[] previousDp = new int[n];
//        Arrays.fill(previousDp, 1);
//
//        for (int i = m - 2; i >= 0; i--) {
//            int[] currentDp = new int[n];
//            currentDp[n - 1] = 1;
//            for (int j = n - 2; j >= 0; j--) {
//                currentDp[j] = previousDp[j] + currentDp[j + 1];
//            }
//            previousDp = currentDp;
//        }
//
//        return previousDp[0];
//    }

//    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[m][n];
//        dp[m - 1][n - 1] = 1;
//
//        for (int i = 0; i < n - 1; i++) {
//            dp[m - 1][i] = 1;
//        }
//
//        for (int i = 0; i < m - 1; i++) {
//            dp[i][n - 1] = 1;
//        }
//
//        for (int i = m - 2; i >= 0; i--) {
//            for (int j = n - 2; j >= 0; j--) {
//                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
//            }
//        }
//
//        return dp[0][0];
//    }

//    private int[][] directions = {{+1, 0}, {0, +1}};
//
//    private boolean isCurrentPositionValid(int currentRow, int currentColumn, int m, int n) {
//        return (currentRow < m && currentColumn < n);
//    }
//
//    private int uniquePaths(int currentRow, int currentColumn, int m, int n, int[][] dp) {
//        if ((currentRow == m - 1) && (currentColumn == n - 1)) {
//            return 1;
//        }
//
//        if (dp[currentRow][currentColumn] != -1) {
//            return dp[currentRow][currentColumn];
//        }
//
//        int totalWays = 0;
//
//        for (int[] currentDirection : directions) {
//            int newRow = currentRow + currentDirection[0];
//            int newColumn = currentColumn + currentDirection[1];
//            if (isCurrentPositionValid(newRow, newColumn, m, n)) {
//                totalWays += uniquePaths(newRow, newColumn, m, n, dp);
//            }
//        }
//
//        dp[currentRow][currentColumn] = totalWays;
//        return dp[currentRow][currentColumn];
//    }
//
//    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return uniquePaths(0, 0, m, n, dp);
//    }

//    private int[][] directions = {{+1, 0}, {0, +1}};
//
//    private boolean isCurrentPositionValid(int currentRow, int currentColumn, int m, int n) {
//        return (currentRow < m && currentColumn < n);
//    }
//
//    private int uniquePaths(int currentRow, int currentColumn, int m, int n) {
//        if ((currentRow == m - 1) && (currentColumn == n - 1)) {
//            return 1;
//        }
//
//        int totalWays = 0;
//
//        for (int[] currentDirection : directions) {
//            int newRow = currentRow + currentDirection[0];
//            int newColumn = currentColumn + currentDirection[1];
//            if (isCurrentPositionValid(newRow, newColumn, m, n)) {
//                totalWays += uniquePaths(newRow, newColumn, m, n);
//            }
//        }
//
//        return totalWays;
//    }
//
//    public int uniquePaths(int m, int n) {
//        return uniquePaths(0, 0, m, n);
//    }
}
