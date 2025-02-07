package org.example.Daily._2025.February._5;

// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/description/
public class _1790_Check_if_One_String_Swap_Can_Make_Strings_Equal {

    public boolean areAlmostEqual(String s1, String s2) {

        if (s1.equals(s2)) {
            return true;
        }

        int mismatchIndex1 = -1;
        int mismatchIndex2 = -1;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (mismatchIndex2 != -1) {
                    return false;
                } else if (mismatchIndex1 == -1) {
                    mismatchIndex1 = i;
                } else {
                    mismatchIndex2 = i;
                }
            }
        }

        // If only 1 character is mismatching, we cannot make them equal with swapping
        // as after swapping, another index will cause mismatch
        if (mismatchIndex2 == -1) {
            return false;
        }

        return (s1.charAt(mismatchIndex1) == s2.charAt(mismatchIndex2) &&
                s1.charAt(mismatchIndex2) == s2.charAt(mismatchIndex1));
    }
}
