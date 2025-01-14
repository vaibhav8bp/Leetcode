package org.example.Daily._2025.January._6;

public class _1769_Minimum_Number_of_Operations_to_Move_All_Balls_to_Each_Box {

    // Most Optimized Solution
    public int[] minOperations(String boxes) {
        int[] result = new int[boxes.length()];

        int prefixCount = 0;
        int prefixSum = 0;

        for (int i = 0; i < boxes.length(); i++) {
            result[i] = i * prefixCount - prefixSum;
            if (boxes.charAt(i) == '1') {
                prefixCount++;
                prefixSum += i;
            }
        }

        int suffixCount = 0;
        int suffixSum = 0;

        for (int i = boxes.length() - 1; i >= 0; i--) {
            result[i] += Math.abs(i * suffixCount - suffixSum);
            if (boxes.charAt(i) == '1') {
                suffixCount++;
                suffixSum += i;
            }
        }

        return result;
    }

    // Optimized Solution
//    public int[] minOperations(String boxes) {
//        int[] result = new int[boxes.length()];
//
//        // Prefix Traversal -> Left To Right
//        int[] leftOperationsCount = new int[boxes.length()];
//        Arrays.fill(leftOperationsCount, 0);
//
//        // Denotes the no. of balls to left of i.
//        int prefixCount = boxes.charAt(0) == '1' ? 1 : 0;
//
//        for (int i = 1; i < boxes.length(); i++) {
//            leftOperationsCount[i] = leftOperationsCount[i - 1] + prefixCount;
//            prefixCount = boxes.charAt(i) == '1' ? prefixCount + 1 : prefixCount;
//        }
//
//        int[] rightOperationsCount = new int[boxes.length()];
//        Arrays.fill(rightOperationsCount, 0);
//
//        // Denotes the no. of balls to right of i.
//        int suffixCount = boxes.charAt(boxes.length() - 1) == '1' ? 1 : 0;
//
//        // Suffix Traversal -> Right To Left
//        for (int i = boxes.length() - 2; i >= 0; i--) {
//            rightOperationsCount[i] = rightOperationsCount[i + 1] + suffixCount;
//            suffixCount = boxes.charAt(i) == '1' ? suffixCount + 1 : suffixCount;
//        }
//
//        for (int i = 0; i < boxes.length(); i++) {
//            result[i] = leftOperationsCount[i] + rightOperationsCount[i];
//        }
//
//        return result;
//    }

//     Brute Force Solution
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

//        List<Integer> indexesWhereBallsExist = new ArrayList<>();

//        for (int i = 0; i < boxes.length(); i++) {
//            if (boxes.charAt(i) == '1') {
//                indexesWhereBallsExist.add(i);
//            }
//        }

//        int[] result = new int[boxes.length()];

//        for (int i = 0; i < boxes.length(); i++) {
//            result[i] = minOperationsForIthIndex(i, indexesWhereBallsExist);
//        }

//        return result;
//    }
}