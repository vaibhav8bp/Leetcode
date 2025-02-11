package org.example.Weekly._436;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// https://leetcode.com/problems/sort-matrix-by-diagonals/
public class _3446_Sort_Matrix_by_Diagonals {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        // Left Bottom Triangle to be sorted in Decreasing Order
        for (int startingRow = 0; startingRow < n - 1; startingRow++) {

            int currentDiagonalRow = startingRow;
            int currentDiagonalColumn = 0;
            List<Integer> valuesInCurrentDiagonal = new ArrayList<>();
            while (currentDiagonalColumn < n) {
                valuesInCurrentDiagonal.add(grid[currentDiagonalRow++][currentDiagonalColumn++]);
            }

            valuesInCurrentDiagonal.sort(Comparator.reverseOrder());

            currentDiagonalRow = startingRow;
            currentDiagonalColumn = 0;
            int index = 0;
            while (currentDiagonalColumn < n) {
                grid[currentDiagonalRow++][currentDiagonalColumn++] = valuesInCurrentDiagonal.get(index++);
            }
        }

        // Right Top Triangle to be sorted in Increasing Order
        for (int startingColumn = 1; startingColumn < n - 1; startingColumn++) {
            int currentDiagonalColumn = startingColumn;
            int currentDiagonalRow = 0;

            List<Integer> valuesInCurrentDiagonal = new ArrayList<>();
            while (currentDiagonalRow < n) {
                valuesInCurrentDiagonal.add(grid[currentDiagonalRow++][currentDiagonalColumn++]);
            }

            valuesInCurrentDiagonal.sort(Comparator.naturalOrder());

            currentDiagonalColumn = startingColumn;
            currentDiagonalRow = 0;
            int index = 0;
            while (currentDiagonalRow < n) {
                grid[currentDiagonalRow++][currentDiagonalColumn++] = valuesInCurrentDiagonal.get(index++);
            }
        }

        return grid;
    }
}