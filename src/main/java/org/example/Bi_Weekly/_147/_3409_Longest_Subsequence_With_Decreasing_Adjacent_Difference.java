package org.example.Bi_Weekly._147;

// https://leetcode.com/problems/longest-subsequence-with-decreasing-adjacent-difference/
public class _3409_Longest_Subsequence_With_Decreasing_Adjacent_Difference {

     private final int LARGEST_VALUE_POSSIBLE = 300;

     public int longestSubsequence(int[] nums) {

         // dp[i][j] represents the longest subsequence that ends with value i (not index i) and a difference j
         // between consecutive elements.

         int[][] dp = new int[LARGEST_VALUE_POSSIBLE + 1][LARGEST_VALUE_POSSIBLE];

         for (int i = 0; i < LARGEST_VALUE_POSSIBLE; i++) {
             dp[nums[0]][i] = 1;
         }

         int maxSubsequence = 1;

         for (int i = 1; i < nums.length; i++) {

             int currentElement = nums[i];

             for (int currentDifference = 0; currentDifference < LARGEST_VALUE_POSSIBLE; currentDifference++) {
                 int current = 0;
                 // Check If Subsequence Can be Formed or not
                 if (currentElement - currentDifference > 0) {
                     current = Math.max(current, dp[currentElement - currentDifference][currentDifference] + 1);
                 }
                 if (currentElement + currentDifference <= LARGEST_VALUE_POSSIBLE) {
                     current = Math.max(current, dp[currentElement + currentDifference][currentDifference] + 1);
                 }
                 dp[currentElement][currentDifference] = Math.max(dp[currentElement][currentDifference], current);
             }

             // This loop ensures that the subsequence length for smaller absolute differences (j) is at-least
             // as long as the length for larger absolute differences (j+1).

             // 150 100 50
             // If dp[50][50] = x
             // We can surely say if difference between consecutive elements is reduced, subsequence length will only go up.
             // Think of it like this way, if there are more difference no. of element picked will be always be
             // less than or equal to if difference is less.

             for (int j = LARGEST_VALUE_POSSIBLE - 2; j >= 0; j--) {
                 dp[currentElement][j] = Math.max(dp[currentElement][j], dp[currentElement][j + 1]);
             }

             maxSubsequence = Math.max(maxSubsequence, dp[currentElement][0]);
         }

         return maxSubsequence;
     }

    // Memoization
//   private int longestSubsequenceHelper(int secondLastIndexTaken, int lastIndexTaken, int currentIndex, int[] nums, int[][][] dp) {
//       if (currentIndex == nums.length) {
//           return 0;
//       }
//
//       if (dp[secondLastIndexTaken + 1][lastIndexTaken + 1][currentIndex] != -1) {
//           return dp[secondLastIndexTaken + 1][lastIndexTaken + 1][currentIndex];
//       }
//
//       // Check If CurrentIndex Cannot be or not.
//
//       // Case 1. CurrentIndex Cannot Be Taken.
//       // This will happen when two elements are already taken into subsequence and
//       // current and previous index's elements difference is greater than last difference.
//       if (secondLastIndexTaken != -1 && lastIndexTaken != -1 && Math.abs(nums[currentIndex] - nums[lastIndexTaken]) > Math.abs(nums[lastIndexTaken] - nums[secondLastIndexTaken])) {
//           dp[secondLastIndexTaken + 1][lastIndexTaken + 1][currentIndex] = longestSubsequenceHelper(secondLastIndexTaken, lastIndexTaken, currentIndex + 1, nums, dp);
//           return dp[secondLastIndexTaken + 1][lastIndexTaken + 1][currentIndex];
//       }
//
//       // Case 2. CurrentIndex Can be taken.
//       // 3 Cases -> No Number Taken Till Now, One Number Taken Till Now, More than one number taken till now.
//       // Now there are 2 options again.
//       // Pick Current Index Element or not
//
//       int pickCurrentIndexElement = 1;
//       int notPickCurrentIndexElement = longestSubsequenceHelper(secondLastIndexTaken, lastIndexTaken, currentIndex + 1, nums, dp);
//
//       // No Number Taken Till Now
//       if (secondLastIndexTaken == -1 && lastIndexTaken == -1) {
//           pickCurrentIndexElement += longestSubsequenceHelper(-1, currentIndex, currentIndex + 1, nums, dp);
//       }
//       // One Number Taken Till Now
//       if (secondLastIndexTaken == -1 && lastIndexTaken != -1) {
//           pickCurrentIndexElement += longestSubsequenceHelper(lastIndexTaken, currentIndex, currentIndex + 1, nums, dp);
//       }
//       // More than one number taken till now
//       if (secondLastIndexTaken != -1 && lastIndexTaken != -1 && Math.abs(nums[currentIndex] - nums[lastIndexTaken]) <= Math.abs(nums[lastIndexTaken] - nums[secondLastIndexTaken])) {
//           pickCurrentIndexElement += longestSubsequenceHelper(lastIndexTaken, currentIndex, currentIndex + 1, nums, dp);
//       }
//
//       dp[secondLastIndexTaken + 1][lastIndexTaken + 1][currentIndex] = Math.max(pickCurrentIndexElement, notPickCurrentIndexElement);
//       return dp[secondLastIndexTaken + 1][lastIndexTaken + 1][currentIndex];
//   }
//
//   public int longestSubsequence(int[] nums) {
//       int[][][] dp = new int[nums.length + 1][nums.length + 1][nums.length];
//       for (int[][] ints : dp) {
//           for (int[] anInt : ints) {
//               Arrays.fill(anInt, -1);
//           }
//       }
//       return longestSubsequenceHelper(-1, -1, 0, nums, dp);
//   }

    // Recursion
//    private int longestSubsequenceHelper(int secondLastIndexTaken, int lastIndexTaken, int currentIndex, int[] nums) {
//        if (currentIndex == nums.length) {
//            return 0;
//        }
//
//        // Check If CurrentIndex Cannot be or not.
//
//        // Case 1. CurrentIndex Cannot Be Taken.
//        // This will happen when two elements are already taken into subsequence and
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