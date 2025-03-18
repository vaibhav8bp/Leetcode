package org.example.Striver_SDE_Sheet.Day_10_Recursion_And_BackTracking._51_N_Queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 import java.util.stream.Stream;

// Brute Force
//    boolean isQueenAllowedHere(int currentRow, int currentColumn, int n, char[][] board, boolean[] top, boolean[] leftDiagonal, boolean[] rightDiagonal) {
//        // Check In Column
//        for (int i = 0; i <= currentRow - 1; i++) {
//            if (Objects.equals(board[i][currentColumn], 'Q')) {
//                return false;
//            }
//        }
//
//
//        // Check In Left Diagonal
//        for (int i = currentRow - 1, j = currentColumn - 1; i >= 0 && j >= 0; i--, j--) {
//            if (Objects.equals(board[i][j], 'Q')) {
//                return false;
//            }
//        }
//
//        // Check In Right Diagonal
//        for (int i = currentRow - 1, j = currentColumn + 1; i >= 0 && j < n; i--, j++) {
//            if (Objects.equals(board[i][j], 'Q')) {
//                return false;
//            }
//        }
//
//        return true;
//    }

class Solution {

    boolean isQueenAllowedHere(int currentRow, int currentColumn, int n, char[][] board, boolean[] top, boolean[] leftDiagonal, boolean[] rightDiagonal) {
        if (top[currentColumn]) {
            return false;
        }

        if (rightDiagonal[currentRow + currentColumn]) {
            return false;
        }

        return !leftDiagonal[currentRow - currentColumn + n - 1];
    }

    void solveNQueensHelper(int n, int currentRow, char[][] board, List<List<String>> finalResult, boolean[] top, boolean[] leftDiagonal, boolean[] rightDiagonal) {
        if (currentRow == n) {
            List<String> currentAnswer = Stream.of(board)
                    .map(String::copyValueOf)
                    .toList();
            finalResult.add(new ArrayList<>(currentAnswer));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isQueenAllowedHere(currentRow, i, n, board, top, leftDiagonal, rightDiagonal)) {
                top[i] = true;
                leftDiagonal[currentRow - i + n - 1] = true;
                rightDiagonal[currentRow + i] = true;
                board[currentRow][i] = 'Q';
                solveNQueensHelper(n, currentRow + 1, board, finalResult, top, leftDiagonal, rightDiagonal);
                board[currentRow][i] = '.';
                top[i] = false;
                leftDiagonal[currentRow - i + n - 1] = false;
                rightDiagonal[currentRow + i] = false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        boolean[] top = new boolean[n];
        Arrays.fill(top, false);
        boolean[] leftDiagonal = new boolean[2 * n - 1];
        Arrays.fill(leftDiagonal, false);
        boolean[] rightDiagonal = new boolean[2 * n - 1];
        Arrays.fill(rightDiagonal, false);
        List<List<String>> finalList = new ArrayList<>();
        solveNQueensHelper(n, 0, board, finalList, top, leftDiagonal, rightDiagonal);
        return finalList;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(4));
    }
}
