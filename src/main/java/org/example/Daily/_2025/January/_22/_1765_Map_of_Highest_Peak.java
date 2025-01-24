package org.example.Daily._2025.January._22;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/map-of-highest-peak/
public class _1765_Map_of_Highest_Peak {

    private boolean isIndexValid(int currentRow, int rowCount, int currentColumn, int columnCount) {
        return (currentRow >= 0 && currentRow < rowCount && currentColumn >= 0 && currentColumn < columnCount);
    }

    private final int[][] directions = {{+1, 0}, {-1, 0}, {0, +1}, {0, -1}};

    public int[][] highestPeak(int[][] isWater) {
        int[][] heights = new int[isWater.length][isWater[0].length];

        Queue<int[]> indexQueue = new LinkedList<>();

        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) {
                    indexQueue.add(new int[]{i, j});
                } else {
                    // To mark unvisited
                    heights[i][j] = -1;
                }
            }
        }

        while (!indexQueue.isEmpty()) {
            int[] front = indexQueue.remove();

            for (int[] currentDirection : directions) {
                int newRow = front[0] + currentDirection[0];
                int newColumn = front[1] + currentDirection[1];

                if (isIndexValid(newRow, isWater.length, newColumn, isWater[0].length) && heights[newRow][newColumn] == -1) {
                    // Why we don't have to check for newRow,newColumn neighbors is because that
                    // we are traversing in BFS fashion, and we are filling heights in increasing order.
                    heights[newRow][newColumn] = heights[front[0]][front[1]] + 1;
                    indexQueue.add(new int[]{newRow, newColumn});
                }
            }
        }

        return heights;
    }
}