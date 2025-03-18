package org.example.Random;

// https://leetcode.com/problems/palindrome-partitioning-iv/description/
public class _1745_Palindrome_Partitioning_IV {

    private void formPalindromeArray(String s, boolean[][] palindrome) {
        // Only Upper Triangle Needs To Be Populated

        // One Length Strings Are Always Palindrome
        for (int i = 0; i < s.length(); i++) {
            palindrome[i][i] = true;
        }

        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                // 2 Length Substrings, just check both characters
                boolean areFirstAndLastCharacterEqual = s.charAt(i) == s.charAt(j);
                if (j - i == 1) {
                    palindrome[i][j] = areFirstAndLastCharacterEqual;
                }
                // > 2 Length Substrings, use dp
                // First and last character should be equal and middle part should be palindrome
                else {
                    palindrome[i][j] = areFirstAndLastCharacterEqual && (palindrome[i + 1][j - 1]);
                }
            }
        }
    }

    // aabbcc

    // Track Every 3rd substring, not a general solution. Only for k=3
    public boolean checkPartitioning(String s) {
        boolean[][] palindrome = new boolean[s.length()][s.length()];
        formPalindromeArray(s, palindrome);

        // i and j are 2 points for substring endings.

        for (int i = 0; i < s.length() - 2; i++) {
            for (int j = i + 1; j < s.length() - 1; j++) {
                if (palindrome[0][i] && palindrome[i + 1][j] && palindrome[j + 1][s.length() - 1]) {
                    return true;
                }
            }
        }

        return false;
    }

//    private void formPalindromeArray(String s, boolean[][] palindrome) {
//        // Only Upper Triangle Needs To Be Populated
//
//        // One Length Strings Are Always Palindrome
//        for (int i = 0; i < s.length(); i++) {
//            palindrome[i][i] = true;
//        }
//
//        for (int i = s.length() - 2; i >= 0; i--) {
//            for (int j = i + 1; j < s.length(); j++) {
//                // 2 Length Substrings, just check both characters
//                boolean areFirstAndLastCharacterEqual = s.charAt(i) == s.charAt(j);
//                if (j - i == 1) {
//                    palindrome[i][j] = areFirstAndLastCharacterEqual;
//                }
//                // > 2 Length Substrings, use dp
//                // First and last character should be equal and middle part should be palindrome
//                else {
//                    palindrome[i][j] = areFirstAndLastCharacterEqual && (palindrome[i + 1][j - 1]);
//                }
//            }
//        }
//    }
//
//    public boolean checkPartitioning(String s) {
//        boolean[][] palindrome = new boolean[s.length()][s.length()];
//        formPalindromeArray(s, palindrome);
//        int k = 3;
//        boolean[][] dp = new boolean[s.length()][k];
//
//        for (int i = 0; i < s.length(); i++) {
//            dp[i][k - 1] = palindrome[i][s.length() - 1];
//        }
//
//        for (int i = s.length() - 1; i >= 0; i--) {
//            for (int j = k - 2; j >= 0; j--) {
//                for (int l = i; l < s.length() - (k - j) + 1; l++) {
//                    if (palindrome[i][l] && dp[l + 1][j + 1]) {
//                        dp[i][j] = true;
//                        break;
//                    }
//                }
//                if (!dp[i][j]) {
//                    dp[i][j] = false;
//                }
//            }
//        }
//
//        return dp[0][0];
//    }

//    private void formPalindromeArray(String s, boolean[][] palindrome) {
//        // Only Upper Triangle Needs To Be Populated
//
//        // One Length Strings Are Always Palindrome
//        for (int i = 0; i < s.length(); i++) {
//            palindrome[i][i] = true;
//        }
//
//        for (int i = s.length() - 2; i >= 0; i--) {
//            for (int j = i + 1; j < s.length(); j++) {
//                // 2 Length Substrings, just check both characters
//                boolean areFirstAndLastCharacterEqual = s.charAt(i) == s.charAt(j);
//                if (j - i == 1) {
//                    palindrome[i][j] = areFirstAndLastCharacterEqual;
//                }
//                // > 2 Length Substrings, use dp
//                // First and last character should be equal and middle part should be palindrome
//                else {
//                    palindrome[i][j] = areFirstAndLastCharacterEqual && (palindrome[i + 1][j - 1]);
//                }
//            }
//        }
//    }
//
//    private boolean checkPartitioning(int currentIndex, int partitionNo, int totalPartition, String s, boolean[][] palindrome, Boolean[][] dp) {
//        if (partitionNo == totalPartition - 1) {
//            return palindrome[currentIndex][s.length() - 1];
//        }
//
//        if (dp[currentIndex][partitionNo] != null) {
//            return dp[currentIndex][partitionNo];
//        }
//
//        for (int i = currentIndex; i < s.length() - (totalPartition - partitionNo) + 1; i++) {
//            if (palindrome[currentIndex][i]) {
//                if (checkPartitioning(i + 1, partitionNo + 1, totalPartition, s, palindrome, dp)) {
//                    dp[currentIndex][partitionNo] = true;
//                    return dp[currentIndex][partitionNo];
//                }
//            }
//        }
//
//        dp[currentIndex][partitionNo] = false;
//        return dp[currentIndex][partitionNo];
//    }
//
//    public boolean checkPartitioning(String s) {
//        boolean[][] palindrome = new boolean[s.length()][s.length()];
//        formPalindromeArray(s, palindrome);
//        int k = 3;
//        Boolean[][] dp = new Boolean[s.length()][k];
//        return checkPartitioning(0, 0, k, s, palindrome, dp);
//    }
}
