package org.example.Google;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-consecutive-sequence/
public class _128_Longest_Consecutive_Sequence {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> numberExistenceMapping = new HashMap<>();

        for (Integer currentNumber : nums) {
            numberExistenceMapping.put(currentNumber, true);
        }

        int maxLength = 0;

        for (Integer currentNumber : nums) {
            if (numberExistenceMapping.containsKey(currentNumber)) {
                int currentLength = 1;
                numberExistenceMapping.remove(currentNumber);

                int next = currentNumber + 1;
                while (numberExistenceMapping.containsKey(next)) {
                    numberExistenceMapping.remove(next++);
                    currentLength++;
                }

                int previous = currentNumber - 1;
                while (numberExistenceMapping.containsKey(previous)) {
                    numberExistenceMapping.remove(previous--);
                    currentLength++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}
