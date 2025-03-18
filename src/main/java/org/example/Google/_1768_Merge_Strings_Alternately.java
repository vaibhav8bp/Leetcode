package org.example.Google;

// https://leetcode.com/problems/merge-strings-alternately/
public class _1768_Merge_Strings_Alternately {
    public String mergeAlternately(String word1, String word2) {
        int word1Index = 0;
        int word2Index = 0;

        StringBuilder answer = new StringBuilder();

        while (word1Index < word1.length() && word2Index < word2.length()) {
            answer.append(word1.charAt(word1Index));
            answer.append(word2.charAt(word2Index));
            word1Index++;
            word2Index++;
        }

        while (word1Index < word1.length()) {
            answer.append(word1.charAt(word1Index));
            word1Index++;
        }

        while (word2Index < word2.length()) {
            answer.append(word2.charAt(word2Index));
            word2Index++;
        }

        return answer.toString();
    }
}
