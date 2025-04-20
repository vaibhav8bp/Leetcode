package org.example.Daily._2025.April._9;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/description/
public class _3375_Minimum_Operations_to_Make_Array_Values_Equal_to_K {
    public int minOperations(int[] nums, int k) {

        Set<Integer> uniqueNumsSet = new HashSet<>();

        for (Integer currentNumber : nums) {
            if (currentNumber < k) {
                return -1;
            } else if (currentNumber > k) {
                uniqueNumsSet.add(currentNumber);
            }
        }

        return uniqueNumsSet.size();
    }
}
