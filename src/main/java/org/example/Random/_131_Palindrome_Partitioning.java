package org.example.Random;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/palindrome-partitioning/description/
public class _131_Palindrome_Partitioning {

    private void formPalindromeArray(String s, boolean[][] palindrome) {
        // Only Upper Triangle Needs To Be Populated

        // One Length Strings Are Always Palindrome
        for (int i = 0; i < s.length(); i++) {
            palindrome[i][i] = true;
        }

        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                // 2 Length Substrings, just check both characters
                boolean areFirstAndLastCharacterEqual = s.charAt(i) == s.charAt(j);
                if (j - i == 1) {
                    palindrome[i][j] = areFirstAndLastCharacterEqual;
                }
                // > 2 Length Substrings, use dp
                // First and last character should be equal and middle part should be palindrome
                else {
                    palindrome[i][j] = areFirstAndLastCharacterEqual && (palindrome[i + 1][j - 1]);
                }
            }
        }
    }

    private void partition(int currentIndex, List<String> currentPartition, String s, List<List<String>> partitions, boolean[][] palindrome) {
        if (currentIndex == s.length()) {
            partitions.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int i = currentIndex; i < s.length(); i++) {
            if (palindrome[currentIndex][i]) {
                currentPartition.add(s.substring(currentIndex, i + 1));
                partition(i + 1, currentPartition, s, partitions, palindrome);
                currentPartition.removeLast();
            }
        }
    }

    public List<List<String>> partition(String s) {
        boolean[][] palindrome = new boolean[s.length()][s.length()];
        formPalindromeArray(s, palindrome);
        List<List<String>> partitions = new ArrayList<>();
        partition(0, new ArrayList<>(), s, partitions, palindrome);
        return partitions;
    }
}