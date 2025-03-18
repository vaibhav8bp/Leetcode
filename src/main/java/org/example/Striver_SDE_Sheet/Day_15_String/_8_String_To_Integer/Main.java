package org.example.Striver_SDE_Sheet.Day_15_String._8_String_To_Integer;

class Solution {
    public int myAtoi(String s) {
        int i = 0;
        boolean isNegative = false;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i < s.length()) {
            if (s.charAt(i) == '-') {
                isNegative = true;
                i++;
            } else if (s.charAt(i) == '+') {
                i++;
            }
        }

        int result = 0;

        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digit = s.charAt(i) - 48;
            // Here >7 works for -ve because that 8 is the end value can't go behind it
            if ((result > (Integer.MAX_VALUE / 10)) || ((result == (Integer.MAX_VALUE / 10)) && digit > 7)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = (result * 10) + digit;
            i++;
        }

        if (isNegative) {
            result *= -1;
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("-2147483648"));
    }
}
