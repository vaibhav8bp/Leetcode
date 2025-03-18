package org.example.Striver_SDE_Sheet.Day_11_Binary_Search._4_Median_Of_Two_Sorted_Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        // To perform BS on shorter array
        if (length1 > length2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int countOfElementsInLeftHalf = (length1 + length2 + 1) / 2;
        int low = 0;
        int high = length1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int l1 = (mid - 1 >= 0) ? nums1[mid - 1] : Integer.MIN_VALUE;
            int l2 = ((countOfElementsInLeftHalf - mid - 1) >= 0) ? nums2[countOfElementsInLeftHalf - mid - 1] : Integer.MIN_VALUE;
            int r1 = (mid < length1) ? nums1[mid] : Integer.MAX_VALUE;
            int r2 = ((countOfElementsInLeftHalf - mid) < length2) ? nums2[countOfElementsInLeftHalf - mid] : Integer.MAX_VALUE;
            if (l1 > r2) {
                high = mid - 1;
            } else if (l2 > r1) {
                low = mid + 1;
            } else {
                // Odd Length
                if ((length1 + length2) % 2 != 0) {
                    return Math.max(l1, l2);
                } else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }
}
