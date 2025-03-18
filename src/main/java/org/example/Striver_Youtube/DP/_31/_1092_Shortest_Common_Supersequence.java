package org.example.Striver_Youtube.DP._31;

// https://leetcode.com/problems/shortest-common-supersequence/description/
public class _1092_Shortest_Common_Supersequence {

    public String shortestCommonSupersequence(String str1, String str2) {

        String[] previousDP = new String[str2.length() + 1];

        for (int i = 0; i < str2.length(); i++) {
            previousDP[i] = str2.substring(i);
        }

        previousDP[str2.length()] = "";

        for (int i = str1.length() - 1; i >= 0; i--) {
            String[] dp = new String[str2.length() + 1];
            dp[str2.length()] = str1.substring(i);
            for (int j = str2.length() - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[j] = str1.charAt(i) + previousDP[j + 1];
                } else {
                    String includeStr1 = str1.charAt(i) + previousDP[j];
                    String includeStr2 = str2.charAt(j) + dp[j + 1];
                    dp[j] = (includeStr1.length() <= includeStr2.length()) ? includeStr1 : includeStr2;
                }
            }
            previousDP = dp;
        }

        return previousDP[0];
    }

//    public String shortestCommonSupersequence(String str1, String str2) {
//        String[][] dp = new String[str1.length() + 1][str2.length() + 1];
//
//        for (int i = 0; i < str2.length(); i++) {
//            dp[str1.length()][i] = str2.substring(i);
//        }
//
//        for (int i = 0; i < str1.length(); i++) {
//            dp[i][str2.length()] = str1.substring(i);
//        }
//
//        dp[str1.length()][str2.length()] = "";
//
//        for (int i = str1.length() - 1; i >= 0; i--) {
//            for (int j = str2.length() - 1; j >= 0; j--) {
//                if (str1.charAt(i) == str2.charAt(j)) {
//                    dp[i][j] = str1.charAt(i) + dp[i + 1][j + 1];
//                } else {
//                    String includeStr1 = str1.charAt(i) + dp[i + 1][j];
//                    String includeStr2 = str2.charAt(j) + dp[i][j + 1];
//                    dp[i][j] = (includeStr1.length() <= includeStr2.length()) ? includeStr1 : includeStr2;
//                }
//            }
//        }
//
//        return dp[0][0];
//    }

//    private String shortestCommonSupersequence(int str1Index, int str2Index, String str1, String str2, String[][] dp) {
//        if (str1Index == str1.length()) {
//            return str2.substring(str2Index);
//        }
//
//        if (str2Index == str2.length()) {
//            return str1.substring(str1Index);
//        }
//
//        if (dp[str1Index][str2Index] != null) {
//            return dp[str1Index][str2Index];
//        }
//
//        if (str1.charAt(str1Index) == str2.charAt(str2Index)) {
//            return str1.charAt(str1Index) + shortestCommonSupersequence(str1Index + 1, str2Index + 1, str1, str2, dp);
//        }
//
//        String includeStr1 = str1.charAt(str1Index) + shortestCommonSupersequence(str1Index + 1, str2Index, str1, str2, dp);
//        String includeStr2 = str2.charAt(str2Index) + shortestCommonSupersequence(str1Index, str2Index + 1, str1, str2, dp);
//
//        dp[str1Index][str2Index] = (includeStr1.length() <= includeStr2.length()) ? includeStr1 : includeStr2;
//        return dp[str1Index][str2Index];
//    }
//
//    public String shortestCommonSupersequence(String str1, String str2) {
//        String[][] dp = new String[str1.length()][str2.length()];
//        return shortestCommonSupersequence(0, 0, str1, str2, dp);
//    }

//    private String shortestCommonSupersequence(int str1Index, int str2Index, String str1, String str2) {
//        if (str1Index == str1.length()) {
//            return str2.substring(str2Index);
//        }
//
//        if (str2Index == str2.length()) {
//            return str1.substring(str1Index);
//        }
//
//        if (str1.charAt(str1Index) == str2.charAt(str2Index)) {
//            return str1.charAt(str1Index) + shortestCommonSupersequence(str1Index + 1, str2Index + 1, str1, str2);
//        }
//
//        String includeStr1 = str1.charAt(str1Index) + shortestCommonSupersequence(str1Index + 1, str2Index, str1, str2);
//        String includeStr2 = str2.charAt(str2Index) + shortestCommonSupersequence(str1Index, str2Index + 1, str1, str2);
//
//        return (includeStr1.length() <= includeStr2.length()) ? includeStr1 : includeStr2;
//    }
//
//    public String shortestCommonSupersequence(String str1, String str2) {
//        return shortestCommonSupersequence(0, 0, str1, str2);
//    }

//    private static StringBuilder getStringBuilder(String str1, String str2, int[][] dp) {
//        StringBuilder answer = new StringBuilder();
//
//        // dp[i][j] represents the length of LCS starting from index i in str1 and index j in str2.
//        // dp for str1 = "abac" and str2 = "cab"
//        // LCS is "ab"
//        // SCS is "cabac"
//
//        /*     c  a  b
//        [      0  1  2  3
//        0  a  [2, 2, 1, 0],
//        1  b  [1, 1, 1, 0],
//        2  a  [1, 1, 0, 0],
//        3  c  [1, 0, 0, 0],
//              [0, 0, 0, 0]
//        ]
//
//        // dp[0][0] -> dp[0][1]
//         */
//
//        // Logic To Construct LCS from dp[i][j] is such that we start from length of LCS, that is dp[0][0].
//
//        // if for currentIndices i in str1 and j in str2, characters are equal that is str1.charAt(i)==str2.charAt(j)
//        // We take that character once and increment both i and j by 1 that is i++, j++
//
//        // else if characters are not equal we check which is greater that is dp[i+1][j]/ dp[i][j+1]
//        // Whichever is larger increment opposite index.
//        // That is if dp[i+1][j] > dp[i][j+1], append str2.charAt(j) and increment j.
//        // if dp[i+1][j] < dp[i][j+1], append str1.charAt(i) and increment i.
//        // if dp[i+1][j] == dp[i][j+1], we can do anything.
//
//        int i = 0;
//        int j = 0;
//
//        while (i < str1.length() && j < str2.length()) {
//            if (str1.charAt(i) == str2.charAt(j)) {
//                answer.append(str1.charAt(i));
//                i++;
//                j++;
//            } else if (dp[i + 1][j] >= dp[i][j + 1]) {
//                answer.append(str1.charAt(i++));
//            } else {
//                answer.append(str2.charAt(j++));
//            }
//        }
//
//        if (i < str1.length()) {
//            answer.append(str1.substring(i));
//        }
//        if (j < str2.length()) {
//            answer.append(str2.substring(j));
//        }
//        return answer;
//    }
//
//    public static String shortestCommonSupersequence(String str1, String str2) {
//
//        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
//
//        for (int i = 0; i < str1.length(); i++) {
//            dp[i][str2.length()] = 0;
//        }
//
//        for (int i = 0; i < str2.length(); i++) {
//            dp[str1.length()][i] = 0;
//        }
//
//        for (int i = str1.length() - 1; i >= 0; i--) {
//            for (int j = str2.length() - 1; j >= 0; j--) {
//                if (str1.charAt(i) == str2.charAt(j)) {
//                    dp[i][j] = 1 + dp[i + 1][j + 1];
//                } else {
//                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
//                }
//            }
//        }
//
//        StringBuilder answer = getStringBuilder(str1, str2, dp);
//        return answer.toString();
//    }
}
