package org.example.Striver_Youtube.DP._15;

import java.util.Arrays;

// https://leetcode.com/problems/partition-equal-subset-sum/description/
public class _416_Partition_Equal_Subset_Sum {

    // Optimized DP
    public boolean canPartition(int[] nums) {

        int maxSum = Arrays.stream(nums).sum();

        if (maxSum % 2 != 0) {
            return false;
        }

        int targetSum = maxSum / 2;

        boolean[] previousDp = new boolean[targetSum + 1];

        previousDp[targetSum] = true;
        // Exclude targetSum index
        for (int i = 0; i < targetSum; i++) {
            previousDp[i] = false;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            boolean[] dp = new boolean[targetSum + 1];
            dp[targetSum] = true;
            for (int j = targetSum - 1; j >= 0; j--) {
                // Skip current element in Subset
                boolean skipCurrentElement = previousDp[j];

                if (skipCurrentElement) {
                    dp[j] = true;
                } else {
                    if (j + nums[i] <= targetSum) {
                        // put current element in subset
                        dp[j] = previousDp[j + nums[i]];
                    } else {
                        dp[j] = false;
                    }
                }
            }
            previousDp = dp;
        }

        return previousDp[0];
    }

    // DP
//    public boolean canPartition(int[] nums) {
//
//        int maxSum = Arrays.stream(nums).sum();
//
//        if (maxSum % 2 != 0) {
//            return false;
//        }
//
//        int targetSum = maxSum / 2;
//
//        boolean[][] dp = new boolean[nums.length + 1][targetSum + 1];
//
//        for (int i = 0; i < nums.length + 1; i++) {
//            dp[i][targetSum] = true;
//        }
//
//        // Exclude targetSum index
//        for (int i = 0; i < targetSum; i++) {
//            dp[nums.length][i] = false;
//        }
//
//        for (int i = nums.length - 1; i >= 0; i--) {
//            for (int j = targetSum - 1; j >= 0; j--) {
//                // Skip current element in Subset
//                boolean skipCurrentElement = dp[i + 1][j];
//
//                if (skipCurrentElement) {
//                    dp[i][j] = true;
//                } else {
//                    if (j + nums[i] <= targetSum) {
//                        // put current element in subset
//                        dp[i][j] = dp[i + 1][j + nums[i]];
//                    } else {
//                        dp[i][j] = false;
//                    }
//                }
//            }
//        }
//
//        return dp[0][0];
//    }

    // Memoization
//    private boolean canPartition(int currentIndex, int subsetSum, int targetSum, int[] nums, Boolean[][] dp) {
//
//        if (subsetSum == targetSum) {
//            return true;
//        }
//
//        if (currentIndex == nums.length) {
//            return false;
//        }
//
//        if (dp[currentIndex][subsetSum] != null) {
//            return dp[currentIndex][subsetSum];
//        }
//
//        // Skip current element in Subset
//        boolean skipCurrentElement = canPartition(currentIndex + 1, subsetSum, targetSum, nums, dp);
//
//        if (skipCurrentElement) {
//            dp[currentIndex][subsetSum] = true;
//            return true;
//        }
//
//        if (subsetSum + nums[currentIndex] <= targetSum) {
//            // put current element in subset
//            dp[currentIndex][subsetSum] = canPartition(currentIndex + 1, subsetSum + nums[currentIndex], targetSum, nums, dp);
//        } else {
//            dp[currentIndex][subsetSum] = false;
//        }
//
//        return dp[currentIndex][subsetSum];
//    }
//
//    public boolean canPartition(int[] nums) {
//
//        int maxSum = Arrays.stream(nums).sum();
//
//        if (maxSum % 2 != 0) {
//            return false;
//        }
//
//        int targetSum = maxSum / 2;
//
//        Boolean[][] dp = new Boolean[nums.length][targetSum];
//
//        return canPartition(0, 0, targetSum, nums, dp);
//    }

    // Recursion
//    private boolean canPartition(int currentIndex, int subsetSum, int targetSum, int[] nums) {
//        if (currentIndex == nums.length) {
//            return subsetSum == targetSum;
//        }
//
//        // Skip current element in Subset
//        boolean skipCurrentElement = canPartition(currentIndex + 1, subsetSum, targetSum, nums);
//
//        if (skipCurrentElement) {
//            return true;
//        }
//
//        if (subsetSum + nums[currentIndex] <= targetSum) {
//            // put current element in subset
//            return canPartition(currentIndex + 1, subsetSum + nums[currentIndex], targetSum, nums);
//        }
//        else{
//            return false;
//        }
//    }
//
//    public boolean canPartition(int[] nums) {
//
//        int maxSum = Arrays.stream(nums).sum();
//
//        if (maxSum % 2 != 0) {
//            return false;
//        }
//
//        return canPartition(0, 0, maxSum / 2, nums);
//    }
}
