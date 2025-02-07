package org.example.Daily._2025.February._3;

// https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/
public class _3105_Longest_Strictly_Increasing_or_Strictly_Decreasing_Subarray {

    public int longestMonotonicSubarray(int[] nums) {

        // Taking 1 as we will start iterating from 1 index
        int maxIncreasingLength = 1;
        int minIncreasingLength = 1;

        int answer = 1;

        for (int i = 1; i < nums.length; i++) {
            // Increasing Subarray
            if (nums[i] > nums[i - 1]) {
                maxIncreasingLength++;
                minIncreasingLength = 1;
            }
            // Decreasing Subarray
            else if (nums[i] < nums[i - 1]) {
                minIncreasingLength++;
                maxIncreasingLength = 1;
            }
            // Equal Consecutive Elements
            else {
                maxIncreasingLength = 1;
                minIncreasingLength = 1;
            }

            answer = Math.max(answer, Math.max(maxIncreasingLength, minIncreasingLength));
        }

        return answer;
    }
}
