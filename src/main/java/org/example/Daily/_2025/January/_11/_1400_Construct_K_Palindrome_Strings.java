package org.example.Daily._2025.January._11;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/construct-k-palindrome-strings/description
public class _1400_Construct_K_Palindrome_Strings {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        } else if (s.length() == k) {
            return true;
        } else {
            Map<Character, Integer> characterToFrequencyMapping = new HashMap<>();

            for (Character currentChar : s.toCharArray()) {
                characterToFrequencyMapping.put(currentChar, characterToFrequencyMapping.getOrDefault(currentChar, 0) + 1);
            }

            int oddFrequencyCharacterCount = 0;

            for (Integer currentCount : characterToFrequencyMapping.values()) {
                if (currentCount % 2 != 0) {
                    oddFrequencyCharacterCount++;
                }
            }

            return oddFrequencyCharacterCount <= k;
        }
    }
}
