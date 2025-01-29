package org.example.Daily._2025.January._28;

// https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/submissions/
public class _2658_Maximum_Number_of_Fish_in_a_Grid {

    // Down,Left,Right,Up
    private final int[][] directions = {{+1, 0}, {-1, 0}, {0, +1}, {0, -1}};

    private boolean isCurrentPositionValid(int currentRow, int currentColumn, int rowCount, int columnCount) {
        return (currentRow >= 0 && currentRow < rowCount && currentColumn >= 0 && currentColumn < columnCount);
    }

    private int findMaxFishHelper(int currentRow, int currentColumn, int rowCount, int columnCount, int[][] grid, boolean[][] visited) {
        visited[currentRow][currentColumn] = true;

        int answer = grid[currentRow][currentColumn];

        for (int[] currentDirection : directions) {
            int newRow = currentRow + currentDirection[0];
            int newColumn = currentColumn + currentDirection[1];

            if (!isCurrentPositionValid(newRow, newColumn, rowCount, columnCount) || grid[newRow][newColumn] == 0 || visited[newRow][newColumn]) {
                continue;
            }
            answer += findMaxFishHelper(newRow, newColumn, rowCount, columnCount, grid, visited);
        }

        // We cannot mark current position unvisited because same node will be counter again
        // if it comes in different path.
//        visited[currentRow][currentColumn] = false;

        return answer;
    }

    public int findMaxFish(int[][] grid) {

        int rowCount = grid.length;
        int columnCount = grid[0].length;

        boolean[][] visited = new boolean[rowCount][columnCount];

        int answer = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    answer = Math.max(answer, findMaxFishHelper(i, j, rowCount, columnCount, grid, visited));
                }
            }
        }

        return answer;
    }
}
