package org.example.Google;

// https://leetcode.com/problems/divide-two-integers/description/
public class _29_Divide_Two_Integers {
    public static int divide(int dividend, int divisor) {

        if (dividend == divisor) {
            return 1;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int negativeCount = 0;
        if (dividend < 0) {
            negativeCount++;
        }
        if (divisor < 0) {
            negativeCount++;
        }

        boolean overAllNegative = (negativeCount == 1);
        int quotient = 0;

        /*
         * 22/3
         * 2^0 2^1 2^2 2^3
         *
         * */

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        while (0 <= (dividend - divisor)) {
            int power = 0;
            while (dividend - (divisor << power << 1) >= 0) {
                power++;
            }
            quotient += (1 << power);
            dividend -= (divisor << power);
        }

        if (overAllNegative) {
            return -(int) quotient;
        }

        return quotient;
    }

    public static void main(String[] args) {
        System.out.println(divide(22, 3));
    }
}
