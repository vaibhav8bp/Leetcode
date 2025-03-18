package org.example.Bi_Weekly._151;

public class _3469_Find_Minimum_Cost_to_Remove_Array_Elements {

    public int minCost(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] initialDp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            initialDp[i] = nums[i];
        }

        int[] secondDp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            secondDp[i] = Math.max(nums[i], nums[nums.length - 1]);
        }

        int[] dp = new int[nums.length];

        for (int i = nums.length - 3; i >= 0; i--) {
            for (int j = nums.length - 1; j >= 0; j--) {
                int first = nums[j];
                int second = nums[i + 1];
                int third = nums[i + 2];

                // Retain First.
                int retainFirst = Math.max(second, third) + initialDp[j];

                // Retain Second.
                int retainSecond = Math.max(first, third) + initialDp[i + 1];

                // Retain Third
                int retainThird = Math.max(first, second) + initialDp[i + 2];

                dp[j] = Math.min(retainFirst, Math.min(retainSecond, retainThird));
            }

            for (int k = 0; k < nums.length; k++) {
                initialDp[k] = secondDp[k];
                secondDp[k] = dp[k];
            }
        }

        return dp[0];
    }

//    public int minCost(int[] nums) {
//
//        if (nums.length == 1) {
//            return nums[0];
//        } else if (nums.length == 2) {
//            return Math.max(nums[0], nums[1]);
//        }
//
//        int[][] dp = new int[nums.length][nums.length];
//
//        for (int i = 0; i < nums.length; i++) {
//            dp[nums.length - 1][i] = nums[i];
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            dp[nums.length - 2][i] = Math.max(nums[i], nums[nums.length - 1]);
//        }
//
//        for (int i = nums.length - 3; i >= 0; i--) {
//            for (int j = nums.length - 1; j >= 0; j--) {
//                int first = nums[j];
//                int second = nums[i + 1];
//                int third = nums[i + 2];
//
//                // Retain First.
//                int retainFirst = Math.max(second, third) + dp[i + 2][j];
//
//                // Retain Second.
//                int retainSecond = Math.max(first, third) + dp[i + 2][i + 1];
//
//                // Retain Third
//                int retainThird = Math.max(first, second) + dp[i + 2][i + 2];
//
//                dp[i][j] = Math.min(retainFirst, Math.min(retainSecond, retainThird));
//            }
//        }
//
//        return dp[0][0];
//    }


    // Memoization
//    private static int minCost(int[] nums, int currentIndex, int indexToBePlacedAtCurrentIndex, int[][] dp) {
//
//        if (currentIndex == nums.length) {
//            return 0;
//        } else if (currentIndex == (nums.length - 1)) {
//            return nums[indexToBePlacedAtCurrentIndex];
//        } else if (currentIndex == (nums.length - 2)) {
//            return Math.max(nums[indexToBePlacedAtCurrentIndex], nums[currentIndex + 1]);
//        }
//
//        if (dp[currentIndex][indexToBePlacedAtCurrentIndex] != -1) {
//            return dp[currentIndex][indexToBePlacedAtCurrentIndex];
//        }
//
//        int first = nums[indexToBePlacedAtCurrentIndex];
//        int second = nums[currentIndex + 1];
//        int third = nums[currentIndex + 2];
//
//        // Retain First.
//        int retainFirst = Math.max(second, third) + minCost(nums, currentIndex + 2, indexToBePlacedAtCurrentIndex, dp);
//
//        // Retain Second.
//        int retainSecond = Math.max(first, third) + minCost(nums, currentIndex + 2, currentIndex + 1, dp);
//
//        // Retain Third
//        int retainThird = Math.max(first, second) + minCost(nums, currentIndex + 2, currentIndex + 2, dp);
//
//        dp[currentIndex][indexToBePlacedAtCurrentIndex] = Math.min(retainFirst, Math.min(retainSecond, retainThird));
//        return dp[currentIndex][indexToBePlacedAtCurrentIndex];
//    }
//
//    public static int minCost(int[] nums) {
//        int[][] dp = new int[nums.length][nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return minCost(nums, 0, 0, dp);
//    }
}
