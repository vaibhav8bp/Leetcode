package org.example.Google;

import java.util.Arrays;

// https://leetcode.com/problems/longest-common-prefix/description/
public class _14_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        StringBuilder answer = new StringBuilder();

        int minStringLength = Integer.MAX_VALUE;

        for (String currentString : strs) {
            minStringLength = Math.min(currentString.length(), minStringLength);
        }

        String firstString = strs[0];
        String lastString = strs[strs.length - 1];

        for (int i = 0; i < minStringLength; i++) {
            if (firstString.charAt(i) != lastString.charAt(i)) {
                return answer.toString();
            }
            answer.append(firstString.charAt(i));
        }

        return answer.toString();
    }
}
