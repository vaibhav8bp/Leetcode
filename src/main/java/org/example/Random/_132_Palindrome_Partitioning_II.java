package org.example.Random;

// https://leetcode.com/problems/palindrome-partitioning-ii/
public class _132_Palindrome_Partitioning_II {

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

    public int minCut(String s) {

        boolean[][] palindrome = new boolean[s.length()][s.length()];
        formPalindromeArray(s, palindrome);

        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 0;

        for (int currentIndex = s.length() - 1; currentIndex >= 0; currentIndex--) {
            int answer = Integer.MAX_VALUE;

            for (int i = currentIndex; i < s.length(); i++) {
                if (palindrome[currentIndex][i]) {
                    answer = Math.min(answer, dp[i + 1]);
                }
            }

            if (answer == Integer.MAX_VALUE) {
                dp[currentIndex] = 0;
            } else {
                dp[currentIndex] = 1 + answer;
            }
        }

        // dp calculates the no. of partitions and not the no. of cuts.
        // There to get cuts we do -1.
        return dp[0] - 1;
    }
}
