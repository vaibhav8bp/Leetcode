package org.example.Daily._2025.January._19;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/trapping-rain-water-ii/description/
public class _407_Trapping_Rain_Water_II {

    private final int[][] directions = {{-1, 0}, {0, +1}, {+1, 0}, {0, -1}};

    static class Helper {
        int currentRow;
        int currentColumn;
        int currentHeight;

        public Helper(int currentRow, int currentColumn, int currentHeight) {
            this.currentRow = currentRow;
            this.currentColumn = currentColumn;
            this.currentHeight = currentHeight;
        }
    }

    private boolean isIndexValid(int currentRow, int currentColumn, int rowCount, int columnCount) {
        return (currentRow >= 0 && currentRow < rowCount && currentColumn >= 0 && currentColumn < columnCount);
    }

    private void traverseRow(int currentRow, int[][] heightMap, PriorityQueue<Helper> minHeightPQ, boolean[][] visited) {
        for (int i = 0; i < heightMap[0].length; i++) {
            minHeightPQ.add(new Helper(currentRow, i, heightMap[currentRow][i]));
            visited[currentRow][i] = true;
        }
    }

    private void traverseColumn(int currentColumn, int[][] heightMap, PriorityQueue<Helper> minHeightPQ, boolean[][] visited) {
        // Using StartRow =1 and EndRow= rowCount -1 because while traversing both rows, first and last column
        // elements for their respective rows were also picked up.

        for (int i = 1; i < heightMap.length - 1; i++) {
            minHeightPQ.add(new Helper(i, currentColumn, heightMap[i][currentColumn]));
            visited[i][currentColumn] = true;
        }
    }

    private void traverseAllBoundaries(int[][] heightMap, PriorityQueue<Helper> minHeightPQ, boolean[][] visited) {
        traverseRow(0, heightMap, minHeightPQ, visited);
        traverseRow(heightMap.length - 1, heightMap, minHeightPQ, visited);
        traverseColumn(0, heightMap, minHeightPQ, visited);
        traverseColumn(heightMap[0].length - 1, heightMap, minHeightPQ, visited);
    }

    public int trapRainWater(int[][] heightMap) {

        Comparator<Helper> minHeightComparator = Comparator.comparingInt(o -> o.currentHeight);
        PriorityQueue<Helper> minHeightPQ = new PriorityQueue<>(minHeightComparator);
        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        traverseAllBoundaries(heightMap, minHeightPQ, visited);

        int totalWaterHeld = 0;

        while (!minHeightPQ.isEmpty()) {
            Helper leastWaterHeightBoundary = minHeightPQ.remove();

            for (int[] currentDirection : directions) {
                int newRow = leastWaterHeightBoundary.currentRow + currentDirection[0];
                int newColumn = leastWaterHeightBoundary.currentColumn + currentDirection[1];

                if (isIndexValid(newRow, newColumn, heightMap.length, heightMap[0].length) && !visited[newRow][newColumn]) {

                    // Water will only be added in case where water[newRow][newColumn] is < water[currentRow][currentColumn]

                    if (heightMap[newRow][newColumn] < leastWaterHeightBoundary.currentHeight) {
                        totalWaterHeld += (leastWaterHeightBoundary.currentHeight - heightMap[newRow][newColumn]);
                        // Adjust water[newRow][newColumn] to water[currentRow][currentColumn] as newRow,newColumn will
                        // hold some water now, so it's height is also increased.
                        heightMap[newRow][newColumn] = leastWaterHeightBoundary.currentHeight;
                    }

                    // Delegation, will happen in every case, i.e. add newRow,newColumn as boundary
                    minHeightPQ.add(new Helper(newRow, newColumn, heightMap[newRow][newColumn]));
                    visited[newRow][newColumn] = true;
                }
            }
        }

        return totalWaterHeld;
    }
}
