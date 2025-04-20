package org.example.Daily._2025.April._6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/largest-divisible-subset/description/
public class _368_Largest_Divisible_Subset {

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        // dp[j] specifies max length starting ending at j.

        int maxLength = 1;
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[j] % nums[i]) == 0) {

                    if (dp[j] <= dp[i]) {
                        dp[j] = dp[i] + 1;
                    }

                    if (dp[j] > maxLength) {
                        maxLength = dp[j];
                        maxIndex = j;
                    }
                }
            }
        }

        List<Integer> answer = new ArrayList<>();

        int maxNumber = nums[maxIndex];
        answer.add(maxNumber);
        maxLength--;

        for (int i = maxIndex - 1; i >= 0 && maxLength != 0; i--) {
            if ((maxNumber % nums[i] == 0) && (dp[i] == maxLength)) {
                maxNumber = nums[i];
                answer.add(maxNumber);
                maxLength--;
            }
        }

        return answer;
    }

//    public static List<Integer> largestDivisibleSubset(int[] nums) {
//        Arrays.sort(nums);
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, 1);
//        int[] parent = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            parent[i] = i;
//        }
//
//        // dp[j] specifies max length starting ending at j.
//
//        int maxLength = 1;
//        int maxIndex = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if ((nums[j] % nums[i]) == 0) {
//
//                    if (dp[j] <= dp[i]) {
//                        dp[j] = dp[i] + 1;
//                        parent[j] = i;
//                    }
//
//                    if (dp[j] > maxLength) {
//                        maxLength = dp[j];
//                        maxIndex = j;
//                    }
//                }
//            }
//        }
//
//        List<Integer> answer = new ArrayList<>();
//
//        while (parent[maxIndex] != maxIndex) {
//            answer.add(nums[maxIndex]);
//            maxIndex = parent[maxIndex];
//        }
//
//        answer.add(nums[maxIndex]);
//        return answer;
//    }

//    private List<Integer> largestDivisibleSubset(int currentIndex, int previousIndex, int[] nums, List<Integer>[][] dp) {
//        if (currentIndex == nums.length) {
//            return new ArrayList<>();
//        }
//
//        if (dp[currentIndex][previousIndex + 1] != null) {
//            return dp[currentIndex][previousIndex + 1];
//        }
//
//        // Exclude
//        List<Integer> exclude = largestDivisibleSubset(currentIndex + 1, previousIndex, nums, dp);
//
//        List<Integer> include = new ArrayList<>();
//        // Include
//        if (previousIndex == -1 || ((nums[currentIndex] % nums[previousIndex]) == 0)) {
//            include.add(nums[currentIndex]);
//            include.addAll(largestDivisibleSubset(currentIndex + 1, currentIndex, nums, dp));
//        }
//
//        if (include.size() < exclude.size()) {
//            dp[currentIndex][previousIndex + 1] = exclude;
//        }
//        else{
//            dp[currentIndex][previousIndex + 1] = include;
//        }
//
//        return dp[currentIndex][previousIndex + 1];
//    }
//
//    public List<Integer> largestDivisibleSubset(int[] nums) {
//        Arrays.sort(nums);
//        List<Integer>[][] dp = new ArrayList[nums.length + 1][nums.length + 1];
//        return largestDivisibleSubset(0, -1, nums, dp);
//    }

    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 4, 8}));
    }
}
