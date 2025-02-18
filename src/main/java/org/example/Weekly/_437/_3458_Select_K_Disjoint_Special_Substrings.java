package org.example.Weekly._437;

import java.util.*;

// https://leetcode.com/problems/select-k-disjoint-special-substrings/
public class _3458_Select_K_Disjoint_Special_Substrings {
    public boolean maxSubstringLength(String s, int k) {
        int[][] specialSubstringIndex = new int[26][2];

        for (int i = 0; i < s.length(); i++) {
            int currentCharacterIndex = s.charAt(i) - 'a';

            if (specialSubstringIndex[currentCharacterIndex] != null) {
                specialSubstringIndex[currentCharacterIndex][1] = i;
            } else {
                specialSubstringIndex[currentCharacterIndex] = new int[2];
                specialSubstringIndex[currentCharacterIndex][0] = specialSubstringIndex[currentCharacterIndex][1] = i;
            }
        }

        int[][] finalSpecialSubstrings = Arrays.stream(specialSubstringIndex).filter(Objects::nonNull).toArray(int[][]::new);

        return false;
    }
}
