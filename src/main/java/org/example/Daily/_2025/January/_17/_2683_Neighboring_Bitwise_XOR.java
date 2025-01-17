package org.example.Daily._2025.January._17;

// https://leetcode.com/problems/neighboring-bitwise-xor/description
public class _2683_Neighboring_Bitwise_XOR {

    private int XORCalculator(int[] arr) {
        int xor = 0;

        for (int currentNumber : arr) {
            xor ^= currentNumber;
        }

        return xor;
    }

    public boolean doesValidArrayExist(int[] derived) {
        return (XORCalculator(derived) == 0);
    }
}
