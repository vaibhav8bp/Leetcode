package org.example.Striver_SDE_Sheet.Day_9_Recursion._90_Subsets_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/subsets-ii/description/
// Optimal
class Solution {

    private void subsetsWithDupHelper(int[] nums, int currentIndex, List<Integer> currentSubset, List<List<Integer>> finalList) {
        // At currentIndex , we will have subset of size = currentIndex
        finalList.add(new ArrayList<>(currentSubset));

        for (int i = currentIndex; i < nums.length; i++) {
            if (i != currentIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            currentSubset.add(nums[i]);
            subsetsWithDupHelper(nums, i + 1, currentSubset, finalList);
            currentSubset.removeLast();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> finalList = new ArrayList<>();
        subsetsWithDupHelper(nums, 0, new ArrayList<>(), finalList);
        return finalList;
    }
}

// Brute Force
//class Solution {
//
//    private void subsetsWithDupHelper(int[] nums, int currentIndex, List<Integer> currentSubset, List<List<Integer>> finalList) {
//        if (currentIndex == nums.length) {
//            finalList.add(currentSubset);
//            return;
//        }
//
//        // Exclude Current Element
//        subsetsWithDupHelper(nums, currentIndex + 1, currentSubset, finalList);
//
//        // Include Current Element
//        List<Integer> newList = new ArrayList<>(currentSubset);
//        newList.add(nums[currentIndex]);
//        subsetsWithDupHelper(nums, currentIndex + 1, newList, finalList);
//    }
//
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> finalList = new ArrayList<>();
//        subsetsWithDupHelper(nums, 0, new ArrayList<>(), finalList);
//        Set<List<Integer>> listSet = new HashSet<>(finalList);
//        finalList = new ArrayList<>(listSet);
//        return finalList;
//    }
//}

//Input: nums = [1,2,2]
//Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(new Solution().subsetsWithDup(nums));
    }
}