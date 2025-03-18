package org.example.Striver_SDE_Sheet.Day_26_Dynamic_Programming_Part_II;

import java.util.List;

// https://leetcode.com/problems/word-break/description/
public class _139_Word_Break {

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String currentWord : wordDict) {
                if (i + currentWord.length() > s.length()) {
                    continue;
                }

                int currentIndexInStringS = i;
                int currentIndexInCurrentWord = 0;

                while (currentIndexInCurrentWord < currentWord.length() && currentIndexInStringS < s.length() && currentWord.charAt(currentIndexInCurrentWord) == s.charAt(currentIndexInStringS)) {
                    currentIndexInCurrentWord++;
                    currentIndexInStringS++;
                }

                if (currentIndexInCurrentWord == currentWord.length() && dp[currentIndexInStringS]) {
                    dp[i] = true;
                    break;
                }
            }
            // if dp[i] is already marked, don't mark it false.
            if (!dp[i]) {
                dp[i] = false;
            }
        }

        return dp[0];
    }

//    private static boolean wordBreak(int currentIndex, String s, List<String> wordDict, Boolean[] dp) {
//        if (currentIndex == s.length()) {
//            return true;
//        }
//
//        if (dp[currentIndex] != null) {
//            return dp[currentIndex];
//        }
//
//        for (String currentWord : wordDict) {
//            if (currentIndex + currentWord.length() > s.length()) {
//                continue;
//            }
//
//            int currentIndexInStringS = currentIndex;
//            int currentIndexInCurrentWord = 0;
//
//            while (currentIndexInCurrentWord < currentWord.length() && currentIndexInStringS < s.length() && currentWord.charAt(currentIndexInCurrentWord) == s.charAt(currentIndexInStringS)) {
//                currentIndexInCurrentWord++;
//                currentIndexInStringS++;
//            }
//
//            if (currentIndexInCurrentWord == currentWord.length() && wordBreak(currentIndexInStringS, s, wordDict, dp)) {
//                dp[currentIndex] = true;
//                return true;
//            }
//        }
//
//        dp[currentIndex] = false;
//        return false;
//    }
//
//    public static boolean wordBreak(String s, List<String> wordDict) {
//        Boolean[] dp = new Boolean[s.length()];
//        return wordBreak(0, s, wordDict, dp);
//    }

//    private static boolean wordBreak(int currentIndex, String s, List<String> wordDict) {
//        if (currentIndex == s.length()) {
//            return true;
//        }
//
//        for (String currentWord : wordDict) {
//            if (currentIndex + currentWord.length() > s.length()) {
//                continue;
//            }
//
//            int currentIndexInStringS = currentIndex;
//            int currentIndexInCurrentWord = 0;
//
//            while (currentIndexInCurrentWord < currentWord.length() && currentIndexInStringS < s.length() && currentWord.charAt(currentIndexInCurrentWord) == s.charAt(currentIndexInStringS)) {
//                currentIndexInCurrentWord++;
//                currentIndexInStringS++;
//            }
//
//            if (currentIndexInCurrentWord == currentWord.length() && wordBreak(currentIndexInStringS, s, wordDict)) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    public static boolean wordBreak(String s, List<String> wordDict) {
//        return wordBreak(0, s, wordDict);
//    }
}
