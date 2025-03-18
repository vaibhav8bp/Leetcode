package org.example.Google;


// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
public class _188_Best_Time_to_Buy_and_Sell_Stock_IV {

    public int maxProfit(int k, int[] prices) {
        return 0;
    }

//    public int maxProfit(int k, int[] prices) {
//        int[][] previousDp = new int[2][k + 1];
//
//        // Base Case -> currentTransactionsCompleted == k
//        for (int i = 0; i < 2; i++) {
//            previousDp[i][k] = 0;
//        }
//
//        for (int i = prices.length - 1; i >= 0; i--) {
//            int[][] currentDp = new int[2][k + 1];
//            // Base Case -> currentTransactionsCompleted == k
//            for (int y = 0; y < 2; y++) {
//                previousDp[y][k] = 0;
//            }
//            for (int j = 0; j < 2; j++) {
//                for (int l = 0; l < k; l++) {
//                    // j == 0 -> signifies we are not holding stock right now.
//                    if (j == 0) {
//                        int buyToday = -prices[i] + previousDp[1][l];
//                        int buyLater = previousDp[0][l];
//                        currentDp[j][l] = Math.max(buyToday, buyLater);
//                    }
//                    // j == 1 -> signifies we are holding stock are now.
//                    else {
//                        int sellToday = prices[i] + previousDp[0][l + 1];
//                        int sellLater = previousDp[1][l];
//                        currentDp[j][l] = Math.max(sellToday, sellLater);
//                    }
//                }
//            }
//            previousDp = currentDp;
//        }
//
//        return previousDp[0][0];
//    }

    // Memoization
//    private int maxProfit(int currentIndex, boolean buy, int currentTransactionsCompleted, int k, int[] prices, int[][][] dp) {
//        if (currentIndex == prices.length || currentTransactionsCompleted == k) {
//            return 0;
//        }
//
//        int currentAction = buy ? 1 : 0;
//
//        if (dp[currentIndex][currentAction][currentTransactionsCompleted] != -1) {
//            return dp[currentIndex][currentAction][currentTransactionsCompleted];
//        }
//
//        // buy -> true signifies we are holding stock are now.
//        if (buy) {
//            int sellToday = prices[currentIndex] + maxProfit(currentIndex + 1, false, currentTransactionsCompleted + 1, k, prices, dp);
//            int sellLater = maxProfit(currentIndex + 1, true, currentTransactionsCompleted, k, prices, dp);
//
//            dp[currentIndex][currentAction][currentTransactionsCompleted] = Math.max(sellToday, sellLater);
//        }
//        // buy -> false signifies we are not holding stock right now.
//        else {
//            int buyToday = -prices[currentIndex] + maxProfit(currentIndex + 1, true, currentTransactionsCompleted, k, prices, dp);
//            int buyLater = maxProfit(currentIndex + 1, false, currentTransactionsCompleted, k, prices, dp);
//            dp[currentIndex][currentAction][currentTransactionsCompleted] = Math.max(buyToday, buyLater);
//        }
//
//        return dp[currentIndex][currentAction][currentTransactionsCompleted];
//    }
//
//    public int maxProfit(int k, int[] prices) {
//        int[][][] dp = new int[prices.length][2][k];
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = 0; j < 2; j++) {
//                Arrays.fill(dp[i][j], -1);
//            }
//        }
//        return maxProfit(0, false, 0, k, prices, dp);
//    }

    // Recursion
//    private int maxProfit(int currentIndex, boolean buy, int currentTransactionsCompleted, int k, int[] prices) {
//        if (currentIndex == prices.length || currentTransactionsCompleted == k) {
//            return 0;
//        }
//
//        // buy -> true signifies we are holding stock are now.
//        if (buy) {
//            int sellToday = prices[currentIndex] + maxProfit(currentIndex + 1, false, currentTransactionsCompleted + 1, k, prices);
//            int sellLater = maxProfit(currentIndex + 1, true, currentTransactionsCompleted, k, prices);
//            return Math.max(sellToday, sellLater);
//        }
//        // buy -> false signifies we are not holding stock right now.
//        else {
//            int buyToday = -prices[currentIndex] + maxProfit(currentIndex + 1, true, currentTransactionsCompleted, k, prices);
//            int buyLater = maxProfit(currentIndex + 1, false, currentTransactionsCompleted, k, prices);
//            return Math.max(buyToday, buyLater);
//        }
//    }
//
//    public int maxProfit(int k, int[] prices) {
//        return maxProfit(0, false, 0, k, prices);
//    }
}