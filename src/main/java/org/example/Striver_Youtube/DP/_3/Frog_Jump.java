package org.example.Striver_Youtube.DP._3;

// https://www.naukri.com/code360/problems/frog-jump_3621012
public class Frog_Jump {

    public static int frogJump(int n, int[] heights) {

        if (n == 1) {
            return 0;
        }

        int last = 0;
        int secondLast = Math.abs(heights[n - 1] - heights[n - 2]);

        for (int i = n - 3; i >= 0; i--) {
            int minimumCost = Math.min(Math.abs(heights[i + 1] - heights[i]) + secondLast, Math.abs(heights[i + 2] - heights[i]) + last);
            last = secondLast;
            secondLast = minimumCost;
        }

        return secondLast;
    }

//    public static int frogJump(int n, int[] heights) {
//        int[] dp = new int[n];
//        dp[n - 1] = 0;
//
//        for (int i = n - 2; i >= 0; i--) {
//            int minimumCost = Integer.MAX_VALUE;
//
//            if (i + 1 < n) {
//                minimumCost = Math.min(minimumCost, Math.abs(heights[i + 1] - heights[i]) + dp[i + 1]);
//            }
//
//            if (i + 2 < n) {
//                minimumCost = Math.min(minimumCost, Math.abs(heights[i + 2] - heights[i]) + dp[i + 2]);
//            }
//
//            dp[i] = minimumCost;
//        }
//
//        return dp[0];
//    }

//    private static int frogJumpHelper(int currentIndex, int[] heights, int[] dp) {
//        if (currentIndex == heights.length - 1) {
//            return 0;
//        }
//
//        if (dp[currentIndex] != -1) {
//            return dp[currentIndex];
//        }
//
//        int minimumCost = Integer.MAX_VALUE;
//
//        if (currentIndex + 1 < heights.length) {
//            minimumCost = Math.min(minimumCost, Math.abs(heights[currentIndex + 1] - heights[currentIndex]) +
//                    frogJumpHelper(currentIndex + 1, heights, dp));
//        }
//
//        if (currentIndex + 2 < heights.length) {
//            minimumCost = Math.min(minimumCost, Math.abs(heights[currentIndex + 2] - heights[currentIndex]) +
//                    frogJumpHelper(currentIndex + 2, heights, dp));
//
//        }
//
//        dp[currentIndex] = minimumCost;
//
//        return dp[currentIndex];
//    }
//
//    public static int frogJump(int n, int[] heights) {
//        int[] dp = new int[n];
//        Arrays.fill(dp, -1);
//        return frogJumpHelper(0, heights, dp);
//    }

//    private static int frogJumpHelper(int currentIndex, int[] heights) {
//        if (currentIndex == heights.length - 1) {
//            return 0;
//        }
//
//        int minimumCost = Integer.MAX_VALUE;
//
//        if (currentIndex + 1 < heights.length) {
//            minimumCost = Math.min(minimumCost, Math.abs(heights[currentIndex + 1] - heights[currentIndex]) +
//                    frogJumpHelper(currentIndex + 1, heights));
//        }
//
//        if (currentIndex + 2 < heights.length) {
//            minimumCost = Math.min(minimumCost, Math.abs(heights[currentIndex + 2] - heights[currentIndex]) +
//                    frogJumpHelper(currentIndex + 2, heights));
//
//        }
//
//        return minimumCost;
//    }
//
//    public static int frogJump(int n, int[] heights) {
//        return frogJumpHelper(0, heights);
//    }
}
