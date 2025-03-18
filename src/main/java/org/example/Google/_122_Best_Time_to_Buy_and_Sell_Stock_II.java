package org.example.Google;

import java.util.Arrays;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
public class _122_Best_Time_to_Buy_and_Sell_Stock_II {

    // Just think about making profit today
    // don't think about future.
//    public int maxProfit(int[] prices) {
//        int maxProfit = 0;
//        int lastBoughtPrice = prices[0];
//
//        for (int i = 1; i < prices.length; i++) {
//            if (prices[i] - lastBoughtPrice > 0) {
//                maxProfit += (prices[i] - lastBoughtPrice);
//            }
//            lastBoughtPrice = prices[i];
//        }
//
//        return maxProfit;
//    }

    public int maxProfit(int[] prices) {

        // Base Case.
        int[] previousDp = new int[2];
        Arrays.fill(previousDp, 0);

        for (int i = prices.length - 1; i >= 0; i--) {
            int[] currentDp = new int[2];
            for (int j = 0; j < 2; j++) {
                // No Stock Holding.
                if (j == 0) {
                    int buyToday = -prices[i] + previousDp[1];
                    int buyLater = previousDp[0];
                    currentDp[j] = Math.max(buyToday, buyLater);
                }
                // j == 1
                // Stock Holding.
                else {
                    int sellToday = prices[i] + previousDp[0];
                    int sellLater = previousDp[1];
                    currentDp[j] = Math.max(sellToday, sellLater);
                }
            }
            previousDp = currentDp;
        }

        return previousDp[0];
    }

//    public int maxProfit(int[] prices) {
//        int[][] dp = new int[prices.length + 1][2];
//
//        // Base Case.
//        Arrays.fill(dp[prices.length], 0);
//
//        for (int i = prices.length - 1; i >= 0; i--) {
//            for (int j = 0; j < 2; j++) {
//                // No Stock Holding.
//                if (j == 0) {
//                    int buyToday = -prices[i] + dp[i + 1][1];
//                    int buyLater = dp[i + 1][0];
//                    dp[i][j] = Math.max(buyToday, buyLater);
//                }
//                // j == 1
//                // Stock Holding.
//                else {
//                    int sellToday = prices[i] + dp[i + 1][0];
//                    int sellLater = dp[i + 1][1];
//                    dp[i][j] = Math.max(sellToday, sellLater);
//                }
//            }
//        }
//
//        return dp[0][0];
//    }

//     No Need to think about -> On each day, you may decide to buy and/or sell the stock.
//     (sell early) (buy sell) -> 0 money
//     (buy early) (sell buy) -> not possible
//
//     buy=false -> signifies no stock holding right now.
//     buy=true -> signifies holding stock right now.

//    private int maxProfit(int currentIndex, int[] prices, boolean buy, int[][] dp) {
//        if (currentIndex == prices.length) {
//            return 0;
//        }
//
//        // currentAction -> 0 specifies no stock holding.
//        // currentAction -> 1 specifies stock holding.
//        int currentAction = (buy) ? 1 : 0;
//
//        if (dp[currentIndex][currentAction] != -1) {
//            return dp[currentIndex][currentAction];
//        }
//
//        // We are holding stock right now.
//        if (buy) {
//            int sellToday = prices[currentIndex] + maxProfit(currentIndex + 1, prices, false, dp);
//            int sellLater = maxProfit(currentIndex + 1, prices, true, dp);
//
//            dp[currentIndex][currentAction] = Math.max(sellToday, sellLater);
//        }
//        // Not Holding Stock Right now.
//        else {
//            int buyToday = -prices[currentIndex] + maxProfit(currentIndex + 1, prices, true, dp);
//            int buyLater = maxProfit(currentIndex + 1, prices, false, dp);
//
//            dp[currentIndex][currentAction] = Math.max(buyToday, buyLater);
//        }
//
//        return dp[currentIndex][currentAction];
//    }
//
//    public int maxProfit(int[] prices) {
//        int[][] dp = new int[prices.length][2];
//        for (int[] currentDp : dp) {
//            Arrays.fill(currentDp, -1);
//        }
//        return maxProfit(0, prices, false, dp);
//    }

//    // buy=false -> signifies no stock holding right now.
//    // buy=true -> signifies holding stock right now.
//
//    private int maxProfit(int currentIndex, int[] prices, boolean buy) {
//        if (currentIndex == prices.length) {
//            return 0;
//        }
//
//        // We are holding stock right now.
//        if (buy) {
//            int sellToday = prices[currentIndex] + maxProfit(currentIndex + 1, prices, false);
//            int sellLater = maxProfit(currentIndex + 1, prices, true);
//
//            return Math.max(sellToday, sellLater);
//        }
//        // Not Holding Stock Right now.
//        else {
//            int buyToday = -prices[currentIndex] + maxProfit(currentIndex + 1, prices, true);
//            int buyLater = maxProfit(currentIndex + 1, prices, false);
//
//            return Math.max(buyToday, buyLater);
//        }
//    }
//
//    public int maxProfit(int[] prices) {
//        return maxProfit(0, prices, false);
//    }
}