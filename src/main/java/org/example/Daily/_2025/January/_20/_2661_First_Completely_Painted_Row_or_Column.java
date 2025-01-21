package org.example.Daily._2025.January._20;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/first-completely-painted-row-or-column/description/
public class _2661_First_Completely_Painted_Row_or_Column {

    static class Helper {
        int currentRow;
        int currentColumn;

        public Helper(int currentRow, int currentColumn) {
            this.currentRow = currentRow;
            this.currentColumn = currentColumn;
        }
    }

    public int firstCompleteIndex(int[] arr, int[][] mat) {

        int rowCount = mat.length;
        int columnCount = mat[0].length;

        Map<Integer, Helper> valueToIndexMapper = new HashMap<>();

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                valueToIndexMapper.put(mat[i][j], new Helper(i, j));
            }
        }

        int[] row = new int[rowCount];
        int[] column = new int[columnCount];

        for (int i = 0; i < arr.length; i++) {
            Helper currentIndex = valueToIndexMapper.get(arr[i]);
            row[currentIndex.currentRow]++;
            column[currentIndex.currentColumn]++;

            if (row[currentIndex.currentRow] == columnCount || column[currentIndex.currentColumn] == rowCount) {
                return i;
            }
        }

        return -1;
    }
}