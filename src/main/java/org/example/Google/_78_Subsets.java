package org.example.Google;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/description/
public class _78_Subsets {

    private static void subsets(int currentIndex, int[] nums, List<Integer> currentSubset, List<List<Integer>> allSubsets) {
        if (currentIndex == nums.length) {
            allSubsets.add(new ArrayList<>(currentSubset));
            return;
        }

        // Don't Include Current Element
        subsets(currentIndex + 1, nums, currentSubset, allSubsets);

        // Include Current Element
        currentSubset.add(nums[currentIndex]);
        subsets(currentIndex + 1, nums, currentSubset, allSubsets);
        currentSubset.removeLast();
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        subsets(0, nums, new ArrayList<>(), allSubsets);
        return allSubsets;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }
}
