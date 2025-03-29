package org.example.Daily._2025.March._26;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/description/
public class _2033_Minimum_Operations_to_Make_a_Uni_Value_Grid {

    private int findMinOperationsToGetAllElementsEqualToX(int[] elements, int elementToBeAchieved, int x) {
        int operations = 0;

        for (Integer currentElement : elements) {
            if (Math.abs(currentElement - elementToBeAchieved) % x != 0) {
                return -1;
            }
            operations += Math.abs(currentElement - elementToBeAchieved) / x;
        }

        return operations;
    }

    public int minOperations(int[][] grid, int x) {

        int rows = grid.length;
        int columns = grid[0].length;
        int totalSize = rows * columns;

        int[] elements = new int[totalSize];
        int elementIndex = 0;

        for (int[] currentRow : grid) {
            for (int j = 0; j < columns; j++) {
                elements[elementIndex++] = currentRow[j];
            }
        }

        Arrays.sort(elements);

        if (elements.length % 2 != 0) {
            return findMinOperationsToGetAllElementsEqualToX(elements, elements[totalSize / 2], x);
        } else {
            // Doing either one is also fine, no need to do both.
            return Math.min(findMinOperationsToGetAllElementsEqualToX(elements, elements[(totalSize / 2) - 1], x), findMinOperationsToGetAllElementsEqualToX(elements, elements[totalSize / 2], x));
        }
    }
}
