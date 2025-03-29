package org.example.Striver_Youtube.DP._12;

import java.util.Scanner;

// https://www.geeksforgeeks.org/problems/path-in-matrix3805/1
public class Maximum_path_sum_in_matrix {

    private final int[][] directions = {{+1, -1}, {+1, 0}, {+1, +1}};

    private boolean isCurrentPositionValid(int currentRow, int currentColumn, int rowCount, int columnCount) {
        return (currentRow < rowCount && currentColumn >= 0 && currentColumn < columnCount);
    }

    public int maximumPath(int[][] mat) {
        int rows = mat.length;
        int columns = mat[0].length;

        int[] previousDP = new int[columns];

        // Last Row Mai Jaha se bhi start karoge wahi answer hoga
        System.arraycopy(mat[rows - 1], 0, previousDP, 0, columns);

        for (int i = rows - 2; i >= 0; i--) {
            int[] currentDP = new int[columns];
            for (int j = 0; j < columns; j++) {
                int currentCost = mat[i][j];
                for (int[] currentDirection : directions) {
                    int newRow = i + currentDirection[0];
                    int newColumn = j + currentDirection[1];
                    if (isCurrentPositionValid(newRow, newColumn, rows, columns)) {
                        currentDP[j] = Math.max(currentDP[j], currentCost + previousDP[newColumn]);
                    }
                }
            }
            previousDP = currentDP;
        }

        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < columns; i++) {
            answer = Math.max(answer, previousDP[i]);
        }

        return answer;
    }

//    private final int[][] directions = {{+1, -1}, {+1, 0}, {+1, +1}};
//
//    private boolean isCurrentPositionValid(int currentRow, int currentColumn, int rowCount, int columnCount) {
//        return (currentRow < rowCount && currentColumn >= 0 && currentColumn < columnCount);
//    }
//
//    private int maximumPath(int currentRow, int currentColumn, int rows, int columns, int[][] mat, int[][] dp) {
//
//        if (dp[currentRow][currentColumn] != -1) {
//            return dp[currentRow][currentColumn];
//        }
//
//        int maxRecursiveCost = 0;
//
//        for (int[] currentDirection : directions) {
//            int newRow = currentRow + currentDirection[0];
//            int newColumn = currentColumn + currentDirection[1];
//
//            if (isCurrentPositionValid(newRow, newColumn, rows, columns)) {
//                maxRecursiveCost = Math.max(maxRecursiveCost, maximumPath(newRow, newColumn, rows, columns, mat, dp));
//            }
//        }
//
//        dp[currentRow][currentColumn] = mat[currentRow][currentColumn] + maxRecursiveCost;
//        return dp[currentRow][currentColumn];
//    }
//
//    public int maximumPath(int[][] mat) {
//        int rows = mat.length;
//        int columns = mat[0].length;
//
//        int answer = Integer.MIN_VALUE;
//
//        int[][] dp = new int[rows][columns];
//
//        for (int i = 0; i < rows; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//
//        for (int i = 0; i < columns; i++) {
//            answer = Math.max(answer, maximumPath(0, i, rows, columns, mat, dp));
//        }
//
//        return answer;
//    }

//    private final int[][] directions = {{+1, -1}, {+1, 0}, {+1, +1}};
//
//    private boolean isCurrentPositionValid(int currentRow, int currentColumn, int rowCount, int columnCount) {
//        return (currentRow < rowCount && currentColumn >= 0 && currentColumn < columnCount);
//    }
//
//    private int maximumPath(int currentRow, int currentColumn, int rows, int columns, int[][] mat) {
//
//        int currentCost = mat[currentRow][currentColumn];
//        int maxRecursiveCost = 0;
//
//        for (int[] currentDirection : directions) {
//            int newRow = currentRow + currentDirection[0];
//            int newColumn = currentColumn + currentDirection[1];
//
//            if (isCurrentPositionValid(newRow, newColumn, rows, columns)) {
//                maxRecursiveCost = Math.max(maxRecursiveCost, maximumPath(newRow, newColumn, rows, columns, mat));
//            }
//        }
//
//        return currentCost + maxRecursiveCost;
//    }
//
//    public int maximumPath(int[][] mat) {
//        int rows = mat.length;
//        int columns = mat[0].length;
//
//        int answer = Integer.MIN_VALUE;
//
//        for (int i = 0; i < columns; i++) {
//            answer = Math.max(answer, maximumPath(0, i, rows, columns, mat));
//        }
//
//        return answer;
//    }
}

class gfg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            int[][] mat = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            Maximum_path_sum_in_matrix ob = new Maximum_path_sum_in_matrix();
            System.out.println(ob.maximumPath(mat));
            System.out.println("~");
        }
    }
}

/*
1
3 3
3 6 1
2 3 4
5 5 1
 */