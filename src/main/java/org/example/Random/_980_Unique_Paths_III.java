package org.example.Random;

// https://leetcode.com/problems/unique-paths-iii/description/
public class _980_Unique_Paths_III {

    private static final int[][] directions = {{-1, 0}, {0, +1}, {+1, 0}, {0, -1}};

    private static boolean isIndexValid(int currentRow, int currentColumn, int rowCount, int columnCount) {
        return (currentRow >= 0 && currentRow < rowCount && currentColumn >= 0 && currentColumn < columnCount);
    }

    private static int uniquePathsIII(int currentRow, int currentColumn, int endingRow, int endingColumn, int rowCount, int columnCount, int currentEmptyPointsTraversed,
                                      int numberOfEmptyPoints, boolean[][] visited, int[][] grid) {

        if (currentRow == endingRow && currentColumn == endingColumn) {
            if (currentEmptyPointsTraversed == numberOfEmptyPoints) {
                return 1;
            } else {
                return 0;
            }
        }

        int totalWays = 0;
        visited[currentRow][currentColumn] = true;
        if (grid[currentRow][currentColumn] == 0) {
            currentEmptyPointsTraversed++;
        }

        for (int[] currentDirection : directions) {
            int newRow = currentRow + currentDirection[0];
            int newColumn = currentColumn + currentDirection[1];

            if (isIndexValid(newRow, newColumn, rowCount, columnCount) && !visited[newRow][newColumn] && grid[newRow][newColumn] != -1) {
                totalWays += uniquePathsIII(newRow, newColumn, endingRow, endingColumn, rowCount, columnCount, currentEmptyPointsTraversed, numberOfEmptyPoints, visited, grid);
            }
        }

        visited[currentRow][currentColumn] = false;
        return totalWays;
    }

    public static int uniquePathsIII(int[][] grid) {

        int rowCount = grid.length;
        int columnCount = grid[0].length;

        int startingRow = -1;
        int startingColumn = -1;

        int endingRow = -1;
        int endingColumn = -1;

        int numberOfEmptyPoints = 0;
        int numberOfObstaclePoints = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                // Starting Point
                if (grid[i][j] == 1) {
                    startingRow = i;
                    startingColumn = j;
                }
                // Ending Point
                else if (grid[i][j] == 2) {
                    endingRow = i;
                    endingColumn = j;
                }
                // Empty Point
                else if (grid[i][j] == 0) {
                    numberOfEmptyPoints++;
                }
                // Obstacle
                else {
                    numberOfObstaclePoints++;
                }
            }
        }

        // All intermediate points are obstacles
        if (numberOfObstaclePoints != 0 && numberOfObstaclePoints == ((rowCount * columnCount) - 2)) {
            return 0;
        }

        boolean[][] visited = new boolean[rowCount][columnCount];
        return uniquePathsIII(startingRow, startingColumn, endingRow, endingColumn, rowCount, columnCount, 0,
                numberOfEmptyPoints, visited, grid);
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1}, {0, 2}};
        System.out.println(uniquePathsIII(grid));
    }
}