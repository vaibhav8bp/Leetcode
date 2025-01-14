package org.example.Daily._2025.January._10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _916_Word_Subsets {

    private boolean doesCurrentStringHaveAllSubsets(String currentWord, int[] finalMaximumCharacterFrequencyMapping, int[] tempFrequencyForCurrentWord) {

        for (Character currentChar : currentWord.toCharArray()) {
            tempFrequencyForCurrentWord[currentChar - 'a']++;
        }

        for (int j = 0; j < 26; j++) {
            if (tempFrequencyForCurrentWord[j] < finalMaximumCharacterFrequencyMapping[j]) {
                return false;
            }
        }

        return true;
    }

    private void finalMaximumCharacterFrequencyMappingPopulation(String currentWord, int[] finalMaximumCharacterFrequencyMapping, int[] tempFrequencyForCurrentWord) {

        for (Character currentChar : currentWord.toCharArray()) {
            tempFrequencyForCurrentWord[currentChar - 'a']++;
        }

        for (int j = 0; j < 26; j++) {
            finalMaximumCharacterFrequencyMapping[j] = Math.max(finalMaximumCharacterFrequencyMapping[j], tempFrequencyForCurrentWord[j]);
            tempFrequencyForCurrentWord[j] = 0;
        }
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();

        int[] finalMaximumCharacterFrequencyMapping = new int[26];

        int[] tempFrequencyForCurrentWord = new int[26];

        for (String currentWord : words2) {
            finalMaximumCharacterFrequencyMappingPopulation(currentWord, finalMaximumCharacterFrequencyMapping, tempFrequencyForCurrentWord);
        }

        for (String currentWord : words1) {
            if (doesCurrentStringHaveAllSubsets(currentWord, finalMaximumCharacterFrequencyMapping, tempFrequencyForCurrentWord)) {
                result.add(currentWord);
            }
            Arrays.fill(tempFrequencyForCurrentWord, 0);
        }

        return result;
    }
}