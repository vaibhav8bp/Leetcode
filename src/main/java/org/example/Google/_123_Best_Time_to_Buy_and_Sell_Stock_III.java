package org.example.Google;


// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
public class _123_Best_Time_to_Buy_and_Sell_Stock_III {

    public static int maxProfit(int[] prices) {

        int costPrice1 = Integer.MAX_VALUE;
        int costPrice2 = Integer.MAX_VALUE;
        int profit1 = 0;
        int profit2 = 0;

        for (int currentPrice : prices) {
            costPrice1 = Math.min(costPrice1, currentPrice);
            profit1 = Math.max(profit1, currentPrice - costPrice1);

            // We have got some profit after completing transaction1.
            // So we can think we will get our next stock at its original price - booked Profit
            costPrice2 = Math.min(costPrice2, currentPrice - profit1);
            profit2 = Math.max(profit2, currentPrice - costPrice2);
        }

        return profit2;
    }

//    public static int maxProfit(int[] prices) {
//        // left[i] denotes max. profit that can be booked by selling before or on ith day.
//        int[] left = new int[prices.length];
//        // right[i] denotes max. profit that can booked by buying on or later ith day.
//        int[] right = new int[prices.length];
//
//        // For Selling we have to keep track of minimum stock price in the past;
//        left[0] = 0;
//        int minimumStockPriceSoFar = prices[0];
//
//        for (int i = 1; i < prices.length; i++) {
//            left[i] = Math.max(left[i - 1], prices[i] - minimumStockPriceSoFar);
//            minimumStockPriceSoFar = Math.min(minimumStockPriceSoFar, prices[i]);
//        }
//
//        // For Buying we have to keep track of maximum stock price in the future
//        right[prices.length - 1] = 0;
//        int maximumStockPriceAhead = prices[prices.length - 1];
//
//        for (int i = prices.length - 2; i >= 0; i--) {
//            right[i] = Math.max(right[i + 1], maximumStockPriceAhead - prices[i]);
//            maximumStockPriceAhead = Math.max(maximumStockPriceAhead, prices[i]);
//        }
//
//        // Considering Only 1 Transaction.
//        int maxProfit = Math.max(left[prices.length - 1], right[0]);
//
//        for (int i = 0; i < prices.length - 1; i++) {
//            maxProfit = Math.max(maxProfit, left[i] + right[i + 1]);
//        }
//
//        return maxProfit;
//    }

//    public int maxProfit(int[] prices) {
//        int[][] previousDp = new int[2][3];
//
//        // Base Case -> currentTransactionsCompleted == k
//        for (int i = 0; i < 2; i++) {
//            previousDp[i][2] = 0;
//        }
//
//        for (int i = prices.length - 1; i >= 0; i--) {
//            int[][] currentDp = new int[2][3];
//            // Base Case -> currentTransactionsCompleted == k
//            for (int y = 0; y < 2; y++) {
//                previousDp[y][2] = 0;
//            }
//            for (int j = 0; j < 2; j++) {
//                for (int k = 0; k < 2; k++) {
//                    // j == 0 -> signifies we are not holding stock right now.
//                    if (j == 0) {
//                        int buyToday = -prices[i] + previousDp[1][k];
//                        int buyLater = previousDp[0][k];
//                        currentDp[j][k] = Math.max(buyToday, buyLater);
//                    }
//                    // j == 1 -> signifies we are holding stock are now.
//                    else {
//                        int sellToday = prices[i] + previousDp[0][k + 1];
//                        int sellLater = previousDp[1][k];
//                        currentDp[j][k] = Math.max(sellToday, sellLater);
//                    }
//                }
//            }
//            previousDp = currentDp;
//        }
//
//        return previousDp[0][0];
//    }

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
//    public int maxProfit(int[] prices) {
//        int[][][] dp = new int[prices.length][2][2];
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = 0; j < 2; j++) {
//                Arrays.fill(dp[i][j], -1);
//            }
//        }
//        return maxProfit(0, false, 0, 2, prices, dp);
//    }

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
//    public int maxProfit(int[] prices) {
//        return maxProfit(0, false, 0, 2, prices);
//    }
}
