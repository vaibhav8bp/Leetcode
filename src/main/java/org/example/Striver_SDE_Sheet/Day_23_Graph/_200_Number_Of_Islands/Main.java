package org.example.Striver_SDE_Sheet.Day_23_Graph._200_Number_Of_Islands;

class Solution {

    int[][] directions = {{-1, 0}, {0, +1}, {+1, 0}, {0, -1}};

    private boolean isValidIndex(int currentRow, int currentColumn, int rows, int columns) {
        return (currentRow >= 0 && currentRow < rows && currentColumn >= 0 && currentColumn < columns);
    }

    private void numIslands(char[][] grid, int currentRow, int currentColumn, boolean[][] visited) {
        visited[currentRow][currentColumn] = true;
        int rows = grid.length;
        int columns = grid[0].length;

        for (int[] direction : directions) {
            int newRow = currentRow + direction[0];
            int newColumn = currentColumn + direction[1];

            if (isValidIndex(newRow, newColumn, rows, columns) && !visited[newRow][newColumn] && grid[newRow][newColumn] == '1') {
                numIslands(grid, newRow, newColumn, visited);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int count = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    numIslands(grid, i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}