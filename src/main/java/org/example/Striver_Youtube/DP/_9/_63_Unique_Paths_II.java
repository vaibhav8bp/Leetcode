package org.example.Striver_Youtube.DP._9;

// https://leetcode.com/problems/unique-paths-ii/description/
public class _63_Unique_Paths_II {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int rowCount = obstacleGrid.length;
        int columnCount = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[rowCount - 1][columnCount - 1] == 1) {
            return 0;
        }

        int[] previousDP = new int[columnCount];
        previousDP[columnCount - 1] = 1;

        for (int i = columnCount - 2; i >= 0; i--) {
            if (obstacleGrid[rowCount - 1][i] == 0) {
                previousDP[i] = 1;
            } else {
                // There will be no path.
                break;
            }
        }

        boolean isLastColumnFreeTillNow = true;

        for (int i = rowCount - 2; i >= 0; i--) {
            int[] dp = new int[columnCount];
            isLastColumnFreeTillNow = isLastColumnFreeTillNow && obstacleGrid[i][columnCount - 1] == 0;
            dp[columnCount - 1] = (isLastColumnFreeTillNow) ? 1 : 0;
            for (int j = columnCount - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] = previousDP[j] + dp[j + 1];
                }
            }
            previousDP = dp;
        }

        return previousDP[0];
    }

//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//
//        int rowCount = obstacleGrid.length;
//        int columnCount = obstacleGrid[0].length;
//
//        if (obstacleGrid[0][0] == 1 || obstacleGrid[rowCount - 1][columnCount - 1] == 1) {
//            return 0;
//        }
//
//        int[][] dp = new int[rowCount][columnCount];
//
//        Arrays.fill(dp[rowCount - 1], 0);
//
//        dp[rowCount - 1][columnCount - 1] = 1;
//
//        for (int i = columnCount - 2; i >= 0; i--) {
//            if (obstacleGrid[rowCount - 1][i] == 0) {
//                dp[rowCount - 1][i] = 1;
//            } else {
//                // There will be no path.
//                break;
//            }
//        }
//
//        for (int i = rowCount - 2; i >= 0; i--) {
//            if (obstacleGrid[i][columnCount - 1] == 0) {
//                dp[i][columnCount - 1] = 1;
//            } else {
//                // There will be no path.
//                break;
//            }
//        }
//
//        for (int i = rowCount - 2; i >= 0; i--) {
//            for (int j = columnCount - 2; j >= 0; j--) {
//                if (obstacleGrid[i][j] == 1) {
//                    dp[i][j] = 0;
//                } else {
//                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
//                }
//            }
//        }
//
//        return dp[0][0];
//    }

//    private final int[][] directions = {{+1, 0}, {0, +1}};
//
//    private boolean isCurrentGridPositionValid(int currentRow, int currentColumn, int rowCount, int columnCount) {
//        return (currentRow < rowCount && currentColumn < columnCount);
//    }
//
//    private int uniquePathsWithObstacles(int currentRow, int currentColumn, int rowCount, int columnCount, int[][] obstacleGrid, int[][] dp) {
//
//        if (currentRow == rowCount - 1 && currentColumn == columnCount - 1) {
//            return 1;
//        }
//
//        if (dp[currentRow][currentColumn] != -1) {
//            return dp[currentRow][currentColumn];
//        }
//
//        int answer = 0;
//
//        for (int[] currentDirection : directions) {
//            int newRow = currentRow + currentDirection[0];
//            int newColumn = currentColumn + currentDirection[1];
//            if (isCurrentGridPositionValid(newRow, newColumn, rowCount, columnCount) && obstacleGrid[newRow][newColumn] != 1) {
//                answer += uniquePathsWithObstacles(newRow, newColumn, rowCount, columnCount, obstacleGrid, dp);
//            }
//        }
//
//        dp[currentRow][currentColumn] = answer;
//        return dp[currentRow][currentColumn];
//    }
//
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//
//        int rowCount = obstacleGrid.length;
//        int columnCount = obstacleGrid[0].length;
//
//        if (obstacleGrid[0][0] == 1 || obstacleGrid[rowCount - 1][columnCount - 1] == 1) {
//            return 0;
//        }
//
//        int[][] dp = new int[rowCount][columnCount];
//
//        for (int i = 0; i < rowCount; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//
//        return uniquePathsWithObstacles(0, 0, rowCount, columnCount, obstacleGrid, dp);
//    }

//    private final int[][] directions = {{+1, 0}, {0, +1}};
//
//    private boolean isCurrentGridPositionValid(int currentRow, int currentColumn, int rowCount, int columnCount) {
//        return (currentRow < rowCount && currentColumn < columnCount);
//    }
//
//    private int uniquePathsWithObstacles(int currentRow, int currentColumn, int rowCount, int columnCount, int[][] obstacleGrid) {
//
//        if (currentRow == rowCount - 1 && currentColumn == columnCount - 1) {
//            return 1;
//        }
//
//        int answer = 0;
//
//        for (int[] currentDirection : directions) {
//            int newRow = currentRow + currentDirection[0];
//            int newColumn = currentColumn + currentDirection[1];
//            if (isCurrentGridPositionValid(newRow, newColumn, rowCount, columnCount) && obstacleGrid[newRow][newColumn] != 1) {
//                answer += uniquePathsWithObstacles(newRow, newColumn, rowCount, columnCount, obstacleGrid);
//            }
//        }
//
//        return answer;
//    }
//
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//
//        int rowCount = obstacleGrid.length;
//        int columnCount = obstacleGrid[0].length;
//
//        if (obstacleGrid[0][0] == 1 || obstacleGrid[rowCount - 1][columnCount - 1] == 1) {
//            return 0;
//        }
//
//        return uniquePathsWithObstacles(0, 0, rowCount, columnCount, obstacleGrid);
//    }
}
