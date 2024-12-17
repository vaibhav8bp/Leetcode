package org.example.Weekly._408._3232_Find_if_Digit_Game_Can_Be_Won;

class Solution {
    public boolean canAliceWin(int[] nums) {
        int oneDigitCount = 0;
        int twoDigitCount = 0;

        for (int currentNumber : nums) {
            if (currentNumber < 10) {
                oneDigitCount += currentNumber;
            } else {
                twoDigitCount += currentNumber;
            }
        }

        return oneDigitCount != twoDigitCount;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arr = {};
        System.out.println(new Solution().canAliceWin(arr));
    }
}