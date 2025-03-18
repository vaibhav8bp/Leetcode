package org.example.Striver_Youtube.DP._24;

// https://www.naukri.com/code360/problems/rod-cutting-problem_800284
public class Rod_cutting_problem {

    public static int cutRod(int[] price, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int maxPrice = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                maxPrice = Math.max(maxPrice, price[j - 1] + dp[i - j]);
            }
            dp[i] = maxPrice;
        }

        return dp[n];
    }

//    public static int cutRod(int[] price, int currentLengthOfRod, int[] dp) {
//        if (currentLengthOfRod == 0) {
//            return 0;
//        }
//
//        if (dp[currentLengthOfRod] != -1) {
//            return dp[currentLengthOfRod];
//        }
//
//        int maxPrice = Integer.MIN_VALUE;
//
//        for (int i = 1; i <= currentLengthOfRod; i++) {
//            maxPrice = Math.max(maxPrice, price[i - 1] + cutRod(price, currentLengthOfRod - i, dp));
//        }
//
//        dp[currentLengthOfRod] = maxPrice;
//        return dp[currentLengthOfRod];
//    }
//
//    public static int cutRod(int[] price, int n) {
//        int[] dp = new int[n + 1];
//        Arrays.fill(dp, -1);
//        return cutRod(price, n, dp);
//    }

//    public static int cutRod(int[] price, int currentLengthOfRod) {
//        if (currentLengthOfRod == 0) {
//            return 0;
//        }
//
//        int maxPrice = Integer.MIN_VALUE;
//
//        for (int i = 1; i <= currentLengthOfRod; i++) {
//            maxPrice = Math.max(maxPrice, price[i - 1] + cutRod(price, currentLengthOfRod - i));
//        }
//
//        return maxPrice;
//    }

    // 3, 5, 8, 9, 10, 17, 17, 20
}
