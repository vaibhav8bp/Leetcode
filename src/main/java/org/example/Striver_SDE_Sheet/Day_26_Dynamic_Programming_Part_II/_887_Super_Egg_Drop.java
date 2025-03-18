package org.example.Striver_SDE_Sheet.Day_26_Dynamic_Programming_Part_II;

import java.util.Arrays;

// https://leetcode.com/problems/super-egg-drop/
public class _887_Super_Egg_Drop {

    public int superEggDrop(int numberOfEggs, int numberOfFloors) {

        int[][] dp = new int[numberOfEggs + 1][numberOfFloors + 1];

        for (int i = 0; i < numberOfFloors + 1; i++) {
            dp[1][i] = i;
        }

        for (int i = 0; i < numberOfEggs + 1; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        for (int i = 2; i < numberOfEggs + 1; i++) {
            for (int j = 2; j < numberOfFloors + 1; j++) {
                int answer = Integer.MAX_VALUE;

                int low = 1;
                int high = j;

                // We want to achieve guarantee, so we go for worst move in direction of greater moves.
                // Since we are trying to minimize the worst-case number of attempts, we always choose the
                // maximum of the two cases (max(eggBreaks, eggSurvives)).

                while (low <= high) {
                    int mid = (low + high) / 2;
                    int eggBreaks = dp[i - 1][mid - 1];
                    int eggSurvives = dp[i][j - mid];

                    if (eggBreaks >= eggSurvives) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }

                    answer = Math.min(answer, Math.max(eggBreaks, eggSurvives));
                }
                dp[i][j] = 1 + answer;
            }
        }

        return dp[numberOfEggs][numberOfFloors];
    }

//    public int superEggDrop(int numberOfEggs, int numberOfFloors, int[][] dp) {
//
//        if (numberOfEggs == 1) {
//            // Consider worst case for guarantee.
//            return numberOfFloors;
//        }
//        if (numberOfFloors == 0 || numberOfFloors == 1) {
//            return numberOfFloors;
//        }
//
//        if (dp[numberOfEggs][numberOfFloors] != -1) {
//            return dp[numberOfEggs][numberOfFloors];
//        }
//
//        int answer = Integer.MAX_VALUE;
//
//        int low = 1;
//        int high = numberOfFloors;
//
//        // We want to achieve guarantee, so we go for worst move in direction of greater moves.
//        while (low <= high) {
//            int mid = (low + high) / 2;
//            int eggBreaks = superEggDrop(numberOfEggs - 1, mid - 1, dp);
//            int eggSurvives = superEggDrop(numberOfEggs, numberOfFloors - mid, dp);
//
//            if (eggBreaks >= eggSurvives) {
//                high = mid - 1;
//            } else {
//                low = mid + 1;
//            }
//
//            answer = Math.min(answer, Math.max(eggBreaks, eggSurvives));
//        }
//
//        dp[numberOfEggs][numberOfFloors] = 1 + answer;
//        return dp[numberOfEggs][numberOfFloors];
//    }
//
//    public int superEggDrop(int numberOfEggs, int numberOfFloors) {
//
//        int[][] dp = new int[numberOfEggs + 1][numberOfFloors + 1];
//
//        for (int i = 0; i < numberOfEggs + 1; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//
//        return superEggDrop(numberOfEggs, numberOfFloors, dp);
//    }

//    public int superEggDrop(int numberOfEggs, int numberOfFloors) {
//
//        int[][] dp = new int[numberOfEggs + 1][numberOfFloors + 1];
//
//        for (int i = 0; i < numberOfFloors + 1; i++) {
//            dp[1][i] = i;
//        }
//
//        for (int i = 0; i < numberOfEggs + 1; i++) {
//            dp[i][0] = 0;
//            dp[i][1] = 1;
//        }
//
//        for (int i = 2; i < numberOfEggs + 1; i++) {
//            for (int j = 2; j < numberOfFloors + 1; j++) {
//                int answer = Integer.MAX_VALUE;
//                for (int k = 1; k <= j; k++) {
//                    int eggBreaks = dp[i - 1][k - 1];
//                    int eggSurvives = dp[i][j - k];
//                    answer = Math.min(answer, Math.max(eggBreaks, eggSurvives));
//                }
//                dp[i][j] = 1 + answer;
//            }
//        }
//
//        return dp[numberOfEggs][numberOfFloors];
//    }

//    public int superEggDrop(int numberOfEggs, int numberOfFloors, int[][] dp) {
//
//        if (numberOfEggs == 1) {
//            // Consider worst case for guarantee.
//            return numberOfFloors;
//        }
//        if (numberOfFloors == 0 || numberOfFloors == 1) {
//            return numberOfFloors;
//        }
//
//        if (dp[numberOfEggs][numberOfFloors] != -1) {
//            return dp[numberOfEggs][numberOfFloors];
//        }
//
//        int answer = Integer.MAX_VALUE;
//
//        for (int i = 1; i <= numberOfFloors; i++) {
//            int eggBreaks = superEggDrop(numberOfEggs - 1, i - 1, dp);
//            int eggSurvives = superEggDrop(numberOfEggs, numberOfFloors - i, dp);
//            answer = Math.min(answer, Math.max(eggBreaks, eggSurvives));
//        }
//
//        dp[numberOfEggs][numberOfFloors] = 1 + answer;
//        return dp[numberOfEggs][numberOfFloors];
//    }
//
//    public int superEggDrop(int numberOfEggs, int numberOfFloors) {
//
//        int[][] dp = new int[numberOfEggs + 1][numberOfFloors + 1];
//
//        for (int i = 0; i < numberOfEggs + 1; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//
//        return superEggDrop(numberOfEggs, numberOfFloors, dp);
//    }

//    public int superEggDrop(int numberOfEggs, int numberOfFloors) {
//
//        if (numberOfEggs == 1) {
//            // Consider worst case for guarantee.
//            return numberOfFloors;
//        }
//        if (numberOfFloors == 0 || numberOfFloors == 1) {
//            return numberOfFloors;
//        }
//
//        int answer = Integer.MAX_VALUE;
//
//        for (int i = 1; i <= numberOfFloors; i++) {
//            int eggBreaks = superEggDrop(numberOfEggs - 1, i - 1);
//            int eggSurvives = superEggDrop(numberOfEggs, numberOfFloors - i);
//            answer = Math.min(answer, Math.max(eggBreaks, eggSurvives));
//        }
//
//        return 1 + answer;
//    }
}
