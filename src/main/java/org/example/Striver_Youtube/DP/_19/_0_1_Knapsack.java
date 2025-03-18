package org.example.Striver_Youtube.DP._19;

import java.util.Arrays;

// https://www.naukri.com/code360/problems/0-1-knapsack_920542
public class _0_1_Knapsack {

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        int[] previousDP = new int[maxWeight + 1];
        Arrays.fill(previousDP, 0);

        for (int i = n - 1; i >= 0; i--) {
            int[] dp = new int[maxWeight + 1];
            dp[maxWeight] = 0;
            for (int j = maxWeight - 1; j >= 0; j--) {
                int excludeCurrentItemInKnapsack = previousDP[j];

                int includeCurrentItemInKnapsack = 0;

                if (j + weight[i] <= maxWeight) {
                    includeCurrentItemInKnapsack = value[i] + previousDP[j + weight[i]];
                }

                dp[j] = Math.max(excludeCurrentItemInKnapsack, includeCurrentItemInKnapsack);
            }
            previousDP = dp;
        }

        return previousDP[0];
    }

//    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
//        int[][] dp = new int[n + 1][maxWeight + 1];
//
//        Arrays.fill(dp[n], 0);
//
//        for (int i = 0; i < n; i++) {
//            dp[i][maxWeight] = 0;
//        }
//
//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = maxWeight - 1; j >= 0; j--) {
//                int excludeCurrentItemInKnapsack = dp[i + 1][j];
//
//                int includeCurrentItemInKnapsack = 0;
//
//                if (j + weight[i] <= maxWeight) {
//                    includeCurrentItemInKnapsack = value[i] + dp[i + 1][j + weight[i]];
//                }
//
//                dp[i][j] = Math.max(excludeCurrentItemInKnapsack, includeCurrentItemInKnapsack);
//            }
//        }
//
//        return dp[0][0];
//    }

    // Memoization
//    static int knapsack(int currentIndex, int currentWeight, int[] weight, int[] value, int n, int maxWeight, int[][] dp) {
//        if (currentIndex == n || currentWeight == maxWeight) {
//            return 0;
//        }
//
//        if (dp[currentIndex][currentWeight] != -1) {
//            return dp[currentIndex][currentWeight];
//        }
//
//        int excludeCurrentItemInKnapsack = knapsack(currentIndex + 1, currentWeight, weight, value, n, maxWeight, dp);
//
//        int includeCurrentItemInKnapsack = 0;
//
//        if (currentWeight + weight[currentIndex] <= maxWeight) {
//            includeCurrentItemInKnapsack = value[currentIndex] + knapsack(currentIndex + 1, currentWeight + weight[currentIndex], weight, value, n, maxWeight, dp);
//        }
//
//        dp[currentIndex][currentWeight] = Math.max(excludeCurrentItemInKnapsack, includeCurrentItemInKnapsack);
//        return dp[currentIndex][currentWeight];
//    }
//
//    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
//        int[][] dp = new int[n][maxWeight + 1];
//
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//
//        return knapsack(0, 0, weight, value, n, maxWeight, dp);
//    }

    // Recursion
//    static int knapsack(int currentIndex, int currentWeight, int[] weight, int[] value, int n, int maxWeight) {
//        if (currentIndex == n) {
//            return 0;
//        }
//
//        int excludeCurrentItemInKnapsack = knapsack(currentIndex + 1, currentWeight, weight, value, n, maxWeight);
//
//        int includeCurrentItemInKnapsack = 0;
//
//        if (currentWeight + weight[currentIndex] <= maxWeight) {
//            includeCurrentItemInKnapsack = value[currentIndex] + knapsack(currentIndex + 1, currentWeight + weight[currentIndex], weight, value, n, maxWeight);
//        }
//
//        return Math.max(excludeCurrentItemInKnapsack, includeCurrentItemInKnapsack);
//    }
//
//    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
//        return knapsack(0, 0, weight, value, n, maxWeight);
//    }
}
