package org.example.Google;

// https://leetcode.com/problems/special-array-i/description/
public class _3151_Special_Array_I {
    public boolean isArraySpecial(int[] nums) {

        if (nums.length == 1) {
            return true;
        }

        boolean previousParity = (nums[0] % 2 == 0);

        for (int i = 1; i < nums.length; i++) {
            boolean currentParity = (nums[i] % 2 == 0);
            if (currentParity == previousParity) {
                return false;
            }
            previousParity = currentParity;
        }

        return true;
    }
}
