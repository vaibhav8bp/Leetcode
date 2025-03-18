package org.example.Striver_SDE_Sheet.Day_4_Arrays_Part_IV._128_Longest_Consecutive_Sequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> integerBooleanMap = new HashMap<>();

        Arrays.stream(nums).forEach(currentNum -> integerBooleanMap.put(currentNum, true));

        int maximumLength = 0;

        for (Map.Entry<Integer, Boolean> currentEntry : integerBooleanMap.entrySet()) {
            if (integerBooleanMap.containsKey(currentEntry.getKey() - 1)) {
                continue;
            } else {
                int currentLength = 0;
                int start = currentEntry.getKey();
                while (integerBooleanMap.containsKey(start)) {
                    currentLength++;
                    start++;
                }
                maximumLength = Math.max(currentLength,maximumLength);
            }
        }

        return maximumLength;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(new Solution().longestConsecutive(nums));
    }
}
