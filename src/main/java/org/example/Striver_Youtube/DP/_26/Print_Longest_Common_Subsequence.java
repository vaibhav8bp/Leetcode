package org.example.Striver_Youtube.DP._26;

// https://www.naukri.com/code360/problems/print-longest-common-subsequence_8416383
public class Print_Longest_Common_Subsequence {

    private static void findLCSDp(int[][] dp, String text1, String text2) {

        for (int i = 0; i < text1.length(); i++) {
            dp[i][text2.length()] = 0;
        }

        for (int i = 0; i < text2.length(); i++) {
            dp[text1.length()][i] = 0;
        }

        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
    }

    public static String findLCS(int n, int m, String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        findLCSDp(dp, s1, s2);

        StringBuilder answer = new StringBuilder();

        int s1Index = 0;
        int s2Index = 0;

        /*
        dp will look like this
        s1 ="abcd" s2="bedg"

            b  e  d  g
            0| 1| 2| 3| 4|
      a  0| 2| 1| 1| 0| 0|
      b  1| 2| 1| 1| 0| 0|
      c  2| 1| 1| 1| 0| 0|
      d  3| 1| 1| 1| 0| 0|
         4| 0| 0| 0| 0| 0|
         */

        while (s1Index < s1.length() && s2Index < s2.length()) {
            if (s1.charAt(s1Index) == s2.charAt(s2Index)) {
                answer.append(s1.charAt(s1Index++));
                s2Index++;
            } else {
                if (dp[s1Index + 1][s2Index] >= dp[s1Index][s2Index + 1]) {
                    s1Index++;
                } else {
                    s2Index++;
                }
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(findLCS(0, 0, "xyz", "abc"));
    }
}