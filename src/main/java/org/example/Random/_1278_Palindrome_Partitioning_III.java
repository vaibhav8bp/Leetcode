package org.example.Random;

// https://leetcode.com/problems/palindrome-partitioning-iii/description/
public class _1278_Palindrome_Partitioning_III {

    private static void populateMinOperationsDp(int[][] minOperationsDp, String s) {
        for (int i = 0; i < s.length(); i++) {
            minOperationsDp[i][i] = 0;
        }

        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                boolean areExtremeCharactersEqual = s.charAt(i) == s.charAt(j);
                if ((j - i) == 1) {
                    if (areExtremeCharactersEqual) {
                        minOperationsDp[i][j] = 0;
                    } else {
                        minOperationsDp[i][j] = 1;
                    }
                } else {
                    if (areExtremeCharactersEqual) {
                        minOperationsDp[i][j] = minOperationsDp[i + 1][j - 1];
                    } else {
                        minOperationsDp[i][j] = 1 + minOperationsDp[i + 1][j - 1];
                    }
                }
            }
        }
    }

    public static int palindromePartition(String s, int k) {
        int[][] minOperationsDp = new int[s.length()][s.length()];
        populateMinOperationsDp(minOperationsDp, s);

        int[][] dp = new int[s.length()][k];

        for (int i = 0; i < s.length(); i++) {
            dp[i][k - 1] = minOperationsDp[i][s.length() - 1];
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = k - 2; j >= 0; j--) {

                int minOperations = Integer.MAX_VALUE;

                for (int l = i; l < s.length() - (k - j) + 1; l++) {
                    minOperations = Math.min(minOperations, minOperationsDp[i][l] + dp[l + 1][j + 1]);
                }

                dp[i][j] = minOperations;
            }
        }

        return dp[0][0];
    }

//    private static void populateMinOperationsDp(int[][] minOperationsDp, String s) {
//        for (int i = 0; i < s.length(); i++) {
//            minOperationsDp[i][i] = 0;
//        }
//
//        for (int i = s.length() - 2; i >= 0; i--) {
//            for (int j = i + 1; j < s.length(); j++) {
//                boolean areExtremeCharactersEqual = s.charAt(i) == s.charAt(j);
//                if ((j - i) == 1) {
//                    if (areExtremeCharactersEqual) {
//                        minOperationsDp[i][j] = 0;
//                    } else {
//                        minOperationsDp[i][j] = 1;
//                    }
//                } else {
//                    if (areExtremeCharactersEqual) {
//                        minOperationsDp[i][j] = minOperationsDp[i + 1][j - 1];
//                    } else {
//                        minOperationsDp[i][j] = 1 + minOperationsDp[i + 1][j - 1];
//                    }
//                }
//            }
//        }
//    }
//
//
//    private static int makeKGroupsOfStringS(int currentIndex, int currentGroupLength, String s, int k, int[][] minOperationsDp, int[][] dp) {
//        if (currentGroupLength == k - 1) {
//            return minOperationsDp[currentIndex][s.length() - 1];
//        }
//
//        if (dp[currentIndex][currentGroupLength] != -1) {
//            return dp[currentIndex][currentGroupLength];
//        }
//
//        int minOperations = Integer.MAX_VALUE;
//
//        for (int i = currentIndex; i < s.length() - (k - currentGroupLength) + 1; i++) {
//            minOperations = Math.min(minOperations, minOperationsDp[currentIndex][i]
//                    + makeKGroupsOfStringS(i + 1, currentGroupLength + 1, s, k, minOperationsDp, dp));
//        }
//
//        dp[currentIndex][currentGroupLength] = minOperations;
//
//        return minOperations;
//    }
//
//    public static int palindromePartition(String s, int k) {
//        int[][] minOperationsDp = new int[s.length()][s.length()];
//        int[][] dp = new int[s.length()][k];
//
//        for (int i = 0; i < s.length(); i++) {
//            Arrays.fill(dp[i], -1);
//        }
//
//        populateMinOperationsDp(minOperationsDp, s);
//        return makeKGroupsOfStringS(0, 0, s, k, minOperationsDp, dp);
//    }

