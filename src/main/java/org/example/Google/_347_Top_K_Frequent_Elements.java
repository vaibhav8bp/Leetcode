package org.example.Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/top-k-frequent-elements/description/
public class _347_Top_K_Frequent_Elements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numberToFrequencyMapping = new HashMap<>();

        for (Integer currentNumber : nums) {
            numberToFrequencyMapping.put(currentNumber, numberToFrequencyMapping.getOrDefault(currentNumber, 0) + 1);
        }

        List<Integer>[] frequencyToElementsMapper = new ArrayList[nums.length];

        for (int i = 0; i < nums.length; i++) {
            frequencyToElementsMapper[i] = new ArrayList<>();
        }

        int[] result = new int[k];
        int resultIndex = 0;

        for (Map.Entry<Integer, Integer> currentEntry : numberToFrequencyMapping.entrySet()) {
            frequencyToElementsMapper[currentEntry.getValue() - 1].add(currentEntry.getKey());
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            List<Integer> currentFrequencyElements = frequencyToElementsMapper[i];

            for (Integer currentElement : currentFrequencyElements) {
                result[resultIndex++] = currentElement;
                if (resultIndex == k) {
                    return result;
                }
            }
        }

        return null;
    }
}
