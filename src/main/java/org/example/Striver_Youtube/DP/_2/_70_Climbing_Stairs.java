package org.example.Striver_Youtube.DP._2;

// https://leetcode.com/problems/climbing-stairs/description/
public class _70_Climbing_Stairs {

    public int climbStairs(int n) {

        if (n == 1) {
            return 1;
        }

        int first = 1;
        int second = 1;
        int answer = first + second;

        for (int i = 2; i <= n; i++) {
            answer = first + second;
            first = second;
            second = answer;
        }

        return answer;
    }

//    public int climbStairs(int n) {
//        int[] dp = new int[n + 1];
//        dp[0] = dp[1] = 1;
//
//        for (int i = 2; i <= n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//
//        return dp[n];
//    }
}
