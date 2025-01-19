package org.example.Bi_Weekly._148;

// https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/
public class _3423_Maximum_Difference_Between_Adjacent_Elements_in_a_Circular_Array {
    public int maxAdjacentDistance(int[] nums) {
        int maxDifference = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                maxDifference = Math.max(maxDifference, Math.abs(nums[i] - nums[0]));
            } else {
                maxDifference = Math.max(maxDifference, Math.abs(nums[i] - nums[i + 1]));
            }
        }

        return maxDifference;
    }
}
