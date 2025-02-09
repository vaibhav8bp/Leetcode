package org.example.Daily._2025.February._9;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/count-number-of-bad-pairs/
public class _2364_Count_Number_of_Bad_Pairs {

    public long countBadPairs(int[] nums) {

        long totalPairsPossible = ((long) nums.length * (nums.length - 1)) / 2;

        long goodPairsCount = 0;

        // For Good Pair j - i == nums[j] - nums[i]
        // After Shifting
        // nums[i]-i==nums[j]-j

        Map<Integer, Long> valueMinusIndexToFrequencyMapper = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int currentValueMinusIndex = nums[i] - i;
            long previousFrequencyOfCurrentValueMinusIndex = valueMinusIndexToFrequencyMapper.getOrDefault(currentValueMinusIndex, 0L);
            goodPairsCount += previousFrequencyOfCurrentValueMinusIndex;
            valueMinusIndexToFrequencyMapper.put(currentValueMinusIndex, previousFrequencyOfCurrentValueMinusIndex + 1);
        }

        return totalPairsPossible - goodPairsCount;
    }
}
