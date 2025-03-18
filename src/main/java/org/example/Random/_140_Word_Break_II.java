package org.example.Random;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/word-break-ii/description/
public class _140_Word_Break_II {

    private void wordBreak(int currentIndex, StringBuilder currentString, List<String> answer, String s, List<String> wordDict) {
        if (currentIndex == s.length()) {
            // Remove Last Space before adding to final answer.
            currentString.deleteCharAt(currentString.length() - 1);
            answer.add(new String(currentString));
            // Backtrack.
            currentString.append(" ");
            return;
        }

        for (String currentWord : wordDict) {
            if (currentIndex + currentWord.length() > s.length()) {
                continue;
            }

            int currentIndexInStringS = currentIndex;
            int currentIndexInWord = 0;

            while (currentIndexInWord < currentWord.length() && currentIndexInStringS < s.length() &&
                    s.charAt(currentIndexInStringS) == currentWord.charAt(currentIndexInWord)) {
                currentIndexInWord++;
                currentIndexInStringS++;
            }

            if (currentIndexInWord == currentWord.length()) {
                int currentStringLengthBeforeAppending = currentString.length();
                currentString.append(currentWord).append(" ");
                wordBreak(currentIndexInStringS, currentString, answer, s, wordDict);
                // Backtracking.
                currentString.delete(currentStringLengthBeforeAppending, currentString.length());
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> answer = new ArrayList<>();
        wordBreak(0, new StringBuilder(), answer, s, wordDict);
        return answer;
    }
}
