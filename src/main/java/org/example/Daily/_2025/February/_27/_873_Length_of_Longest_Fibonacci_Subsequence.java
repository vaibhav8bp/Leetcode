package org.example.Daily._2025.February._27;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
public class _873_Length_of_Longest_Fibonacci_Subsequence {

    public int lenLongestFibSubseq(int[] arr) {

        int length = arr.length;

        // dp[i][j] denotes the length max Fibonacci subsequence
        // with first 2 numbers at index i and j.

        int[][] dp = new int[length][length];

        // Initialize complete 2D array with size = 2.
        // Before returning maxLength we will check
        // if maxLength=2 return 2, as minimum length of
        // Fibonacci subsequence should be 3.

        for (int i = 0; i < length; i++) {
            Arrays.fill(dp[i], 2);
        }

        Map<Integer, Integer> numberToIndexMapper = new HashMap<>();

        for (int i = 0; i < length; i++) {
            numberToIndexMapper.put(arr[i], i);
        }

        int maxLength = 0;

        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                int firstNumber = arr[i];
                int secondNumber = arr[j];
                int sum = firstNumber + secondNumber;

                if (numberToIndexMapper.containsKey(sum)) {
                    int sumIndex = numberToIndexMapper.get(sum);
                    dp[i][j] = dp[j][sumIndex] + 1;
                }

                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }

        if (maxLength == 2) {
            return 0;
        }

        return maxLength;
    }

//    public int lenLongestFibSubseq(int[] arr) {
//        Map<Integer, Integer> numberToIndexMapper = new HashMap<>();
//
//        for (int i = 0; i < arr.length; i++) {
//            numberToIndexMapper.put(arr[i], i);
//        }
//
//        int maxLength = 0;
//
//        for (int i = 0; i < arr.length; i++) {
//            int firstNumber = arr[i];
//
//            for (int j = i + 1; j < arr.length; j++) {
//                int secondNumber = arr[j];
//                int firstNumber1 = firstNumber;
//                int next = firstNumber1 + secondNumber;
//
//                int currentLength = 2;
//
//                while (numberToIndexMapper.containsKey(next)) {
//                    firstNumber1 = secondNumber;
//                    secondNumber = next;
//                    next = firstNumber1 + secondNumber;
//                    currentLength++;
//                }
//
//                // Fibonacci is of length >=3
//                if (currentLength == 2) {
//                    continue;
//                }
//
//                maxLength = Math.max(currentLength, maxLength);
//            }
//        }
//
//        return maxLength;
//    }
}
