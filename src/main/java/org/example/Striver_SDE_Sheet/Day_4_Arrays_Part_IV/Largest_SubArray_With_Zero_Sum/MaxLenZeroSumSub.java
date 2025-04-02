package org.example.Striver_SDE_Sheet.Day_4_Arrays_Part_IV.Largest_SubArray_With_Zero_Sum;

import java.util.*;

// https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
class GfG {
    int maxLen(int[] arr, int n) {

        int maxLength = 0;
        Map<Integer, Integer> indexToSumMapping = new LinkedHashMap<>();

        int sumSoFar = 0;
        for (int i = 0; i < n; i++) {
            sumSoFar += arr[i];
            // This is the maxSubArrayLength so far which has 0 sum
            if (sumSoFar == 0) {
                maxLength = i + 1;
            } else {
                if (indexToSumMapping.containsKey(sumSoFar)) {
                    int previousIndexWithCurrentSumSoFar = indexToSumMapping.get(sumSoFar);
                    maxLength = Math.max(maxLength, i - previousIndexWithCurrentSumSoFar);
                } else {
                    indexToSumMapping.put(sumSoFar, i);
                }
            }
        }
        return maxLength;
    }
}

public class MaxLenZeroSumSub {
    public static void main(String[] arg) {
        int[] nums = new int[]{15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(new GfG().maxLen(nums, 8));
    }
}