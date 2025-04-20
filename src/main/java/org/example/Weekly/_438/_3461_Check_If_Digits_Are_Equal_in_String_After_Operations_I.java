package org.example.Weekly._438;

// https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/description/
public class _3461_Check_If_Digits_Are_Equal_in_String_After_Operations_I {
    public boolean hasSameDigits(String s) {
        StringBuilder current = new StringBuilder(s);

        while (current.length() != 2) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < current.length() - 1; i++) {
                int currentSum = (Integer.parseInt(String.valueOf(current.charAt(i))) + Integer.parseInt(String.valueOf(current.charAt(i + 1)))) % 10;
                temp.append(currentSum);
            }
            current = new StringBuilder(temp);
        }

        return current.charAt(0) == current.charAt(1);
    }
}
