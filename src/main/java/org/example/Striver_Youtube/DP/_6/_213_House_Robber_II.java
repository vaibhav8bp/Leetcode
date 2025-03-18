package org.example.Striver_Youtube.DP._6;


// https://leetcode.com/problems/house-robber-ii/description/
public class _213_House_Robber_II {

    // We can also think like since 0 and n-1 can't be picked together.
    // We will either pick 0 and go till n-2 or go from 1 to n-1.
    // Return the max of these too.
    // Edge case will be 1 length array.

    // Simple House Robber - 1 Problem
    // start will be startindex and end will length (exclusive)
    public int rob(int start, int end, int[] nums) {
        int last = 0;
        int secondLast = nums[end - 1];
        int current = last + secondLast;

        for (int i = end - 2; i >= start; i--) {
            int lootCurrentHouse = nums[i];

            if (i + 2 <= end) {
                lootCurrentHouse += last;
            }

            current = Math.max(lootCurrentHouse, secondLast);
            last = secondLast;
            secondLast = current;
        }

        return current;
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(0, nums.length - 1, nums), rob(1, nums.length, nums));
    }

//    public static int rob(int[] nums) {
//        int[][] dp = new int[nums.length + 1][2];
//
//        dp[nums.length][0] = 0;
//        dp[nums.length][1] = 0;
//
//        dp[nums.length - 1][0] = nums[nums.length - 1];
//        dp[nums.length - 1][1] = 0;
//
//        for (int i = nums.length - 2; i >= 0; i--) {
//            for (int j = 0; j < 2; j++) {
//
//                int lootCurrentHouse;
//
//                if (i == 0) {
//                    lootCurrentHouse = nums[i] + dp[i + 2][1];
//                } else {
//                    lootCurrentHouse = nums[i] + dp[i + 2][j];
//                }
//
//                int excludeCurrentHouse = dp[i + 1][j];
//                dp[i][j] = Math.max(lootCurrentHouse, excludeCurrentHouse);
//            }
//        }
//
//        return dp[0][0];
//    }

//    private static int rob(int currentIndex, boolean isFirstHouseRobbed, int[] nums, int[][] dp) {
//        if (currentIndex == nums.length) {
//            return 0;
//        } else if (currentIndex == nums.length - 1) {
//            // Cannot loot this house.
//            if (isFirstHouseRobbed) {
//                return 0;
//            } else {
//                return nums[currentIndex];
//            }
//        }
//
//        int currentAction = (isFirstHouseRobbed) ? 1 : 0;
//
//        if (dp[currentIndex][currentAction] != -1) {
//            return dp[currentIndex][currentAction];
//        }
//
//        int lootCurrentHouse;
//
//        if (currentIndex == 0) {
//            lootCurrentHouse = nums[currentIndex] + rob(currentIndex + 2, true, nums, dp);
//        } else {
//            lootCurrentHouse = nums[currentIndex] + rob(currentIndex + 2, isFirstHouseRobbed, nums, dp);
//        }
//
//        int excludeCurrentHouse = rob(currentIndex + 1, isFirstHouseRobbed, nums, dp);
//
//        dp[currentIndex][currentAction] = Math.max(lootCurrentHouse, excludeCurrentHouse);
//        return dp[currentIndex][currentAction];
//    }
//
//    public static int rob(int[] nums) {
//        int[][] dp = new int[nums.length][2];
//
//        // 0 for false, 1 for true
//        for (int i = 0; i < nums.length; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return rob(0, false, nums, dp);
//    }

//    private static int rob(int currentIndex, boolean isFirstHouseRobbed, int[] nums) {
//        if (currentIndex == nums.length) {
//            return 0;
//        } else if (currentIndex == nums.length - 1) {
//            // Cannot loot this house.
//            if (isFirstHouseRobbed) {
//                return 0;
//            } else {
//                return nums[currentIndex];
//            }
//        }
//
//        int lootCurrentHouse;
//
//        if (currentIndex == 0) {
//            lootCurrentHouse = nums[currentIndex] + rob(currentIndex + 2, true, nums);
//        } else {
//            lootCurrentHouse = nums[currentIndex] + rob(currentIndex + 2, isFirstHouseRobbed, nums);
//        }
//
//        int excludeCurrentHouse = rob(currentIndex + 1, isFirstHouseRobbed, nums);
//
//        return Math.max(lootCurrentHouse, excludeCurrentHouse);
//    }
//
//    public static int rob(int[] nums) {
//        return rob(0, false, nums);
//    }
}