//    private static void populateMinOperationsDp(int[][] minOperationsDp, String s) {
//        for (int i = 0; i < s.length(); i++) {
//            minOperationsDp[i][i] = 0;
//        }
//
//        for (int i = s.length() - 2; i >= 0; i--) {
//            for (int j = i + 1; j < s.length(); j++) {
//                boolean areExtremeCharactersEqual = s.charAt(i) == s.charAt(j);
//                if ((j - i) == 1) {
//                    if (areExtremeCharactersEqual) {
//                        minOperationsDp[i][j] = 0;
//                    } else {
//                        minOperationsDp[i][j] = 1;
//                    }
//                } else {
//                    if (areExtremeCharactersEqual) {
//                        minOperationsDp[i][j] = minOperationsDp[i + 1][j - 1];
//                    } else {
//                        minOperationsDp[i][j] = 1 + minOperationsDp[i + 1][j - 1];
//                    }
//                }
//            }
//        }
//    }
//
//
//    private static int makeKGroupsOfStringS(int currentIndex, int currentGroupLength, String s, int k, int[][] minOperationsDp, int[][] dp) {
//        if (currentGroupLength == k - 1) {
//            return minOperationsDp[currentIndex][s.length() - 1];
//        }
//
//        if (currentIndex == s.length()) {
//            return 0;
//        }
//
//        if (dp[currentIndex][currentGroupLength] != -1) {
//            return dp[currentIndex][currentGroupLength];
//        }
//
//        int minOperations = Integer.MAX_VALUE;
//
//        for (int i = currentIndex; i < s.length() - (k - currentGroupLength) + 1; i++) {
//            minOperations = Math.min(minOperations, minOperationsDp[currentIndex][i]
//                    + makeKGroupsOfStringS(i + 1, currentGroupLength + 1, s, k, minOperationsDp, dp));
//        }
//
//        dp[currentIndex][currentGroupLength] = minOperations;
//
//        return minOperations;
//    }
//
//    public static int palindromePartition(String s, int k) {
//        int[][] minOperationsDp = new int[s.length()][s.length()];
//        int[][] dp = new int[s.length()][k];
//
//        for (int i = 0; i < s.length(); i++) {
//            Arrays.fill(dp[i], -1);
//        }
//
//        populateMinOperationsDp(minOperationsDp, s);
//        return makeKGroupsOfStringS(0, 0, s, k, minOperationsDp, dp);
//    }

//    private static void populateMinOperationsDp(int[][] minOperationsDp, String s) {
//        for (int i = 0; i < s.length(); i++) {
//            minOperationsDp[i][i] = 0;
//        }
//
//        for (int i = s.length() - 2; i >= 0; i--) {
//            for (int j = i + 1; j < s.length(); j++) {
//                boolean areExtremeCharactersEqual = s.charAt(i) == s.charAt(j);
//                if ((j - i) == 1) {
//                    if (areExtremeCharactersEqual) {
//                        minOperationsDp[i][j] = 0;
//                    } else {
//                        minOperationsDp[i][j] = 1;
//                    }
//                } else {
//                    if (areExtremeCharactersEqual) {
//                        minOperationsDp[i][j] = minOperationsDp[i + 1][j - 1];
//                    } else {
//                        minOperationsDp[i][j] = 1 + minOperationsDp[i + 1][j - 1];
//                    }
//                }
//            }
//        }
//    }
//
//
//    private static int makeKGroupsOfStringS(int currentIndex, int currentGroupLength, String s, int k, int[][] minOperationsDp) {
//        if (currentGroupLength == k - 1) {
//            return minOperationsDp[currentIndex][s.length() - 1];
//        }
//
//        if (currentIndex == s.length()) {
//            return 0;
//        }
//
//        int minOperations = Integer.MAX_VALUE;
//
//        for (int i = currentIndex; i < s.length() - (k - currentGroupLength) + 1; i++) {
//            minOperations = Math.min(minOperations, minOperationsDp[currentIndex][i]
//                    + makeKGroupsOfStringS(i + 1, currentGroupLength + 1, s, k, minOperationsDp));
//        }
//
//        return minOperations;
//    }
//
//    public static int palindromePartition(String s, int k) {
//        int[][] minOperationsDp = new int[s.length()][s.length()];
//        populateMinOperationsDp(minOperationsDp, s);
//        return makeKGroupsOfStringS(0, 0, s, k, minOperationsDp);
//    }

