package org.example.Google;

// https://leetcode.com/problems/maximal-square/description/
public class _221_Maximal_Square {

    public static int maximalSquare(char[][] matrix) {

        int columns = matrix[0].length;
        int[] dp = new int[columns];

        int maxSquare = 0;

        for (char[] currentRow : matrix) {
            int topLeftCell = 0;
            for (int j = 0; j < columns; j++) {
                int temp = dp[j];
                if (currentRow[j] == '1') {
                    if (j == 0) {
                        // Because for 1st Column , no left and top left columns are there.
                        dp[j] = 1;
                    } else {
                        // dp[j] before updating represents top right cell.
                        // dp[j-1] represents left cell.
                        // prev represents top left cell. How ?
                        // before updating dp[j] , it represents dp[i-1][j] of 2D DP.
                        // So for next iteration it becomes dp[i-1][j-1]
                        dp[j] = 1 + Math.min(dp[j], Math.min(topLeftCell, dp[j - 1]));
                    }
                    maxSquare = Math.max(maxSquare, dp[j]);
                } else {
                    dp[j] = 0;
                }
                topLeftCell = temp;
            }
        }

        return maxSquare * maxSquare;
    }

//    public static int maximalSquare(char[][] matrix) {
//        int rows = matrix.length;
//        int columns = matrix[0].length;
//
//        int[][] dp = new int[rows][columns];
//
//        int maxSquare = 0;
//
//        for (int i = 0; i < rows; i++) {
//            dp[i][0] = (matrix[i][0] == '1' ? 1 : 0);
//            maxSquare = Math.max(maxSquare, dp[i][0]);
//        }
//
//        for (int i = 0; i < columns; i++) {
//            dp[0][i] = (matrix[0][i] == '1' ? 1 : 0);
//            maxSquare = Math.max(maxSquare, dp[0][i]);
//        }
//
//        for (int i = 1; i < rows; i++) {
//            for (int j = 1; j < columns; j++) {
//                if (matrix[i][j] == '1') {
//                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
//                    maxSquare = Math.max(dp[i][j], maxSquare);
//                }
//            }
//        }
//
//        return maxSquare * maxSquare;
//    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {
                '1', '0', '0', '1', '0'}};

        System.out.println(maximalSquare(matrix));
    }
}
