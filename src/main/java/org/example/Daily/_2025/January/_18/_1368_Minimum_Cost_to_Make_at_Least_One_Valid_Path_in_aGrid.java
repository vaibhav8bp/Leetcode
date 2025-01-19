package org.example.Daily._2025.January._18;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/
class Helper {
    int currentRow;
    int currentColumn;
    int currentCost;

    public Helper(int currentRow, int currentColumn, int currentCost) {
        this.currentRow = currentRow;
        this.currentColumn = currentColumn;
        this.currentCost = currentCost;
    }
}

public class _1368_Minimum_Cost_to_Make_at_Least_One_Valid_Path_in_aGrid {

    private final int[][] directions = {{-1, 0}, {0, +1}, {+1, 0}, {0, -1}};

    private final Map<Integer, int[]> gridValueToDirectionMapper = Map.of(1, directions[1], 2, directions[3], 3, directions[2], 4, directions[0]);

    private boolean isIndexValid(int currentRow, int currentColumn, int rowCount, int columnCount) {
        return (currentRow >= 0 && currentRow < rowCount && currentColumn >= 0 && currentColumn < columnCount);
    }

    private boolean isCurrentGridDirectionSameAsGoingDirection(int gridValue, int[] direction) {
        return Arrays.equals(gridValueToDirectionMapper.get(gridValue), direction);
    }

    private int minCostHelper(int[][] grid, boolean[][] visited, int rowCount, int columnCount) {

        Comparator<Helper> minCostComparator = Comparator.comparingInt(o -> o.currentCost);

        PriorityQueue<Helper> minCostPQ = new PriorityQueue<>(minCostComparator);

        minCostPQ.add(new Helper(0, 0, 0));

        while (!minCostPQ.isEmpty()) {
            Helper top = minCostPQ.remove();

            if ((top.currentRow == (rowCount - 1)) && (top.currentColumn == (columnCount - 1))) {
                return top.currentCost;
            }

            if (visited[top.currentRow][top.currentColumn]) {
                continue;
            }

            visited[top.currentRow][top.currentColumn] = true;

            for (int[] direction : directions) {
                int newRow = top.currentRow + direction[0];
                int newColumn = top.currentColumn + direction[1];

                if (isIndexValid(newRow, newColumn, rowCount, columnCount) && !visited[newRow][newColumn]) {
                    int currentDirectionCost = 0;
                    if (!isCurrentGridDirectionSameAsGoingDirection(grid[top.currentRow][top.currentColumn], direction)) {
                        currentDirectionCost++;
                    }
                    minCostPQ.add(new Helper(newRow, newColumn, currentDirectionCost + top.currentCost));
                }
            }
        }

        return -1;
    }

    public int minCost(int[][] grid) {
        int rowCount = grid.length;
        int columnCount = grid[0].length;
        boolean[][] visited = new boolean[rowCount][columnCount];
        return minCostHelper(grid, visited, rowCount, columnCount);
    }
}

    // Brute Force - DFS
//    private int minCostHelper(int[][] grid, int currentRow, int currentColumn, boolean[][] visited, int rowCount, int columnCount) {
//        if ((currentRow == (rowCount - 1)) && (currentColumn == (columnCount - 1))) {
//            return 0;
//        }

//        visited[currentRow][currentColumn] = true;

//        // To reach from (0,0) to (m-1,n-1) , total steps can be m-1+n-1.
//        // currentRow and currentColumn can also be induced in this formula. But taking from 0,0
//        // works fine.
//        int minCost = rowCount + columnCount - 2;

//        for (int[] direction : directions) {
//            int newRow = currentRow + direction[0];
//            int newColumn = currentColumn + direction[1];

//            if (isIndexValid(newRow, newColumn, rowCount, columnCount) && !visited[newRow][newColumn]) {
//                int currentDirectionCost = 0;
//                if (!isCurrentGridDirectionSameAsGoingDirection(grid[currentRow][currentColumn], direction)) {
//                    currentDirectionCost++;
//                }
//                currentDirectionCost += minCostHelper(grid, newRow, newColumn, visited, rowCount, columnCount);
//                minCost = Math.min(minCost, currentDirectionCost);
//            }
//        }

//        visited[currentRow][currentColumn] = false;

//        return minCost;
//    }