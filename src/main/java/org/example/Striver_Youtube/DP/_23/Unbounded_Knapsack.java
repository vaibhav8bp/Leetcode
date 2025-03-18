package org.example.Striver_Youtube.DP._23;

import java.util.Arrays;

// https://www.naukri.com/code360/problems/unbounded-knapsack_1215029
public class Unbounded_Knapsack {

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {

        int[] previousDP = new int[w + 1];
        Arrays.fill(previousDP, 0);

        for (int i = n - 1; i >= 0; i--) {
            int[] dp = new int[w + 1];
            dp[w] = 0;
            for (int j = w - 1; j >= 0; j--) {
                int excludeCurrentElementInKnapsack = previousDP[j];
                int includeCurrentElementInKnapsack = 0;
                if (j + weight[i] <= w) {
                    includeCurrentElementInKnapsack = profit[i] + dp[j + weight[i]];
                }
                dp[j] = Math.max(includeCurrentElementInKnapsack, excludeCurrentElementInKnapsack);
            }
            previousDP = dp;
        }

        return previousDP[0];
    }

//    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
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
//                int excludeCurrentElementInKnapsack = dp[i + 1][j];
//                int includeCurrentElementInKnapsack = 0;
//                if (j + weight[i] <= w) {
//                    includeCurrentElementInKnapsack = profit[i] + dp[i][j + weight[i]];
//                }
//                dp[i][j] = Math.max(includeCurrentElementInKnapsack, excludeCurrentElementInKnapsack);
//            }
//        }
//
//        return dp[0][0];
//    }

//    private static int unboundedKnapsack(int currentIndex, int currentWeight, int n, int w, int[] profit, int[] weight, int[][] dp) {
//        if ((currentIndex == n) || (currentWeight == w)) {
//            return 0;
//        }
//
//        if (dp[currentIndex][currentWeight] != -1) {
//            return dp[currentIndex][currentWeight];
//        }
//
//        int excludeCurrentElementInKnapsack = unboundedKnapsack(currentIndex + 1, currentWeight, n, w, profit, weight, dp);
//
//        int includeCurrentElementInKnapsack = 0;
//
//        if (currentWeight + weight[currentIndex] <= w) {
//            includeCurrentElementInKnapsack = profit[currentIndex] +
//                    unboundedKnapsack(currentIndex, currentWeight + weight[currentIndex], n, w, profit, weight, dp);
//        }
//
//        dp[currentIndex][currentWeight] = Math.max(includeCurrentElementInKnapsack, excludeCurrentElementInKnapsack);
//        return dp[currentIndex][currentWeight];
//    }
//
//    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
//        int[][] dp = new int[n][w];
//
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//
//        return unboundedKnapsack(0, 0, n, w, profit, weight, dp);
//    }

//    private static int unboundedKnapsack(int currentIndex, int currentWeight, int n, int w, int[] profit, int[] weight) {
//        if ((currentIndex == n) || (currentWeight == w)) {
//            return 0;
//        }
//
//        int excludeCurrentElementInKnapsack = unboundedKnapsack(currentIndex + 1, currentWeight, n, w, profit, weight);
//
//        int includeCurrentElementInKnapsack = 0;
//
//        if (currentWeight + weight[currentIndex] <= w) {
//            includeCurrentElementInKnapsack = profit[currentIndex] +
//                    unboundedKnapsack(currentIndex, currentWeight + weight[currentIndex], n, w, profit, weight);
//        }
//
//        return Math.max(includeCurrentElementInKnapsack, excludeCurrentElementInKnapsack);
//    }
//
//    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
//        return unboundedKnapsack(0, 0, n, w, profit, weight);
//    }
}
