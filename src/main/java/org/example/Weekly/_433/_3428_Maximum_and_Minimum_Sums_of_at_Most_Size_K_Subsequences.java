package org.example.Weekly._433;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/maximum-and-minimum-sums-of-at-most-size-k-subsequences/
// TODO : TLE Coming
public class _3428_Maximum_and_Minimum_Sums_of_at_Most_Size_K_Subsequences {

    private final int MODULO = 1000000007;

    private void getAllSubsequencesOfLengthKHelper(int[] nums, int currentIndex, int maxLength, List<List<Integer>> subsequences, List<Integer> currentSubsequence) {

        if (currentSubsequence.size() == maxLength) {
            subsequences.add(new ArrayList<>(currentSubsequence));
            return;
        }

        if (currentIndex == nums.length) {
            return;
        }

        // 2 options -> Add Current Index Element Or Not

        // Add
        currentSubsequence.add(nums[currentIndex]);
        getAllSubsequencesOfLengthKHelper(nums, currentIndex + 1, maxLength, subsequences, currentSubsequence);
        // Skip
        currentSubsequence.removeLast();
        getAllSubsequencesOfLengthKHelper(nums, currentIndex + 1, maxLength, subsequences, currentSubsequence);
    }

    private List<List<Integer>> getAllSubsequencesOfLengthK(int[] nums, int currentLength) {
        List<List<Integer>> allSubsequencesOfLengthK = new ArrayList<>();
        getAllSubsequencesOfLengthKHelper(nums, 0, currentLength, allSubsequencesOfLengthK, new ArrayList<>());
        return allSubsequencesOfLengthK;
    }

    public int minMaxSums(int[] nums, int k) {
        List<List<Integer>> allSubsequences = getAllSubsequencesOfLengthK(nums, k);

        for (List<Integer> currentSubsequence : allSubsequences) {
            Collections.sort(currentSubsequence);
        }

        int finalAnswer = 0;

        for (List<Integer> currentSubsequence : allSubsequences) {

            finalAnswer += currentSubsequence.getFirst();
            finalAnswer += currentSubsequence.getLast();

            for (int i = 0; i < k; i++) {

            }
        }

        return finalAnswer % MODULO;
    }

//    private void getAllSubsequencesOfLengthKHelper(int[] nums, int currentIndex, int maxLength, List<List<Integer>> subsequences, List<Integer> currentSubsequence) {
//
//        if (currentSubsequence.size() == maxLength) {
//            subsequences.add(new ArrayList<>(currentSubsequence));
//            return;
//        }
//
//        if (currentIndex == nums.length) {
//            return;
//        }
//
//        // 2 options -> Add Current Index Element Or Not
//
//        // Add
//        currentSubsequence.add(nums[currentIndex]);
//        getAllSubsequencesOfLengthKHelper(nums, currentIndex + 1, maxLength, subsequences, currentSubsequence);
//        // Skip
//        currentSubsequence.removeLast();
//        getAllSubsequencesOfLengthKHelper(nums, currentIndex + 1, maxLength, subsequences, currentSubsequence);
//    }
//
//    private List<List<Integer>> getAllSubsequencesOfLengthK(int[] nums, int currentLength) {
//        List<List<Integer>> allSubsequencesOfLengthK = new ArrayList<>();
//        getAllSubsequencesOfLengthKHelper(nums, 0, currentLength, allSubsequencesOfLengthK, new ArrayList<>());
//        return allSubsequencesOfLengthK;
//    }
//
//    public int minMaxSums(int[] nums, int k) {
//        List<List<Integer>> allSubsequences = new ArrayList<>();
//
//        for (int i = 1; i <= k; i++) {
//            allSubsequences.addAll(getAllSubsequencesOfLengthK(nums, i));
//        }
//
//        int finalAnswer = 0;
//
//        for (List<Integer> currentSubsequence : allSubsequences) {
//            int minimum = Integer.MAX_VALUE;
//            int maximum = Integer.MIN_VALUE;
//
//            for (Integer currentElement : currentSubsequence) {
//                minimum = Math.min(minimum, currentElement);
//                maximum = Math.max(maximum, currentElement);
//            }
//
//            finalAnswer += minimum;
//            finalAnswer += maximum;
//        }
//
//        return finalAnswer % MODULO;
//    }
}
