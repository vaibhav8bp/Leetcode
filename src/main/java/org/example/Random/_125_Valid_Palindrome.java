package org.example.Random;

import org.example.Striver_SDE_Sheet.Day_17_Binary_Tree.Top_View_Of_Binary_Tree.Tree;

// https://leetcode.com/problems/valid-palindrome/description/
public class _125_Valid_Palindrome {

    public boolean isPalindrome(String s) {

        int low = 0;
        int high = s.length() - 1;

        while (low < high) {
            if (!Character.isLetterOrDigit(s.charAt(low))) {
                low++;
            } else if (!Character.isLetterOrDigit(s.charAt(high))) {
                high--;
            } else {
                char leftCharacter = (Character.isUpperCase(s.charAt(low))) ?
                        Character.toLowerCase(s.charAt(low)) : s.charAt(low);
                char rightCharacter = (Character.isUpperCase(s.charAt(high))) ?
                        Character.toLowerCase(s.charAt(high)) : s.charAt(high);

                if (leftCharacter != rightCharacter) {
                    return false;
                }

                low++;
                high--;
            }
        }
        return true;
    }
//    public boolean isPalindrome(String s) {
//        StringBuilder modified = new StringBuilder();
//
//        for (Character currentCharacter : s.toCharArray()) {
//            if (Character.isLetterOrDigit(currentCharacter)) {
//                if (Character.isUpperCase(currentCharacter)) {
//                    modified.append(Character.toLowerCase(currentCharacter));
//                } else {
//                    modified.append(currentCharacter);
//                }
//            }
//        }
//
//        int low = 0;
//        int high = modified.length() - 1;
//
//        while (low < high) {
//            if (modified.charAt(low++) != modified.charAt(high--)) {
//                return false;
//            }
//        }
//
//        return true;
//    }

    public static void main(String[] args) {
        System.out.println(Character.isLetter(','));
    }
}
