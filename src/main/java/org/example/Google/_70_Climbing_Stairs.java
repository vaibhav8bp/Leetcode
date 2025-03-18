package org.example.Google;

import java.util.Arrays;

// https://leetcode.com/problems/climbing-stairs/
public class _70_Climbing_Stairs {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

//    private int climbStairs(int n, int[] dp) {
//        if (n == 0 || n == 1) {
//            return 1;
//        }
//
//        if (dp[n] != -1) {
//            return dp[n];
//        }
//
//        if (dp[n - 1] == -1) {
//            dp[n - 1] = climbStairs(n - 1, dp);
//        }
//
//        if (dp[n - 2] == -1) {
//            dp[n - 2] = climbStairs(n - 2, dp);
//        }
//
//        dp[n] = dp[n - 1] + dp[n - 2];
//        return dp[n];
//    }
//
//    public int climbStairs(int n) {
//        int[] dp = new int[n + 1];
//        Arrays.fill(dp, -1);
//        return climbStairs(n, dp);
//    }
}
