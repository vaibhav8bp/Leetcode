package org.example.Daily._2025.January._14;

// https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/description

public class _2657_Find_the_Prefix_Common_Array_of_Two_Arrays {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] result = new int[A.length];
        boolean[] seen = new boolean[A.length];
        int common = 0;

        for (int i = 0; i < A.length; i++) {
            if (seen[A[i] - 1]) {
                common++;
            } else {
                seen[A[i] - 1] = true;
            }
            if (seen[B[i] - 1]) {
                common++;
            } else {
                seen[B[i] - 1] = true;
            }
            result[i] = common;
        }

        return result;
    }

//    public int[] findThePrefixCommonArray(int[] A, int[] B) {
//        int[] result = new int[A.length];
//        int[] frequency = new int[A.length];

//        for (int i = 0; i < A.length; i++) {
//            int count = 0;
//            frequency[A[i] - 1]++;
//            if (frequency[A[i] - 1] == 2) {
//                count++;
//            }
//            frequency[B[i] - 1]++;
//            if (frequency[B[i] - 1] == 2) {
//                count++;
//            }
//            if (i == 0) {
//                result[i] = count;
//            } else {
//                result[i] = result[i - 1] + count;
//            }
//        }

//        return result;
//    }

    // Brute Force
//    public int[] findThePrefixCommonArray(int[] A, int[] B) {
//        int[] result = new int[A.length];
//        Set<Integer> A_Elements = new HashSet<>();
//        Set<Integer> B_Elements = new HashSet<>();

//        for (int i = 0; i < A.length; i++) {
//            A_Elements.add(A[i]);
//            B_Elements.add(B[i]);

//            Set<Integer> commonElements = new HashSet<>(A_Elements);
//            commonElements.retainAll(B_Elements);
//            result[i] = commonElements.size();
//        }

//        return result;
//    }
}
