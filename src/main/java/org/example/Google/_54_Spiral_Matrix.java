package org.example.Google;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/description/
public class _54_Spiral_Matrix {

    private void traverseRowForwards(int currentRow, int startingColumn, int endingColumn, int[][] matrix, List<Integer> answer) {
        for (int i = startingColumn; i <= endingColumn; i++) {
            answer.add(matrix[currentRow][i]);
        }
    }

    private void traverseColumnDownwards(int currentColumn, int startingRow, int endingRow, int[][] matrix, List<Integer> answer) {
        for (int i = startingRow; i <= endingRow; i++) {
            answer.add(matrix[i][currentColumn]);
        }
    }

    private void traverseRowBackwards(int currentRow, int startingColumn, int endingColumn, int[][] matrix, List<Integer> answer) {
        for (int i = endingColumn; i >= startingColumn; i--) {
            answer.add(matrix[currentRow][i]);
        }
    }

    private void traverseColumnUpwards(int currentColumn, int startingRow, int endingRow, int[][] matrix, List<Integer> answer) {
        for (int i = endingRow; i >= startingRow; i--) {
            answer.add(matrix[i][currentColumn]);
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> answer = new ArrayList<>();

        int rows = matrix.length;
        int columns = matrix[0].length;

        int startingRow = 0;
        int endingRow = rows - 1;
        int startingColumn = 0;
        int endingColumn = columns - 1;

        while (startingRow <= endingRow && startingColumn <= endingColumn) {
            traverseRowForwards(startingRow, startingColumn, endingColumn, matrix, answer);
            startingRow++;
            traverseColumnDownwards(endingColumn, startingRow, endingRow, matrix, answer);
            endingColumn--;
            if (startingRow <= endingRow) {
                traverseRowBackwards(endingRow, startingColumn, endingColumn, matrix, answer);
            }
            endingRow--;
            if (startingColumn <= endingColumn) {
                traverseColumnUpwards(startingColumn, startingRow, endingRow, matrix, answer);
            }
            startingColumn++;
        }

        return answer;
    }
}
