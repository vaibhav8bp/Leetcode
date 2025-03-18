package org.example.Striver_SDE_Sheet.Day_25_Dynamic_Programming._152_Maximum_Product_Subarray;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.naukri.com/code360/problems/1072980
public class _0_1_Knapsack {
    // Greedy Solution fails for 0/1 knapsack but works for fractional knapsack. (Refer Below Example)
//    values = [60, 100, 120]
//    weights = [10, 20, 30]
//    w = 50

    // For 0-1 output will 60+100, but we could have picked 100+120

    public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        int[] dp = new int[w + 1];
        int[] previousDp = new int[w + 1];
        Arrays.fill(previousDp, 0);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = w - 1; j >= 0; j--) {
                // Not Include Current Item In Our KnapSack.
                int notIncludeItem = previousDp[j];

                // Include Current Item In Our KnapSack.
                // Just check before including , weight constraint is not exceeded.
                int includeItem = 0;

                if (j + weights.get(i) <= w) {
                    includeItem = values.get(i) + previousDp[j + weights.get(i)];
                }

                dp[j] = Math.max(includeItem, notIncludeItem);
            }
            if (w + 1 >= 0) System.arraycopy(dp, 0, previousDp, 0, w + 1);
        }
        return previousDp[0];
    }
}

//    public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
//        int[][] dp = new int[n + 1][w + 1];
//
//        Arrays.fill(dp[n], 0);
//
//        for (int i = 0; i < n + 1; i++) {
//            dp[i][w] = 0;
//        }
//
//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = w - 1; j >= 0; j--) {
//                // Not Include Current Item In Our KnapSack.
//                int notIncludeItem = dp[i + 1][j];
//
//                // Include Current Item In Our KnapSack.
//                // Just check before including , weight constraint is not exceeded.
//                int includeItem = 0;
//
//                if (j + weights.get(i) <= w) {
//                    includeItem = values.get(i) + dp[i + 1][j + weights.get(i)];
//                }
//
//                dp[i][j] = Math.max(includeItem, notIncludeItem);
//            }
//        }
//
//        return dp[0][0];
//    }

//    private static int maxProfit(int currentIndex, int currentWeight, ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w, int[][] dp) {
//        if (currentIndex == n || currentWeight == w) {
//            return 0;
//        }
//
//
//        if (dp[currentIndex][currentWeight] != -1) {
//            return dp[currentIndex][currentWeight];
//        }
//
//        // Not Include Current Item In Our KnapSack.
//        int notIncludeItem = maxProfit(currentIndex + 1, currentWeight, values, weights, n, w, dp);
//
//        // Include Current Item In Our KnapSack.
//        // Just check before including , weight constraint is not exceeded.
//        int includeItem = 0;
//
//        if (currentWeight + weights.get(currentIndex) <= w) {
//            includeItem = values.get(currentIndex) + maxProfit(currentIndex + 1, currentWeight + weights.get(currentIndex), values, weights, n, w, dp);
//        }
//
//        dp[currentIndex][currentWeight] = Math.max(includeItem, notIncludeItem);
//        return dp[currentIndex][currentWeight];
//    }
//
//    public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
//        int[][] dp = new int[n][w];
//
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//
//        return maxProfit(0, 0, values, weights, n, w, dp);
//    }