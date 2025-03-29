package org.example.Random;

// https://leetcode.com/problems/backspace-string-compare/description/
public class _844_Backspace_String_Compare {

    private static boolean evaluateIfAStringIsEffectivelyEmpty(String currentString, int currentIndex) {
        int hashLength = 0;

        while (currentIndex >= 0) {
            if (currentString.charAt(currentIndex) == '#') {
                hashLength++;
            } else {
                if (hashLength == 0) {
                    return false;
                }
                hashLength--;
            }
            currentIndex--;
        }

        return true;
    }

    // This method will return the index to be compared when no hash are there.
    private static int helper(String currentString, int currentIndex, int currentHashLength) {

        // Base Case
        if ((currentIndex == -1) || currentString.charAt(currentIndex) != '#' && currentHashLength == 0) {
            return currentIndex;
        }

        while (currentIndex >= 0 && currentString.charAt(currentIndex) != '#' && currentHashLength >= 1) {
            currentIndex--;
            currentHashLength--;
        }

        while (currentIndex >= 0 && currentString.charAt(currentIndex) == '#') {
            currentIndex--;
            currentHashLength++;
        }

        return helper(currentString, currentIndex, currentHashLength);
    }

    public static boolean backspaceCompare(String s, String t) {

        int sIndex = s.length() - 1;
        int tIndex = t.length() - 1;

        while (sIndex != -1 && tIndex != -1) {
            sIndex = helper(s, sIndex, 0);
            tIndex = helper(t, tIndex, 0);

            // both strings empty return true.
            if (sIndex == -1 && tIndex == -1) {
                return true;
            }
            // one of the strings get empty check other should be empty also
            else if (sIndex == -1 || tIndex == -1) {
                break;
            }
            // both non-empty, compare characters
            else {
                if (s.charAt(sIndex--) != t.charAt(tIndex--)) {
                    return false;
                }
            }
        }

        // Both Are Empty
        if (sIndex == -1 && tIndex == -1) {
            return true;
        }
        // s non-empty, t empty
        else if (sIndex != -1) {
            return evaluateIfAStringIsEffectivelyEmpty(s, sIndex);
        }
        // t non-empty, s empty
        else {
            return evaluateIfAStringIsEffectivelyEmpty(t, tIndex);
        }
    }

//    public boolean backspaceCompare(String s, String t) {
//        StringBuilder modifiedS = new StringBuilder();
//
//        for (Character currentCharacter : s.toCharArray()) {
//            if (currentCharacter.equals('#')) {
//                if (!modifiedS.isEmpty()) {
//                    modifiedS.deleteCharAt(modifiedS.length() - 1);
//                }
//            } else {
//                modifiedS.append(currentCharacter);
//            }
//        }
//
//        StringBuilder modifiedT = new StringBuilder();
//
//        for (Character currentCharacter : t.toCharArray()) {
//            if (currentCharacter.equals('#')) {
//                if (!modifiedT.isEmpty()) {
//                    modifiedT.deleteCharAt(modifiedT.length() - 1);
//                }
//            } else {
//                modifiedT.append(currentCharacter);
//            }
//        }
//
//        return modifiedS.compareTo(modifiedT) == 0;
//    }
}
