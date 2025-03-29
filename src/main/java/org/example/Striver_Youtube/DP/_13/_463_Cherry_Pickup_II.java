package org.example.Striver_Youtube.DP._13;

// https://leetcode.com/problems/cherry-pickup-ii/description/
public class _463_Cherry_Pickup_II {

    private final int[] directions = {-1, 0, +1};

    private boolean isCurrentPositionValid(int row, int c1, int c2, int rowCount, int columnCount) {
        return (row < rowCount && c1 >= 0 && c1 < columnCount && c2 >= 0 && c2 < columnCount);
    }

    public int cherryPickup(int[][] grid) {
        int rowCount = grid.length;
        int columnCount = grid[0].length;

        int[][] previousDP = new int[columnCount][columnCount];

        for (int i = 0; i < columnCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (i == j) {
                    previousDP[i][j] = grid[rowCount - 1][i];
                } else {
                    previousDP[i][j] = grid[rowCount - 1][i] + grid[rowCount - 1][j];
                }
            }
        }

        for (int i = rowCount - 2; i >= 0; i--) {
            int[][] currentDP = new int[columnCount][columnCount];
            for (int j = 0; j < columnCount; j++) {
                for (int k = columnCount - 1; k >= 0; k--) {
                    int currentAnswer = (j == k) ? grid[i][j] : grid[i][j] + grid[i][k];
                    int recursiveAnswer = 0;
                    for (int c1Delta : directions) {
                        for (int c2Delta : directions) {
                            int newRow = i + 1;
                            int newC1 = j + c1Delta;
                            int newC2 = k + c2Delta;
                            if (isCurrentPositionValid(newRow, newC1, newC2, rowCount, columnCount)) {
                                recursiveAnswer = Math.max(recursiveAnswer, previousDP[newC1][newC2]);
                            }
                        }
                    }
                    currentDP[j][k] = currentAnswer + recursiveAnswer;
                }
            }
            previousDP = currentDP;
        }

        return previousDP[0][columnCount - 1];
    }

//    private final int[] directions = {-1, 0, +1};
//
//    private boolean isCurrentPositionValid(int row, int c1, int c2, int rowCount, int columnCount) {
//        return (row < rowCount && c1 >= 0 && c1 < columnCount && c2 >= 0 && c2 < columnCount);
//    }
//
//    public int cherryPickup(int[][] grid) {
//        int rowCount = grid.length;
//        int columnCount = grid[0].length;
//
//        int[][][] dp = new int[rowCount][columnCount][columnCount];
//
//        for (int i = 0; i < columnCount; i++) {
//            for (int j = 0; j < columnCount; j++) {
//                if (i == j) {
//                    dp[rowCount - 1][i][j] = grid[rowCount - 1][i];
//                } else {
//                    dp[rowCount - 1][i][j] = grid[rowCount - 1][i] + grid[rowCount - 1][j];
//                }
//            }
//        }
//
//        for (int i = rowCount - 2; i >= 0; i--) {
//            for (int j = 0; j < columnCount; j++) {
//                for (int k = columnCount - 1; k >= 0; k--) {
//                    int currentAnswer = (j == k) ? grid[i][j] : grid[i][j] + grid[i][k];
//                    int recursiveAnswer = 0;
//                    for (int c1Delta : directions) {
//                        for (int c2Delta : directions) {
//                            int newRow = i + 1;
//                            int newC1 = j + c1Delta;
//                            int newC2 = k + c2Delta;
//                            if (isCurrentPositionValid(newRow, newC1, newC2, rowCount, columnCount)) {
//                                recursiveAnswer = Math.max(recursiveAnswer, dp[newRow][newC1][newC2]);
//                            }
//                        }
//                    }
//                    dp[i][j][k] = currentAnswer + recursiveAnswer;
//                }
//            }
//        }
//
//        return dp[0][0][columnCount - 1];
//    }

//    private final int[] directions = {-1, 0, +1};
//
//    private boolean isCurrentPositionValid(int row, int c1, int c2, int rowCount, int columnCount) {
//        return (row < rowCount && c1 >= 0 && c1 < columnCount && c2 >= 0 && c2 < columnCount);
//    }
//
//    // Players will always remain in the same row, so no need of maintaining 2 variables.
//    private int cherryPickup(int row, int c1, int c2, int rowCount, int columnCount, int[][] grid, int[][][] dp) {
//
//        if (dp[row][c1][c2] != -1) {
//            return dp[row][c1][c2];
//        }
//
//        int answer = 0;
//        answer += grid[row][c1];
//        if (c1 != c2) {
//            answer += grid[row][c2];
//        }
//
//        if (row == rowCount - 1) {
//            return answer;
//        }
//
//        int recursiveAnswer = 0;
//
//        for (int c1Delta : directions) {
//            for (int c2Delta : directions) {
//                int newRow = row + 1;
//                int newC1 = c1 + c1Delta;
//                int newC2 = c2 + c2Delta;
//                if (isCurrentPositionValid(newRow, newC1, newC2, rowCount, columnCount)) {
//                    recursiveAnswer = Math.max(recursiveAnswer, cherryPickup(newRow, newC1, newC2, rowCount, columnCount, grid, dp));
//                }
//            }
//        }
//
//        dp[row][c1][c2] = answer + recursiveAnswer;
//        return dp[row][c1][c2];
//    }
//
//    public int cherryPickup(int[][] grid) {
//        int rowCount = grid.length;
//        int columnCount = grid[0].length;
//
//        int[][][] dp = new int[rowCount][columnCount][columnCount];
//
//        for (int i = 0; i < rowCount; i++) {
//            for (int j = 0; j < columnCount; j++) {
//                Arrays.fill(dp[i][j], -1);
//            }
//        }
//
//        return cherryPickup(0, 0, columnCount - 1, rowCount, columnCount, grid, dp);
//    }

//    private final int[] directions = {-1, 0, +1};
//
//    private boolean isCurrentPositionValid(int row, int c1, int c2, int rowCount, int columnCount) {
//        return (row < rowCount && c1 >= 0 && c1 < columnCount && c2 >= 0 && c2 < columnCount);
//    }
//
//    // Players will always remain in the same row, so no need of maintaining 2 variables.
//    private int cherryPickup(int row, int c1, int c2, int rowCount, int columnCount, int[][] grid) {
//        int answer = 0;
//        answer += grid[row][c1];
//        if (c1 != c2) {
//            answer += grid[row][c2];
//        }

//        if (row == rowCount - 1) {
//            return answer;
//        }
//
//        int recursiveAnswer = 0;
//
//        for (int c1Delta : directions) {
//            for (int c2Delta : directions) {
//                int newRow = row + 1;
//                int newC1 = c1 + c1Delta;
//                int newC2 = c2 + c2Delta;
//                if (isCurrentPositionValid(newRow, newC1, newC2, rowCount, columnCount)) {
//                    recursiveAnswer = Math.max(recursiveAnswer, cherryPickup(newRow, newC1, newC2, rowCount, columnCount, grid));
//                }
//            }
//        }
//
//        return answer + recursiveAnswer;
//    }
//
//    public int cherryPickup(int[][] grid) {
//        int rowCount = grid.length;
//        int columnCount = grid[0].length;
//        return cherryPickup(0, 0, columnCount - 1, rowCount, columnCount, grid);
//    }
}