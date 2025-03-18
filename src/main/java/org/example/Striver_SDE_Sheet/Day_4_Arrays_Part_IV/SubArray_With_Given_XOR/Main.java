package org.example.Striver_SDE_Sheet.Day_4_Arrays_Part_IV.SubArray_With_Given_XOR;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solve(int[] A, int B) {
        Map<Integer, Integer> xorToIndexMapping = new HashMap<>();

        int xorTillNow = 0;
        int numberOfSubArraysWithXorK = 0;
        xorToIndexMapping.put(0, 1);

        for (int j : A) {
            xorTillNow = xorTillNow ^ j;
            // Check if there is any subArray with XOR k ending at i
            int previousXor = xorTillNow ^ B;
            if (xorToIndexMapping.containsKey(previousXor)) {
                numberOfSubArraysWithXorK += xorToIndexMapping.get(previousXor);
            }
            if (xorToIndexMapping.containsKey(xorTillNow)) {
                xorToIndexMapping.put(xorTillNow, xorToIndexMapping.get(xorTillNow) + 1);
            } else {
                xorToIndexMapping.put(xorTillNow, 1);
            }
        }

        return numberOfSubArraysWithXorK;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 6, 7, 8, 9};
        System.out.println(new Solution().solve(nums, 5));
    }
}
