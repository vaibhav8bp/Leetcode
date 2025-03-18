package org.example.Striver_SDE_Sheet.Day_4_Arrays_Part_IV._3_Longest_Substring_Without_Repeating_Characters;

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> currentLongestMapping = new HashMap<>();
        int currentMaximumLength = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            if (currentLongestMapping.containsKey(s.charAt(right))) {
                int previousIndex = currentLongestMapping.get(s.charAt(right));
                left = Math.max(left, previousIndex + 1);
            }
            currentLongestMapping.put(s.charAt(right), right);
            currentMaximumLength = Math.max(currentMaximumLength, right - left + 1);
            right++;
        }

        return currentMaximumLength;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("wobgrovw"));
    }
}
