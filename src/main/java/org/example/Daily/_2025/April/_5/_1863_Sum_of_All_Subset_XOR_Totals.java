package org.example.Daily._2025.April._5;

// https://leetcode.com/problems/sum-of-all-subset-xor-totals/description/
public class _1863_Sum_of_All_Subset_XOR_Totals {

    /*
    Combinatorics Approach -

    Let's say we have 5,1,6 in nums array.
    6 will be present in half of the subsets and will be absent in other half.

    5 -> 0101
    1 -> 0001
    6 -> 0110

    Now half of the subsets that is 4 subsets will have 3rd bit from left = 1.
    Now half will have 3rd bit =0.

    Now even if let's assume another element with 3rd bit set is there. What will happen ?

    When we will XOR half of 1's will be converted to 0 and half of 0's will be converted to 1's.

    So if any column has 1 irrespective of its frequency, we know in half of subsets 1 will be there
    and in half it won't be there.

    And if 1 is there it is fair to say that that value will be multiplied by 2^(n-1) (Binary To Decimal Conversion)

    We have to just find set bits. That's it.

     */

    public int subsetXORSum(int[] nums) {
        int answer = 0;

        for (int currentNumber : nums) {
            answer |= currentNumber;
        }

        // Ex. answer= 1100 and n=4
        // We have to do 8*2^3+4*2^3
        // So we can just do (8+4)*2^3=12*2^3, 12 is the OR of every number in nums and 3 is nums.length-1
        return (answer * (int) Math.pow(2, nums.length - 1));
    }

//    private int subsetXORSum(int currentIndex, int runningXOR, int[] nums) {
//        if (currentIndex == nums.length) {
//            return runningXOR;
//        }
//
//        // Include
//        int includeCurrentElement = subsetXORSum(currentIndex + 1, runningXOR ^ nums[currentIndex], nums);
//        // Exclude
//        int excludeCurrentElement = subsetXORSum(currentIndex + 1, runningXOR, nums);
//
//        return includeCurrentElement + excludeCurrentElement;
//    }
//
//    public int subsetXORSum(int[] nums) {
//        return subsetXORSum(0, 0, nums);
//    }
}