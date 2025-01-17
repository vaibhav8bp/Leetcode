package org.example.Daily._2025.January._8;

// https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description
public class _3042_Count_Prefix_and_Suffix_Pairs_I {

    private boolean isStr1BothPrefixAndSuffixOfStr2(String str1, String str2) {
        if (str1.length() > str2.length()) {
            return false;
        } else if (str1.length() == str2.length()) {
            return str1.equals(str2);
        } else {

            // Prefix Check
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    return false;
                }
            }

            // Suffix Check

            int lengthDifference = str2.length() - str1.length();

            for (int i = lengthDifference; i < str2.length(); i++) {
                if (str1.charAt(i-lengthDifference) != str2.charAt(i)) {
                    return false;
                }
            }

            return true;
        }
    }

    public int countPrefixSuffixPairs(String[] words) {

        int count = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isStr1BothPrefixAndSuffixOfStr2(words[i], words[j])) {
                    count++;
                }
            }
        }

        return count;
    }
}
