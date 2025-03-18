package org.example.Google;

// https://leetcode.com/problems/palindrome-number/
public class _9_Palindrome_Number {
    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        int reversedNumber = 0;

        int originalNumber = x;

        while (originalNumber != 0) {
            reversedNumber = (reversedNumber * 10) + (originalNumber % 10);
            originalNumber /= 10;
        }

        return reversedNumber == x;
    }
}
