package org.example.Striver_SDE_Sheet.Day_25_Dynamic_Programming._152_Maximum_Product_Subarray;

// https://leetcode.com/problems/edit-distance/description/
public class _72_Edit_Distance {

    public int minDistance(String word1, String word2) {

        int[] previousDp = new int[word2.length() + 1];

        previousDp[word2.length()] = 0;

        // Last Row Base Case
        for (int i = 0; i < word2.length() + 1; i++) {
            previousDp[i] = word2.length() - i;
        }

        for (int i = word1.length() - 1; i >= 0; i--) {
            int[] dp = new int[word2.length() + 1];
            // Last Column Base Case
            dp[word2.length()] = word1.length() - i;
            for (int j = word2.length() - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[j] = previousDp[j + 1];
                } else {
                    int insert = dp[j + 1];
                    int delete = previousDp[j];
                    int replace = previousDp[j + 1];
                    dp[j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
            previousDp = dp;
        }

        return previousDp[0];
    }

//    public int minDistance(String word1, String word2) {
//        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
//        dp[word1.length()][word2.length()] = 0;
//
//        for (int i = 0; i < word2.length() + 1; i++) {
//            dp[word1.length()][i] = word2.length() - i;
//        }
//
//        for (int i = 0; i < word1.length() + 1; i++) {
//            dp[i][word2.length()] = word1.length() - i;
//        }
//
//        for (int i = word1.length() - 1; i >= 0; i--) {
//            for (int j = word2.length() - 1; j >= 0; j--) {
//                if (word1.charAt(i) == word2.charAt(j)) {
//                    dp[i][j] = dp[i + 1][j + 1];
//                } else {
//                    int insert = dp[i][j + 1];
//                    int delete = dp[i + 1][j];
//                    int replace = dp[i + 1][j + 1];
//                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
//                }
//            }
//        }
//
//        return dp[0][0];
//    }

//    private int minDistance(int word1Index, int word2Index, String word1, String word2, int[][] dp) {
//        if (word1Index == word1.length() && word2Index == word2.length()) {
//            return 0;
//        }
//
//        if (word1Index == word1.length()) {
//            return (word2.length() - word2Index);
//        }
//
//        if (word2Index == word2.length()) {
//            return (word1.length() - word1Index);
//        }
//
//        if (dp[word1Index][word2Index] != -1) {
//            return dp[word1Index][word2Index];
//        }
//
//        if (word1.charAt(word1Index) == word2.charAt(word2Index)) {
//            dp[word1Index][word2Index] = minDistance(word1Index + 1, word2Index + 1, word1, word2, dp);
//        } else {
//
//            int insert = minDistance(word1Index, word2Index + 1, word1, word2, dp);
//
//            int delete = minDistance(word1Index + 1, word2Index, word1, word2, dp);
//
//            int replace = minDistance(word1Index + 1, word2Index + 1, word1, word2, dp);
//
//            dp[word1Index][word2Index] = 1 + Math.min(insert, Math.min(delete, replace));
//        }
//
//        return dp[word1Index][word2Index];
//    }
//
//    public int minDistance(String word1, String word2) {
//        int[][] dp = new int[word1.length()][word2.length()];
//        for (int i = 0; i < word1.length(); i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return minDistance(0, 0, word1, word2, dp);
//    }

//    private int minDistance(int word1Index, int word2Index, String word1, String word2) {
//        if (word1Index == word1.length() && word2Index == word2.length()) {
//            return 0;
//        }
//
//        if (word1Index == word1.length()) {
//            return (word2.length() - word2Index);
//        }
//
//        if (word2Index == word2.length()) {
//            return (word1.length() - word1Index);
//        }
//
//        // If Characters Are Equal no need of changing anything.
//
//        if (word1.charAt(word1Index) == word2.charAt(word2Index)) {
//            return minDistance(word1Index + 1, word2Index + 1, word1, word2);
//        } else {
//            // We have to convert word1 to word2.
//
//            // We can do
//
//            // 1. Insert that is
//            // word1 = abcd
//            // word2 = xyz
//
//            // After Insert
//
//            // word1 = xabcd
//            // word2 = xyz
//
//            int insert = 1 + minDistance(word1Index, word2Index + 1, word1, word2);
//
//            // 2. Delete that is
//
//            // word1 = abcd
//            // word2 = bcd
//
//            // After Delete
//
//            // word1 = bcd
//            // word2 = bcd
//
//            int delete = 1 + minDistance(word1Index + 1, word2Index, word1, word2);
//
//            // 3. Replace that is
//
//            // word1 = abcd
//            // word2 = xbcd
//
//            // After Replace
//
//            // word1 = xbcd
//            // word2 = xbcd
//
//            int replace = 1 + minDistance(word1Index + 1, word2Index + 1, word1, word2);
//
//            return Math.min(insert, Math.min(delete, replace));
//        }
//    }
//
//    public int minDistance(String word1, String word2) {
//        return minDistance(0, 0, word1, word2);
//    }
}
