package org.example.Striver_SDE_Sheet.Day_9_Recursion._39_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/description/
class Solution {

    void combinationSumHelper(int[] candidates, int target, int currentIndex, List<List<Integer>> finalList, List<Integer> currentList) {
        if (target < 0) {
            return;
        }

        if (currentIndex == candidates.length) {
            if (target == 0) {
                finalList.add(new ArrayList<>(currentList));
            }
            return;
        }
        // Check If you Can Include Current Index Or Not

        // Cannot include current index
        if (target < candidates[currentIndex]) {
            combinationSumHelper(candidates, target, currentIndex + 1, finalList, currentList);
        } else {
            // Include
            currentList.add(candidates[currentIndex]);
            // Not incrementing currentIndex as same element can be used again and again
            combinationSumHelper(candidates, target - candidates[currentIndex], currentIndex, finalList, currentList);
            // Exclude
            currentList.removeLast();
            combinationSumHelper(candidates, target, currentIndex + 1, finalList, currentList);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, finalList, currentList);
        return finalList;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(new Solution().combinationSum(candidates, target));
    }
}
