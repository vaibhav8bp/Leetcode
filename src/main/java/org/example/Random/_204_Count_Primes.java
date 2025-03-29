package org.example.Random;

// https://leetcode.com/problems/count-primes/description/
public class _204_Count_Primes {
    public int countPrimes(int n) {
        boolean[] visited = new boolean[n];

        int count = 0;

        // We can only go till i*i<=(n-1), but we have to count too so going till n-1.
        for (int i = 2; i <= (n - 1); i++) {
            if (!visited[i]) {
                count++;
                for (long j = (long) i * i; j <= (n - 1); j += i) {
                    visited[(int) j] = true;
                }
            }
        }

        return count;
    }
}
