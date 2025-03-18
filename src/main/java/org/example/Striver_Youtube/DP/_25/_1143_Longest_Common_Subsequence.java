package org.example.Striver_Youtube.DP._25;

import java.util.Arrays;

// https://leetcode.com/problems/longest-common-subsequence/description/
public class _1143_Longest_Common_Subsequence {

    public int longestCommonSubsequence(String text1, String text2) {

        int[] previousDP = new int[text2.length() + 1];

        Arrays.fill(previousDP, 0);

        for (int i = text1.length() - 1; i >= 0; i--) {
            int[] dp = new int[text2.length() + 1];
            dp[text2.length()] = 0;
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[j] = 1 + previousDP[j + 1];
                } else {
                    dp[j] = Math.max(dp[j + 1], previousDP[j]);
                }
            }
            previousDP = dp;
        }

        return previousDP[0];
    }

//    public int longestCommonSubsequence(String text1, String text2) {
//        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
//
//        for (int i = 0; i < text1.length(); i++) {
//            dp[i][text2.length()] = 0;
//        }
//
//        for (int i = 0; i < text2.length(); i++) {
//            dp[text1.length()][i] = 0;
//        }
//
//        for (int i = text1.length() - 1; i >= 0; i--) {
//            for (int j = text2.length() - 1; j >= 0; j--) {
//                if (text1.charAt(i) == text2.charAt(j)) {
//                    dp[i][j] = 1 + dp[i + 1][j + 1];
//                } else {
//                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
//                }
//            }
//        }
//
//        return dp[0][0];
//    }

//    private int longestCommonSubsequence(String text1, String text2, int text1Index, int text2Index, int[][] dp) {
//
//        if (text1Index == text1.length() || text2Index == text2.length()) {
//            return 0;
//        }
//
//        if (dp[text1Index][text2Index] != -1) {
//            return dp[text1Index][text2Index];
//        }
//
//        if (text1.charAt(text1Index) == text2.charAt(text2Index)) {
//            dp[text1Index][text2Index] = 1 + longestCommonSubsequence(text1, text2, text1Index + 1, text2Index + 1, dp);
//            return dp[text1Index][text2Index];
//        }
//
//        int removeText1 = longestCommonSubsequence(text1, text2, text1Index + 1, text2Index, dp);
//        int removeText2 = longestCommonSubsequence(text1, text2, text1Index, text2Index + 1, dp);
//
//        dp[text1Index][text2Index] = Math.max(removeText1, removeText2);
//
//        return dp[text1Index][text2Index];
//    }
//
//    public int longestCommonSubsequence(String text1, String text2) {
//        int[][] dp = new int[text1.length()][text2.length()];
//        for (int i = 0; i < text1.length(); i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return longestCommonSubsequence(text1, text2, 0, 0, dp);
//    }

//    private int longestCommonSubsequence(String text1, String text2, int text1Index, int text2Index) {
//
//        if (text1Index == text1.length() || text2Index == text2.length()) {
//            return 0;
//        }
//
//        if (text1.charAt(text1Index) == text2.charAt(text2Index)) {
//            return 1 + longestCommonSubsequence(text1, text2, text1Index + 1, text2Index + 1);
//        }
//
//        int removeText1 = longestCommonSubsequence(text1, text2, text1Index + 1, text2Index);
//        int removeText2 = longestCommonSubsequence(text1, text2, text1Index, text2Index + 1);
//
//        return Math.max(removeText1, removeText2);
//    }
//
//    public int longestCommonSubsequence(String text1, String text2) {
//        return longestCommonSubsequence(text1, text2, 0, 0);
//    }
}
