package org.example.Google;


// https://leetcode.com/problems/merge-sorted-array/
public class _88_Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int nums1Index = m - 1;
        int nums2Index = n - 1;

        int finalIndex = m + n - 1;

        while (nums1Index >= 0 && nums2Index >= 0) {
            if (nums1[nums1Index] >= nums2[nums2Index]) {
                nums1[finalIndex--] = nums1[nums1Index--];
            } else {
                nums1[finalIndex--] = nums2[nums2Index--];
            }
        }

        while (nums2Index >= 0) {
            nums1[finalIndex--] = nums2[nums2Index--];
        }
    }
}