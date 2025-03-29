package org.example.Striver_Youtube.DP._11;

import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/triangle/description/
public class _120_Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] previousDP = new int[triangle.size() + 1];
        Arrays.fill(previousDP, 0);

        for (int i = triangle.size() - 1; i >= 0; i--) {
            int[] currentDP = new int[triangle.size() + 1];
            for (int j = i; j >= 0; j--) {
                int currentCost = triangle.get(i).get(j);

                int sameIndexCost = previousDP[j];
                int nextIndexCost = previousDP[j + 1];

                currentDP[j] = currentCost + Math.min(sameIndexCost, nextIndexCost);
            }
            previousDP = currentDP;
        }

        return previousDP[0];
    }

//    public int minimumTotal(List<List<Integer>> triangle) {
//        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];
//        Arrays.fill(dp[triangle.size()], 0);
//
//        for (int i = triangle.size() - 1; i >= 0; i--) {
//            for (int j = i; j >= 0; j--) {
//                int currentCost = triangle.get(i).get(j);
//
//                int sameIndexCost = dp[i + 1][j];
//                int nextIndexCost = dp[i + 1][j + 1];
//
//                dp[i][j] = currentCost + Math.min(sameIndexCost, nextIndexCost);
//            }
//        }
//
//        return dp[0][0];
//    }

//    private int minimumTotal(int currentRow, int currentIndexInCurrentRow, List<List<Integer>> triangle, int[][] dp) {
//        if (currentRow == triangle.size()) {
//            return 0;
//        }
//
//        if (dp[currentRow][currentIndexInCurrentRow] != -1) {
//            return dp[currentRow][currentIndexInCurrentRow];
//        }
//
//        int currentCost = triangle.get(currentRow).get(currentIndexInCurrentRow);
//
//        int sameIndexCost = minimumTotal(currentRow + 1, currentIndexInCurrentRow, triangle, dp);
//        int nextIndexCost = minimumTotal(currentRow + 1, currentIndexInCurrentRow + 1, triangle, dp);
//
//        dp[currentRow][currentIndexInCurrentRow] = currentCost + Math.min(sameIndexCost, nextIndexCost);
//        return dp[currentRow][currentIndexInCurrentRow];
//    }
//
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int[][] dp = new int[triangle.size()][triangle.size()];
//        for (int i = 0; i < triangle.size(); i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return minimumTotal(0, 0, triangle, dp);
//    }

//    private int minimumTotal(int currentRow, int currentIndexInCurrentRow, List<List<Integer>> triangle) {
//        if (currentRow == triangle.size()) {
//            return 0;
//        }
//
//        int currentCost = triangle.get(currentRow).get(currentIndexInCurrentRow);
//
//        int sameIndexCost = minimumTotal(currentRow + 1, currentIndexInCurrentRow, triangle);
//        int nextIndexCost = minimumTotal(currentRow + 1, currentIndexInCurrentRow + 1, triangle);
//
//        return currentCost + Math.min(sameIndexCost, nextIndexCost);
//    }
//
//    public int minimumTotal(List<List<Integer>> triangle) {
//        return minimumTotal(0, 0, triangle);
//    }
}
