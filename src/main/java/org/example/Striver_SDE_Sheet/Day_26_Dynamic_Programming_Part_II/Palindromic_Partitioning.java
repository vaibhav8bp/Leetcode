package org.example.Striver_SDE_Sheet.Day_26_Dynamic_Programming_Part_II;

// https://www.geeksforgeeks.org/problems/palindromic-patitioning4845/1


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindromic_Partitioning {

    private static void formPalindromeArray(String s, boolean[][] palindrome) {
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

    static int palindromicPartition(String s) {

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


//    private static int palindromicPartition(int currentIndex, String s, boolean[][] palindrome, int[] dp) {
//        if (currentIndex == s.length()) {
//            return 0;
//        }
//
//        if (dp[currentIndex] != -1) {
//            return dp[currentIndex];
//        }
//
//        int answer = Integer.MAX_VALUE;
//
//        for (int i = currentIndex; i < s.length(); i++) {
//            if (palindrome[currentIndex][i]) {
//                answer = Math.min(answer, palindromicPartition(i + 1, s, palindrome, dp));
//            }
//        }
//
//        if (answer == Integer.MAX_VALUE) {
//            dp[currentIndex] = 0;
//        } else {
//            dp[currentIndex] = 1 + answer;
//        }
//
//        return dp[currentIndex];
//    }
//
//    static int palindromicPartition(String s) {
//
//        // Only Upper Triangle Needs To Be Populated
//        boolean[][] palindrome = new boolean[s.length()][s.length()];
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
//
//        int[] dp = new int[s.length()];
//        Arrays.fill(dp, -1);
//
//        return palindromicPartition(0, s, palindrome, dp) - 1;
//    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String str = in.readLine();
            System.out.println(Palindromic_Partitioning.palindromicPartition(str));
        }
    }
}

/*
1
aaabba
 */

/*
1
ababbbabbababa
 */