package org.example.Daily._2025.March._30;

import java.util.*;

// https://leetcode.com/problems/partition-labels/description/
public class _763_Partition_Labels {

    public List<Integer> partitionLabels(String s) {
// 0 1 2 3 4 5 6 7 8 9
// c a e d b d e d d a

// c->[0]
// a->[1,9]
// e->[2,6]
// d->[3,8]
// b->[4]

        Map<Character, Integer> characterToLastOccurrenceMapping = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            characterToLastOccurrenceMapping.put(s.charAt(i), i);
        }

        List<Integer> answer = new ArrayList<>();

        int currentWindowStart = 0;
        int currentWindowEnd = 0;

        for (int i = 0; i < s.length(); i++) {
            currentWindowEnd = Math.max(currentWindowEnd, characterToLastOccurrenceMapping.get(s.charAt(i)));
            if (currentWindowEnd == i) {
                answer.add(currentWindowEnd - currentWindowStart + 1);
                currentWindowStart = i + 1;
            }
        }

        return answer;
    }

//    public List<Integer> partitionLabels(String s) {
//        // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23
//        // a b a b c b a c a d  e f   e  g  d  e  h  i  j  h  k  l  i  j
//
//        // a->[0,8]
//        // b->[1,5]
//        // c->[4,7]
//        // d->[9,14]
//        // e->[10,15]
//        // f->[11]
//        // g->[13]
//        // h->[16,19]
//        // i->[17,22]
//        // j->[18-23]
//        // k->[20]
//
//        int[][] intervals = new int[26][2];
//
//        for (int i = 0; i < 26; i++) {
//            Arrays.fill(intervals[i], -1);
//        }
//
//        for (int i = 0; i < s.length(); i++) {
//            int currentCharacterIndex = s.charAt(i) - 'a';
//            if (intervals[currentCharacterIndex][0] == -1) {
//                intervals[currentCharacterIndex][0] = i;
//            }
//            intervals[currentCharacterIndex][1] = i;
//        }
//
//        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
//
//        List<Integer> answer = new ArrayList<>();
//
//        int i = 0;
//        while (i < 26 && intervals[i][0] == -1) {
//            i++;
//        }
//
//        int currentWindowStart = intervals[i][0];
//        int currentWindowEnd = intervals[i][1];
//
//        for (; i < 26; i++) {
//            int currentCharacterStart = intervals[i][0];
//            int currentCharacterEnd = intervals[i][1];
//
//            // currentWindowEnd and currentCharacterStart will never be equal.
//            // 2 characters cannot be at same index.
//
//            if (currentWindowEnd < currentCharacterStart) {
//                answer.add(currentWindowEnd - currentWindowStart + 1);
//                currentWindowStart = currentCharacterStart;
//                currentWindowEnd = currentCharacterEnd;
//            } else if (currentWindowEnd > currentCharacterStart) {
//                currentWindowEnd = Math.max(currentWindowEnd, currentCharacterEnd);
//            }
//        }
//
//        answer.add(currentWindowEnd - currentWindowStart + 1);
//        return answer;
//    }
}