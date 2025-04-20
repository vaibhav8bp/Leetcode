package org.example.Daily._2025.April._13;

// https://leetcode.com/problems/count-good-numbers/
public class _1922_Count_Good_Numbers {

    private static final int MODULO = (int) 1e9 + 7;

    private static final int PRIMES_LENGTH = 4;

    private static final int EVENS_LENGTH = 5;

    private static long pow(long x, long n) {
        long result = 1;

        while (n != 0) {
            if (n % 2 != 0) {
                result = (result * x) % MODULO;
                n--;
            } else {
                x = (x * x) % MODULO;
                n /= 2;
            }
        }

        return result;
    }

    public static int countGoodNumbers(long n) {
        long evenPlaces = (n % 2 == 0) ? (n / 2) : ((n / 2) + 1);
        long oddPlaces = n / 2;
        return (int) ((pow(EVENS_LENGTH, evenPlaces) * pow(PRIMES_LENGTH, oddPlaces)) % MODULO);
    }

//    private static final int MODULO = (int) 1e9 + 7;
//
//    private static final int[] primes = {2, 3, 5, 7};
//
//    private static final int[] evens = {0, 2, 4, 6, 8};
//
//    private static long countGoodNumbers(StringBuilder currentString, long n) {
//        if (currentString.length() == n) {
//            return 1;
//        }
//
//        long answer = 0;
//
//        int[] listToBeUsed;
//        if (currentString.length() % 2 == 0) {
//            listToBeUsed = evens;
//        } else {
//            listToBeUsed = primes;
//        }
//
//        for (int currentDigit : listToBeUsed) {
//            currentString.append(currentDigit);
//            answer = (answer + countGoodNumbers(currentString, n)) % MODULO;
//            currentString.deleteCharAt(currentString.length() - 1);
//        }
//
//        return answer;
//    }
//
//    public static int countGoodNumbers(long n) {
//        return (int) countGoodNumbers(new StringBuilder(), n);
//    }

    public static void main(String[] args) {
//        System.out.println(countGoodNumbers(1));
//        System.out.println(countGoodNumbers(4));
        System.out.println(countGoodNumbers(50));
    }
}
