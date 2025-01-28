package org.example.Daily._2025.January._21;

import java.util.Arrays;

// https://leetcode.com/problems/grid-game/
public class _2017_Grid_Game {
    public long gridGame(int[][] grid) {

        int columnLength = grid[0].length;

        long remainingSumOfFirstRow = Arrays.stream(grid[0]).mapToLong(a -> a).sum();
        long maxScoreOfPlayer2 = Long.MAX_VALUE;
        long prefixSumOfSecondRow = 0;

        for (int downIndex = 0; downIndex < columnLength; downIndex++) {
            remainingSumOfFirstRow -= grid[0][downIndex];
            long currentIndexScore;
            if (downIndex == 0) {
                currentIndexScore = remainingSumOfFirstRow;
            } else if (downIndex == columnLength - 1) {
                currentIndexScore = prefixSumOfSecondRow;
            } else {
                currentIndexScore = Math.max(remainingSumOfFirstRow, prefixSumOfSecondRow);
            }
            maxScoreOfPlayer2 = Math.min(maxScoreOfPlayer2, currentIndexScore);
            prefixSumOfSecondRow += grid[1][downIndex];
        }

        return maxScoreOfPlayer2;
    }
}