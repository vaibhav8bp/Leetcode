package org.example.Daily._2024.December._17;

import com.sun.source.tree.Tree;

import java.util.*;

public class _2182_Construct_String_With_Repeat_Limit {

    private boolean isCurrentCharacterPossible(StringBuilder result, int repeatLimit, Character largestCharPossible) {
        if (result.length() >= repeatLimit) {
            int index = result.length() - repeatLimit;
            for (int i = result.length() - 1; i >= index; i--) {
                if (result.charAt(i) != largestCharPossible) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private void populateLargestStringWithLimit(StringBuilder result, int repeatLimit, TreeMap<Character, Integer> characterToFrequencyMapping) {
        Character largestCharPossible = characterToFrequencyMapping.firstKey();

        // No Further Possible Solution For This Character

    }

    public String repeatLimitedString(String s, int repeatLimit) {
        TreeMap<Character, Integer> characterToFrequencyMapping = new TreeMap<>(Comparator.reverseOrder());

        for (char currentChar : s.toCharArray()) {
            if (characterToFrequencyMapping.containsKey(currentChar)) {
                characterToFrequencyMapping.put(currentChar, characterToFrequencyMapping.get(currentChar) + 1);
            } else {
                characterToFrequencyMapping.put(currentChar, 1);
            }
        }

        StringBuilder answer = new StringBuilder();
        populateLargestStringWithLimit(answer, repeatLimit, characterToFrequencyMapping);
        return answer.toString();
    }
}
