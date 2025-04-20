package org.example.Striver_SDE_Sheet.Day_11_Binary_Search._33_Search_In_Rotated_Sorted_Array;

// https://leetcode.com/problems/search-in-rotated-sorted-array/description/
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else {
                // Left Part Is Sorted
                if (nums[low] <= nums[mid]) {
                    if (nums[low] <= target && target <= nums[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                // Right Part Is Sorted
                else {
                    if (nums[mid] <= target && target <= nums[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }

        return -1;
    }
}

// class Solution {

//    public int findPivotIndex(int[] nums) {
//        int low = 0;
//        int high = nums.length - 1;

//        while (low <= high) {
//            int mid = (low + high) / 2;
//            int leftValue = (mid - 1 >= 0) ? nums[mid - 1] : Integer.MIN_VALUE;
//            int rightValue = (mid + 1 < nums.length) ? nums[mid + 1] : Integer.MAX_VALUE;

//            if (nums[mid] < leftValue) {
//                return mid;
//            } else if (nums[mid] > rightValue) {
//                return mid + 1;
//            } else {
//                if (nums[low] <= nums[mid]) {
//                    low = mid + 1;
//                } else {
//                    high = mid - 1;
//                }
//            }
//        }
//        return low;
//    }

//    public int search(int[] nums, int target) {
//        int pivotIndex = findPivotIndex(nums);
//        int low;
//        int high;

//        if (nums[0] <= target && target <= nums[pivotIndex - 1]) {
//            low = 0;
//            high = pivotIndex - 1;
//        } else {
//            low = pivotIndex;
//            high = nums.length - 1;
//        }

//        while (low <= high) {
//            int mid = (low + high) / 2;
//            if (nums[mid] == target) {
//                return mid;
//            } else if (nums[mid] < target) {
//                low = mid + 1;
//            } else {
//                high = mid - 1;
//            }
//        }

//        return -1;
//    }
// }

public class Main {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(new Solution().search(nums, target));
    }
}
