package org.example.Daily._2025.January._31;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/making-a-large-island/description/
public class _827_Making_A_Large_Island {

    int[][] directions = {{-1, 0}, {+1, 0}, {0, +1}, {0, -1}};

    private boolean isCurrentGridPositionValid(int currentRow, int currentColumn, int rowCount, int columnCount) {
        return (currentRow >= 0 && currentRow < rowCount && currentColumn >= 0 && currentColumn < columnCount);
    }

    private int currentIslandLength(int currentRow, int currentColumn, int rowCount, int columnCount, int currentRegion, int[][] grid) {
        // No need of visited because we are modifying the original grid.

        int currentIslandLength = 1;
        grid[currentRow][currentColumn] = currentRegion;

        for (int[] currentDirection : directions) {
            int newRow = currentRow + currentDirection[0];
            int newColumn = currentColumn + currentDirection[1];

            if (!isCurrentGridPositionValid(newRow, newColumn, rowCount, columnCount) || grid[newRow][newColumn] != 1) {
                continue;
            }

            currentIslandLength += currentIslandLength(newRow, newColumn, rowCount, columnCount, currentRegion, grid);
        }

        return currentIslandLength;
    }

    private int largestIslandHelper(int rowCount, int columnCount, int[][] grid, Map<Integer, Integer> regionToAreaMapper) {

        // No need of visited because we are modifying the original grid.
        int maxLength = 0;
        // To avoid collision with 0 or 1
        int currentRegion = 2;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (grid[i][j] == 1) {
                    int currentIsLandLength = currentIslandLength(i, j, rowCount, columnCount, currentRegion, grid);
                    regionToAreaMapper.put(currentRegion, currentIsLandLength);
                    maxLength = Math.max(maxLength, currentIsLandLength);
                    currentRegion++;
                }
            }
        }

        return maxLength;
    }

    public int largestIsland(int[][] grid) {
        int rowCount = grid.length;
        int columnCount = grid[0].length;

        Map<Integer, Integer> regionToAreaMapper = new HashMap<>();
        int maxIslandLength = largestIslandHelper(rowCount, columnCount, grid, regionToAreaMapper);

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> surroundingRegions = new HashSet<>();
                    for (int[] currentDirection : directions) {
                        int newRow = i + currentDirection[0];
                        int newColumn = j + currentDirection[1];
                        if (!isCurrentGridPositionValid(newRow, newColumn, rowCount, columnCount) || grid[newRow][newColumn] == 0) {
                            continue;
                        }
                        surroundingRegions.add(grid[newRow][newColumn]);
                    }

                    int currentTotalArea = 1;

                    for (Integer currentRegion : surroundingRegions) {
                        currentTotalArea += regionToAreaMapper.get(currentRegion);
                    }

                    maxIslandLength = Math.max(maxIslandLength, currentTotalArea);
                }
            }
        }
        return maxIslandLength;
    }

    // Brute Force
//    int[][] directions = {{-1, 0}, {+1, 0}, {0, +1}, {0, -1}};
//
//    private boolean isCurrentGridPositionValid(int currentRow, int currentColumn, int rowCount, int columnCount) {
//        return (currentRow >= 0 && currentRow < rowCount && currentColumn >= 0 && currentColumn < columnCount);
//    }
//
//    private boolean doesGridHaveNoWater(int[][] grid, int rowCount, int columnCount) {
//        for (int i = 0; i < rowCount; i++) {
//            for (int j = 0; j < columnCount; j++) {
//                if (grid[i][j] == 0) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    private int currentIslandLength(int currentRow, int currentColumn, int rowCount, int columnCount, boolean[][] visited, int[][] grid) {
//        visited[currentRow][currentColumn] = true;
//
//        int currentIslandLength = 1;
//
//        for (int[] currentDirection : directions) {
//            int newRow = currentRow + currentDirection[0];
//            int newColumn = currentColumn + currentDirection[1];
//
//            if (!isCurrentGridPositionValid(newRow, newColumn, rowCount, columnCount) || visited[newRow][newColumn] || grid[newRow][newColumn] != 1) {
//                continue;
//            }
//
//            currentIslandLength += currentIslandLength(newRow, newColumn, rowCount, columnCount, visited, grid);
//        }
//
//        return currentIslandLength;
//    }
//
//    private int largestIslandHelper(int rowCount, int columnCount, int[][] grid) {
//        boolean[][] visited = new boolean[rowCount][columnCount];
//
//        int maxLength = 0;
//
//        for (int i = 0; i < rowCount; i++) {
//            for (int j = 0; j < columnCount; j++) {
//                if (!visited[i][j] && grid[i][j] == 1) {
//                    maxLength = Math.max(maxLength, currentIslandLength(i, j, rowCount, columnCount, visited, grid));
//                }
//            }
//        }
//
//        return maxLength;
//    }
//
//    public int largestIsland(int[][] grid) {
//        int rowCount = grid.length;
//        int columnCount = grid[0].length;
//
//        int normalFlowLargestIslandLength = largestIslandHelper(rowCount, columnCount, grid);
//        // Just Find Largest Island in Grid
//        if (doesGridHaveNoWater(grid, rowCount, columnCount)) {
//            return normalFlowLargestIslandLength;
//        } else {
//            int maxIslandLength = normalFlowLargestIslandLength;
//            for (int i = 0; i < rowCount; i++) {
//                for (int j = 0; j < columnCount; j++) {
//                    if (grid[i][j] == 0) {
//                        grid[i][j] = 1;
//                        maxIslandLength = Math.max(maxIslandLength, currentIslandLength(i, j, rowCount, columnCount, new boolean[rowCount][columnCount], grid));
//                        grid[i][j] = 0;
//                    }
//                }
//            }
//            return maxIslandLength;
//        }
//    }
}
