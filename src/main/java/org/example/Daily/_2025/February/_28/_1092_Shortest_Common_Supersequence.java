package org.example.Daily._2025.February._28;

// https://leetcode.com/problems/shortest-common-supersequence/
public class _1092_Shortest_Common_Supersequence {

    private static StringBuilder getStringBuilder(String str1, String str2, int[][] dp) {
        StringBuilder answer = new StringBuilder();

        // dp[i][j] represents the length of LCS starting from index i in str1 and index j in str2.
        // dp for str1 = "abac" and str2 = "cab"
        // LCS is "ab"
        // SCS is "cabac"

        /*     c  a  b
        [      0  1  2  3
        0  a  [2, 2, 1, 0],
        1  b  [1, 1, 1, 0],
        2  a  [1, 1, 0, 0],
        3  c  [1, 0, 0, 0],
              [0, 0, 0, 0]
        ]

        // VVV IMP.
        Start From 0,0 and Compare str1[0] str2[0], a and c are not equal.
        check dp[1][0] and dp[0][1] , dp[1][0] < dp[0][1]
        So we move towards dp[0][1], what just happened here ? in respect to strings,
        if dp[i+1][j] < dp[i][j+1], we are moving towards bigger index w.r.t to dp,
        so now we are at dp[0][1], if we move to dp[0][1], our str2 is reduced,
        so we append str2.charAt(j) in our result.
         */

        // Logic To Construct LCS from dp[i][j] is such that we start from length of LCS, that is dp[0][0].

        // if for currentIndices i in str1 and j in str2, characters are equal that is str1.charAt(i)==str2.charAt(j)
        // We take that character once and increment both i and j by 1 that is i++, j++

        // else if characters are not equal we check which is greater that is dp[i+1][j]/ dp[i][j+1]
        // Whichever is larger increment opposite index.
        // That is if dp[i+1][j] > dp[i][j+1], append str2.charAt(j) and increment j.
        // if dp[i+1][j] < dp[i][j+1], append str1.charAt(i) and increment i.
        // if dp[i+1][j] == dp[i][j+1], we can do anything.

        int i = 0;
        int j = 0;

        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                answer.append(str1.charAt(i));
                i++;
                j++;
            } else if (dp[i + 1][j] >= dp[i][j + 1]) {
                answer.append(str1.charAt(i++));
            } else {
                answer.append(str2.charAt(j++));
            }
        }

        if (i < str1.length()) {
            answer.append(str1.substring(i));
        }
        if (j < str2.length()) {
            answer.append(str2.substring(j));
        }
        return answer;
    }

    public static String shortestCommonSupersequence(String str1, String str2) {

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i < str1.length(); i++) {
            dp[i][str2.length()] = 0;
        }

        for (int i = 0; i < str2.length(); i++) {
            dp[str1.length()][i] = 0;
        }

        for (int i = str1.length() - 1; i >= 0; i--) {
            for (int j = str2.length() - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        StringBuilder answer = getStringBuilder(str1, str2, dp);
        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("abac", "cab"));
    }
}
