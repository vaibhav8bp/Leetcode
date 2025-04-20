package org.example.Daily._2025.April._19;

import java.util.Arrays;

// https://leetcode.com/problems/count-the-number-of-fair-pairs/description/
public class _2563_Count_the_Number_of_Fair_Pairs {

    /*
       lower<= nums[i] + nums[j] <= upper
       lower-nums[j]<=nums[i]<=upper-nums[j]
     */

    private static int findIndexJustSmallerThanCurrentNumber(int[] nums, int startIndex, int target) {
        int low = startIndex;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static int findIndexJustGreaterThanCurrentNumber(int[] nums, int startIndex, int target) {
        int low = startIndex;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static long countFairPairs(int[] nums, int lower, int upper) {

        Arrays.sort(nums);

        long answer = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int lowerLimit = lower - nums[i];
            int upperLimit = upper - nums[i];
            // Now we need to know how many numbers are in this range.
            answer += (findIndexJustGreaterThanCurrentNumber(nums, i + 1, upperLimit) -
                    findIndexJustSmallerThanCurrentNumber(nums, i + 1, lowerLimit));
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(countFairPairs(new int[]{1,7,9,2,5}, 11, 11));
    }
}

/*
Index        0 1 2 3 4 5
Values       0 1 7 4 4 5

lower = 3, upper = 6

        After Sorting

Original Index   0 1 3 4 5 2
New Index        0 1 2 3 4 5
Values           0 1 4 4 5 7

 */
