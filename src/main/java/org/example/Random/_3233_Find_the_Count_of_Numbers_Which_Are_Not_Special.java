package org.example.Random;

import java.util.Arrays;

// https://leetcode.com/problems/find-the-count-of-numbers-which-are-not-special/description/
public class _3233_Find_the_Count_of_Numbers_Which_Are_Not_Special {
    public static int nonSpecialCount(int l, int r) {
        int rRoot = (int) Math.sqrt(r);
        int lRoot = (int) Math.ceil(Math.sqrt(l));

        boolean[] primes = new boolean[rRoot + 1];
        Arrays.fill(primes, true);

        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i * i <= rRoot; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= rRoot; j += i) {
                    primes[j] = false;
                }
            }
        }

        int specialNumbers = 0;

        for (int i = lRoot; i <= rRoot; i++) {
            if (primes[i]) {
                specialNumbers++;
            }
        }

        return (r - l + 1 - specialNumbers);
    }

    public static void main(String[] args) {
        System.out.println(nonSpecialCount(5, 7));
    }
}
