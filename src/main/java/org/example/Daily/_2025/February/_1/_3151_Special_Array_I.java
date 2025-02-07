package org.example.Daily._2025.February._1;

// https://leetcode.com/problems/special-array-i/
public class _3151_Special_Array_I {
    public boolean isArraySpecial(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            int firstNumberParity = nums[i] & 1;
            int secondNumberParity = nums[i + 1] & 1;

            if (firstNumberParity == secondNumberParity) {
                return false;
            }
        }

        return true;
    }
}
