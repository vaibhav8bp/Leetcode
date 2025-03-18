package org.example.Daily._2025.March._2;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/
public class _2570_Merge_Two_2D_Arrays_by_Summing_Values {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int nums1Index = 0;
        int nums2Index = 0;

        List<int[]> result = new ArrayList<>();

        while (nums1Index < nums1.length && nums2Index < nums2.length) {
            if (nums1[nums1Index][0] < nums2[nums2Index][0]) {
                result.add(nums1[nums1Index++]);
            } else if (nums1[nums1Index][0] > nums2[nums2Index][0]) {
                result.add(nums2[nums2Index++]);
            } else {
                int[] arr = {nums1[nums1Index][0], nums1[nums1Index++][1] + nums2[nums2Index++][1]};
                result.add(arr);
            }
        }

        while (nums1Index < nums1.length) {
            result.add(nums1[nums1Index++]);
        }

        while (nums2Index < nums2.length) {
            result.add(nums2[nums2Index++]);
        }

        int[][] finalResult = new int[result.size()][2];
        int finalResultIndex = 0;

        for (int[] currentPair : result) {
            finalResult[finalResultIndex][0] = currentPair[0];
            finalResult[finalResultIndex++][1] = currentPair[1];
        }

        return finalResult;
    }
}
