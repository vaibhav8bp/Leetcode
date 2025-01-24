package org.example.Daily._2025.January._23;

public class _1267_Count_Servers_that_Communicate {
    public int countServers(int[][] grid) {
        int rowCount = grid.length;
        int columnCount = grid[0].length;
        int[] rows = new int[rowCount];
        int[] columns = new int[columnCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    columns[j]++;
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (grid[i][j] == 1 && (rows[i] > 1 || columns[j] > 1)) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
