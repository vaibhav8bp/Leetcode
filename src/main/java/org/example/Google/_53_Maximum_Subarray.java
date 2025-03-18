package org.example.Google;

// https://leetcode.com/problems/maximum-subarray/
public class _53_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int runningSum = 0;
        int maximumSum = Integer.MIN_VALUE;

        for (int currentNumber : nums) {
            runningSum += currentNumber;
            maximumSum = Math.max(maximumSum, runningSum);
            if (runningSum < 0) {
                runningSum = 0;
            }
        }

        return maximumSum;
    }
}
