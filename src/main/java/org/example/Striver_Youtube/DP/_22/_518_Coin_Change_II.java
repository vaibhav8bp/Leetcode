package org.example.Striver_Youtube.DP._22;

// https://leetcode.com/problems/coin-change-ii/
public class _518_Coin_Change_II {

    public int change(int amount, int[] coins) {

        int[] previousDP = new int[amount + 1];

        for (int i = 0; i < amount + 1; i++) {
            if (i == amount) {
                previousDP[i] = 1;
            } else {
                previousDP[i] = 0;
            }
        }

        for (int i = coins.length - 1; i >= 0; i--) {
            int[] dp = new int[amount + 1];

            for (int j = amount; j >= 0; j--) {
                int excludeCurrentCoin = previousDP[j];
                int includeCurrentCoin = 0;

                if (j + coins[i] <= amount) {
                    includeCurrentCoin = dp[j + coins[i]];
                }

                dp[j] = excludeCurrentCoin + includeCurrentCoin;
            }
            previousDP = dp;
        }

        return previousDP[0];
    }

//    public int change(int amount, int[] coins) {
//        int[][] dp = new int[coins.length + 1][amount + 1];
//
//        for (int i = 0; i < amount + 1; i++) {
//            if (i == amount) {
//                dp[coins.length][i] = 1;
//            } else {
//                dp[coins.length][i] = 0;
//            }
//        }
//
//        for (int i = coins.length - 1; i >= 0; i--) {
//            for (int j = amount; j >= 0; j--) {
//                int excludeCurrentCoin = dp[i + 1][j];
//                int includeCurrentCoin = 0;
//
//                if (j + coins[i] <= amount) {
//                    includeCurrentCoin = dp[i][j + coins[i]];
//                }
//
//                dp[i][j] = excludeCurrentCoin + includeCurrentCoin;
//            }
//        }
//
//        return dp[0][0];
//    }

//    private int change(int currentIndex, int currentAmount, int amount, int[] coins, int[][] dp) {
//        if (currentIndex == coins.length) {
//            if (currentAmount == amount) {
//                return 1;
//            } else {
//                return 0;
//            }
//        }
//
//        if (dp[currentIndex][currentAmount] != -1) {
//            return dp[currentIndex][currentAmount];
//        }
//
//        int excludeCurrentCoin = change(currentIndex + 1, currentAmount, amount, coins, dp);
//        int includeCurrentCoin = 0;
//
//        if (currentAmount + coins[currentIndex] <= amount) {
//            includeCurrentCoin = change(currentIndex, currentAmount + coins[currentIndex], amount, coins, dp);
//        }
//
//        dp[currentIndex][currentAmount] = excludeCurrentCoin + includeCurrentCoin;
//        return dp[currentIndex][currentAmount];
//    }
//
//    public int change(int amount, int[] coins) {
//        int[][] dp = new int[coins.length][amount + 1];
//
//        for (int i = 0; i < coins.length; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//
//        return change(0, 0, amount, coins, dp);
//    }

//    private int change(int currentIndex, int currentAmount, int amount, int[] coins) {
//        if (currentIndex == coins.length) {
//            if (currentAmount == amount) {
//                return 1;
//            } else {
//                return 0;
//            }
//        }
//
//        int excludeCurrentCoin = change(currentIndex + 1, currentAmount, amount, coins);
//        int includeCurrentCoin = 0;
//
//        if (currentAmount + coins[currentIndex] <= amount) {
//            includeCurrentCoin = change(currentIndex, currentAmount + coins[currentIndex], amount, coins);
//        }
//
//        return excludeCurrentCoin + includeCurrentCoin;
//    }
//
//    public int change(int amount, int[] coins) {
//        return change(0, 0, amount, coins);
//    }
}
