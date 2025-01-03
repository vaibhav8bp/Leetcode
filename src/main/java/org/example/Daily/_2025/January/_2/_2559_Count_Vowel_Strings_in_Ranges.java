package org.example.Daily._2025.January._2;

import java.util.*;

public class _2559_Count_Vowel_Strings_in_Ranges {

    private Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));

    private boolean doesStringStartAndEndWithVowel(String word) {
        return vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1));
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] answer = new int[queries.length];
        int[] prefixSum = new int[words.length];
        Arrays.fill(prefixSum, 0);

        for (int i = 0; i < words.length; i++) {
            if (doesStringStartAndEndWithVowel(words[i])) {
                if (i == 0) {
                    prefixSum[i] = 1;
                } else {
                    prefixSum[i] = prefixSum[i - 1] + 1;
                }
            } else {
                if (i == 0) {
                    prefixSum[i] = 0;
                } else {
                    prefixSum[i] = prefixSum[i - 1];
                }
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int leftRange = queries[i][0];
            int rightRange = queries[i][1];

            if (leftRange == 0) {
                answer[i] = prefixSum[rightRange];
            }
            else{
                answer[i] = prefixSum[rightRange] - prefixSum[leftRange - 1];
            }
        }

        return answer;
    }

//    public int[] vowelStrings(String[] words, int[][] queries) {
//        int[] answer = new int[queries.length];
//        boolean[] mapping = new boolean[words.length];
//        Arrays.fill(mapping, false);
//
//        for (int i = 0; i < words.length; i++) {
//            if (doesStringStartAndEndWithVowel(words[i])) {
//                mapping[i] = true;
//            }
//        }
//
//        for (int i = 0; i < queries.length; i++) {
//            int leftRange = queries[i][0];
//            int rightRange = queries[i][1];
//
//            int count = 0;
//
//            for (int j = leftRange; j <= rightRange; j++) {
//                if (mapping[j]) {
//                    count++;
//                }
//            }
//
//            answer[i] = count;
//        }
//
//        return answer;
//    }
}
