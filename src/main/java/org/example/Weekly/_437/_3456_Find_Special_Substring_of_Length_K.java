package org.example.Weekly._437;

// https://leetcode.com/problems/find-special-substring-of-length-k/description/
public class _3456_Find_Special_Substring_of_Length_K {
    public boolean hasSpecialSubstring(String s, int k) {
        for (int i = 0; i < s.length() - k + 1; i++) {
            int index = i + 1;
            int count = 1;

            while (count != k && s.charAt(i) == s.charAt(index)) {
                count++;
                index++;
            }

            if (count == k) {
                // Check Back
                boolean special = true;
                if (i != 0 && s.charAt(i - 1) == s.charAt(i)) {
                    special = false;
                }

                // Check Forward
                if (i != s.length() - k && s.charAt(i + k) == s.charAt(i)) {
                    special = false;
                }

                if (special) {
                    return true;
                }
            }
        }

        return false;
    }
}
