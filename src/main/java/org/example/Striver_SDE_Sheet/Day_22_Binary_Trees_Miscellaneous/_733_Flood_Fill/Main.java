package org.example.Striver_SDE_Sheet.Day_22_Binary_Trees_Miscellaneous._733_Flood_Fill;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/flood-fill/description/
class Helper {
    int row;
    int column;

    public Helper(int row, int column) {
        this.row = row;
        this.column = column;
    }
}

class Solution {

    // Up Right Down Left
    final int[][] directions = {{-1, 0}, {0, +1}, {+1, 0}, {0, -1}};

    private boolean isIndexValid(int currentRow, int currentColumn, int rows, int columns) {
        return (currentRow >= 0 && currentRow < rows && currentColumn >= 0 && currentColumn < columns);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        if (originalColor == color) {
            return image;
        }

        int rows = image.length;
        int columns = image[0].length;
        Queue<Helper> queue = new LinkedList<>();
        queue.add(new Helper(sr, sc));

        while (!queue.isEmpty()) {
            Helper front = queue.remove();
            image[front.row][front.column] = color;
            for (int i = 0; i < 4; i++) {
                int newRow = front.row + directions[i][0];
                int newColumn = front.column + directions[i][1];

                if (!isIndexValid(newRow, newColumn, rows, columns) || image[newRow][newColumn] != originalColor) {
                    continue;
                }
                queue.add(new Helper(newRow, newColumn));
            }
        }

        return image;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(Arrays.deepToString(new Solution().floodFill(arr, 1, 1, 2)));
    }
}