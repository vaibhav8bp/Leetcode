package org.example.Daily._2025.March._15;

import java.util.Arrays;

// https://leetcode.com/problems/house-robber-iv/description/
public class _2560_House_Robber_IV {

    // No need to ever loot more than k houses as we have to minimize the maximum loot
    // eg 2 5 9 4 ..........
    // k=2
    // After taking 2 and 9 can we ever minimize the max. no. 9 ?
    // No, so no need of looting more than k houses.

    // Goal is to check whether we can achieve atleast k houses with capability<= capability, that is max of picks<=capability
    // Always beneficial to start early, as we have to loot k houses.
    // So just greedily pick those house with loot<=capability and if picking skip adjacent house.

    private boolean canCurrentLootBeCollectedFromAtLeastKHouses(int capability, int k, int[] nums) {
        int houses = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= capability) {
                houses++;
                if (houses == k) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public int minCapability(int[] nums, int k) {

        int low = Arrays.stream(nums).min().getAsInt();
        int high = Arrays.stream(nums).max().getAsInt();

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canCurrentLootBeCollectedFromAtLeastKHouses(mid, k, nums)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

//    public static int minCapability(int[] nums, int k) {
//        int[][] dp = new int[nums.length + 2][k + 1];
//
//        Arrays.fill(dp[nums.length + 1], Integer.MAX_VALUE);
//        Arrays.fill(dp[nums.length], Integer.MAX_VALUE);
//
//        for (int i = 0; i < nums.length + 2; i++) {
//            dp[i][k] = 0;
//        }
//
//        for (int i = nums.length - 1; i >= 0; i--) {
//            for (int j = k - 1; j >= 0; j--) {
//                int lootCurrentHouse = Math.max(nums[i], dp[i + 2][j + 1]);
//                int includeCurrentHouse = dp[i + 1][j];
//                dp[i][j] = Math.min(lootCurrentHouse, includeCurrentHouse);
//            }
//        }
//
//        return dp[0][0];
//    }

//    private static int minCapability(int currentIndex, int housesLooted, int k, int[] nums, int[][] dp) {
//
//        if (housesLooted == k) {
//            return 0;
//        }
//
//        if (currentIndex >= nums.length) {
//            return Integer.MAX_VALUE;
//        }
//
//        if (dp[currentIndex][housesLooted] != -1) {
//            return dp[currentIndex][housesLooted];
//        }
//
//        int lootCurrentHouse = Math.max(nums[currentIndex], minCapability(currentIndex + 2, housesLooted + 1, k, nums, dp));
//        int includeCurrentHouse = minCapability(currentIndex + 1, housesLooted, k, nums, dp);
//
//        dp[currentIndex][housesLooted] = Math.min(lootCurrentHouse, includeCurrentHouse);
//        return dp[currentIndex][housesLooted];
//    }
//
//    public static int minCapability(int[] nums, int k) {
//        int[][] dp = new int[nums.length][k];
//        for (int i = 0; i < nums.length; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return minCapability(0, 0, k, nums, dp);
//    }
}
