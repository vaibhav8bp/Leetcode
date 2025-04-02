package org.example.Google;

// https://leetcode.com/problems/majority-element/description/
public class _169_Majority_Element {
    public int majorityElement(int[] nums) {

        int currentNumber = nums[0];
        int currentNumberFrequency = 1;

        for (int i = 1; i < nums.length; i++) {
            if (currentNumber == nums[i]) {
                currentNumberFrequency++;
            } else {
                currentNumberFrequency--;
                if (currentNumberFrequency == 0) {
                    currentNumberFrequency = 1;
                    currentNumber = nums[i];
                }
            }
        }

        return currentNumber;
    }
}
