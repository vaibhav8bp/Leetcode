package org.example.Striver_SDE_Sheet.Day_25_Dynamic_Programming._152_Maximum_Product_Subarray;

// https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1


import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

    static int matrixMultiplication(int[] arr) {
        int[][] matrix = new int[arr.length - 1][2];

        for (int i = 0; i < arr.length - 1; i++) {
            matrix[i] = new int[]{arr[i], arr[i + 1]};
        }

        int[][] dp = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            dp[i][i] = 0;
        }

        // We have to form triangular matrix here.
        /// Why ?
        // Because startIndex will always be <= endIndex
        // For startIndex==endIndex, we have filled the base case.

        for (int startIndex = matrix.length - 2; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < matrix.length; endIndex++) {
                int minOperations = Integer.MAX_VALUE;
                for (int i = startIndex; i < endIndex; i++) {
                    int leftMatricesMultiplication = dp[startIndex][i];
                    int rightMatricesMultiplication = dp[i + 1][endIndex];
                    int leftAndRightMatricesMultiplication = matrix[startIndex][0] * matrix[i][1] * matrix[endIndex][1];
                    minOperations = Math.min(minOperations, leftMatricesMultiplication + rightMatricesMultiplication + leftAndRightMatricesMultiplication);
                }
                dp[startIndex][endIndex] = minOperations;
            }
        }

        return dp[0][matrix.length - 1];
    }

//    static int matrixMultiplicationHelper(int startIndex, int endIndex, int[][] matrix, int[][] dp) {
//
//        if (startIndex == endIndex) {
//            return 0;
//        }
//
//        if (dp[startIndex][endIndex] != -1) {
//            return dp[startIndex][endIndex];
//        }
//
//        int minOperations = Integer.MAX_VALUE;
//
//        for (int i = startIndex; i < endIndex; i++) {
//            int leftMatricesMultiplication = matrixMultiplicationHelper(startIndex, i, matrix, dp);
//            int rightMatricesMultiplication = matrixMultiplicationHelper(i + 1, endIndex, matrix, dp);
//            // 1*2 2*3 3*4 4*5 5*6
//            // For sI=0, and i=1 ,Upper 2 Operations have given 2 matrices of size
//            // 1*3 and 3*6
//            // Now We have to add 1*3*6
//            int leftAndRightMatricesMultiplication = matrix[startIndex][0] * matrix[i][1] * matrix[endIndex][1];
//            minOperations = Math.min(minOperations, leftMatricesMultiplication + rightMatricesMultiplication + leftAndRightMatricesMultiplication);
//        }
//
//        dp[startIndex][endIndex] = minOperations;
//
//        return minOperations;
//    }
//
//    static int matrixMultiplication(int[] arr) {
//        int[][] matrix = new int[arr.length - 1][2];
//
//        for (int i = 0; i < arr.length - 1; i++) {
//            matrix[i] = new int[]{arr[i], arr[i + 1]};
//        }
//
//        int[][] dp = new int[matrix.length][matrix.length];
//
//        for (int i = 0; i < matrix.length; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//
//        return matrixMultiplicationHelper(0, matrix.length - 1, matrix, dp);
//    }

    // M1*M2*M3*M4

//    static int matrixMultiplicationHelper(int startIndex, int endIndex, int[][] matrix) {
//
//        if (startIndex == endIndex) {
//            return 0;
//        }
//
//        int minOperations = Integer.MAX_VALUE;
//
//        for (int i = startIndex; i < endIndex; i++) {
//            int leftMatricesMultiplication = matrixMultiplicationHelper(startIndex, i, matrix);
//            int rightMatricesMultiplication = matrixMultiplicationHelper(i + 1, endIndex, matrix);
//            // 1*2 2*3 3*4 4*5 5*6
//            // For sI=0, and i=1 ,Upper 2 Operations have given 2 matrices of size
//            // 1*3 and 3*6
//            // Now We have to add 1*3*6
//            int leftAndRightMatricesMultiplication = matrix[startIndex][0] * matrix[i][1] * matrix[endIndex][1];
//            minOperations = Math.min(minOperations, leftMatricesMultiplication + rightMatricesMultiplication + leftAndRightMatricesMultiplication);
//        }
//
//        return minOperations;
//    }
//
//    static int matrixMultiplication(int[] arr) {
//        int[][] matrix = new int[arr.length - 1][2];
//
//        for (int i = 0; i < arr.length - 1; i++) {
//            matrix[i] = new int[]{arr[i], arr[i + 1]};
//        }
//
//        return matrixMultiplicationHelper(0, matrix.length - 1, matrix);
//    }
}

/*
1
2 1 3 4
1
1 2 3 4 3
30
 */

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(Solution.matrixMultiplication(arr));
            System.out.println("~");
        }
    }
}