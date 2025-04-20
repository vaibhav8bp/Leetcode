package org.example.Daily._2025.April._7;

import java.util.Arrays;

// https://leetcode.com/problems/partition-equal-subset-sum/description/
public class _416_Partition_Equal_Subset_Sum {

    public boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();

        if (totalSum % 2 != 0) {
            return false;
        }

        int targetSum = totalSum / 2;

        boolean[] previousDP = new boolean[targetSum + 1];

        Arrays.fill(previousDP, false);
        previousDP[targetSum] = true;

        for (int i = nums.length - 1; i >= 0; i--) {
            boolean[] currentDP = new boolean[targetSum + 1];
            for (int j = targetSum; j >= 0; j--) {
                // Exclude
                boolean excludeCurrentElement = previousDP[j];

                // Include
                boolean includeCurrentElement = false;

                if (j + nums[i] <= targetSum) {
                    includeCurrentElement = previousDP[j + nums[i]];
                }

                currentDP[j] = includeCurrentElement || excludeCurrentElement;
            }
            previousDP = currentDP;
        }

        return previousDP[0];
    }

//    public boolean canPartition(int[] nums) {
//        int totalSum = Arrays.stream(nums).sum();
//
//        if (totalSum % 2 != 0) {
//            return false;
//        }
//
//        int targetSum = totalSum / 2;
//
//        boolean[][] dp = new boolean[nums.length + 1][(totalSum / 2) + 1];
//
//        Arrays.fill(dp[nums.length], false);
//        dp[nums.length][targetSum] = true;
//
//        for (int i = nums.length - 1; i >= 0; i--) {
//            for (int j = targetSum; j >= 0; j--) {
//                // Exclude
//                boolean excludeCurrentElement = dp[i + 1][j];
//
//                // Include
//                boolean includeCurrentElement = false;
//
//                if (j + nums[i] <= targetSum) {
//                    includeCurrentElement = dp[i + 1][j + nums[i]];
//                }
//
//                dp[i][j] = includeCurrentElement || excludeCurrentElement;
//            }
//        }
//
//        return dp[0][0];
//    }

//    private boolean canPartition(int currentIndex, int currentSum, int targetSum, int[] nums, Boolean[][] dp) {
//        if (currentIndex == nums.length) {
//            return currentSum == targetSum;
//        }
//
//        if (dp[currentIndex][currentSum] != null) {
//            return dp[currentIndex][currentSum];
//        }
//
//        // Exclude
//        boolean excludeCurrentElement = canPartition(currentIndex + 1, currentSum, targetSum, nums, dp);
//
//        // Include
//        boolean includeCurrentElement = false;
//
//        if (currentSum + nums[currentIndex] <= targetSum) {
//            includeCurrentElement = canPartition(currentIndex + 1, currentSum + nums[currentIndex], targetSum, nums, dp);
//        }
//
//        dp[currentIndex][currentSum] = includeCurrentElement || excludeCurrentElement;
//        return dp[currentIndex][currentSum];
//    }
//
//
//    public boolean canPartition(int[] nums) {
//        int totalSum = Arrays.stream(nums).sum();
//
//        if (totalSum % 2 != 0) {
//            return false;
//        }
//
//        Boolean[][] dp = new Boolean[nums.length][(totalSum / 2) + 1];
//
//        return canPartition(0, 0, totalSum / 2, nums, dp);
//    }

//    private boolean canPartition(int currentIndex, int currentSum, int targetSum, int[] nums) {
//        if (currentIndex == nums.length) {
//            return currentSum == targetSum;
//        }
//
//        // Exclude
//        boolean excludeCurrentElement = canPartition(currentIndex + 1, currentSum, targetSum, nums);
//
//        // Include
//        boolean includeCurrentElement = false;
//
//        if (currentSum + nums[currentIndex] <= targetSum) {
//            includeCurrentElement = canPartition(currentIndex + 1, currentSum + nums[currentIndex], targetSum, nums);
//        }
//
//        return includeCurrentElement || excludeCurrentElement;
//    }
//
//
//    public boolean canPartition(int[] nums) {
//        int totalSum = Arrays.stream(nums).sum();
//
//        if (totalSum % 2 != 0) {
//            return false;
//        }
//
//        return canPartition(0, 0, totalSum / 2, nums);
//    }
}
