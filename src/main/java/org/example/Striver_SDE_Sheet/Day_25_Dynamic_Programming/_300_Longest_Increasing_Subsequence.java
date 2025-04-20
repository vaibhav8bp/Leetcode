package org.example.Striver_SDE_Sheet.Day_25_Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/longest-increasing-subsequence/
public class _300_Longest_Increasing_Subsequence {

    private int smallestElementGreaterThanCurrentElementIndex(List<Integer> monotonicallyIncreasingArray, int currentNumber) {
        int low = 0;
        int high = monotonicallyIncreasingArray.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (monotonicallyIncreasingArray.get(mid) < currentNumber) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    // Binary Search Solution
    public int lengthOfLIS(int[] nums) {

        List<Integer> monotonicallyIncreasingArray = new ArrayList<>();

        for (Integer currentNumber : nums) {
            if (monotonicallyIncreasingArray.isEmpty() || monotonicallyIncreasingArray.getLast() < currentNumber) {
                monotonicallyIncreasingArray.add(currentNumber);
            } else {
                // 2 4 6
                // CurrentNumber is 5
                // It Does 2 4 5
                // So BS Function returns 2, we set 5 at index 2.
                monotonicallyIncreasingArray.set(smallestElementGreaterThanCurrentElementIndex(monotonicallyIncreasingArray, currentNumber), currentNumber);
            }
        }

        return monotonicallyIncreasingArray.size();
    }

//    public int lengthOfLIS(int[] nums) {
//        int[] dp = new int[nums.length + 1];
//
//        // Doing +1 for j column because, starting value is -1.
//        // In the end we are returning dp[0][0] which is dp[0][-1+1], here -1 is the previousIndex.
//
//        int[] previousDp = new int[nums.length + 1];
//        Arrays.fill(previousDp, 0);
//
//        for (int i = nums.length - 1; i >= 0; i--) {
//            for (int j = i - 1; j >= -1; j--) {
//                int notPick = previousDp[j + 1];
//                int pick = 0;
//
//                if (j == -1) {
//                    pick = 1 + previousDp[i + 1];
//                } else {
//                    if (nums[j] < nums[i]) {
//                        pick = 1 + previousDp[i + 1];
//                    }
//                }
//                dp[j + 1] = Math.max(pick, notPick);
//            }
//            previousDp = dp;
//        }
//
//        return previousDp[0];
//    }

//    public int lengthOfLIS(int[] nums) {
//        int[][] dp = new int[nums.length + 1][nums.length + 1];
//
//        // Doing +1 for j column because, starting value is -1.
//        // In the end we are returning dp[0][0] which is dp[0][-1+1], here -1 is the previousIndex.
//
//        for (int i = nums.length - 1; i >= 0; i--) {
//            for (int j = i - 1; j >= -1; j--) {
//                int notPick = dp[i + 1][j + 1];
//                int pick = 0;
//
//                if (j == -1) {
//                    pick = 1 + dp[i + 1][i + 1];
//                } else {
//                    if (nums[j] < nums[i]) {
//                        pick = 1 + dp[i + 1][i + 1];
//                    }
//                }
//
//                dp[i][j + 1] = Math.max(pick, notPick);
//            }
//        }
//
//        return dp[0][0];
//    }

//    private int lengthOfLISHelper(int[] nums, int currentIndex, int previousIndex, int[][] dp) {
//        if (currentIndex == nums.length) {
//            return 0;
//        }
//
//        if (dp[currentIndex][previousIndex + 1] != -1) {
//            return dp[currentIndex][previousIndex + 1];
//        }
//
//        int notPick = lengthOfLISHelper(nums, currentIndex + 1, previousIndex, dp);
//        int pick = 0;
//
//        // No Element has been picked so far
//        if (previousIndex == -1) {
//            pick = 1 + lengthOfLISHelper(nums, currentIndex + 1, currentIndex, dp);
//        } else {
//            if (nums[previousIndex] < nums[currentIndex]) {
//                pick = 1 + lengthOfLISHelper(nums, currentIndex + 1, currentIndex, dp);
//            }
//        }
//
//        dp[currentIndex][previousIndex + 1] = Math.max(pick, notPick);
//        return dp[currentIndex][previousIndex + 1];
//    }
//
//    public int lengthOfLIS(int[] nums) {
//        int[][] dp = new int[nums.length][nums.length + 1];
//        for (int i = 0; i < nums.length; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return lengthOfLISHelper(nums, 0, -1, dp);
//    }
}
