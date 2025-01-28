package org.example.Weekly._434;

import java.util.Arrays;

public class Q1_Count_Partitions_with_Even_Sum_Difference {
    public int countPartitions(int[] nums) {
        long totalSum = Arrays.stream(nums).sum();

        long leftSum = 0;

        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            long rightSum = totalSum - leftSum;

            if (Math.abs(leftSum - rightSum) % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}
