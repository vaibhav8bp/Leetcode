package org.example.Weekly._442;

// https://leetcode.com/problems/minimum-operations-to-make-array-elements-zero/description/
public class _3495_Minimum_Operations_to_Make_Array_Elements_Zero {
    public long minOperations(int[][] queries) {
        long totalOperations = 0;

        for (int[] query : queries) {
            long left = query[0];
            long right = query[1];

            long queryOperations = 0;

            long powerLevel = (long) Math.floor(Math.log(left) / Math.log(4));
            long powerValue = (long) Math.pow(4, powerLevel);

            // Left==right is considered inside loop
            // in constraint it is given that left<right.
            // So the loop will always run once.
            while (left < right) {
                long nextPowerValue = powerValue * 4;

                if (right <= nextPowerValue) {
                    queryOperations += (right - left + 1) * (powerLevel + 1);
                    if (right == nextPowerValue) {
                        queryOperations++;
                    }
                } else {
                    queryOperations += (nextPowerValue - left) * (powerLevel + 1);
                }

                powerValue = nextPowerValue;
                powerLevel++;
                left = Math.min(right, powerValue);
            }

            totalOperations += (queryOperations + 1) / 2;
        }

        return totalOperations;
    }
}
