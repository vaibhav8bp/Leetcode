package org.example.Daily._2025.April._12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/find-the-count-of-good-integers/description/
public class _3272_Find_the_Count_of_Good_Integers {

    private static long factorial(int n, Map<Integer, Long> dp) {
        if (n <= 1) {
            return 1;
        }

        if (dp.containsKey(n)) {
            return dp.get(n);
        }

        long result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        dp.put(n, result);
        return result;
    }

    private static long countGoodIntegersForCurrentCombination(int[] currentNumber, Set<String> visited, Map<Integer, Long> dp) {
        Map<Integer, Integer> digitToFrequencyMapping = new HashMap<>();

        for (int currentDigit : currentNumber) {
            digitToFrequencyMapping.put(currentDigit, digitToFrequencyMapping.getOrDefault(currentDigit, 0) + 1);
        }

        if (visited.contains(digitToFrequencyMapping.toString())) {
            return 0;
        }

        visited.add(digitToFrequencyMapping.toString());

        long totalPermutations = factorial(currentNumber.length, dp);

        for (int currentFrequency : digitToFrequencyMapping.values()) {
            totalPermutations /= factorial(currentFrequency, dp);
        }

        if (!digitToFrequencyMapping.containsKey(0)) {
            return totalPermutations;
        }

        // Fix 0 at start, only rest characters can be rearranged.
        digitToFrequencyMapping.put(0, digitToFrequencyMapping.get(0) - 1);
        long permutationsStartingWithZero = factorial(currentNumber.length - 1, dp);

        for (int currentFrequency : digitToFrequencyMapping.values()) {
            permutationsStartingWithZero /= factorial(currentFrequency, dp);
        }

        return totalPermutations - permutationsStartingWithZero;
    }

    private static long getActualNumber(int[] currentNumber) {
        long actualNumber = 0;
        long base = 1;

        int index = currentNumber.length - 1;

        while (index != -1) {
            actualNumber += (currentNumber[index] * base);
            base *= 10;
            index--;
        }

        return actualNumber;
    }

    private static long countGoodIntegers(int[] currentNumber, int leftIndex, int rightIndex, int k, Set<String> visited, Map<Integer, Long> dp) {
        if (leftIndex > rightIndex) {
            if ((getActualNumber(currentNumber) % k) == 0) {
                return countGoodIntegersForCurrentCombination(currentNumber, visited, dp);
            }
            return 0;
        }

        long answer = 0;

        for (int currentDigit = 0; currentDigit <= 9; currentDigit++) {
            // To Avoid Leading Zeros
            if (leftIndex == 0 && currentDigit == 0) {
                continue;
            }
            currentNumber[leftIndex] = currentNumber[rightIndex] = currentDigit;
            answer += countGoodIntegers(currentNumber, leftIndex + 1, rightIndex - 1, k, visited, dp);
        }

        return answer;
    }

    public static long countGoodIntegers(int n, int k) {
        return countGoodIntegers(new int[n], 0, n - 1, k, new HashSet<>(), new HashMap<>());
    }

//    private static boolean isPalindrome(StringBuilder currentString) {
//
//        if (currentString.charAt(0) == '0') {
//            return false;
//        }
//
//        int left = 0;
//        int right = currentString.length() - 1;
//
//        while (left < right) {
//            if (currentString.charAt(left++) != currentString.charAt(right--)) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    private static void swap(int left, int right, StringBuilder currentString) {
//        char leftCharacter = currentString.charAt(left);
//        currentString.setCharAt(left, currentString.charAt(right));
//        currentString.setCharAt(right, leftCharacter);
//    }
//
//    private static boolean isGood(int currentIndex, StringBuilder currentString, int k) {
//        if (currentIndex == currentString.length()) {
//            return isPalindrome(currentString) && ((Integer.parseInt(currentString.toString()) % k) == 0);
//        }
//
//        for (int i = currentIndex; i < currentString.length(); i++) {
//            swap(currentIndex, i, currentString);
//            if (isGood(currentIndex + 1, currentString, k)) {
//                swap(currentIndex, i, currentString);
//                return true;
//            }
//            swap(currentIndex, i, currentString);
//        }
//
//        return false;
//    }
//
//    // Check All Permutations, if any permutation is found good, return true.
//    // Else return false.
//    private static boolean isGood(StringBuilder currentString, int k) {
//        return isGood(0, currentString, k);
//    }
//
//    private static long countGoodIntegers(StringBuilder currentString, int n, int k) {
//        if (currentString.length() == n) {
//            if (isGood(currentString, k)) {
//                return 1;
//            }
//            return 0;
//        }
//
//        long answer = 0;
//
//        for (int i = 0; i <= 9; i++) {
//            // Avoid leading Zero's
//            if (currentString.isEmpty() && i == 0) {
//                continue;
//            }
//            currentString.append(i);
//            answer += countGoodIntegers(currentString, n, k);
//            currentString.deleteCharAt(currentString.length() - 1);
//        }
//
//        return answer;
//    }
//
//    public static long countGoodIntegers(int n, int k) {
//        return countGoodIntegers(new StringBuilder(), n, k);
//    }

    public static void main(String[] args) {
        System.out.println(countGoodIntegers(3, 5));
        System.out.println(countGoodIntegers(1, 4));
        System.out.println(countGoodIntegers(5, 6));
    }
}
