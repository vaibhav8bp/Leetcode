package org.example.Daily._2025.March._4;

// https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/
public class _1780_Check_if_Number_is_a_Sum_of_Powers_of_Three {

    public boolean checkPowersOfThree(int n) {

        while (n != 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }

        return true;
    }

//    private boolean checkPowersOfThree(int currentNumber, int currentValue, int n) {
//        if (currentValue == n) {
//            return true;
//        }
//
//        if (currentValue > n || (currentValue + Math.pow(3, currentNumber) > n)) {
//            return false;
//        }
//
//        // Not Pick Current Power
//        boolean notPickCurrentPower = checkPowersOfThree(currentNumber + 1, currentValue, n);
//        // Pick Current Power.
//        boolean pickCurrentPower = checkPowersOfThree(currentNumber + 1, (int) (currentValue + Math.pow(3, currentNumber)), n);
//
//        return (pickCurrentPower || notPickCurrentPower);
//    }
//
//    public boolean checkPowersOfThree(int n) {
//        return checkPowersOfThree(0, 0, n);
//    }
}
