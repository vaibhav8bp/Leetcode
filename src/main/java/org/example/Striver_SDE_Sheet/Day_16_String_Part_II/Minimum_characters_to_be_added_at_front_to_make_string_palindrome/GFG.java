package org.example.Striver_SDE_Sheet.Day_16_String_Part_II.Minimum_characters_to_be_added_at_front_to_make_string_palindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.interviewbit.com/problems/minimum-characters-required-to-make-a-string-palindromic/
// Z Function Solution
// After forming zArray. How to get the answer ?
class Solution {
    public static int minChar(String str) {
        StringBuilder concatenated = new StringBuilder()
                .append(str).append('$').append(new StringBuilder(str).reverse());
        int[] zArray = new int[concatenated.length()];
        int length = 0;
        zArray[0] = 0;
        int left = 0;
        int right = 0;
        for (int k = 1; k < concatenated.length(); k++) {
            if (k > right) {
                left = k;
                right = k;
                while (right < concatenated.length() && concatenated.charAt(right) == concatenated.charAt(right - left)) {
                    right++;
                }
                zArray[k] = right - left;
                right--;
            } else {
                int k1 = k - left;
                if (zArray[k1] < right - k + 1) {
                    zArray[k] = zArray[k1];
                } else {
                    left = k;
                    while (right < concatenated.length() && concatenated.charAt(right) == concatenated.charAt(right - left)) {
                        right++;
                    }
                    zArray[k] = right - left;
                    right--;
                }
            }
            if (zArray[k] == concatenated.length() - k) {
                length = Math.max(length, zArray[k]);
            }
        }


        return str.length() - length;
    }
}

// KMP Solution
// Length of string - lps[end] will be the no. of chars to be added
// class Solution {
//    public static int minChar(String str) {
//        StringBuilder concatenated = new StringBuilder()
//                .append(str).append('$').append(new StringBuilder(str).reverse());
//        int[] lps = new int[concatenated.length()];
//        int previousLPS = 0;
//        lps[0] = 0;
//        int index = 1;
//        while (index < concatenated.length()) {
//            if (concatenated.charAt(index) == concatenated.charAt(previousLPS)) {
//                previousLPS++;
//                lps[index++] = previousLPS;
//            } else {
//                if (previousLPS == 0) {
//                    lps[index++] = 0;
//                } else {
//                    previousLPS = lps[previousLPS - 1];
//                }
//            }
//        }
//        return str.length() - lps[concatenated.length() - 1];
//    }
// }

// 2 Pointers - O(N^2),
// class Solution {
//    public static int minChar(String str) {
//        int count = 0;
//        int start = 0;
//        int end = str.length() - 1;

//        while (start < end) {
//            if (str.charAt(start) == str.charAt(end)) {
//                start++;
//                end--;
//            } else {
//                // Update Start end again.
//                // End now will be lastIndex - count that is
//                // subtracting the value of mismatched characters
//                count++;
//                start = 0;
//                end = str.length() - 1 - count;
//            }
//        }

//        return count;
//    }
// }

// Brute Force - O(N^2), Check Palindrome
// class Solution {

//    static boolean isPalindrome(String s) {
//        int start = 0;
//        int end = s.length() - 1;
//        while (start < end) {
//            if (s.charAt(start) != s.charAt(end)) {
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
//    }

//    public static int minChar(String str) {
//        int count = 0;

//        while (!str.isEmpty()) {
//            if (isPalindrome(str)) {
//                break;
//            } else {
//                count++;
//                StringBuilder stringBuilder = new StringBuilder(str);
//                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
//                str = stringBuilder.toString();
//            }
//        }
//        return count;
//    }
// }

class GFG {
    public static void main(String[] args) throws IOException {
        var sc = new FastReader();
        int test = sc.nextInt();
        while (test-- > 0) {
            String s = sc.nextString();
            System.out.println(Solution.minChar(s));
        }
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        private void read() throws IOException {
            st = new StringTokenizer(br.readLine());
        }

        public String nextString() throws IOException {
            while (!st.hasMoreTokens()) read();
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(nextString());
        }
    }
}