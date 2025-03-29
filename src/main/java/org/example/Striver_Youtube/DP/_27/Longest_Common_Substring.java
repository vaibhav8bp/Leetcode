package org.example.Striver_Youtube.DP._27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/longest-common-substring1452/1
public class Longest_Common_Substring {

    // dp[i][j] denotes only length of substring starting from i in s1 and j in s2.
    // For max. we have to give max value of table

    public int longestCommonSubstr(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        Arrays.fill(dp[s1.length()], 0);

        for (int i = 0; i < s1.length() + 1; i++) {
            dp[i][s2.length()] = 0;
        }

        int answer = 0;

        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                    answer = Math.max(answer, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return answer;
    }

//    public int longestCommonSubstr(String s1, String s2) {
//        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
//        Arrays.fill(dp[s1.length()], 0);
//
//        for (int i = 0; i < s1.length() + 1; i++) {
//            dp[i][s2.length()] = 0;
//        }
//
//        for (int i = s1.length() - 1; i >= 0; i--) {
//            for (int j = s2.length() - 1; j >= 0; j--) {
//                int considerSubstring = 0;
//                if (s1.charAt(i) == s2.charAt(j)) {
//                    int length = 1;
//                    int tempS1Index = i + 1;
//                    int tempS2Index = j + 1;
//                    while (tempS1Index < s1.length() && tempS2Index < s2.length() && s1.charAt(tempS1Index) == s2.charAt(tempS2Index)) {
//                        length++;
//                        tempS1Index++;
//                        tempS2Index++;
//                    }
//                    considerSubstring = Math.max(length, dp[tempS1Index][tempS2Index]);
//                }
//
//                int skipS1 = dp[i + 1][j];
//                int skipS2 = dp[i][j + 1];
//                dp[i][j] = Math.max(Math.max(considerSubstring, skipS1), skipS2);
//            }
//        }
//
//        return dp[0][0];
//    }

//    private int longestCommonSubstr(int s1Index, int s2Index, String s1, String s2, int[][] dp) {
//
//        if (s1Index == s1.length() || s2Index == s2.length()) {
//            return 0;
//        }
//
//        if (dp[s1Index][s2Index] != -1) {
//            return dp[s1Index][s2Index];
//        }
//
//        int considerSubstring = 0;
//
//        if (s1.charAt(s1Index) == s2.charAt(s2Index)) {
//            int length = 1;
//            int tempS1Index = s1Index + 1;
//            int tempS2Index = s2Index + 1;
//            while (tempS1Index < s1.length() && tempS2Index < s2.length() && s1.charAt(tempS1Index) == s2.charAt(tempS2Index)) {
//                length++;
//                tempS1Index++;
//                tempS2Index++;
//            }
//            considerSubstring = Math.max(length, longestCommonSubstr(tempS1Index, tempS2Index, s1, s2, dp));
//        }
//
//        int skipS1 = longestCommonSubstr(s1Index + 1, s2Index, s1, s2, dp);
//        int skipS2 = longestCommonSubstr(s1Index, s2Index + 1, s1, s2, dp);
//        dp[s1Index][s2Index] = Math.max(Math.max(considerSubstring, skipS1), skipS2);
//        return dp[s1Index][s2Index];
//    }
//
//    public int longestCommonSubstr(String s1, String s2) {
//        int[][] dp = new int[s1.length()][s2.length()];
//        for (int i = 0; i < s1.length(); i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return longestCommonSubstr(0, 0, s1, s2, dp);
//    }

//    private int longestCommonSubstr(int s1Index, int s2Index, String s1, String s2) {
//
//        if (s1Index == s1.length() || s2Index == s2.length()) {
//            return 0;
//        }
//
//        int considerSubstring = 0;
//
//        if (s1.charAt(s1Index) == s2.charAt(s2Index)) {
//            int length = 1;
//            int tempS1Index = s1Index + 1;
//            int tempS2Index = s2Index + 1;
//            while (tempS1Index < s1.length() && tempS2Index < s2.length() && s1.charAt(tempS1Index) == s2.charAt(tempS2Index)) {
//                length++;
//                tempS1Index++;
//                tempS2Index++;
//            }
//            considerSubstring = Math.max(length, longestCommonSubstr(tempS1Index, tempS2Index, s1, s2));
//        }
//
//        int skipS1 = longestCommonSubstr(s1Index + 1, s2Index, s1, s2);
//        int skipS2 = longestCommonSubstr(s1Index, s2Index + 1, s1, s2);
//        return Math.max(Math.max(considerSubstring, skipS1), skipS2);
//    }
//
//    public int longestCommonSubstr(String s1, String s2) {
//        return longestCommonSubstr(0, 0, s1, s2);
//    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Longest_Common_Substring ob = new Longest_Common_Substring();
            System.out.println(ob.longestCommonSubstr(S1, S2));

            System.out.println("~");
        }
    }
}

/*
1
ABCDGH
ACDGHR
 */