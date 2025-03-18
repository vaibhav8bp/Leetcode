package org.example.Google;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/contains-duplicate-ii/description/
public class _219_Contains_Duplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numberToIndexMapping = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (numberToIndexMapping.containsKey(nums[i])) {
                if (Math.abs(i - numberToIndexMapping.get(nums[i])) <= k) {
                    return true;
                }
            }
            numberToIndexMapping.put(nums[i], i);
        }

        return false;
    }
}
