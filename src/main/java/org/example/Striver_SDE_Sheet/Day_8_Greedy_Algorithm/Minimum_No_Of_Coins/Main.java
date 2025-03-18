package org.example.Striver_SDE_Sheet.Day_8_Greedy_Algorithm.Minimum_No_Of_Coins;

import java.io.*;
import java.util.*;

class Solution {

    static final int[] DENOMINATIONS = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};

    static List<Integer> minPartition(int N) {
        List<Integer> coinsList = new ArrayList<>();
        int denominationIndex = DENOMINATIONS.length - 1;

        while (N > 0) {
            if (N < DENOMINATIONS[denominationIndex]) {
                denominationIndex--;
            } else {
                N -= DENOMINATIONS[denominationIndex];
                coinsList.add(DENOMINATIONS[denominationIndex]);
            }
        }

        return coinsList;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            List<Integer> numbers;
            numbers = Solution.minPartition(N);
            for (int i : numbers) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}