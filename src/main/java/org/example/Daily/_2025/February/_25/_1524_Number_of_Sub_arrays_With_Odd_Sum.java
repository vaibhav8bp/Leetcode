package org.example.Daily._2025.February._25;

// https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/
public class _1524_Number_of_Sub_arrays_With_Odd_Sum {

    //    O.   E.   O.   E.    O     E     O
    //    1,   2,   3,   4,    5,    6,    7

    private static final int MODULO = (int) (1e9 + 7);

    public static int numOfSubarrays(int[] arr) {
        int answer = 0;

        long runningSum = 0;
        // Running Sum of 0 is even, hence initializing evenSumCount with 1.
        long evenSumCount = 1;
        long oddSumCount = 0;

        for (int currentNumber : arr) {
            runningSum += currentNumber;
            if (runningSum % 2 == 0) {
                answer = (int) ((answer + oddSumCount) % MODULO);
                evenSumCount++;
            } else {
                answer = (int) ((answer + evenSumCount) % MODULO);
                oddSumCount++;
            }
        }

        return answer;
    }

    // 1 3 5 7 9 11
    //   1 2 3 4 5
    public static void main(String[] args) {
        System.out.println(numOfSubarrays(new int[]{1, 3, 5}));
        System.out.println(numOfSubarrays(new int[]{2, 4, 6}));
        System.out.println(numOfSubarrays(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }
}
