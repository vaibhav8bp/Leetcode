package org.example.Striver_SDE_Sheet.Day_26_Dynamic_Programming_Part_II;

// https://leetcode.com/problems/coin-change/description/
public class _322_Coin_Change {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int[] previousDp = new int[amount + 1];

        // Last Row is -1.
        for (int i = 0; i < amount; i++) {
            previousDp[i] = -1;
        }

        // Last Column is 0.
        previousDp[amount] = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            dp[amount] = 0;
            for (int j = amount - 1; j >= 0; j--) {
                // Not Pick Current Coin
                int notPickCurrentCoin = previousDp[j];
                // Pick Current Coin, just check currentAmount+currentCoinAmount<=amount
                int pickCurrentCoin = Integer.MAX_VALUE;

                if ((long) j + coins[i] <= amount) {
                    pickCurrentCoin = 1 + dp[j + coins[i]];
                }

                // If not able to pick currentCoin, just return notPickCurrentCoin
                if (pickCurrentCoin == Integer.MAX_VALUE || pickCurrentCoin == 0) {
                    dp[j] = notPickCurrentCoin;
                } else {
                    if (notPickCurrentCoin == -1) {
                        dp[j] = pickCurrentCoin;
                    } else {
                        dp[j] = Math.min(pickCurrentCoin, notPickCurrentCoin);
                    }
                }
            }
            previousDp = dp;
        }

        return previousDp[0];
    }

//    public static int coinChange(int[] coins, int amount) {
//        int[][] dp = new int[coins.length + 1][amount + 1];
//
//        // Last Row is -1.
//        for (int i = 0; i < amount + 1; i++) {
//            dp[coins.length][i] = -1;
//        }
//
//        // Last Column is 0.
//        for (int i = 0; i < coins.length + 1; i++) {
//            dp[i][amount] = 0;
//        }
//
//        for (int i = coins.length - 1; i >= 0; i--) {
//            for (int j = amount - 1; j >= 0; j--) {
//
//                // Not Pick Current Coin
//                int notPickCurrentCoin = dp[i + 1][j];
//
//                // Pick Current Coin, just check currentAmount+currentCoinAmount<=amount
//                int pickCurrentCoin = Integer.MAX_VALUE;
//
//                if ((long) j + coins[i] <= amount) {
//                    pickCurrentCoin = 1 + dp[i][j + coins[i]];
//                }
//
//                // If not able to pick currentCoin, just return notPickCurrentCoin
//                if (pickCurrentCoin == Integer.MAX_VALUE || pickCurrentCoin == 0) {
//                    dp[i][j] = notPickCurrentCoin;
//                } else {
//                    if (notPickCurrentCoin == -1) {
//                        dp[i][j] = pickCurrentCoin;
//                    } else {
//                        dp[i][j] = Math.min(pickCurrentCoin, notPickCurrentCoin);
//                    }
//                }
//            }
//        }
//
//        return dp[0][0];
//    }

//    private static int coinChange(int currentCoinIndex, int currentAmount, int[] coins, int amount, int[][] dp) {
//
//        if (currentAmount == amount) {
//            return 0;
//        }
//
//        if (currentCoinIndex == coins.length) {
//            return -1;
//        }
//
//        if (dp[currentCoinIndex][currentAmount] != -2) {
//            return dp[currentCoinIndex][currentAmount];
//        }
//
//        // Not Pick Current Coin
//        int notPickCurrentCoin = coinChange(currentCoinIndex + 1, currentAmount, coins, amount, dp);
//
//        // Pick Current Coin, just check currentAmount+currentCoinAmount<=amount
//        int pickCurrentCoin = Integer.MAX_VALUE;
//
//        if ((long) currentAmount + coins[currentCoinIndex] <= amount) {
//            pickCurrentCoin = 1 + coinChange(currentCoinIndex, currentAmount + coins[currentCoinIndex], coins, amount, dp);
//        }
//
//        // If not able to pick currentCoin, just return notPickCurrentCoin
//        if (pickCurrentCoin == Integer.MAX_VALUE || pickCurrentCoin == 0) {
//            dp[currentCoinIndex][currentAmount] = notPickCurrentCoin;
//        } else {
//            if (notPickCurrentCoin == -1) {
//                dp[currentCoinIndex][currentAmount] = pickCurrentCoin;
//            } else {
//                dp[currentCoinIndex][currentAmount] = Math.min(pickCurrentCoin, notPickCurrentCoin);
//            }
//        }
//
//        return dp[currentCoinIndex][currentAmount];
//    }
//
//    public static int coinChange(int[] coins, int amount) {
//        int[][] dp = new int[coins.length][amount];
//
//        for (int i = 0; i < coins.length; i++) {
//            Arrays.fill(dp[i], -2);
//        }
//
//        return coinChange(0, 0, coins, amount, dp);
//    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2147483647}, 2));
    }
}
