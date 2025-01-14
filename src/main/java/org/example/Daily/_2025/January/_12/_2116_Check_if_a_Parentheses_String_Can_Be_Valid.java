package org.example.Daily._2025.January._12;

// https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/description

public class _2116_Check_if_a_Parentheses_String_Can_Be_Valid {

    public boolean canBeValid(String s, String locked) {

        if (s.length() % 2 != 0) {
            return false;
        }

        int openingCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0' || s.charAt(i) == '(') {
                openingCount++;
            } else {
                openingCount--;
                if (openingCount < 0) {
                    return false;
                }
            }
        }

        int closingCount = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0' || s.charAt(i) == ')') {
                closingCount++;
            } else {
                closingCount--;
                if (closingCount < 0) {
                    return false;
                }
            }
        }

        return true;
    }

    // public boolean canBeValid(String s, String locked) {

    //     if (s.length() % 2 != 0) {
    //         return false;
    //     }

    //     // ( indices
    //     Stack<Integer> openIndices = new Stack<>();
    //     // locked = 0, indices
    //     Stack<Integer> unlockedIndices = new Stack<>();

    //     for (int i = 0; i < s.length(); i++) {
    //         if (locked.charAt(i) == '0') {
    //             unlockedIndices.add(i);
    //         } else if (s.charAt(i) == '(') {
    //             openIndices.add(i);
    //         } else {
    //             if (!openIndices.isEmpty()) {
    //                 openIndices.pop();
    //             } else if (!unlockedIndices.isEmpty()) {
    //                 unlockedIndices.pop();
    //             } else {
    //                 return false;
    //             }
    //         }
    //     }

    //     while (!openIndices.isEmpty() && !unlockedIndices.isEmpty() && openIndices.peek() < unlockedIndices.peek()) {
    //         openIndices.pop();
    //         unlockedIndices.pop();
    //     }

    //     if (openIndices.isEmpty() && !unlockedIndices.isEmpty()) {
    //         return (unlockedIndices.size() % 2) == 0;
    //     }

    //     return openIndices.isEmpty();
    // }
}