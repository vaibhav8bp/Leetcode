package org.example.Google;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/n-queens/description/
public class _51_N_Queens {
    private static boolean isColumnSafe(int currentColumn, boolean[] columns) {
        return !columns[currentColumn];
    }

    // \
    //  \
    //   \

    /*
    n = 4
       0 1 2 3
    0  3 2 1 0
    1  4 3 2 1
    2  5 4 3 2
    3  6 5 4 3

    So for each left diagonal (n-1)-(columnIndex-rowIndex) is unique.
     */
    private static boolean isLeftDiagonalSafe(int currentRow, int currentColumn, int n, boolean[] leftDiagonal) {
        return !leftDiagonal[(n - 1) - (currentColumn - currentRow)];
    }

    //   /
    //  /
    // /

    /*
    n = 4
       0 1 2 3
    0  0 1 2 3
    1  1 2 3 4
    2  2 3 4 5
    3  3 4 5 6

    So for each right diagonal (rowIndex+columnIndex) is unique.
     */

    private static boolean isRightDiagonalSafe(int currentRow, int currentColumn, boolean[] rightDiagonal) {
        return !rightDiagonal[currentRow + currentColumn];
    }

    private static boolean isSafeToPlaceQueenOnCurrentRowAndCurrentColumn(int currentRow, int currentColumn, int n, boolean[] columns, boolean[] leftDiagonal, boolean[] rightDiagonal) {
        return isColumnSafe(currentColumn, columns) &&
                isLeftDiagonalSafe(currentRow, currentColumn, n, leftDiagonal) &&
                isRightDiagonalSafe(currentRow, currentColumn, rightDiagonal);
    }

    private static List<String> characterArrayToListOfString(char[][] board, int n) {

        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder currentRow = new StringBuilder();
            for (int j = 0; j < n; j++) {
                currentRow.append(board[i][j]);
            }
            result.add(currentRow.toString());
        }

        return result;
    }

    private static void nQueenSolver(int currentRow, int n, char[][] currentBoard, List<List<String>> allBoards, boolean[] columns, boolean[] leftDiagonal, boolean[] rightDiagonal) {

        if (currentRow == n) {
            allBoards.add(characterArrayToListOfString(currentBoard, n));
            return;
        }

        for (int currentColumn = 0; currentColumn < n; currentColumn++) {
            if (isSafeToPlaceQueenOnCurrentRowAndCurrentColumn(currentRow, currentColumn, n, columns, leftDiagonal, rightDiagonal)) {
                columns[currentColumn] = true;
                leftDiagonal[(n - 1) - (currentColumn - currentRow)] = true;
                rightDiagonal[currentRow + currentColumn] = true;
                currentBoard[currentRow][currentColumn] = 'Q';
                nQueenSolver(currentRow + 1, n, currentBoard, allBoards, columns, leftDiagonal, rightDiagonal);
                columns[currentColumn] = false;
                leftDiagonal[(n - 1) - (currentColumn - currentRow)] = false;
                rightDiagonal[currentRow + currentColumn] = false;
                currentBoard[currentRow][currentColumn] = '.';
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        char[][] initialBoard = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                initialBoard[i][j] = '.';
            }
        }

        boolean[] columns = new boolean[n];
        boolean[] leftDiagonal = new boolean[2 * n - 1];
        boolean[] rightDiagonal = new boolean[2 * n - 1];

        List<List<String>> allBoards = new ArrayList<>();
        nQueenSolver(0, n, initialBoard, allBoards, columns, leftDiagonal, rightDiagonal);
        return allBoards;
    }

//    private static boolean isColumnSafe(int currentRow, int currentColumn, char[][] currentBoard) {
//        for (int i = currentRow - 1; i >= 0; i--) {
//            if (currentBoard[i][currentColumn] == 'Q') {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    // \
//    //  \
//    //   \
//    private static boolean isLeftDiagonalSafe(int currentRow, int currentColumn, char[][] currentBoard) {
//        currentRow -= 1;
//        currentColumn -= 1;
//
//        while (currentRow >= 0 && currentColumn >= 0) {
//            if (currentBoard[currentRow][currentColumn] == 'Q') {
//                return false;
//            }
//            currentRow -= 1;
//            currentColumn -= 1;
//        }
//
//        return true;
//    }
//
//    //   /
//    //  /
//    // /
//    private static boolean isRightDiagonalSafe(int currentRow, int currentColumn, int n, char[][] currentBoard) {
//        currentRow -= 1;
//        currentColumn += 1;
//
//        while (currentRow >= 0 && currentColumn < n) {
//            if (currentBoard[currentRow][currentColumn] == 'Q') {
//                return false;
//            }
//            currentRow -= 1;
//            currentColumn += 1;
//        }
//
//        return true;
//    }
//
//    private static boolean isSafeToPlaceQueenOnCurrentRowAndCurrentColumn(int currentRow, int currentColumn, int n, char[][] currentBoard) {
//        return isColumnSafe(currentRow, currentColumn, currentBoard) &&
//                isLeftDiagonalSafe(currentRow, currentColumn, currentBoard) &&
//                isRightDiagonalSafe(currentRow, currentColumn, n, currentBoard);
//    }
//
//    private static List<String> characterArrayToListOfString(char[][] board, int n) {
//
//        List<String> result = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            StringBuilder currentRow = new StringBuilder();
//            for (int j = 0; j < n; j++) {
//                currentRow.append(board[i][j]);
//            }
//            result.add(currentRow.toString());
//        }
//
//        return result;
//    }
//
//    private static void nQueenSolver(int currentRow, int n, char[][] currentBoard, List<List<String>> allBoards) {
//
//        if (currentRow == n) {
//            allBoards.add(characterArrayToListOfString(currentBoard, n));
//            return;
//        }
//
//        for (int currentColumn = 0; currentColumn < n; currentColumn++) {
//            if (isSafeToPlaceQueenOnCurrentRowAndCurrentColumn(currentRow, currentColumn, n, currentBoard)) {
//                currentBoard[currentRow][currentColumn] = 'Q';
//                nQueenSolver(currentRow + 1, n, currentBoard, allBoards);
//                currentBoard[currentRow][currentColumn] = '.';
//            }
//        }
//    }
//
//    public static List<List<String>> solveNQueens(int n) {
//        char[][] initialBoard = new char[n][n];
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                initialBoard[i][j] = '.';
//            }
//        }
//
//        List<List<String>> allBoards = new ArrayList<>();
//        nQueenSolver(0, n, initialBoard, allBoards);
//        return allBoards;
//    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(1));
    }
}
