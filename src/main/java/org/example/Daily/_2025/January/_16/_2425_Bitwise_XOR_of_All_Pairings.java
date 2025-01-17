package org.example.Daily._2025.January._16;

// https://leetcode.com/problems/bitwise-xor-of-all-pairings/description
public class _2425_Bitwise_XOR_of_All_Pairings {
    private int XORCalculator(int[] arr) {
        int xor = 0;

        for (int currentNumber : arr) {
            xor ^= currentNumber;
        }

        return xor;
    }

    public int xorAllNums(int[] nums1, int[] nums2) {
        boolean isNums1EvenInLength = (nums1.length % 2 == 0);
        boolean isNums2EvenInLength = (nums2.length % 2 == 0);

        if (isNums1EvenInLength && isNums2EvenInLength) {
            return 0;
        } else if (!isNums1EvenInLength && isNums2EvenInLength) {
            return XORCalculator(nums2);
        } else if (isNums1EvenInLength && !isNums2EvenInLength) {
            return XORCalculator(nums1);
        } else {
            return XORCalculator(nums1) ^ XORCalculator(nums2);
        }
    }
}
