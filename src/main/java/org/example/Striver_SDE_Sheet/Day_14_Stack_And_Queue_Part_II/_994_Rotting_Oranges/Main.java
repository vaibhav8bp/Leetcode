package org.example.Striver_SDE_Sheet.Day_14_Stack_And_Queue_Part_II._994_Rotting_Oranges;

import java.util.ArrayDeque;
import java.util.Queue;

// https://leetcode.com/problems/rotting-oranges/
class Helper {
    public int row;
    public int column;
    public int time;

    public Helper(int row, int column, int time) {
        this.row = row;
        this.column = column;
        this.time = time;
    }
}

class Solution {

    private final int[][] directions = {{-1, 0}, {0, +1}, {0, -1}, {+1, 0}};

    private boolean isCurrentPositionValid(int currentRow, int currentColumn, int rowCount, int columnCount) {
        return ((currentRow >= 0) && (currentRow < rowCount) && (currentColumn >= 0) && (currentColumn < columnCount));
    }

    private int placeInitialOrangesInQueueAndReturnCountOfFreshOranges(int[][] grid, Queue<Helper> queue) {

        int countOfFreshOranges = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    countOfFreshOranges++;
                } else if (grid[i][j] == 2) {
                    queue.add(new Helper(i, j, 0));
                }
            }
        }

        return countOfFreshOranges;

    }

    // Return no. of fresh oranges marked rotten
    private int traverseInAllFourDirectionsAndMarkFreshOrangesRotten(int row, int column, int rows, int columns, int[][] grid, Queue<Helper> queue, int currentTime) {

        int count = 0;

        for (int[] currentDirection : directions) {
            int newRow = row + currentDirection[0];
            int newColumn = column + currentDirection[1];
            if (isCurrentPositionValid(newRow, newColumn, rows, columns) && grid[newRow][newColumn] == 1) {
                grid[newRow][newColumn] = 2;
                queue.add(new Helper(newRow, newColumn, currentTime + 1));
                count++;
            }
        }

        return count;
    }

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        Queue<Helper> queue = new ArrayDeque<>();
        int countOfFreshOranges = placeInitialOrangesInQueueAndReturnCountOfFreshOranges(grid, queue);

        if (countOfFreshOranges == 0) {
            return 0;
        }

        if (queue.isEmpty()) {
            return -1;
        }

        while (!queue.isEmpty()) {
            Helper front = queue.remove();
            int markedOranges = traverseInAllFourDirectionsAndMarkFreshOrangesRotten(front.row, front.column, rows, columns, grid, queue, front.time);
            countOfFreshOranges -= markedOranges;
            if (countOfFreshOranges == 0) {
                break;
            }
        }

        if (countOfFreshOranges == 0) {
            while (queue.size() != 1) {
                queue.poll();
            }
            return queue.peek().time;
        }

        return -1;
    }
}

//class Solution {
//
//    private boolean checkIfNoFreshOrangesAreThere(int[][] grid) {
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                if (grid[i][j] == 1) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    private void markOriginalRotten(int[][] grid, boolean[][] originalRotten) {
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                if (grid[i][j] == 2) {
//                    originalRotten[i][j] = true;
//                }
//            }
//        }
//    }
//
//    private int orangesRottingHelper(int[][] grid, boolean[][] originalRotten) {
//        if (checkIfNoFreshOrangesAreThere(grid)) {
//            return 0;
//        }
//
//        boolean colored = false;
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                // If current orange is rotten, rot all oranges in 4 directions
//                if (grid[i][j] == 2 && originalRotten[i][j]) {
//
//                    if (((i - 1) >= 0) && grid[i - 1][j] == 1) {
//                        grid[i - 1][j] = 2;
//                        colored = true;
//                    }
//
//                    if (((j + 1) < grid[i].length) && grid[i][j + 1] == 1) {
//                        grid[i][j + 1] = 2;
//                        colored = true;
//                    }
//
//                    if (((i + 1) < grid.length) && grid[i + 1][j] == 1) {
//                        grid[i + 1][j] = 2;
//                        colored = true;
//                    }
//
//                    if (((j - 1) >= 0) && grid[i][j - 1] == 1) {
//                        grid[i][j - 1] = 2;
//                        colored = true;
//                    }
//                }
//            }
//        }
//
//        if (!colored) {
//            return -1;
//        }
//
//        markOriginalRotten(grid, originalRotten);
//
//        int recursionAnswer = orangesRottingHelper(grid, originalRotten);
//
//        if (recursionAnswer == -1) {
//            return recursionAnswer;
//        } else {
//            return recursionAnswer + 1;
//        }
//    }
//
//    // 0 for empty space, 1 for fresh orange, 2 for rotten orange
//    public int orangesRotting(int[][] grid) {
//
//        if (checkIfNoFreshOrangesAreThere(grid)) {
//            return 0;
//        }
//
//        boolean[][] originalRotten = new boolean[grid.length][grid[0].length];
//
//        for (int i = 0; i < grid.length; i++) {
//            Arrays.fill(originalRotten[i], false);
//        }
//
//        markOriginalRotten(grid, originalRotten);
//        return orangesRottingHelper(grid, originalRotten);
//    }
//}

public class Main {
    public static void main(String[] args) {
        int[][] grid1 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int[][] grid2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int[][] grid3 = {{1}, {1}, {1}, {1}};
        int[][] grid4 = {{0}};
        int[][] grid5 = {{2}, {2}, {1}, {0}, {1}, {1}};
        System.out.println(new Solution().orangesRotting(grid1));
    }
}
