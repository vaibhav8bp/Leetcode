package org.example.Striver_SDE_Sheet.Day_4_Arrays_Part_IV._1_Two_Sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/description/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberToIndexMapping = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numberToIndexMapping.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (numberToIndexMapping.containsKey(target - nums[i])) {
                int index = numberToIndexMapping.get(target - nums[i]);
                if (index != i) {
                    return new int[]{i, index};
                }
            }
        }

        return new int[]{};
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{3, 2, 4}, 6)));
    }
}