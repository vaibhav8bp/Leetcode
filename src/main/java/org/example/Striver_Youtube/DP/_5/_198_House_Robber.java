package org.example.Striver_Youtube.DP._5;

// https://leetcode.com/problems/house-robber/description/
public class _198_House_Robber {

    public int rob(int[] nums) {

        int last = 0;
        int secondLast = nums[nums.length - 1];
        int current = last + secondLast;

        for (int i = nums.length - 2; i >= 0; i--) {
            int lootCurrentHouse = nums[i];

            if (i + 2 <= nums.length) {
                lootCurrentHouse += last;
            }

            current = Math.max(lootCurrentHouse, secondLast);
            last = secondLast;
            secondLast = current;
        }

        return current;
    }

//    public int rob(int[] nums) {
//        int[] dp = new int[nums.length + 1];
//        dp[nums.length] = 0;
//
//        for (int i = nums.length - 1; i >= 0; i--) {
//            int lootCurrentHouse = nums[i];
//
//            if (i + 2 <= nums.length) {
//                lootCurrentHouse += dp[i + 2];
//            }
//
//            int excludeCurrentHouse = dp[i + 1];
//            dp[i] = Math.max(lootCurrentHouse, excludeCurrentHouse);
//        }
//
//        return dp[0];
//    }

//    private int rob(int currentIndex, int[] nums, int[] dp) {
//        if (currentIndex == nums.length) {
//            return 0;
//        }
//
//        if (dp[currentIndex] != -1) {
//            return dp[currentIndex];
//        }
//
//        int lootCurrentHouse = nums[currentIndex];
//
//        if (currentIndex + 2 <= nums.length) {
//            lootCurrentHouse += rob(currentIndex + 2, nums, dp);
//        }
//
//        int excludeCurrentHouse = rob(currentIndex + 1, nums, dp);
//
//        dp[currentIndex] = Math.max(lootCurrentHouse, excludeCurrentHouse);
//        return dp[currentIndex];
//    }
//
//    public int rob(int[] nums) {
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, -1);
//        return rob(0, nums, dp);
//    }

//    private int rob(int currentIndex, int[] nums) {
//        if (currentIndex == nums.length) {
//            return 0;
//        }
//
//        int lootCurrentHouse = nums[currentIndex];
//
//        if (currentIndex + 2 <= nums.length) {
//            lootCurrentHouse += rob(currentIndex + 2, nums);
//        }
//
//        int excludeCurrentHouse = rob(currentIndex + 1, nums);
//
//        return Math.max(lootCurrentHouse, excludeCurrentHouse);
//    }
//
//    public int rob(int[] nums) {
//        return rob(0, nums);
//    }
}
