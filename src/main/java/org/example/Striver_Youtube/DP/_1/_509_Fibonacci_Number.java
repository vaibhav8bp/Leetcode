package org.example.Striver_Youtube.DP._1;

// https://leetcode.com/problems/fibonacci-number/description/
public class _509_Fibonacci_Number {

    // Optimized DP
    public int fib(int n) {

        if (n == 0 || n == 1) {
            return n;
        }

        int first = 0;
        int second = 1;
        int answer = first + second;

        for (int i = 2; i <= n; i++) {
            answer = first + second;
            first = second;
            second = answer;
        }

        return answer;
    }

    // DP
//    public int fib(int n) {
//
//        if (n == 0 || n == 1) {
//            return n;
//        }
//
//        int[] dp = new int[n + 1];
//        dp[0] = 0;
//        dp[1] = 1;
//
//        for (int i = 2; i <= n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//
//        return dp[n];
//    }

    // Memoization
//    public int fib(int n, int[] dp) {
//        if (n == 0 || n == 1) {
//            return n;
//        }
//
//        if (dp[n] != -1) {
//            return dp[n];
//        }
//
//        if (dp[n - 1] == -1) {
//            dp[n - 1] = fib(n - 1, dp);
//        }
//
//        if (dp[n - 2] == -1) {
//            dp[n - 2] = fib(n - 2, dp);
//        }
//
//        return dp[n - 1] + dp[n - 2];
//    }
//
//    public int fib(int n) {
//        int[] dp = new int[n + 1];
//        Arrays.fill(dp, -1);
//        return fib(n, dp);
//    }

    // Recursion
//    public int fib(int n) {
//        if (n == 0 || n == 1) {
//            return n;
//        }
//
//        return fib(n - 1) + fib(n - 2);
//    }
}
