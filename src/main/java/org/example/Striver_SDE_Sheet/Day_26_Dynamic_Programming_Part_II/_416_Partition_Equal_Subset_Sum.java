package org.example.Striver_SDE_Sheet.Day_26_Dynamic_Programming_Part_II;

// https://leetcode.com/problems/partition-equal-subset-sum/description/

import java.util.Arrays;

public class _416_Partition_Equal_Subset_Sum {

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
//        boolean[] dp = new boolean[targetSum + 1];
//        boolean[] previousDp = new boolean[targetSum + 1];
//
//        previousDp[targetSum] = true;
//        // Exclude targetSum index
//        for (int i = 0; i < targetSum; i++) {
//            previousDp[i] = false;
//        }
//
//        for (int i = nums.length - 1; i >= 0; i--) {
//            dp[targetSum] = true;
//            for (int j = targetSum - 1; j >= 0; j--) {
//                // Skip current element in Subset
//                boolean skipCurrentElement = previousDp[j];
//
//                if (skipCurrentElement) {
//                    dp[j] = true;
//                } else {
//                    if (j + nums[i] <= targetSum) {
//                        // put current element in subset
//                        dp[j] = previousDp[j + nums[i]];
//                    } else {
//                        dp[j] = false;
//                    }
//                }
//            }
//            System.arraycopy(dp, 0, previousDp, 0, targetSum + 1);
//        }
//
//        return previousDp[0];
//    }

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

//    private boolean canPartition(int currentIndex, int leftSubsetSum, int rightSubsetSum, int[] nums, Boolean[][][] dp) {
//        if (currentIndex == nums.length) {
//            return leftSubsetSum == rightSubsetSum;
//        }
//
//        if (dp[currentIndex][leftSubsetSum][rightSubsetSum] != null) {
//            return dp[currentIndex][leftSubsetSum][rightSubsetSum];
//        }
//
//        // Put current element in left subset
//        boolean putCurrentElementInLeftSubset = canPartition(currentIndex + 1, leftSubsetSum + nums[currentIndex], rightSubsetSum, nums, dp);
//
//        if (putCurrentElementInLeftSubset) {
//            dp[currentIndex][leftSubsetSum][rightSubsetSum] = true;
//            return true;
//        }
//
//        // put current element in right subset
//        dp[currentIndex][leftSubsetSum][rightSubsetSum] = canPartition(currentIndex + 1, leftSubsetSum, rightSubsetSum + nums[currentIndex], nums, dp);
//        return dp[currentIndex][leftSubsetSum][rightSubsetSum];
//    }
//
//    public boolean canPartition(int[] nums) {
//        int maxSum = Arrays.stream(nums).sum();
//        Boolean[][][] dp = new Boolean[nums.length][maxSum + 1][maxSum + 1];
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < maxSum + 1; j++) {
//                Arrays.fill(dp[i][j], null);
//            }
//        }
//
//        return canPartition(0, 0, 0, nums, dp);
//    }

//    private boolean canPartition(int currentIndex, int leftSubsetSum, int rightSubsetSum, int[] nums) {
//        if (currentIndex == nums.length) {
//            return leftSubsetSum == rightSubsetSum;
//        }
//
//        // Put current element in left subset
//        boolean putCurrentElementInLeftSubset = canPartition(currentIndex + 1, leftSubsetSum + nums[currentIndex], rightSubsetSum, nums);
//
//        // put current element in right subset
//        boolean putCurrentElementInRightSubset = canPartition(currentIndex + 1, leftSubsetSum, rightSubsetSum + nums[currentIndex], nums);
//
//        return (putCurrentElementInLeftSubset || putCurrentElementInRightSubset);
//    }
//
//    public boolean canPartition(int[] nums) {
//        return canPartition(0, 0, 0, nums);
//    }
}
