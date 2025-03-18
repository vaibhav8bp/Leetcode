package org.example.Daily._2025.March._17;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/divide-array-into-equal-pairs/description/
public class _2206_Divide_Array_Into_Equal_Pairs {

    public static boolean divideArray(int[] nums) {
        Map<Integer, Integer> numberToFrequencyMapper = new HashMap<>();

        for (Integer currentNumber : nums) {
            numberToFrequencyMapper.put(currentNumber, numberToFrequencyMapper.getOrDefault(currentNumber, 0) + 1);
        }

        for (Integer currentFrequency : numberToFrequencyMapper.values()) {
            // If any elements frequency is odd, we cannot convert it into pairs
            // 2 2 2 3 3 3
            // Because we have to form 3 pairs, so  2 and 3 will get matched for 1 pair.
            if (currentFrequency % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}
