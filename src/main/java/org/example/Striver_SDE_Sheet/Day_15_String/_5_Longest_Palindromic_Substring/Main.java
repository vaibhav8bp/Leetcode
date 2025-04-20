package org.example.Striver_SDE_Sheet.Day_15_String._5_Longest_Palindromic_Substring;

// https://leetcode.com/problems/longest-palindromic-substring/description/
// Expand From Center Solution
// TC - O(N^2), SC - O(1)
class Solution {

   // Return the length of the substring
   public int expandOutwards(String s, int start, int end) {
       int lengthOfPalindrome = 0;

       while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
           if (start == end) {
               lengthOfPalindrome += 1;
           } else {
               lengthOfPalindrome += 2;
           }
           start--;
           end++;
       }

       return lengthOfPalindrome;
   }

   public String longestPalindrome(String s) {
       int maxLengthSoFar = 0;
       int start = 0;
       int end = 0;

       for (int i = 0; i < s.length(); i++) {
           // Odd Length
           int oddLength = expandOutwards(s, i, i);
           // Even Length
           int evenLength = expandOutwards(s, i, i + 1);

           if (maxLengthSoFar < oddLength) {
               maxLengthSoFar = oddLength;
               int expansionLength = (oddLength - 1);
               start = i - expansionLength / 2;
               end = i + expansionLength / 2;
           }
           if (maxLengthSoFar < evenLength) {
               maxLengthSoFar = evenLength;
               int expansionLength = (evenLength - 2);
               start = i - expansionLength / 2;
               end = (i + 1) + expansionLength / 2;
           }
       }

       return s.substring(start, end + 1);
   }
}

// TC - O(N^2), SC -O(N^2)
// class Solution {

//    public String longestPalindrome(String s) {
//        boolean[][] dp = new boolean[s.length()][s.length()];
//        for (int i = 0; i < s.length(); i++) {
//            Arrays.fill(dp[i], false);
//        }

//        //We have to return substring so we will consider only lower
//        // triangular matrix that is i<=j . j can't be less than i

//        int maxLengthSubstring = 0;
//        int start = 0;
//        int end = 0;

//        for (int i = s.length() - 1; i >= 0; i--) {
//            for (int j = i; j < s.length(); j++) {
//                // 1 length string always a palindrome
//                if (i == j) {
//                    dp[i][j] = true;
//                }
//                // For 2 length string just check first and last char
//                else if ((j - i) == 1) {
//                    if (s.charAt(i) == s.charAt(j)) {
//                        dp[i][j] = true;
//                    }
//                }
//                // For length>2 , we will check whether first and last are equal
//                // plus middle of them is palindrome or not. That can be easily accessed from dp
//                else {
//                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
//                        dp[i][j] = true;
//                    }
//                }

//                if (maxLengthSubstring < (j - i + 1) && dp[i][j]) {
//                    start = i;
//                    end = j;
//                    maxLengthSubstring = j - i + 1;
//                }
//            }
//        }

//        return s.substring(start, end + 1);
//    }
// }

// O(N^3)
// class Solution {

//    public boolean isPalindrome(String s, int start, int end) {
//        while (start < end) {
//            if (s.charAt(start) != s.charAt(end)) {
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
//    }

//    public String longestPalindrome(String s) {
//        int maxLengthSubstring = 0;
//        String answer = "";
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i; j < s.length(); j++) {
//                if (maxLengthSubstring < (j - i + 1) && isPalindrome(s, i, j)) {
//                    answer = s.substring(i, j + 1);
//                    maxLengthSubstring = j - i + 1;
//                }
//            }
//        }
//        return answer;
//    }
// }

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("cbbd"));
    }
}
