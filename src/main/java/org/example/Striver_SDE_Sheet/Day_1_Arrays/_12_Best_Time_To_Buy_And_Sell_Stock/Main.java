package org.example.Striver_SDE_Sheet.Day_1_Arrays._12_Best_Time_To_Buy_And_Sell_Stock;

class Solution {

    // Brute Force - O(N^2)

//    public int maxProfit(int[] prices) {
//        int maxProfitSoFar = 0;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                if (prices[j] > prices[i]) {
//                    maxProfitSoFar = Math.max(maxProfitSoFar, prices[j] - prices[i]);
//                }
//            }
//        }
//        return maxProfitSoFar;
//    }

    // DP
//    public int maxProfitHelper(int[] prices, int currentIndex, int buy, int[][] dp, int transactionCount) {
//        if (transactionCount == 0 || currentIndex == prices.length) {
//            return 0;
//        }
//        if (dp[currentIndex][buy] != -1) {
//            return dp[currentIndex][buy];
//        }

//        if (buy == 1) {
//            dp[currentIndex][buy] =
//                    Math.max(-prices[currentIndex] + maxProfitHelper(prices, currentIndex + 1, 0, dp, transactionCount),
//                            maxProfitHelper(prices, currentIndex + 1, 1, dp, transactionCount));
//        } else {
//            dp[currentIndex][buy] = Math.max(prices[currentIndex] + maxProfitHelper(prices, currentIndex + 1, 1, dp, transactionCount - 1),
//                    maxProfitHelper(prices, currentIndex + 1, 0, dp, transactionCount));
//        }

//        return dp[currentIndex][buy];
//    }

//    public int maxProfit(int[] prices) {
//        int[][] dp = new int[prices.length][2];
//        for (int i = 0; i < prices.length; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return maxProfitHelper(prices, 0, 1, dp, 1);
//    }

    public int maxProfit(int[] prices) {
        int minimumSoFar = Integer.MAX_VALUE, maximumProfitSoFar = 0;

        for (int price : prices) {
            if (price - minimumSoFar > maximumProfitSoFar) {
                maximumProfitSoFar = price - minimumSoFar;
            }
            minimumSoFar = Math.min(minimumSoFar, price);
        }

        return maximumProfitSoFar;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit(prices));
    }
}
