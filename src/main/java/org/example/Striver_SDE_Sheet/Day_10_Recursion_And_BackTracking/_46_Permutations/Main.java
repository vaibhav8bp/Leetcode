package org.example.Striver_SDE_Sheet.Day_10_Recursion_And_BackTracking._46_Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// https://leetcode.com/problems/permutations/description/
// Swapping Solution
class Solution {

    private void swap(List<Integer> currentList, int left, int right) {
        int temp = currentList.get(left);
        currentList.set(left, currentList.get(right));
        currentList.set(right, temp);
    }

    private void permuteHelper(int currentIndex, List<Integer> currentList, List<List<Integer>> finalList) {
        if (currentIndex == currentList.size()) {
            finalList.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = currentIndex; i < currentList.size(); i++) {
            swap(currentList, currentIndex, i);
            permuteHelper(currentIndex + 1, currentList, finalList);
            swap(currentList, currentIndex, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> currentList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        permuteHelper(0, currentList, finalList);
        return finalList;
    }
}

//class Solution {
//
//   public List<List<Integer>> permute(int[] nums) {
//       List<Integer> numsList = new ArrayList<>();
//       for (int num : nums) {
//           numsList.add(num);
//       }
//       return permuteHelper(numsList);
//   }
//
//   private List<List<Integer>> permuteHelper(List<Integer> numsList) {
//       List<List<Integer>> result = new ArrayList<>();
//
//       if (numsList.isEmpty()) {
//           result.add(new ArrayList<>()); // Base case: add an empty list
//           return result;
//       }
//
//       for (int i = 0; i < numsList.size(); i++) {
//           int currentNum = numsList.get(i);
//
//           List<Integer> remaining = new ArrayList<>(numsList);
//           remaining.remove(i);
//
//           List<List<Integer>> permutations = permuteHelper(remaining);
//
//           for (List<Integer> permutation : permutations) {
//               permutation.addFirst(currentNum);
//               result.add(new ArrayList<>(permutation));
//           }
//       }
//
//       return result;
//   }
//}

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution a = new Solution();
        List<List<Integer>> finalList = a.permute(nums);
        System.out.println(finalList);
    }
}
