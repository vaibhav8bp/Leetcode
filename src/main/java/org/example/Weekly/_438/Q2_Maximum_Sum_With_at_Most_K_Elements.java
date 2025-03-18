package org.example.Weekly._438;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q2_Maximum_Sum_With_at_Most_K_Elements {
    public long maxSum(int[][] grid, int[] limits, int k) {

        int rows = grid.length;
        int columns = grid[0].length;

        for (int[] currentRow : grid) {
            Arrays.sort(currentRow);
        }

        PriorityQueue<Integer> maximumSumPQ = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < rows; i++) {
            int currentRowLimit = limits[i];
            for (int j = columns - 1; currentRowLimit != 0; j--, currentRowLimit--) {
                maximumSumPQ.add(grid[i][j]);
            }
        }

        long maxSum = 0;

        while (k != 0 && !maximumSumPQ.isEmpty()) {
            maxSum += maximumSumPQ.remove();
            k--;
        }

        return maxSum;
    }
}
