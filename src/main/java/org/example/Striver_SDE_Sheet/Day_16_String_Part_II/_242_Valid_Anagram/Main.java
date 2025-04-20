package org.example.Striver_SDE_Sheet.Day_16_String_Part_II._242_Valid_Anagram;

import java.util.Arrays;

// https://leetcode.com/problems/valid-anagram/description/
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] frequency = new int[26];
        Arrays.fill(frequency, 0);
        int length = s.length();
        for (int i = 0; i < length; i++) {
            frequency[s.charAt(i) - 'a']++;
            frequency[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (frequency[i] != 0) {
                return false;
            }
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("anagram", "nagaram"));
    }
}