//    private static int minOperations = Integer.MAX_VALUE;
//
//    private static void makeKGroupsOfStringS(int currentIndex, int currentGroupLength, int[][] currentGroup, String s, int k, int[][] minOperationsDp) {
//        if (currentGroupLength == k - 1) {
//            currentGroup[k - 1][0] = currentIndex;
//            currentGroup[k - 1][1] = s.length() - 1;
//
//            int currentGroupOperations = 0;
//            for (int[] current : currentGroup) {
//                currentGroupOperations += minOperationsDp[current[0]][current[1]];
//            }
//            minOperations = Math.min(minOperations, currentGroupOperations);
//            return;
//        }
//
//        if (currentIndex == s.length()) {
//            return;
//        }
//
//        // aabbc
//        // First -> aa
//        // currentIndex = 2, endIndex = 5-(3-1)+1=5-2+1=4
//
//        // Tried to loop less no. of times on virtue of length.
//        for (int i = currentIndex; i < s.length() - (k - currentGroupLength) + 1; i++) {
//            currentGroup[currentGroupLength][0] = currentIndex;
//            currentGroup[currentGroupLength][1] = i;
//            makeKGroupsOfStringS(i + 1, currentGroupLength + 1, currentGroup, s, k, minOperationsDp);
//        }
//    }
//
//    private static void populateMinOperationsDp(int[][] minOperationsDp, String s) {
//        for (int i = 0; i < s.length(); i++) {
//            minOperationsDp[i][i] = 0;
//        }
//
//        for (int i = s.length() - 2; i >= 0; i--) {
//            for (int j = i + 1; j < s.length(); j++) {
//                boolean areExtremeCharactersEqual = s.charAt(i) == s.charAt(j);
//                if ((j - i) == 1) {
//                    if (areExtremeCharactersEqual) {
//                        minOperationsDp[i][j] = 0;
//                    } else {
//                        minOperationsDp[i][j] = 1;
//                    }
//                } else {
//                    if (areExtremeCharactersEqual) {
//                        minOperationsDp[i][j] = minOperationsDp[i + 1][j - 1];
//                    } else {
//                        minOperationsDp[i][j] = 1 + minOperationsDp[i + 1][j - 1];
//                    }
//                }
//            }
//        }
//    }
//
//    public static int palindromePartition(String s, int k) {
//        int[][] minOperationsDp = new int[s.length()][s.length()];
//        populateMinOperationsDp(minOperationsDp, s);
//        minOperations = Integer.MAX_VALUE;
//        // This will store start and endIndex of every string in group.
//        int[][] currentGroup = new int[k][2];
//        makeKGroupsOfStringS(0, 0, currentGroup, s, k, minOperationsDp);
//        return minOperations;
//    }

//    private static int minOperations = Integer.MAX_VALUE;
//
//    private static int minimumCharacterChangeToMakeCurrentStringPalindrome(String currentString) {
//        int minCharacterChange = 0;
//
//        int left = 0;
//        int right = currentString.length() - 1;
//
//        while (left < right) {
//            if (currentString.charAt(left) != currentString.charAt(right)) {
//                minCharacterChange++;
//            }
//            left++;
//            right--;
//        }
//
//        return minCharacterChange;
//    }
//
//    private static void makeKGroupsOfStringS(int currentIndex, int currentGroupLength, String[] currentGroup, String s, int k) {
//        if (currentGroupLength == k - 1) {
//            currentGroup[k - 1] = s.substring(currentIndex);
//            int currentGroupOperations = 0;
//            for (String current : currentGroup) {
//                currentGroupOperations += minimumCharacterChangeToMakeCurrentStringPalindrome(current);
//            }
//            minOperations = Math.min(minOperations, currentGroupOperations);
//            return;
//        }
//
//        if (currentIndex == s.length()) {
//            return;
//        }
//
//        for (int i = currentIndex; i < s.length() - 1; i++) {
//            currentGroup[currentGroupLength] = s.substring(currentIndex, i + 1);
//            makeKGroupsOfStringS(i + 1, currentGroupLength + 1, currentGroup, s, k);
//        }
//    }
//
//    public static int palindromePartition(String s, int k) {
//        minOperations = Integer.MAX_VALUE;
//        makeKGroupsOfStringS(0, 0, new String[k], s, k);
//        return minOperations;
//    }

    public static void main(String[] args) {
        System.out.println(palindromePartition("aabbc", 3));
    }
}
