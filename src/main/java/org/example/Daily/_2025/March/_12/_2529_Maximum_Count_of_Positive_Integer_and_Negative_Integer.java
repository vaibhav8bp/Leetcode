package org.example.Daily._2025.March._12;

// https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/
public class _2529_Maximum_Count_of_Positive_Integer_and_Negative_Integer {

    private static int findIndexOfElementJustSmallerThanCurrentElement(int[] nums, int currentNumber) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    private static int findIndexOfElementJustGreaterThanCurrentElement(int[] nums, int currentNumber) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static int maximumCount(int[] nums) {
        int indexOfLastNegativeNumber = findIndexOfElementJustSmallerThanCurrentElement(nums, 0);
        int indexOfFirstPositiveNumber = findIndexOfElementJustGreaterThanCurrentElement(nums, 0);

        int countOfNegativeElements = indexOfLastNegativeNumber + 1;
        int countOfPositiveElements = nums.length - indexOfFirstPositiveNumber;

        return Math.max(countOfNegativeElements, countOfPositiveElements);
    }

    public static void main(String[] args) {
        System.out.println(maximumCount(new int[]{0, 1, 2, 3, 4}));
    }
}