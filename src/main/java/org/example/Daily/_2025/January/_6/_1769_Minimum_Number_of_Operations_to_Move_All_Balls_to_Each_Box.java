package org.example.Daily._2025.January._6;

public class _1769_Minimum_Number_of_Operations_to_Move_All_Balls_to_Each_Box {

    // Optimized Solution
    public int[] minOperations(String boxes) {
        return null;
    }

    // Brute Force Solution
//    private int minOperationsForIthIndex(int currentIndex, List<Integer> indexesWhereBallsExist) {
//        int count = 0;
//        for (Integer index : indexesWhereBallsExist) {
//            if (currentIndex == index) {
//                continue;
//            }
//            count += Math.abs(currentIndex - index);
//        }
//        return count;
//    }

//    public int[] minOperations(String boxes) {
//
//        List<Integer> indexesWhereBallsExist = new ArrayList<>();
//
//        for (int i = 0; i < boxes.length(); i++) {
//            if (boxes.charAt(i) == '1') {
//                indexesWhereBallsExist.add(i);
//            }
//        }
//
//        int[] result = new int[boxes.length()];
//
//        for (int i = 0; i < boxes.length(); i++) {
//            result[i] = minOperationsForIthIndex(i, indexesWhereBallsExist);
//        }
//
//        return result;
//    }
}