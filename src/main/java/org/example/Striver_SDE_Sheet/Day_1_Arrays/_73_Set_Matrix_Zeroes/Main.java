package org.example.Striver_SDE_Sheet.Day_1_Arrays._73_Set_Matrix_Zeroes;

import java.util.Arrays;

// https://leetcode.com/problems/set-matrix-zeroes/description/
class Solution {

    // Brute Force
//    private void zeroesSetter(int[][] matrix, int currentRow, int currentColumn) {
//        // Row
//        Arrays.fill(matrix[currentRow], 0);
//        // Column
//        for (int i = 0; i < matrix.length; i++) {
//            matrix[i][currentColumn] = 0;
//        }
//    }
//
//    public void setZeroes(int[][] matrix) {
//        boolean[][] originalZeroes = new boolean[matrix.length][];
//        for (int i = 0; i < matrix.length; i++) {
//            originalZeroes[i] = new boolean[matrix[i].length];
//            Arrays.fill(originalZeroes[i], false);
//            for (int j = 0; j < matrix[i].length; j++) {
//                if (matrix[i][j] == 0) {
//                    originalZeroes[i][j] = true;
//                }
//            }
//        }
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                if (originalZeroes[i][j]) {
//                    zeroesSetter(matrix, i, j);
//                }
//            }
//        }
//    }

    // Optimal (Constant Space)

    public void setZeroes(int[][] matrix) {
        boolean isFirstRow0 = false, isFirstColumn0 = false;

        // Mark the isRow0 and isColumn0 variables

        // Traverse in 1st Row
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                isFirstRow0 = true;
                break;
            }
        }

        // Traverse in 1st Column

        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                isFirstColumn0 = true;
                break;
            }
        }

        // Mark the 1st row and 1st column 0 if any corresponding cell is 0. Acts an indicator entire row/column will be 0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Now based on above loop marked 0th row and 0th column values mark 0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Now only 1st row and column remains, set them to 0 based on row0 and col0 variables.

        if (isFirstRow0) {
            Arrays.fill(matrix[0], 0);
        }

        if (isFirstColumn0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        new Solution().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
