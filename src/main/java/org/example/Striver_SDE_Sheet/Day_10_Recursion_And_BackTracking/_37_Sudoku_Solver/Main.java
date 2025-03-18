package org.example.Striver_SDE_Sheet.Day_10_Recursion_And_BackTracking._37_Sudoku_Solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public boolean isNumberAllowedAtCurrentPosition(char currentNumber, int currentRow, int currentColumn, char[][] board) {

        // Check In Row
        for (int i = 0; i < 9; i++) {
            if (board[currentRow][i] == currentNumber) {
                return false;
            }
        }

        // Check In Column
        for (int i = 0; i < 9; i++) {
            if (board[i][currentColumn] == currentNumber) {
                return false;
            }
        }

        // Check In Box
        int rowBoxIndex = currentRow / 3;
        int columnBoxIndex = currentColumn / 3;
        int startingRowIndex = rowBoxIndex * 3;
        int startingColumnIndex = columnBoxIndex * 3;

        for (int i = startingRowIndex; i <= startingRowIndex + 2; i++) {
            for (int j = startingColumnIndex; j <= startingColumnIndex + 2; j++) {
                if (board[i][j] == currentNumber) {
                    return false;
                }
            }
        }

        return true;
    }

    public List<Integer> findEmptyPosition(char[][] board) {

        List<Integer> index = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    index.add(i);
                    index.add(j);
                    return index;
                }
            }
        }

        return index;
    }


    public boolean solveSudokuHelper(char[][] board) {

        List<Integer> emptyPositionIndex = findEmptyPosition(board);
        if (emptyPositionIndex.isEmpty()) {
            return true;
        }

        int currentRow = emptyPositionIndex.getFirst();
        int currentColumn = emptyPositionIndex.get(1);

        for (int k = 1; k <= 9; k++) {
            if (isNumberAllowedAtCurrentPosition((char) (48 + k), currentRow, currentColumn, board)) {
                board[currentRow][currentColumn] = (char) (48 + k);
                boolean answer = solveSudokuHelper(board);
                if (answer) {
                    return true;
                }
                board[currentRow][currentColumn] = '.';
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }
}

public class Main {
    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {
                '6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {
                '8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {
                '7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {
                '.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        Solution solution = new Solution();
        solution.solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }
}
