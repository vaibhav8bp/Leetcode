package org.example.Daily._2025.March._7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/closest-prime-numbers-in-range/
public class _2523_Closest_Prime_Numbers_in_Range {

    private List<Integer> getAllPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        // This is just for marking phase.
        // it can happen that numbers that don't come in this loop are also prime
        // example 11 in case of 100.
        // 11's square is 121 , so no need of travelling right ?

        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primesBetweenLeftAndRight = new ArrayList<>();

        for (int i = 0; i <= right; i++) {
            if (i >= left && isPrime[i]) {
                primesBetweenLeftAndRight.add(i);
            }
        }

        return primesBetweenLeftAndRight;
    }

    public int[] closestPrimes(int left, int right) {
        List<Integer> allPrimes = getAllPrimes(left, right);

        int[] result = new int[2];

        if (allPrimes.isEmpty() || allPrimes.size() == 1) {
            Arrays.fill(result, -1);
        } else {
            int first = allPrimes.getFirst();
            int second = allPrimes.get(1);
            result[0] = first;
            result[1] = second;
            int minimumDifference = second - first;

            for (int i = 2; i < allPrimes.size(); i++) {
                if (allPrimes.get(i) - allPrimes.get(i - 1) < minimumDifference) {
                    minimumDifference = allPrimes.get(i) - allPrimes.get(i - 1);
                    first = allPrimes.get(i - 1);
                    second = allPrimes.get(i);
                    result[0] = first;
                    result[1] = second;
                }
            }
        }

        return result;
    }
}