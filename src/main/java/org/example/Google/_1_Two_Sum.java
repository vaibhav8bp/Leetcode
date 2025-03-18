package org.example.Google;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
public class _1_Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        Map<Integer, Integer> elementToIndexMapper = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int numberRequired = target - nums[i];

            if (elementToIndexMapper.containsKey(numberRequired)) {
                answer[0] = elementToIndexMapper.get(numberRequired);
                answer[1] = i;
            }

            elementToIndexMapper.put(nums[i], i);
        }

        return null;
    }
}
