package org.example.Bi_Weekly._147;

// TODO: Optimization Pending
// https://leetcode.com/problems/maximize-subarray-sum-after-removing-all-occurrences-of-one-element/

import java.util.HashMap;
import java.util.Map;

public class _3410_Maximize_Subarray_Sum_After_Removing_All_Occurrences_of_One_Element {

    // Kadane's Algorithm Solution
    // Apply Kadane Algorithm by removing every -ve element and computing max subarray sum.
    // Return max of all.

//    private long maxSubarraySumHelper(int[] nums, int elementToBeExcluded) {
//        int sumSoFar = 0;
//        int maxSumSoFar = Integer.MIN_VALUE;
//
//        for (Integer currentElement : nums) {
//            if (currentElement == elementToBeExcluded) {
//                continue;
//            }
//
//            sumSoFar += currentElement;
//            maxSumSoFar = Math.max(maxSumSoFar, sumSoFar);
//
//            if (sumSoFar < 0) {
//                sumSoFar = 0;
//            }
//        }
//
//        return maxSumSoFar;
//    }
//
//    public long maxSubarraySum(int[] nums) {
//
//        Map<Integer, Integer> numberExistsMapper = new HashMap<>();
//
//        for (Integer currentNumber : nums) {
//            numberExistsMapper.put(currentNumber, numberExistsMapper.getOrDefault(currentNumber, 0) + 1);
//
//            // If all elements are same, if -ve return number, if positive return number*arrayLength;
//            if (numberExistsMapper.get(currentNumber) == nums.length) {
//                if (currentNumber <= 0) {
//                    return currentNumber;
//                } else {
//                    return (long) currentNumber * nums.length;
//                }
//            }
//        }
//
//        // Whole Subarray can be max. too, in case of whole array having positive elements.
//        // It is not necessary to remove any element. In question, it is mentioned at-most once, not exactly once.
//        long answer = Arrays.stream(nums).sum();
//
//        for (Integer currentNumber : numberExistsMapper.keySet()) {
//            // Only remove -ve element
//            if (currentNumber < 0) {
//                answer = Math.max(answer, maxSubarraySumHelper(nums, currentNumber));
//            }
//        }
//
//        return answer;
//    }
}