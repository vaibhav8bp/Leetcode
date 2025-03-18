package org.example.Daily._2025.February._26;

// https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/
public class _1749_Maximum_Absolute_Sum_of_Any_Subarray {

    public int maxAbsoluteSum(int[] nums) {
        int maxRunningSum = 0;
        int maxSumSoFar = Integer.MIN_VALUE;

        int minRunningSum = 0;
        int minSumSoFar = Integer.MAX_VALUE;

        for (int currentNumber : nums) {
            maxRunningSum += currentNumber;
            maxSumSoFar = Math.max(maxSumSoFar, maxRunningSum);

            if (maxRunningSum < 0) {
                maxRunningSum = 0;
            }

            minRunningSum += currentNumber;
            minSumSoFar = Math.min(minSumSoFar, minRunningSum);

            if (minRunningSum > 0) {
                minRunningSum = 0;
            }
        }

        return Math.max(maxSumSoFar, Math.abs(minSumSoFar));
    }

//    public int maxAbsoluteSum(int[] nums) {
//        int runningSum = 0;
//        int maxSumSoFar = Integer.MIN_VALUE;
//
//        for (int currentNumber : nums) {
//            runningSum += currentNumber;
//
//            maxSumSoFar = Math.max(maxSumSoFar, Math.abs(runningSum));
//
//            if (runningSum < 0) {
//                runningSum = 0;
//            }
//        }
//
//        nums = Arrays.stream(nums).map(x -> -x).toArray();
//
//        runningSum = 0;
//
//        for (int currentNumber : nums) {
//            runningSum += currentNumber;
//            maxSumSoFar = Math.max(maxSumSoFar, Math.abs(runningSum));
//
//            if (runningSum < 0) {
//                runningSum = 0;
//            }
//        }
//
//        return maxSumSoFar;
//    }
}
