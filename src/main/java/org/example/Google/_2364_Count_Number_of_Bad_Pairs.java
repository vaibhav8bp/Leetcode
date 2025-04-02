package org.example.Google;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/count-number-of-bad-pairs/description/
public class _2364_Count_Number_of_Bad_Pairs {

    // j - i != nums[j] - nums[i]
    // j - nums[j] != i - nums[i]

    public static long countBadPairs(int[] nums) {

        long totalLength = nums.length;
        long totalPairs = (totalLength * (totalLength - 1)) / 2;
        long goodPairs = 0;

        Map<Integer, Long> indexMinusNumberToFrequency = new HashMap<>();

        for (int i = 0; i < totalLength; i++) {
            int currentIndexMinusNumber = i - nums[i];
            goodPairs += indexMinusNumberToFrequency.getOrDefault(currentIndexMinusNumber, 0L);
            indexMinusNumberToFrequency.put(currentIndexMinusNumber, indexMinusNumberToFrequency.getOrDefault(currentIndexMinusNumber, 0L) + 1);
        }

        return (totalPairs - goodPairs);
    }

    public static void main(String[] args) {
        System.out.println(countBadPairs(new int[]{1, 2, 3, 4, 5}));
    }
}
