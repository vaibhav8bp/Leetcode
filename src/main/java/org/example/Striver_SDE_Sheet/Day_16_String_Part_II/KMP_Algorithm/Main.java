package org.example.Striver_SDE_Sheet.Day_16_String_Part_II.KMP_Algorithm;

import java.util.Arrays;

class Solution {

    private void computeLPSArray(int[] lps, String needle) {
        lps[0] = 0;
        int previousLPS = 0;
        for (int i = 1; i < needle.length(); ) {
            if (needle.charAt(i) == needle.charAt(previousLPS)) {
                previousLPS++;
                lps[i] = previousLPS;
                i++;
            } else {
                if (previousLPS == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    previousLPS = lps[previousLPS - 1];
                }
            }
        }
    }

    public int strStr(String haystack, String needle) {
        int[] lps = new int[needle.length()];
        computeLPSArray(lps, needle);
        System.out.println(Arrays.toString(lps));

        int i = 0, j = 0;
        int h = haystack.length();
        int n = needle.length();

        while (i < h) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
            if (j == n) {
                return i - n;
                // In case all occurrences are need
//                j = lps[j - 1];
            }
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().strStr("sadbutsad", "aacecaaa"));
    }
}