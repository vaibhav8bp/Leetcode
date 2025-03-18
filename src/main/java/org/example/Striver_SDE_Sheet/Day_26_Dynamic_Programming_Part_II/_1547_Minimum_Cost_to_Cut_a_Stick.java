package org.example.Striver_SDE_Sheet.Day_26_Dynamic_Programming_Part_II;

import java.util.*;

// https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/
public class _1547_Minimum_Cost_to_Cut_a_Stick {

    public static int minCost(int n, int[] cuts) {
        int newCutsLength = cuts.length + 2;
        int[] newCuts = new int[newCutsLength];
        System.arraycopy(cuts, 0, newCuts, 0, cuts.length);
        newCuts[cuts.length] = 0;
        newCuts[cuts.length + 1] = n;
        Arrays.sort(newCuts);

        int[][] dp = new int[newCutsLength][newCutsLength];

        // Upper Triangular Matrix Will Be Formed.

        for (int i = 1; i <= cuts.length; i++) {
            dp[i][i] = newCuts[i + 1] - newCuts[i - 1];
        }

        for (int startCutIndex = cuts.length - 1; startCutIndex >= 1; startCutIndex--) {
            for (int endCutIndex = startCutIndex + 1; endCutIndex < cuts.length + 1; endCutIndex++) {
                int totalCost = Integer.MAX_VALUE;
                for (int i = startCutIndex; i <= endCutIndex; i++) {
                    totalCost = Math.min(totalCost, newCuts[endCutIndex + 1] - newCuts[startCutIndex - 1] + dp[startCutIndex][i - 1] + dp[i + 1][endCutIndex]);
                }
                dp[startCutIndex][endCutIndex] = totalCost;
            }
        }

        return dp[1][cuts.length];
    }

    // Eliminating int startLength, int endLength variables
    // Eg cuts={1 3 4 5}, and n=7
    // add 0 and 7 to cuts to get below
    // Index -> 0 1 2 3 4 5
    // Cuts ->  0 1 3 4 5 7

    // Let's say we get cut at index =3 and cut=4
    // To right recursion we pass
    // startCutIndex=4 and endCutIndex=4 (we pass 1 and cuts.length initially)
    // Now how can we get length of this duration
    // Length = 7-4=3 (cuts[endCutIndex+1]-cuts[startCutIndex-1])

    // Let's say we get cut at index =4 and cut=5
    // To Left recursion we pass
    // startCutIndex=1 and endCutIndex=3 (we pass 1 and cuts.length initially)
    // Now how can we get length of this duration
    // Length = 5 (5-0) (cuts[endCutIndex+1]-cuts[startCutIndex-1])

//    private static int minCost(int startCutIndex, int endCutIndex, int[] newCuts, int[][] dp) {
//
//        // No cut available, no cost.
//        if (startCutIndex > endCutIndex) {
//            return 0;
//        }
//
//        // If only 1 cut, return entire length of rod.
//        if (startCutIndex == endCutIndex) {
//            return newCuts[endCutIndex + 1] - newCuts[startCutIndex - 1];
//        }
//
//        if (dp[startCutIndex][endCutIndex] != -1) {
//            return dp[startCutIndex][endCutIndex];
//        }
//
//        int totalCost = Integer.MAX_VALUE;
//
//        for (int i = startCutIndex; i <= endCutIndex; i++) {
//            totalCost = Math.min(totalCost, newCuts[endCutIndex + 1] - newCuts[startCutIndex - 1] +
//                    minCost(startCutIndex, i - 1, newCuts, dp) +
//                    minCost(i + 1, endCutIndex, newCuts, dp));
//        }
//
//        dp[startCutIndex][endCutIndex] = totalCost;
//        return dp[startCutIndex][endCutIndex];
//    }
//
//    public static int minCost(int n, int[] cuts) {
//        int newCutsLength = cuts.length + 2;
//        int[] newCuts = new int[newCutsLength];
//        System.arraycopy(cuts, 0, newCuts, 0, cuts.length);
//        newCuts[cuts.length] = 0;
//        newCuts[cuts.length + 1] = n;
//        Arrays.sort(newCuts);
//        int[][] dp = new int[newCutsLength][newCutsLength];
//        for (int i = 0; i < newCutsLength; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//
//        // Adjust startIndex and endIndex by adding +1 to both.
//        return minCost(1, cuts.length, newCuts, dp);
//    }

//    private static int minCost(int startLength, int endLength, int startCutIndex, int endCutIndex, int[] cuts, int[][] dp) {
//
//        // No cut available, no cost.
//        if (startCutIndex > endCutIndex) {
//            return 0;
//        }
//
//        // If only 1 cut, return entire length of rod.
//        if (startCutIndex == endCutIndex) {
//            return endLength - startLength;
//        }
//
//        if (dp[startCutIndex][endCutIndex] != -1) {
//            return dp[startCutIndex][endCutIndex];
//        }
//
//        int totalCost = Integer.MAX_VALUE;
//
//        for (int i = startCutIndex; i <= endCutIndex; i++) {
//            totalCost = Math.min(totalCost, (endLength - startLength) +
//                    minCost(startLength, cuts[i], startCutIndex, i - 1, cuts, dp) +
//                    minCost(cuts[i], endLength, i + 1, endCutIndex, cuts, dp));
//        }
//
//        dp[startCutIndex][endCutIndex] = totalCost;
//        return dp[startCutIndex][endCutIndex];
//    }
//
//    public static int minCost(int n, int[] cuts) {
//        Arrays.sort(cuts);
//        int[][] dp = new int[cuts.length][cuts.length];
//        for (int i = 0; i < cuts.length; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return minCost(0, n, 0, cuts.length - 1, cuts, dp);
//    }

//    private static int minCost(int startLength, int endLength, int startCutIndex, int endCutIndex, int[] cuts) {
//        if (startCutIndex > endCutIndex) {
//            return 0;
//        }
//
//        int totalCost = Integer.MAX_VALUE;
//
//        for (int i = startCutIndex; i <= endCutIndex; i++) {
//            totalCost = Math.min(totalCost, (endLength - startLength) +
//                    minCost(startLength, cuts[i], startCutIndex, i - 1, cuts) +
//                    minCost(cuts[i], endLength, i + 1, endCutIndex, cuts));
//        }
//
//        return totalCost;
//    }
//
//    public static int minCost(int n, int[] cuts) {
//        Arrays.sort(cuts);
//        return minCost(0, n, 0, cuts.length - 1, cuts);
//    }

    public static void main(String[] args) {
        System.out.println(minCost(7, new int[]{1, 3, 4, 5}));
        System.out.println(minCost(9, new int[]{5, 6, 1, 4, 2}));
    }
}
