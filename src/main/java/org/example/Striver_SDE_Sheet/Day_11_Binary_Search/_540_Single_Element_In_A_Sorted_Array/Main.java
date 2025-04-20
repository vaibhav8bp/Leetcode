package org.example.Striver_SDE_Sheet.Day_11_Binary_Search._540_Single_Element_In_A_Sorted_Array;

// https://leetcode.com/problems/single-element-in-a-sorted-array/description/
class Solution {

    public int singleNonDuplicate(int[] nums) {

        int length = nums.length;

        if (length == 1) {
            return nums[0];
        }

        if (nums[0] != nums[1]) {
            return nums[0];
        }

        if (nums[length - 2] != nums[length - 1]) {
            return nums[length - 1];
        }

        int low = 1;
        int high = nums.length - 2;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid - 1]) {
                    high = mid - 2;
                } else {
                    low = mid + 2;
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return nums[high];
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 3, 7, 7, 10, 11, 11};
        System.out.println(new Solution().singleNonDuplicate(nums));
    }
}
