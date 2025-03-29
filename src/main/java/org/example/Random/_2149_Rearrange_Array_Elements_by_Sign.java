package org.example.Random;

// https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
public class _2149_Rearrange_Array_Elements_by_Sign {
    public int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];

        int evenIndex = 0;
        int oddIndex = 1;

        for (int currentNumber : nums) {
            // Number cant be 0, given in constraints.
            if (currentNumber < 0) {
                result[oddIndex] = currentNumber;
                oddIndex += 2;
            } else if (currentNumber > 0) {
                result[evenIndex] = currentNumber;
                evenIndex += 2;
            }
        }

        return result;
    }
}
