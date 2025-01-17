package org.example.Daily._2025.January._1;

// https://leetcode.com/problems/maximum-score-after-splitting-a-string/description
public class _1422_Maximum_Score_After_Splitting_a_String {

    public int maxScore(String s) {

        int zerosOnLeft = 0;
        int onesOnRight = (int) s.chars().filter(c -> c == '1').count();
        int maxScore = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            zerosOnLeft = (s.charAt(i) == '0') ? (zerosOnLeft + 1) : (zerosOnLeft);
            onesOnRight = (s.charAt(i) == '1') ? (onesOnRight - 1) : (onesOnRight);

            maxScore = Math.max(maxScore, zerosOnLeft + onesOnRight);
        }

        return maxScore;
    }

//    public int maxScore(String s) {
//        Map<Integer, Integer> indexToZeroCountMappingOnLeft = new HashMap<>();
//        Map<Integer, Integer> indexToOneCountMappingOnRight = new HashMap<>();
//
//        int index = 0;
//        int zeroCount = 0;
//
//        for (char currentChar : s.toCharArray()) {
//            if (currentChar == '0') {
//                zeroCount++;
//            }
//            indexToZeroCountMappingOnLeft.put(index, zeroCount);
//            index++;
//        }
//
//        index = s.length() - 1;
//        int onesCount = 0;
//
//        while (index >= 0) {
//            if (s.charAt(index) == '1') {
//                onesCount++;
//            }
//            indexToOneCountMappingOnRight.put(index, onesCount);
//            index--;
//        }
//
//        int maxScore = 0;
//
//        for (int i = 1; i < s.length(); i++) {
//            maxScore = Math.max(maxScore, indexToZeroCountMappingOnLeft.get(i - 1) + indexToOneCountMappingOnRight.get(i));
//        }
//
//        return maxScore;
//    }
}