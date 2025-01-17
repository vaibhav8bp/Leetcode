package org.example.Daily._2025.January._3;

// https://leetcode.com/problems/number-of-ways-to-split-array/description
public class _2270_Number_of_Ways_to_Split_Array {

    public int waysToSplitArray(int[] nums) {
        int totalSplitCount = 0;

        long totalSumCount = 0;

        for (int currentNumber : nums) {
            totalSumCount += currentNumber;
        }

        long leftSideSum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            leftSideSum += nums[i];
            long rightSideSum = totalSumCount - leftSideSum;
            if (leftSideSum >= rightSideSum) {
                totalSplitCount++;
            }
        }

        return totalSplitCount;
    }

//    public int waysToSplitArray(int[] nums) {
//        long[] suffixSum = new long[nums.length];
//        Arrays.fill(suffixSum, 0);
//
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (i == (nums.length - 1)) {
//                suffixSum[i] = nums[i];
//            } else {
//                suffixSum[i] = suffixSum[i + 1] + nums[i];
//            }
//        }
//
//        int totalSplitCount = 0;
//        long leftSideSum = 0;
//
//        for (int i = 0; i < nums.length - 1; i++) {
//            leftSideSum += nums[i];
//            long rightSideSum = suffixSum[i + 1];
//            if (leftSideSum >= rightSideSum) {
//                totalSplitCount++;
//            }
//        }
//
//        return totalSplitCount;
//    }

//    public int waysToSplitArray(int[] nums) {
//        int leftSideSum = 0;
//        int totalSplitCount = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            leftSideSum += nums[i];
//            int rightSideSum = 0;
//            for (int j = i + 1; j < nums.length; j++) {
//                rightSideSum += nums[j];
//            }
//            if (leftSideSum >= rightSideSum) {
//                totalSplitCount++;
//            }
//        }
//        return totalSplitCount;
//    }
}
