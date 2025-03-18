package org.example.Striver_Youtube.DP._4;

// https://atcoder.jp/contests/dp/tasks/dp_b
public class B_Frog_2 {

    private int minCost(int[] heights, int k) {
        int[] dp = new int[heights.length];
        dp[heights.length - 1] = 0;

        for (int i = heights.length - 2; i >= 0; i--) {
            int startIndex = i + 1;
            int endIndex = Math.min(heights.length - 1, i + k);

            int answer = Integer.MAX_VALUE;

            while (startIndex <= endIndex) {
                answer = Math.min(answer, Math.abs(heights[startIndex] - heights[i]) + dp[startIndex]);
                startIndex++;
            }
            dp[i] = answer;
        }

        return dp[0];
    }

//    private int minCost(int currentIndex, int k, int[] heights, int[] dp) {
//        if (currentIndex == heights.length - 1) {
//            return 0;
//        }
//
//        if (dp[currentIndex] != -1) {
//            return dp[currentIndex];
//        }
//
//        int startIndex = currentIndex + 1;
//        int endIndex = Math.min(heights.length - 1, currentIndex + k);
//
//        int answer = Integer.MAX_VALUE;
//
//        while (startIndex <= endIndex) {
//            answer = Math.min(answer, Math.abs(heights[startIndex] - heights[currentIndex]) +
//                    minCost(startIndex, k, heights, dp));
//            startIndex++;
//        }
//
//        dp[currentIndex] = answer;
//        return answer;
//    }
//
//    private int minCost(int[] heights, int k) {
//        int[] dp = new int[heights.length];
//        Arrays.fill(dp, -1);
//        return minCost(0, k, heights, dp);
//    }

//    private int minCost(int currentIndex, int k, int[] heights) {
//        if (currentIndex == heights.length - 1) {
//            return 0;
//        }
//
//        int startIndex = currentIndex + 1;
//        int endIndex = Math.min(heights.length - 1, currentIndex + k);
//
//        int answer = Integer.MAX_VALUE;
//
//        while (startIndex <= endIndex) {
//            answer = Math.min(answer, Math.abs(heights[startIndex] - heights[currentIndex]) +
//                    minCost(startIndex, k, heights));
//            startIndex++;
//        }
//
//        return answer;
//    }
//
//    private int minCost(int[] heights, int k) {
//        return minCost(0, k, heights);
//    }
}