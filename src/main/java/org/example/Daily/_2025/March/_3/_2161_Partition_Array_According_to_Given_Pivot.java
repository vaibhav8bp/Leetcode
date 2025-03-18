package org.example.Daily._2025.March._3;

import java.util.Arrays;

// https://leetcode.com/problems/partition-array-according-to-given-pivot/
public class _2161_Partition_Array_According_to_Given_Pivot {

    public static int[] pivotArray(int[] nums, int pivot) {

        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];

        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            if (nums[i] < pivot) {
                result[left++] = nums[i];
            }
            if (nums[j] > pivot) {
                result[right--] = nums[j];
            }
        }

        for (int i = left; i <= right; i++) {
            result[i] = pivot;
        }

        return result;
    }

//    public static int[] pivotArray(int[] nums, int pivot) {
//        int countOfElementsSmallerOrEqualToPivot = 0;
//
//        for (Integer currentElement : nums) {
//            if (currentElement <= pivot) {
//                countOfElementsSmallerOrEqualToPivot++;
//            }
//        }
//
//        int[] result = new int[nums.length];
//        int smallerElementsIndex = 0;
//        int largerElementsIndex = countOfElementsSmallerOrEqualToPivot;
//
//        for (Integer currentElement : nums) {
//            if (currentElement < pivot) {
//                result[smallerElementsIndex++] = currentElement;
//            } else if (currentElement > pivot) {
//                result[largerElementsIndex++] = currentElement;
//            }
//        }
//
//        for (int i = smallerElementsIndex; i < countOfElementsSmallerOrEqualToPivot; i++) {
//            result[i] = pivot;
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10)));
    }
}
