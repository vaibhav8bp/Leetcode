package org.example.Weekly._432;

// https://leetcode.com/problems/maximum-amount-of-money-robot-can-earn
public class _3418_Maximum_Amount_of_Money_Robot_Can_Earn {

    private static final int MAXIMUM_NEUTRAL_ROBBERS_COUNT = 2;
    private static final int[][] DIRECTIONS = {{+1, 0}, {0, +1}};

    private boolean isIndexValid(int currentRow, int currentColumn, int rowCount, int columnCount) {
        return (currentRow < rowCount && currentColumn < columnCount);
    }

    private int dfsTraversal(int currentRow, int currentColumn, int currentNeutralizeRobbersCount, int rowCount, int columnCount, int[][][] dp) {
        int recursiveMaxCoinsCount = Integer.MIN_VALUE;
        for (int[] currentDirection : DIRECTIONS) {
            int newRow = currentRow + currentDirection[0];
            int newColumn = currentColumn + currentDirection[1];

            if (isIndexValid(newRow, newColumn, rowCount, columnCount)) {
                recursiveMaxCoinsCount = Math.max(recursiveMaxCoinsCount, dp[newRow][newColumn][currentNeutralizeRobbersCount]);
            }
        }
        return recursiveMaxCoinsCount;
    }

    public int maximumAmount(int[][] coins) {
        int rowCount = coins.length;
        int columnCount = coins[0].length;
        int[][][] dp = new int[rowCount][columnCount][MAXIMUM_NEUTRAL_ROBBERS_COUNT + 1];

        for (int i = 0; i < MAXIMUM_NEUTRAL_ROBBERS_COUNT + 1; i++) {
            if (coins[rowCount - 1][columnCount - 1] < 0 && i < MAXIMUM_NEUTRAL_ROBBERS_COUNT) {
                dp[rowCount - 1][columnCount - 1][i] = 0;
            } else {
                dp[rowCount - 1][columnCount - 1][i] = coins[rowCount - 1][columnCount - 1];
            }
        }

        for (int i = rowCount - 1; i >= 0; i--) {
            for (int j = columnCount - 1; j >= 0; j--) {
                if (i == (rowCount - 1) && j == (columnCount - 1)) {
                    continue;
                }
                for (int k = MAXIMUM_NEUTRAL_ROBBERS_COUNT; k >= 0; k--) {
                    int dontNeutralizeRobber = coins[i][j];
                    dontNeutralizeRobber += dfsTraversal(i, j, k, rowCount, columnCount, dp);
                    if (coins[i][j] < 0 && k < MAXIMUM_NEUTRAL_ROBBERS_COUNT) {
                        int neutralizeRobberCount = dfsTraversal(i, j, k + 1, rowCount, columnCount, dp);
                        dp[i][j][k] = Math.max(dontNeutralizeRobber, neutralizeRobberCount);
                    } else {
                        dp[i][j][k] = dontNeutralizeRobber;
                    }
                }
            }
        }

        return dp[0][0][0];
    }

//    private static final int MAXIMUM_NEUTRAL_ROBBERS_COUNT = 2;
//    private static final int[][] DIRECTIONS = {{+1, 0}, {0, +1}};
//
//    private boolean isIndexValid(int currentRow, int currentColumn, int rowCount, int columnCount) {
//        return (currentRow < rowCount && currentColumn < columnCount);
//    }
//
//    private int dfsTraversal(int currentRow, int currentColumn, int currentNeutralizeRobbersCount, int rowCount, int columnCount, int[][][] dp) {
//        int recursiveMaxCoinsCount = Integer.MIN_VALUE;
//        for (int[] currentDirection : DIRECTIONS) {
//            int newRow = currentRow + currentDirection[0];
//            int newColumn = currentColumn + currentDirection[1];
//
//            if (isIndexValid(newRow, newColumn, rowCount, columnCount)) {
//                recursiveMaxCoinsCount = Math.max(recursiveMaxCoinsCount, dp[newRow][newColumn][currentNeutralizeRobbersCount]);
//            }
//        }
//        return recursiveMaxCoinsCount;
//    }
//
//    public int maximumAmount(int[][] coins) {
//        int rowCount = coins.length;
//        int columnCount = coins[0].length;
//        int[][][] dp = new int[rowCount][columnCount][MAXIMUM_NEUTRAL_ROBBERS_COUNT + 1];
//
//        for (int i = 0; i < MAXIMUM_NEUTRAL_ROBBERS_COUNT + 1; i++) {
//            if (coins[rowCount - 1][columnCount - 1] < 0 && i < MAXIMUM_NEUTRAL_ROBBERS_COUNT) {
//                dp[rowCount - 1][columnCount - 1][i] = 0;
//            } else {
//                dp[rowCount - 1][columnCount - 1][i] = coins[rowCount - 1][columnCount - 1];
//            }
//        }
//
//        // Last Row
//        for (int i = columnCount - 2; i >= 0; i--) {
//            for (int k = MAXIMUM_NEUTRAL_ROBBERS_COUNT; k >= 0; k--) {
//                int dontNeutralizeRobber = coins[rowCount - 1][i] + dp[rowCount - 1][i + 1][k];
//                if (coins[rowCount - 1][i] < 0 && k < MAXIMUM_NEUTRAL_ROBBERS_COUNT) {
//                    int neutralizeRobberCount = dp[rowCount - 1][i + 1][k + 1];
//                    dp[rowCount - 1][i][k] = Math.max(dontNeutralizeRobber, neutralizeRobberCount);
//                } else {
//                    dp[rowCount - 1][i][k] = dontNeutralizeRobber;
//                }
//            }
//        }
//
//        // Last Column
//        for (int i = rowCount - 2; i >= 0; i--) {
//            for (int k = MAXIMUM_NEUTRAL_ROBBERS_COUNT; k >= 0; k--) {
//                int dontNeutralizeRobber = coins[i][columnCount - 1] + dp[i + 1][columnCount - 1][k];
//                if (coins[i][columnCount - 1] < 0 && k < MAXIMUM_NEUTRAL_ROBBERS_COUNT) {
//                    int neutralizeRobberCount = dp[i + 1][columnCount - 1][k + 1];
//                    dp[i][columnCount - 1][k] = Math.max(dontNeutralizeRobber, neutralizeRobberCount);
//                } else {
//                    dp[i][columnCount - 1][k] = dontNeutralizeRobber;
//                }
//            }
//        }
//
//        for (int i = rowCount - 2; i >= 0; i--) {
//            for (int j = columnCount - 2; j >= 0; j--) {
//                for (int k = MAXIMUM_NEUTRAL_ROBBERS_COUNT; k >= 0; k--) {
//                    int dontNeutralizeRobber = coins[i][j];
//                    dontNeutralizeRobber += dfsTraversal(i, j, k, rowCount, columnCount, dp);
//                    if (coins[i][j] < 0 && k < MAXIMUM_NEUTRAL_ROBBERS_COUNT) {
//                        int neutralizeRobberCount = dfsTraversal(i, j, k + 1, rowCount, columnCount, dp);
//                        dp[i][j][k] = Math.max(dontNeutralizeRobber, neutralizeRobberCount);
//                    } else {
//                        dp[i][j][k] = dontNeutralizeRobber;
//                    }
//                }
//            }
//        }
//
//        return dp[0][0][0];
//    }

//    private static final int MAXIMUM_NEUTRAL_ROBBERS_COUNT = 2;
//    private static final int[][] DIRECTIONS = {{+1, 0}, {0, +1}};
//
//    private boolean isIndexValid(int currentRow, int currentColumn, int rowCount, int columnCount) {
//        return (currentRow < rowCount && currentColumn < columnCount);
//    }
//
//    private int dfsTraversal(int[][] coins, int currentRow, int currentColumn, int currentNeutralizeRobbersCount, int rowCount, int columnCount, int[][][] dp) {
//        int recursiveMaxCoinsCount = Integer.MIN_VALUE;
//        for (int[] currentDirection : DIRECTIONS) {
//            int newRow = currentRow + currentDirection[0];
//            int newColumn = currentColumn + currentDirection[1];
//
//            if (isIndexValid(newRow, newColumn, rowCount, columnCount)) {
//                recursiveMaxCoinsCount = Math.max(recursiveMaxCoinsCount,
//                        maximumAmount(coins, newRow, newColumn, currentNeutralizeRobbersCount, rowCount, columnCount, dp));
//            }
//        }
//        return recursiveMaxCoinsCount;
//    }
//
//    private int maximumAmount(int[][] coins, int currentRow, int currentColumn, int currentNeutralizeRobbersCount, int rowCount, int columnCount, int[][][] dp) {
//
//        if ((currentRow == (rowCount - 1)) && (currentColumn == (columnCount - 1))) {
//            if (coins[currentRow][currentColumn] < 0 && currentNeutralizeRobbersCount < MAXIMUM_NEUTRAL_ROBBERS_COUNT) {
//                return 0;
//            }
//            return coins[currentRow][currentColumn];
//        }
//
//        if (dp[currentRow][currentColumn][currentNeutralizeRobbersCount] != -1) {
//            return dp[currentRow][currentColumn][currentNeutralizeRobbersCount];
//        }
//
//        int dontNeutralizeRobber = coins[currentRow][currentColumn];
//        dontNeutralizeRobber += dfsTraversal(coins, currentRow, currentColumn, currentNeutralizeRobbersCount, rowCount, columnCount, dp);
//
//        if (coins[currentRow][currentColumn] < 0 && currentNeutralizeRobbersCount < MAXIMUM_NEUTRAL_ROBBERS_COUNT) {
//            int neutralizeRobberCount = dfsTraversal(coins, currentRow, currentColumn, currentNeutralizeRobbersCount + 1, rowCount, columnCount, dp);
//            dp[currentRow][currentColumn][currentNeutralizeRobbersCount] = Math.max(dontNeutralizeRobber, neutralizeRobberCount);
//        } else {
//            dp[currentRow][currentColumn][currentNeutralizeRobbersCount] = dontNeutralizeRobber;
//        }
//
//        return dp[currentRow][currentColumn][currentNeutralizeRobbersCount];
//    }
//
//    public int maximumAmount(int[][] coins) {
//        int rowCount = coins.length;
//        int columnCount = coins[0].length;
//        int[][][] dp = new int[rowCount][columnCount][MAXIMUM_NEUTRAL_ROBBERS_COUNT + 1];
//        for (int i = 0; i < rowCount; i++) {
//            for (int j = 0; j < columnCount; j++) {
//                Arrays.fill(dp[i][j], -1);
//            }
//        }
//        return maximumAmount(coins, 0, 0, 0, rowCount, columnCount, dp);
//    }

//    private static final int MAXIMUM_NEUTRAL_ROBBERS_COUNT = 2;
//    private static final int[][] DIRECTIONS = {{+1, 0}, {0, +1}};
//
//    private boolean isIndexValid(int currentRow, int currentColumn, int rowCount, int columnCount) {
//        return (currentRow < rowCount && currentColumn < columnCount);
//    }
//
//    private int dfsTraversal(int[][] coins, int currentRow, int currentColumn, int currentNeutralizeRobbersCount, int rowCount, int columnCount) {
//        int recursiveMaxCoinsCount = Integer.MIN_VALUE;
//        for (int[] currentDirection : DIRECTIONS) {
//            int newRow = currentRow + currentDirection[0];
//            int newColumn = currentColumn + currentDirection[1];
//
//            if (isIndexValid(newRow, newColumn, rowCount, columnCount)) {
//                recursiveMaxCoinsCount = Math.max(recursiveMaxCoinsCount,
//                        maximumAmount(coins, newRow, newColumn, currentNeutralizeRobbersCount, rowCount, columnCount));
//            }
//        }
//        return recursiveMaxCoinsCount;
//    }
//
//    private int maximumAmount(int[][] coins, int currentRow, int currentColumn, int currentNeutralizeRobbersCount, int rowCount, int columnCount) {
//
//        if ((currentRow == (rowCount - 1)) && (currentColumn == (columnCount - 1))) {
//            if (coins[currentRow][currentColumn] < 0 && currentNeutralizeRobbersCount < MAXIMUM_NEUTRAL_ROBBERS_COUNT) {
//                return 0;
//            }
//            return coins[currentRow][currentColumn];
//        }
//
//        int dontNeutralizeRobber = coins[currentRow][currentColumn];
//        dontNeutralizeRobber += dfsTraversal(coins, currentRow, currentColumn, currentNeutralizeRobbersCount, rowCount, columnCount);
//
//        if (coins[currentRow][currentColumn] < 0 && currentNeutralizeRobbersCount < MAXIMUM_NEUTRAL_ROBBERS_COUNT) {
//            int neutralizeRobberCount = dfsTraversal(coins, currentRow, currentColumn, currentNeutralizeRobbersCount + 1, rowCount, columnCount);
//            return Math.max(dontNeutralizeRobber, neutralizeRobberCount);
//        } else {
//            return dontNeutralizeRobber;
//        }
//    }
//
//    public int maximumAmount(int[][] coins) {
//        return maximumAmount(coins, 0, 0, 0, coins.length, coins[0].length);
//    }
}