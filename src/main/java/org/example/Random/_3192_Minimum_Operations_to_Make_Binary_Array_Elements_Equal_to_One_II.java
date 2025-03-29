package org.example.Random;

// https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-ii/description/
public class _3192_Minimum_Operations_to_Make_Binary_Array_Elements_Equal_to_One_II {
    public int minOperations(int[] nums) {
        int operationCount = 0;

        // Line sweep
        int runningSum = 0;

        for (int i = 0; i < nums.length; i++) {
            // Running sum is just how many times, this index's value is changed.
            if (runningSum % 2 != 0) {
                nums[i] ^= 1;
            }
            if (nums[i] == 0) {
                runningSum++;
                operationCount++;
            }
        }
        return operationCount;
    }
}