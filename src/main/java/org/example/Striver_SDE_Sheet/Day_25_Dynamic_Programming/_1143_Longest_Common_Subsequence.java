package org.example.Striver_SDE_Sheet.Day_25_Dynamic_Programming;

// https://leetcode.com/problems/longest-common-subsequence/description/
public class _1143_Longest_Common_Subsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }

//    private int longestCommonSubsequence(int text1Index, int text2Index, String text1, String text2, int[][] dp) {
//        if (text1Index == text1.length() || text2Index == text2.length()) {
//            return 0;
//        }
//
//        if (dp[text1Index][text2Index] != -1) {
//            return dp[text1Index][text2Index];
//        }
//
//        if (text1.charAt(text1Index) == text2.charAt(text2Index)) {
//            dp[text1Index][text2Index] = 1 + longestCommonSubsequence(text1Index + 1, text2Index + 1, text1, text2, dp);
//        } else {
//            // Skip In text1
//            int skipInText1 = longestCommonSubsequence(text1Index + 1, text2Index, text1, text2, dp);
//            // Skip In text2
//            int skipInText2 = longestCommonSubsequence(text1Index, text2Index + 1, text1, text2, dp);
//            dp[text1Index][text2Index] = Math.max(skipInText1, skipInText2);
//        }
//
//        return dp[text1Index][text2Index];
//    }
//
//    public int longestCommonSubsequence(String text1, String text2) {
//        int[][] dp = new int[text1.length()][text2.length()];
//        for (int i = 0; i < text1.length(); i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return longestCommonSubsequence(0, 0, text1, text2, dp);
//    }

//    private int longestCommonSubsequence(int text1Index, int text2Index, String text1, String text2) {
//        if (text1Index == text1.length() || text2Index == text2.length()) {
//            return 0;
//        }
//
//        if (text1.charAt(text1Index) == text2.charAt(text2Index)) {
//            return 1 + longestCommonSubsequence(text1Index + 1, text2Index + 1, text1, text2);
//        } else {
//            // Skip In text1
//            int skipInText1 = longestCommonSubsequence(text1Index + 1, text2Index, text1, text2);
//            // Skip In text2
//            int skipInText2 = longestCommonSubsequence(text1Index, text2Index + 1, text1, text2);
//
//            return Math.max(skipInText1, skipInText2);
//        }
//    }
//
//    public int longestCommonSubsequence(String text1, String text2) {
//        return longestCommonSubsequence(0, 0, text1, text2);
//    }
}