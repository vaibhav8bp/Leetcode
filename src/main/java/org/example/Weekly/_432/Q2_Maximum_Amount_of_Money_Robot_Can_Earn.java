package org.example.Weekly._432;

public class Q2_Maximum_Amount_of_Money_Robot_Can_Earn {

    private static final int MAXIMUM_NEUTRAL_ROBBERS_COUNT = 2;
    private static final int[][] DIRECTIONS = {{+1, 0}, {0, +1}};

    private boolean isIndexValid(int currentRow, int currentColumn, int rowCount, int columnCount) {
        return (currentRow < rowCount && currentColumn < columnCount);
    }

    private int coinFlow(int[][] coins, int currentRow, int currentColumn, int currentNeutralizeRobbersCount, int rowCount, int columnCount, boolean isNormalFlow) {

        int maxCoinsCount = 0;

        for (int[] currentDirection : DIRECTIONS) {
            int newRow = currentRow + currentDirection[0];
            int newColumn = currentColumn + currentDirection[1];

            if (isIndexValid(newRow, newColumn, rowCount, columnCount)) {
                int currentDirectionCoinsCount;
                if (isNormalFlow) {
                    currentDirectionCoinsCount = maximumCountHelper(coins, newRow, newColumn, currentNeutralizeRobbersCount, rowCount, columnCount);
                } else {
                    currentDirectionCoinsCount = maximumCountHelper(coins, newRow, newColumn, currentNeutralizeRobbersCount + 1, rowCount, columnCount);
                }
                maxCoinsCount = Math.max(maxCoinsCount, currentDirectionCoinsCount);
            }
        }

        if (isNormalFlow) {
            return coins[currentRow][currentColumn] + maxCoinsCount;
        }
        return maxCoinsCount;
    }

    private int maximumCountHelper(int[][] coins, int currentRow, int currentColumn, int currentNeutralizeRobbersCount, int rowCount, int columnCount) {

        if ((currentRow == (rowCount - 1)) && (currentColumn == (columnCount - 1))) {
            if (coins[currentRow][currentColumn] < 0 && currentNeutralizeRobbersCount < MAXIMUM_NEUTRAL_ROBBERS_COUNT) {
                return 0;
            }
            return coins[currentRow][currentColumn];
        }

        if (coins[currentRow][currentColumn] >= 0) {
            return coinFlow(coins, currentRow, currentColumn, currentNeutralizeRobbersCount, rowCount, columnCount, true);
        } else {
            if (currentNeutralizeRobbersCount < MAXIMUM_NEUTRAL_ROBBERS_COUNT) {
                // Option A -> Don't Neutralize Now
                int optionACoinsCount = coinFlow(coins, currentRow, currentColumn, currentNeutralizeRobbersCount, rowCount, columnCount, true);
                // Option B -> Neutralize Now
                int optionBCoinsCount = coinFlow(coins, currentRow, currentColumn, currentNeutralizeRobbersCount, rowCount, columnCount, false);
                return Math.max(optionACoinsCount, optionBCoinsCount);
            } else {
                return coinFlow(coins, currentRow, currentColumn, currentNeutralizeRobbersCount, rowCount, columnCount, true);
            }
        }
    }

    public int maximumAmount(int[][] coins) {
        return maximumCountHelper(coins, 0, 0, 0, coins.length, coins[0].length);
    }
}
