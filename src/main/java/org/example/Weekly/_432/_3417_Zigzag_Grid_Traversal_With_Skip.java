package org.example.Weekly._432;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/zigzag-grid-traversal-with-skip/description
public class _3417_Zigzag_Grid_Traversal_With_Skip {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        int rowsCount = grid.length;
        int columnsCount = grid[0].length;
        boolean lastTaken = false;

        for (int i = 0; i < rowsCount; i++) {
            // Left to Right Traversal
            if (i % 2 == 0) {
                for (int j = 0; j < columnsCount; j++) {
                    if (!lastTaken) {
                        lastTaken = true;
                        result.add(grid[i][j]);
                    } else {
                        lastTaken = false;
                    }
                }
            }
            // Right To Left Traversal
            else {
                for (int j = columnsCount - 1; j >= 0; j--) {
                    if (!lastTaken) {
                        lastTaken = true;
                        result.add(grid[i][j]);
                    } else {
                        lastTaken = false;
                    }
                }
            }
        }

        return result;
    }
}
