package org.example.Google;

// https://leetcode.com/problems/reverse-integer/description/
public class _7_Reverse_Integer {

    public static int reverse(int x) {

        int reversed = 0;

        while (x != 0) {
            long temp = ((reversed * 10L) + (x % 10));
            if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE) {
                return 0;
            }
            reversed = ((reversed * 10) + (x % 10));
            x /= 10;
        }

        return reversed;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }
}
