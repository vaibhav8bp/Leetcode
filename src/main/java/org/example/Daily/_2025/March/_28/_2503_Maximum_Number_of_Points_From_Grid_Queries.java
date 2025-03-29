package org.example.Daily._2025.March._28;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/maximum-number-of-points-from-grid-queries/description/
public class _2503_Maximum_Number_of_Points_From_Grid_Queries {

    private static final int[][] directions = {{+1, 0}, {0, +1}, {0, -1}, {-1, 0}};

    private static boolean isCurrentPositionValid(int currentRow, int currentColumn, int rowCount, int columnCount) {
        return ((currentRow >= 0) && (currentRow < rowCount) && (currentColumn >= 0) && (currentColumn < columnCount));
    }

    public static int[] maxPoints(int[][] grid, int[] queries) {

        int rowCount = grid.length;
        int columnCount = grid[0].length;
        int[] result = new int[queries.length];

        boolean[][] visited = new boolean[rowCount][columnCount];
        PriorityQueue<int[]> minPQ = new PriorityQueue<>(Comparator.comparingInt(o -> grid[o[0]][o[1]]));

        minPQ.add(new int[]{0, 0});

        int[][] queriesWithIndex = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            queriesWithIndex[i][0] = queries[i];
            queriesWithIndex[i][1] = i;
        }

        Arrays.sort(queriesWithIndex, Comparator.comparingInt(o -> o[0]));
        int queryIndex = 0;
        int elementsProcessedTillNow = 0;

        while (!minPQ.isEmpty()) {
            int[] front = minPQ.remove();
            int frontRow = front[0];
            int frontColumn = front[1];

            if (visited[frontRow][frontColumn]) {
                continue;
            }

            visited[frontRow][frontColumn] = true;

            while (grid[frontRow][frontColumn] >= queriesWithIndex[queryIndex][0]) {
                result[queriesWithIndex[queryIndex][1]] = elementsProcessedTillNow;
                queryIndex++;
                if (queryIndex == queriesWithIndex.length) {
                    return result;
                }
            }

            elementsProcessedTillNow++;

            for (int[] currentDirection : directions) {
                int newRow = frontRow + currentDirection[0];
                int newColumn = frontColumn + currentDirection[1];
                if (isCurrentPositionValid(newRow, newColumn, rowCount, columnCount) && !visited[newRow][newColumn]) {
                    minPQ.add(new int[]{newRow, newColumn});
                }
            }
        }

        for (int i = queryIndex; i < queriesWithIndex.length; i++) {
            result[queriesWithIndex[i][1]] = elementsProcessedTillNow;
        }

        return result;
    }

//    private static final int[][] directions = {{+1, 0}, {0, +1}, {0, -1}, {-1, 0}};
//
//    private static boolean isCurrentPositionValid(int currentRow, int currentColumn, int rowCount, int columnCount) {
//        return ((currentRow >= 0) && (currentRow < rowCount) && (currentColumn >= 0) && (currentColumn < columnCount));
//    }
//
//    private static int maxPoints(int currentRow, int currentColumn, int rowCount, int columnCount, int[][] grid, int maxElement, boolean[][] visited) {
//
//        int answer = 1;
//
//        visited[currentRow][currentColumn] = true;
//
//        for (int[] currentDirection : directions) {
//            int newRow = currentRow + currentDirection[0];
//            int newColumn = currentColumn + currentDirection[1];
//
//            if (isCurrentPositionValid(newRow, newColumn, rowCount, columnCount) && !visited[newRow][newColumn] && grid[newRow][newColumn] < maxElement) {
//                answer += (maxPoints(newRow, newColumn, rowCount, columnCount, grid, maxElement, visited));
//            }
//        }
//
//        return answer;
//    }
//
//    public static int[] maxPoints(int[][] grid, int[] queries) {
//
//        int rowCount = grid.length;
//        int columnCount = grid[0].length;
//        int[] result = new int[queries.length];
//        boolean[][] visited = new boolean[rowCount][columnCount];
//        for (int i = 0; i < queries.length; i++) {
//            if (grid[0][0] < queries[i]) {
//                result[i] = maxPoints(0, 0, rowCount, columnCount, grid, queries[i], visited);
//                for (int j = 0; j < rowCount; j++) {
//                    Arrays.fill(visited[j],false);
//                }
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {2, 5, 7}, {3, 5, 1}};
        int[] queries = {5, 6, 2};
        System.out.println(Arrays.toString(maxPoints(grid, queries)));
    }
}