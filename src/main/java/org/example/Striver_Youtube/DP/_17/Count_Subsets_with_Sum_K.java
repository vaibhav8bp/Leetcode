package org.example.Striver_Youtube.DP._17;

public class Count_Subsets_with_Sum_K {

    // Optimized DP
    private static final int MODULO = (int) (1e9 + 7);

    public static int findWays(int[] num, int tar) {
        int[] previousDP = new int[tar + 1];

        previousDP[tar] = 1;
        for (int i = 0; i < tar; i++) {
            previousDP[i] = 0;
        }

        for (int i = num.length - 1; i >= 0; i--) {
            int[] dp = new int[tar + 1];
            for (int j = tar; j >= 0; j--) {
                int includeCurrentElementInSubset = 0;
                if (j + num[i] <= tar) {
                    includeCurrentElementInSubset = previousDP[j + num[i]];
                }
                int excludeCurrentElementInSubset = previousDP[j];
                dp[j] = (includeCurrentElementInSubset + excludeCurrentElementInSubset) % MODULO;
            }
            previousDP = dp;
        }

        return previousDP[0];
    }

    // DP
//    private static final int MODULO = (int) (1e9 + 7);
//
//    public static int findWays(int[] num, int tar) {
//        int[][] dp = new int[num.length + 1][tar + 1];
//
//        for (int i = 0; i < tar + 1; i++) {
//            if (i == tar) {
//                dp[num.length][i] = 1;
//            } else {
//                dp[num.length][i] = 0;
//            }
//        }
//
//        for (int i = num.length - 1; i >= 0; i--) {
//            for (int j = tar; j >= 0; j--) {
//                int includeCurrentElementInSubset = 0;
//                if (j + num[i] <= tar) {
//                    includeCurrentElementInSubset = dp[i + 1][j + num[i]];
//                }
//                int excludeCurrentElementInSubset = dp[i + 1][j];
//                dp[i][j] = (includeCurrentElementInSubset + excludeCurrentElementInSubset) % MODULO;
//            }
//        }
//
//        return dp[0][0];
//    }

    // Memoization
//    private static final int MODULO = (int) (1e9 + 7);
//
//    private static int findWays(int currentIndex, int currentSum, int target, int[] num, int[][] dp) {
//
//        if (currentIndex == num.length) {
//            if (currentSum == target) {
//                return 1;
//            } else {
//                return 0;
//            }
//        }
//
//        if (dp[currentIndex][currentSum] != -1) {
//            return dp[currentIndex][currentSum];
//        }
//
//        int includeCurrentElementInSubset = 0;
//
//        if (currentSum + num[currentIndex] <= target) {
//            includeCurrentElementInSubset = findWays(currentIndex + 1, currentSum + num[currentIndex], target, num, dp);
//        }
//
//        int excludeCurrentElementInSubset = findWays(currentIndex + 1, currentSum, target, num, dp);
//
//        dp[currentIndex][currentSum] = (includeCurrentElementInSubset + excludeCurrentElementInSubset) % MODULO;
//
//        return dp[currentIndex][currentSum];
//    }
//
//    public static int findWays(int[] num, int tar) {
//        int[][] dp = new int[num.length][tar + 1];
//        for (int i = 0; i < num.length; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return findWays(0, 0, tar, num, dp);
//    }

    // Recursion
//    private static final int MODULO = (int) (1e9 + 7);
//
//    private static int findWays(int currentIndex, int currentSum, int target, int[] num) {
//
//        if (currentIndex == num.length) {
//            if (currentSum == target) {
//                return 1;
//            } else {
//                return 0;
//            }
//        }
//
//        int includeCurrentElementInSubset = 0;
//
//        if (currentSum + num[currentIndex] <= target) {
//            includeCurrentElementInSubset = findWays(currentIndex + 1, currentSum + num[currentIndex], target, num);
//        }
//
//        int excludeCurrentElementInSubset = findWays(currentIndex + 1, currentSum, target, num);
//
//        return (includeCurrentElementInSubset + excludeCurrentElementInSubset) % MODULO;
//    }
//
//    public static int findWays(int[] num, int tar) {
//        return findWays(0, 0, tar, num);
//    }
}