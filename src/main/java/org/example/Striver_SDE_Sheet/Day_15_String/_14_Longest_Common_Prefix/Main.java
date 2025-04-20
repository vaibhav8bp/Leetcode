package org.example.Striver_SDE_Sheet.Day_15_String._14_Longest_Common_Prefix;

import java.util.Arrays;

// https://leetcode.com/problems/longest-common-prefix/description/
class Solution {
    public String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);
        int index = 0;
        String firstString = strs[0];
        String lastString = strs[strs.length - 1];
        while (index < firstString.length() && index < lastString.length() && firstString.charAt(index) == lastString.charAt(index)) {
            index++;
        }

        return firstString.substring(0, index);
    }
}

public class Main {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(new Solution().longestCommonPrefix(strs));
    }
}
