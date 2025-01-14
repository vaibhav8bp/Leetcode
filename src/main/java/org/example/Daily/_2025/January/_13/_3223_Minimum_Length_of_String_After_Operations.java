package org.example.Daily._2025.January._13;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-length-of-string-after-operations/description

public class _3223_Minimum_Length_of_String_After_Operations {

    public int minimumLength(String s) {
        int subtractedLength = 0;
        int[] frequency = new int[26];
        Arrays.fill(frequency, 0);

        for (Character currentCharacter : s.toCharArray()) {
            frequency[currentCharacter - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            // For Characters With Odd Length, Finally only 1 will remain
            // In Other Words , their length will be reduces by originalLength - 1
            int currentFrequency = frequency[i];

            if (currentFrequency == 0) {
                continue;
            }

            if (currentFrequency % 2 != 0) {
                subtractedLength += (currentFrequency - 1);
            }
            // For Characters With Even Length, Finally only 2 will remain
            // In Other Words , their length will be reduces by originalLength - 2
            else {
                subtractedLength += (currentFrequency - 2);
            }
        }

        return s.length() - subtractedLength;
    }
}