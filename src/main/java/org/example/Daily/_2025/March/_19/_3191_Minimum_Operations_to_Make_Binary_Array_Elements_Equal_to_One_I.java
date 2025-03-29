package org.example.Daily._2025.March._19;

// https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/
public class _3191_Minimum_Operations_to_Make_Binary_Array_Elements_Equal_to_One_I {

    public int minOperations(int[] nums) {

        int operations = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (i + 2 >= nums.length) {
                    return -1;
                } else {
                    nums[i] = 1;
                    nums[i + 1] ^= 1;
                    nums[i + 2] ^= 1;
                    operations++;
                }
            }
        }

        return operations;
    }
}