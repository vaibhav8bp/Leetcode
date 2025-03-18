package org.example.Google;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class _3_Longest_Substring_Without_Repeating_Characters {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;

        Map<Character, Integer> characterToIndexMapping = new HashMap<>();
        int maxLength = 0;

        while (right < s.length()) {
            if (characterToIndexMapping.containsKey(s.charAt(right))) {
                left = Math.max(left, characterToIndexMapping.get(s.charAt(right)) + 1);
            }
            characterToIndexMapping.put(s.charAt(right), right);
            right++;
            maxLength = Math.max(maxLength, right - left);
        }

        //abba

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
