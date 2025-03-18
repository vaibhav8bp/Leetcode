package org.example.Striver_Youtube.DP._14;

// https://www.naukri.com/code360/problems/subset-sum-equal-to-k_1550954
public class Subset_Sum_Equal_To_K {

    // Optimized DP
    public static boolean subsetSumToK(int n, int k, int[] arr) {
        boolean[] previousDp = new boolean[k + 1];

        for (int i = 0; i < k + 1; i++) {
            previousDp[i] = (i == k);
        }

        for (int i = n - 1; i >= 0; i--) {
            boolean[] dp = new boolean[k + 1];
            dp[k] = true;
            for (int j = k - 1; j >= 0; j--) {
                boolean includeCurrentElement = false;
                if (j + arr[i] <= k) {
                    includeCurrentElement = previousDp[j + arr[i]];
                }
                boolean excludeCurrentElement = previousDp[j];
                dp[j] = includeCurrentElement || excludeCurrentElement;
            }
            previousDp = dp;
        }

        return previousDp[0];
    }

    // DP
//    public static boolean subsetSumToK(int n, int k, int[] arr) {
//        boolean[][] dp = new boolean[n + 1][k + 1];
//
//        for (int i = 0; i < k + 1; i++) {
//            dp[n][i] = (i == k);
//        }
//
//        for (int i = 0; i < n; i++) {
//            dp[i][k] = true;
//        }
//
//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = k - 1; j >= 0; j--) {
//                boolean includeCurrentElement = false;
//                if (j + arr[i] <= k) {
//                    includeCurrentElement = dp[i + 1][j + arr[i]];
//                }
//                boolean excludeCurrentElement = dp[i + 1][j];
//                dp[i][j] = includeCurrentElement || excludeCurrentElement;
//
//            }
//        }
//
//        return dp[0][0];
//    }

    // Memoization
//    private static boolean subsetSumToKHelper(int currentIndex, int currentSum, int k, int[] arr, Boolean[][] dp) {
//        if (currentIndex == arr.length) {
//            return currentSum == k;
//        }
//
//        if (currentSum == k) {
//            return true;
//        }
//
//        if (dp[currentIndex][currentSum] != null) {
//            return dp[currentIndex][currentSum];
//        }
//
//        boolean includeCurrentElement = false;
//
//        if (currentSum + arr[currentIndex] <= k) {
//            includeCurrentElement = subsetSumToKHelper(currentIndex + 1, currentSum + arr[currentIndex], k, arr, dp);
//        }
//
//        boolean excludeCurrentElement = subsetSumToKHelper(currentIndex + 1, currentSum, k, arr, dp);
//
//        dp[currentIndex][currentSum] = includeCurrentElement || excludeCurrentElement;
//
//        return dp[currentIndex][currentSum];
//    }
//
//    public static boolean subsetSumToK(int n, int k, int[] arr) {
//        Boolean[][] dp = new Boolean[n][k + 1];
//        return subsetSumToKHelper(0, 0, k, arr, dp);
//    }

    // Recursion
//    private static boolean subsetSumToKHelper(int currentIndex, int currentSum, int k, int[] arr) {
//        if (currentIndex == arr.length) {
//            return currentSum == k;
//        }
//
//        if (currentSum == k) {
//            return true;
//        }
//
//        boolean includeCurrentElement = false;
//
//        if (currentSum + arr[currentIndex] <= k) {
//            includeCurrentElement = subsetSumToKHelper(currentIndex + 1, currentSum + arr[currentIndex], k, arr);
//        }
//
//        boolean excludeCurrentElement = subsetSumToKHelper(currentIndex + 1, currentSum, k, arr);
//
//        return includeCurrentElement || excludeCurrentElement;
//    }
//
//    public static boolean subsetSumToK(int n, int k, int[] arr) {
//        return subsetSumToKHelper(0, 0, k, arr);
//    }
}
