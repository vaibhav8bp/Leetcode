package org.example.Striver_SDE_Sheet.Day_9_Recursion._60_Permutation_Sequence;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutation-sequence/description/

// Iterative
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> integerList = new ArrayList<>();
        int factorial = 1;
        for (int i = 1; i < n; i++) {
            factorial *= i;
            integerList.add(i);
        }
        integerList.add(n);

        StringBuilder answer = new StringBuilder();
        k--; // Done this to match with index
        while (true) {
            int firstCharacterIndex = k / factorial;
            char currentFirstChar = (char) (48 + integerList.get(firstCharacterIndex));
            answer.append(currentFirstChar);
            integerList.remove(firstCharacterIndex);
            if (integerList.isEmpty()) {
                break;
            }
            k %= factorial;
            factorial = factorial / integerList.size();
        }

        return answer.toString();
    }
}

// class Solution {
//    public String getPermutationHelper(int k, String current, List<Integer> factorialList) {

//        if (k == 1) {
//            return current;
//        }

//        int n_minus_one_factorial = factorialList.get(current.length() - 1);
//        int factor = k / n_minus_one_factorial;

//        if (k % n_minus_one_factorial != 0) {
//            factor++;
//        }

//        String modifiedString = current.substring(0, factor - 1) + current.substring(factor);
//        return current.charAt(factor - 1) + getPermutationHelper(k - ((factor - 1) * n_minus_one_factorial), modifiedString, factorialList);
//    }

//    public String getPermutation(int n, int k) {
//        StringBuilder current = new StringBuilder();
//        for (int i = 1; i <= n; i++) {
//            current.append((char) (48 + i));
//        }
//        List<Integer> factorialList = new ArrayList<>(n + 1);
//        factorialList.add(1);
//        int currentFactorial = 1;
//        for (int i = 1; i <= n; i++) {
//            currentFactorial *= i;
//            factorialList.add(currentFactorial);
//        }
//        return getPermutationHelper(k, current.toString(), factorialList);
//    }
// }

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(4, 9));
    }
}