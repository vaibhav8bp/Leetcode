package org.example.Striver_SDE_Sheet.Day_26_Dynamic_Programming_Part_II;

// https://leetcode.com/problems/minimum-path-sum/description/
public class _64_Minimum_Path_Sum {

    public int minPathSum(int[][] grid) {

        int rowCount = grid.length;
        int columnCount = grid[0].length;

        int[] currentDp = new int[columnCount];
        int[] previousDp = new int[columnCount];
        previousDp[columnCount - 1] = grid[rowCount - 1][columnCount - 1];

        for (int i = columnCount - 2; i >= 0; i--) {
            previousDp[i] = grid[rowCount - 1][i] + previousDp[i + 1];
        }

        for (int i = rowCount - 2; i >= 0; i--) {
            currentDp[columnCount - 1] = grid[i][columnCount - 1] + previousDp[columnCount - 1];
            for (int j = columnCount - 2; j >= 0; j--) {
                currentDp[j] = grid[i][j] + Math.min(previousDp[j], currentDp[j + 1]);
            }
            previousDp = currentDp;
        }

        return previousDp[0];
    }

//    public int minPathSum(int[][] grid) {
//
//        int rowCount = grid.length;
//        int columnCount = grid[0].length;
//
//        int[][] dp = new int[rowCount][columnCount];
//
//        dp[rowCount - 1][columnCount - 1] = grid[rowCount - 1][columnCount - 1];
//
//        for (int i = columnCount - 2; i >= 0; i--) {
//            dp[rowCount - 1][i] = grid[rowCount - 1][i] + dp[rowCount - 1][i + 1];
//        }
//
//        for (int i = rowCount - 2; i >= 0; i--) {
//            dp[i][columnCount - 1] = grid[i][columnCount - 1] + dp[i + 1][columnCount - 1];
//        }
//
//        for (int i = rowCount - 2; i >= 0; i--) {
//            for (int j = columnCount - 2; j >= 0; j--) {
//                dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
//            }
//        }
//
//        return dp[0][0];
//    }

//    private final int[][] directions = {{+1, 0}, {0, +1}};
//
//    private boolean isPositionValid(int currentRow, int currentColumn, int rowCount, int columnCount) {
//        return (currentRow < rowCount && currentColumn < columnCount);
//    }
//
//    private int minPathSum(int currentRow, int currentColumn, int rowCount, int columnCount, int[][] grid, int[][] dp) {
//
//        int minCost = grid[currentRow][currentColumn];
//
//        if (currentRow == rowCount - 1 && currentColumn == columnCount - 1) {
//            return minCost;
//        }
//
//        if (dp[currentRow][currentColumn] != -1) {
//            return dp[currentRow][currentColumn];
//        }
//
//        int minRecursiveCost = Integer.MAX_VALUE;
//
//        for (int[] currentDirection : directions) {
//            int newRow = currentRow + currentDirection[0];
//            int newColumn = currentColumn + currentDirection[1];
//
//            if (!isPositionValid(newRow, newColumn, rowCount, columnCount)) {
//                continue;
//            }
//
//            minRecursiveCost = Math.min(minRecursiveCost, minPathSum(newRow, newColumn, rowCount, columnCount, grid, dp));
//        }
//
//        dp[currentRow][currentColumn] = minCost + minRecursiveCost;
//        return dp[currentRow][currentColumn];
//    }
//
//    public int minPathSum(int[][] grid) {
//        int[][] dp = new int[grid.length][grid[0].length];
//
//        for (int i = 0; i < grid.length; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//
//        return minPathSum(0, 0, grid.length, grid[0].length, grid, dp);
//    }

//    private final int[][] directions = {{+1, 0}, {0, +1}};
//
//    private boolean isPositionValid(int currentRow, int currentColumn, int rowCount, int columnCount) {
//        return (currentRow < rowCount && currentColumn < columnCount);
//    }
//
//    private int minPathSum(int currentRow, int currentColumn, int rowCount, int columnCount, int[][] grid) {
//
//        int minCost = grid[currentRow][currentColumn];
//
//        if (currentRow == rowCount - 1 && currentColumn == columnCount - 1) {
//            return minCost;
//        }
//
//        int minRecursiveCost = Integer.MAX_VALUE;
//
//        for (int[] currentDirection : directions) {
//            int newRow = currentRow + currentDirection[0];
//            int newColumn = currentColumn + currentDirection[1];
//
//            if (!isPositionValid(newRow, newColumn, rowCount, columnCount)) {
//                continue;
//            }
//
//            minRecursiveCost = Math.min(minRecursiveCost, minPathSum(newRow, newColumn, rowCount, columnCount, grid));
//        }
//
//        return minCost + minRecursiveCost;
//    }
//
//    public int minPathSum(int[][] grid) {
//        return minPathSum(0, 0, grid.length, grid[0].length, grid);
//    }
}
