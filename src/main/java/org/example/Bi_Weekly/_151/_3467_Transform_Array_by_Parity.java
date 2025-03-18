package org.example.Bi_Weekly._151;

// https://leetcode.com/problems/transform-array-by-parity/description/
public class _3467_Transform_Array_by_Parity {
    public int[] transformArray(int[] nums) {
        int evenCount = 0;

        for (Integer currentNumber : nums) {
            if (currentNumber % 2 == 0) {
                evenCount++;
            }
        }

        for (int i = 0; i < evenCount; i++) {
            nums[i] = 0;
        }

        for (int i = evenCount; i < nums.length; i++) {
            nums[i] = 1;
        }

        return nums;
    }
}
