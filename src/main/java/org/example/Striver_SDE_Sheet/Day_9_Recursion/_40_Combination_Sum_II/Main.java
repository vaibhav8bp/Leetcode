package org.example.Striver_SDE_Sheet.Day_9_Recursion._40_Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum-ii/description/
class Solution {

    private void combinationSum2Helper(int[] candidates, int target, int currentIndex, List<List<Integer>> finalList, List<Integer> currentList) {

        if (target == 0) {
            finalList.add(new ArrayList<>(currentList));
        }

        for (int i = currentIndex; i < candidates.length; i++) {
            if (i > currentIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target < candidates[i]) {
                break;
            }
            currentList.add(candidates[i]);
            combinationSum2Helper(candidates, target - candidates[i], i + 1, finalList, currentList);
            currentList.removeLast();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        combinationSum2Helper(candidates, target, 0, finalList, currentList);
        return finalList;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(new Solution().combinationSum2(candidates, target));
    }
}
