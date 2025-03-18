package org.example.Striver_SDE_Sheet.Day_2_Arrays_Part_II._Repeat_And_Missing_Number_Array;

import java.util.Arrays;

class Solution {
    public int[] repeatedNumber(final int[] A) {
        int n = A.length;

        int sumOfnNaturalNumbers = ((n) * (n + 1)) / 2;
        int sumOfArrayNumbers = Arrays.stream(A).sum();
        int sumOfSquaresOfnNaturalNumbers = ((n) * (n + 1) * (2 * n + 1)) / 6;
        int sumOfSquaresOfArrayNumbers = Arrays.stream(A).map(currentNumber -> currentNumber * currentNumber).sum();

        int A_MINUS_B = sumOfArrayNumbers - sumOfnNaturalNumbers;
        int A_2_MINUS_B_2 = sumOfSquaresOfArrayNumbers - sumOfSquaresOfnNaturalNumbers;

        int A_PLUS_B = A_2_MINUS_B_2 / A_MINUS_B;

        int a = (A_PLUS_B + A_MINUS_B) / 2;
        int b = a - A_MINUS_B;

        return new int[]{a, b};
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 5, 3};
        System.out.println(Arrays.toString(new Solution().repeatedNumber(arr)));
    }
}
