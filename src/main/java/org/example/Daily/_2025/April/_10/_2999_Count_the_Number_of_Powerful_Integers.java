package org.example.Daily._2025.April._10;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/count-the-number-of-powerful-integers/description/
public class _2999_Count_the_Number_of_Powerful_Integers {

    private static int getNumberOfDigits(long number) {
        if (number >= 0 && number <= 9) {
            return 1;
        }
        return 1 + getNumberOfDigits(number / 10);
    }

    private static long numberOfPowerfulInt(long start, long finish, int limit, StringBuilder s, int numberOfDigits, Map<StringBuilder, Long> dp) {
        long currentNumber = Long.parseLong(s.toString());
        if (numberOfDigits < s.length() || finish < currentNumber) {
            return 0;
        }

        if (dp.containsKey(s)) {
            return dp.get(s);
        }

        long answer = (s.charAt(0) != '0' && start <= currentNumber) ? 1 : 0;

        for (int i = 0; i <= limit; i++) {
            StringBuilder temp = new StringBuilder(String.valueOf(i) + s);
            answer += (numberOfPowerfulInt(start, finish, limit, temp, numberOfDigits, dp));
        }

        dp.put(s, answer);
        return answer;
    }

    public static long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        Map<StringBuilder, Long> dp = new HashMap<>();
        return numberOfPowerfulInt(start, finish, limit, new StringBuilder(s), getNumberOfDigits(finish), dp);
    }

    public static void main(String[] args) {
        System.out.println(numberOfPowerfulInt(1, 6000, 4, "124"));
        System.out.println(numberOfPowerfulInt(15, 215, 6, "10"));
        System.out.println(numberOfPowerfulInt(1000, 2000, 4, "3000"));
    }
}