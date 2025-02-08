package org.example.Daily._2025.February._2;

// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
public class _1752_Check_if_Array_Is_Sorted_and_Rotated {

    // Another Approach is to just count the no. of irregularities in the nums array.
    // if irregularities >=2 return false, else return ture.

    // 3 4 5 6 7 8 8 1
    // 9 1 2 3 4 5
    private int findBreakingPoint(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }

        return -1;
    }

    public boolean check(int[] nums) {
        int breakingIndex = findBreakingPoint(nums);

        if (breakingIndex == -1) {
            return true;
        }

        int least = nums[0];

        for (int i = breakingIndex + 1; i < nums.length; i++) {
            // Array Was Sorted So, After Rotating every element should be smaller than smallest element i.e. nums[0]
            if (nums[i] > least) {
                return false;
            }
            // Part Of breakingPart should also be sorted.
            else if ((i != nums.length - 1) && (nums[i] > nums[i + 1])) {
                return false;
            }
        }

        return true;
    }
}
