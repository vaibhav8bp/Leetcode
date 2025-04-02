package org.example.Google;


// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class _121_Best_Time_to_Buy_and_Sell_Stock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int maxSellingPrice = prices[prices.length - 1];

        for (int i = prices.length - 2; i >= 0; i--) {
            maxProfit = Math.max(maxProfit, -prices[i] + maxSellingPrice);
            maxSellingPrice = Math.max(maxSellingPrice, prices[i]);
        }

        return maxProfit;
    }

//    // dp[][0] specifies buying
//    // dp[][1] specifies selling
//
//    private int maxProfit(int currentIndex, int[] prices, boolean stockBought, int[][] dp) {
//        if (currentIndex == prices.length) {
//            return 0;
//        }
//
//        int currentAction = (!stockBought) ? 0 : 1;
//
//        if (dp[currentIndex][currentAction] != -1) {
//            return dp[currentIndex][currentAction];
//        }
//
//        // If stock is already bought, we can choose whether to sell today.
//        if (stockBought) {
//            // Sell Today
//            int sellToday = prices[currentIndex];
//            // Don't Sell Today
//            int dontSellToday = 0;
//            if (currentIndex + 1 != prices.length) {
//                if (dp[currentIndex + 1][1] == -1) {
//                    dp[currentIndex + 1][1] = maxProfit(currentIndex + 1, prices, true, dp);
//                }
//                dontSellToday = dp[currentIndex + 1][1];
//            }
//            dp[currentIndex][currentAction] = Math.max(sellToday, dontSellToday);
//        }
//        // If stock is not already bought, we can choose whether to buy today.
//        else {
//            // Buy Today
//            int buyToday = -prices[currentIndex];
//            int buyTodayRecursion = 0;
//            if (currentIndex + 1 != prices.length) {
//                if (dp[currentIndex + 1][1] == -1) {
//                    dp[currentIndex + 1][1] = maxProfit(currentIndex + 1, prices, true, dp);
//                }
//                buyTodayRecursion = dp[currentIndex + 1][1];
//            }
//            buyToday += buyTodayRecursion;
//            // Don't Buy Today
//            int dontBuyToday = 0;
//            if (currentIndex + 1 != prices.length) {
//                if (dp[currentIndex + 1][0] == -1) {
//                    dp[currentIndex + 1][0] = maxProfit(currentIndex + 1, prices, false, dp);
//                }
//                dontBuyToday = dp[currentIndex + 1][0];
//            }
//
//            dp[currentIndex][currentAction] = Math.max(buyToday, dontBuyToday);
//        }
//        return dp[currentIndex][currentAction];
//    }
//
//    public int maxProfit(int[] prices) {
//        int[][] dp = new int[prices.length][2];
//        for (int[] current : dp) {
//            Arrays.fill(current, -1);
//        }
//        return maxProfit(0, prices, false, dp);
//    }
}
