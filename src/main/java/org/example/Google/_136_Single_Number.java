package org.example.Google;

// https://leetcode.com/problems/single-number/description/
public class _136_Single_Number {
    public int singleNumber(int[] nums) {
        int runningXOR = 0;

        for (Integer currentNumber : nums) {
            runningXOR ^= currentNumber;
        }

        return runningXOR;
    }
}
