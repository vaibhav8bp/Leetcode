package org.example.Daily._2025.March._1;

// https://leetcode.com/problems/apply-operations-to-an-array/description/
public class _2460_Apply_Operations_to_an_Array {
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int lastZero = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[lastZero];
                nums[lastZero] = temp;
                lastZero++;
            }
        }

        for (int i = lastZero; i < nums.length; i++) {
            nums[i] = 0;
        }

        return nums;
    }
}
