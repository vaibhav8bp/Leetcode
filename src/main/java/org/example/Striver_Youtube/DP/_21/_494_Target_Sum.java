package org.example.Striver_Youtube.DP._21;

import java.util.Arrays;

// https://leetcode.com/problems/target-sum/description/
public class _494_Target_Sum {

    private boolean isSumValid(int currentSum, int maxSum) {
        return (currentSum <= maxSum && currentSum >= -maxSum);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = Arrays.stream(nums).sum();

        if (target > totalSum || target < -totalSum) {
            return 0;
        }

        int[] previousDP = new int[2 * totalSum + 1];
        int[] currentDP = new int[2 * totalSum + 1];
        previousDP[target + totalSum] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = -totalSum; j <= totalSum; j++) {
                int plusWays = 0;
                int newSum = j + nums[i];
                if (isSumValid(newSum, totalSum)) {
                    plusWays = previousDP[j + nums[i] + totalSum];
                }
                int minusWays = 0;
                newSum = j - nums[i];
                if (isSumValid(newSum, totalSum)) {
                    minusWays = previousDP[j - nums[i] + totalSum];
                }
                currentDP[j + totalSum] = plusWays + minusWays;
            }
            previousDP = currentDP;
        }

        return previousDP[totalSum];
    }

//    private boolean isSumValid(int currentSum, int maxSum) {
//        return (currentSum <= maxSum && currentSum >= -maxSum);
//    }
//
//    public int findTargetSumWays(int[] nums, int target) {
//        int n = nums.length;
//        int totalSum = Arrays.stream(nums).sum();
//
//        if (target > totalSum || target < -totalSum) {
//            return 0;
//        }
//
//        int[][] dp = new int[n + 1][2 * totalSum + 1];
//        dp[n][target + totalSum] = 1;
//
//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = -totalSum; j <= totalSum; j++) {
//                int plusWays = 0;
//                int newSum = j + nums[i];
//                if (isSumValid(newSum, totalSum)) {
//                    plusWays = dp[i + 1][j + nums[i] + totalSum];
//                }
//                int minusWays = 0;
//                newSum = j - nums[i];
//                if (isSumValid(newSum, totalSum)) {
//                    minusWays = dp[i + 1][j - nums[i] + totalSum];
//                }
//                dp[i][j + totalSum] = plusWays + minusWays;
//            }
//        }
//
//        return dp[0][totalSum];
//    }

//    private int findTargetSumWays(int currentIndex, int currentSum, int totalSum, int target, int[] nums, int[][] dp) {
//        if (currentIndex == nums.length) {
//            if (currentSum == target) {
//                return 1;
//            } else {
//                return 0;
//            }
//        }
//
//        if (dp[currentIndex][currentSum + totalSum] != -1) {
//            return dp[currentIndex][currentSum + totalSum];
//        }
//
//        int plusWays = findTargetSumWays(currentIndex + 1, currentSum + nums[currentIndex], totalSum, target, nums, dp);
//        int minusWays = findTargetSumWays(currentIndex + 1, currentSum - nums[currentIndex], totalSum, target, nums, dp);
//
//        dp[currentIndex][currentSum + totalSum] = plusWays + minusWays;
//        return dp[currentIndex][currentSum + totalSum];
//    }
//
//    public int findTargetSumWays(int[] nums, int target) {
//        int n = nums.length;
//        int totalSum = Arrays.stream(nums).sum();
//
//        // Sum can be -ve too.
//        // Let's say sum can be -10 to 10.
//        // So total distinct sums can be 21 2*10+1
//        // And for accessing index we will do currentSum+totalSum
//        // So for -10 sum, index = -10+10 =0
//        // So for 10 sum, index = 10+10 = 20
//        int[][] dp = new int[n][2 * totalSum + 1];
//
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//
//        return findTargetSumWays(0, 0, totalSum, target, nums, dp);
//    }

//    private int findTargetSumWays(int currentIndex, int currentSum, int target, int[] nums) {
//        if (currentIndex == nums.length) {
//            if (currentSum == target) {
//                return 1;
//            } else {
//                return 0;
//            }
//        }
//
//        int plusWays = findTargetSumWays(currentIndex + 1, currentSum + nums[currentIndex], target, nums);
//        int minusWays = findTargetSumWays(currentIndex + 1, currentSum - nums[currentIndex], target, nums);
//
//        return plusWays + minusWays;
//    }
//
//    public int findTargetSumWays(int[] nums, int target) {
//        return findTargetSumWays(0, 0, target, nums);
//    }
}