package org.example.Daily._2025.March._6;

import java.util.Arrays;

// https://leetcode.com/problems/find-missing-and-repeated-values/description/
public class _2965_Find_Missing_and_Repeated_Values {
    public static int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length * grid.length;
        long sumIfAllNumbersWerePresent = ((long) n * (n + 1)) / 2;
        long sumOfSquaresIfAllNumbersWerePresent = (n * (n + 1) * (2L * n + 1)) / 6;
        long currentSum = 0;
        long currentSumOfSquares = 0;

        for (int[] currentRow : grid) {
            currentSum += Arrays.stream(currentRow).sum();
            currentSumOfSquares += Arrays.stream(currentRow).map(i -> i * i).sum();
        }

        // Appears twice
        int a;
        // Missing
        int b;

        long bMinusA = sumIfAllNumbersWerePresent - currentSum;
        long bSquareMinusASquare = sumOfSquaresIfAllNumbersWerePresent - currentSumOfSquares;
        long bPlusA = bSquareMinusASquare / bMinusA;

        b = (int) ((bMinusA + bPlusA) / 2);
        a = (int) (b - bMinusA);

        int[] result = new int[2];
        result[0] = a;
        result[1] = b;
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3}, {2, 2}};
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(grid)));
    }
}
