package org.example.Daily._2025.January._5;

import java.util.Arrays;

public class _2381_Shifting_Letters_II {

    public String shiftingLetters(String s, int[][] shifts) {

        int[] directionMarker = new int[s.length()];
        Arrays.fill(directionMarker, 0);

        for (int[] currentShift : shifts) {
            int leftIndex = currentShift[0];
            int rightIndex = currentShift[1];
            int direction = currentShift[2];

            if (direction == 0) {
                directionMarker[leftIndex]--;
                if (rightIndex + 1 < s.length()) {
                    directionMarker[rightIndex + 1]++;
                }
            } else if (direction == 1) {
                directionMarker[leftIndex]++;
                if (rightIndex + 1 < s.length()) {
                    directionMarker[rightIndex + 1]--;
                }
            }
        }

        int prefixSum = 0;

        char[] originalString = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            prefixSum += directionMarker[i];
            int currentPositionInAlphaBet = originalString[i] - 'a' + 1;
            int newPositionInAlphaBet = currentPositionInAlphaBet + prefixSum;
            newPositionInAlphaBet %= 26;
            if (newPositionInAlphaBet <= 0) {
                originalString[i] = (char) ('z' + newPositionInAlphaBet);
            } else {
                originalString[i] = (char) ('a' + newPositionInAlphaBet - 1);
            }
        }

        return new String(originalString);
    }

    // Brute Force Solution
//    public String shiftingLetters(String s, int[][] shifts) {
//
//        char[] originalString = s.toCharArray();
//
//        for (int[] currentShift : shifts) {
//            int leftIndex = currentShift[0];
//            int rightIndex = currentShift[1];
//            int direction = currentShift[2];
//
//            for (int i = leftIndex; i <= rightIndex; i++) {
//                int overallShift = 0;
//                if (direction == 0) {
//                    overallShift -= 1;
//                } else if (direction == 1) {
//                    overallShift += 1;
//                }
//
//                int currentPositionInAlphaBet = originalString[i] - 'a' + 1;
//                int newPositionInAlphaBet = currentPositionInAlphaBet + overallShift;
//                newPositionInAlphaBet %= 26;
//                if (newPositionInAlphaBet <= 0) {
//                    originalString[i] = (char) ('z' + newPositionInAlphaBet);
//                } else {
//                    originalString[i] = (char) ('a' + newPositionInAlphaBet - 1);
//                }
//            }
//        }
//
//        return new String(originalString);
//    }
}
