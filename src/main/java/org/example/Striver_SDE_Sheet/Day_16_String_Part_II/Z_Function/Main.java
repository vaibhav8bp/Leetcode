package org.example.Striver_SDE_Sheet.Day_16_String_Part_II.Z_Function;

// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
class Solution {
    public int strStr(String haystack, String needle) {
        String zArrayString = needle + '$' + haystack;
        int[] zArray = new int[zArrayString.length()];

        int left = 0;
        int right = 0;

        for (int k = 1; k < zArray.length; k++) {
            if (k > right) {
                left = right = k;
                while (right < zArrayString.length() && zArrayString.charAt(right) == zArrayString.charAt(right - left)) {
                    right++;
                }
                zArray[k] = right - left;
                right--;
            } else {
                // We are operating inside the z array box
                int k1 = k - left;
                // Here we have not done <= because we have to check only from z-array last index
                // because if it is not matching prefix before z-array last index. What's the point of comparing ?
                if (zArray[k1] < (right - k + 1)) {
                    zArray[k] = zArray[k1];
                }
                // Value is stretching outside the box. Loop again
                else {
                    left = k;
                    while (right < zArrayString.length() && zArrayString.charAt(right) == zArrayString.charAt(right - left)) {
                        right++;
                    }
                    zArray[k] = right - left;
                    right--;
                }
            }
            if (zArray[k] == needle.length()) {
                return k - needle.length() - 1;
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().strStr("sadbutsad", "sad"));
    }
}