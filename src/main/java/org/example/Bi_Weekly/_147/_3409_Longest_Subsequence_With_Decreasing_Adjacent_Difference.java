package org.example.Bi_Weekly._147;

// https://leetcode.com/problems/longest-subsequence-with-decreasing-adjacent-difference/

import java.util.Arrays;

// TODO: Optimization Pending
public class _3409_Longest_Subsequence_With_Decreasing_Adjacent_Difference {

    private int longestSubsequenceHelper(int secondLastIndexTaken, int lastIndexTaken, int currentIndex, int[] nums, int[][][] dp) {
        if (currentIndex == nums.length) {
            return 0;
        }

        if (dp[secondLastIndexTaken + 1][lastIndexTaken + 1][currentIndex] != -1) {
            return dp[secondLastIndexTaken + 1][lastIndexTaken + 1][currentIndex];
        }

        // Check If CurrentIndex Cannot be or not.

        // Case 1. CurrentIndex Cannot Be Taken.
        // This will happen when one element is already taken into subsequence and
        // current and previous index's elements difference is greater than last difference.
        if (secondLastIndexTaken != -1 && lastIndexTaken != -1 && Math.abs(nums[currentIndex] - nums[lastIndexTaken]) > Math.abs(nums[lastIndexTaken] - nums[secondLastIndexTaken])) {
            dp[secondLastIndexTaken + 1][lastIndexTaken + 1][currentIndex] = longestSubsequenceHelper(secondLastIndexTaken, lastIndexTaken, currentIndex + 1, nums, dp);
            return dp[secondLastIndexTaken + 1][lastIndexTaken + 1][currentIndex];
        }

        // Case 2. CurrentIndex Can be taken.
        // 3 Cases -> No Number Taken Till Now, One Number Taken Till Now, More than one number taken till now.
        // Now there are 2 options again.
        // Pick Current Index Element or not

        int pickCurrentIndexElement = 1;
        int notPickCurrentIndexElement = longestSubsequenceHelper(secondLastIndexTaken, lastIndexTaken, currentIndex + 1, nums, dp);

        // No Number Taken Till Now
        if (secondLastIndexTaken == -1 && lastIndexTaken == -1) {
            pickCurrentIndexElement += longestSubsequenceHelper(-1, currentIndex, currentIndex + 1, nums, dp);
        }
        // One Number Taken Till Now
        if (secondLastIndexTaken == -1 && lastIndexTaken != -1) {
            pickCurrentIndexElement += longestSubsequenceHelper(lastIndexTaken, currentIndex, currentIndex + 1, nums, dp);
        }
        // More than one number taken till now
        if (secondLastIndexTaken != -1 && lastIndexTaken != -1 && Math.abs(nums[currentIndex] - nums[lastIndexTaken]) <= Math.abs(nums[lastIndexTaken] - nums[secondLastIndexTaken])) {
            pickCurrentIndexElement += longestSubsequenceHelper(lastIndexTaken, currentIndex, currentIndex + 1, nums, dp);
        }

        dp[secondLastIndexTaken + 1][lastIndexTaken + 1][currentIndex] = Math.max(pickCurrentIndexElement, notPickCurrentIndexElement);
        return dp[secondLastIndexTaken + 1][lastIndexTaken + 1][currentIndex];
    }

    public int longestSubsequence(int[] nums) {
        int[][][] dp = new int[nums.length + 1][nums.length + 1][nums.length];
        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }
        return longestSubsequenceHelper(-1, -1, 0, nums, dp);
    }

//    private int longestSubsequenceHelper(int secondLastIndexTaken, int lastIndexTaken, int currentIndex, int[] nums) {
//        if (currentIndex == nums.length) {
//            return 0;
//        }
//
//        // Check If CurrentIndex Cannot be or not.
//
//        // Case 1. CurrentIndex Cannot Be Taken.
//        // This will happen when one element is already taken into subsequence and
//        // current and previous index's elements difference is greater than last difference.
//        if (secondLastIndexTaken != -1 && lastIndexTaken != -1 && Math.abs(nums[currentIndex] - nums[lastIndexTaken]) > Math.abs(nums[lastIndexTaken] - nums[secondLastIndexTaken])) {
//            return longestSubsequenceHelper(secondLastIndexTaken, lastIndexTaken, currentIndex + 1, nums);
//        }
//
//        // Case 2. CurrentIndex Can be taken.
//        // 3 Cases -> No Number Taken Till Now, One Number Taken Till Now, More than one number taken till now.
//        // Now there are 2 options again.
//        // Pick Current Index Element or not
//
//        int pickCurrentIndexElement = 1;
//        int notPickCurrentIndexElement = longestSubsequenceHelper(secondLastIndexTaken, lastIndexTaken, currentIndex + 1, nums);
//
//        // No Number Taken Till Now
//        if (secondLastIndexTaken == -1 && lastIndexTaken == -1) {
//            pickCurrentIndexElement += longestSubsequenceHelper(-1, currentIndex, currentIndex + 1, nums);
//        }
//        // One Number Taken Till Now
//        if (secondLastIndexTaken == -1 && lastIndexTaken != -1) {
//            pickCurrentIndexElement += longestSubsequenceHelper(lastIndexTaken, currentIndex, currentIndex + 1, nums);
//        }
//        // More than one number taken till now
//        if (secondLastIndexTaken != -1 && lastIndexTaken != -1 && Math.abs(nums[currentIndex] - nums[lastIndexTaken]) <= Math.abs(nums[lastIndexTaken] - nums[secondLastIndexTaken])) {
//            pickCurrentIndexElement += longestSubsequenceHelper(lastIndexTaken, currentIndex, currentIndex + 1, nums);
//        }
//        return Math.max(pickCurrentIndexElement, notPickCurrentIndexElement);
//    }
//
//    public int longestSubsequence(int[] nums) {
//        return longestSubsequenceHelper(-1, -1, 0, nums);
//    }
}