package org.example.Bi_Weekly._149;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/find-valid-pair-of-adjacent-digits-in-string/description/
public class _3438_Find_Valid_Pair_of_Adjacent_Digits_in_String {
    public String findValidPair(String s) {

        Map<Character, Integer> characterToFrequencyMapping = new HashMap<>();

        for (Character currentCharacter : s.toCharArray()) {
            characterToFrequencyMapping.put(currentCharacter, characterToFrequencyMapping.getOrDefault(currentCharacter, 0) + 1);
        }

        for (int i = 0; i < s.length() - 1; i++) {
            Character currentCharacter = s.charAt(i);
            Character nextCharacter = s.charAt(i + 1);

            if ((currentCharacter != nextCharacter) && (Integer.parseInt(String.valueOf(currentCharacter)) == characterToFrequencyMapping.get(currentCharacter)) &&
                    (Integer.parseInt(String.valueOf(nextCharacter)) == characterToFrequencyMapping.get(nextCharacter))) {
                return String.valueOf(currentCharacter) + nextCharacter;
            }
        }

        return "";
    }
}
