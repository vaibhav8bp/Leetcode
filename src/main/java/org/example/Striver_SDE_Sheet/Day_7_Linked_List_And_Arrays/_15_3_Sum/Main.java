package org.example.Striver_SDE_Sheet.Day_7_Linked_List_And_Arrays._15_3_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/description/
class Solution {

    public List<List<Integer>> twoSum(int[] nums, int k, int startIndex) {
        int start = startIndex;
        int end = nums.length - 1;

        List<List<Integer>> twoSumList = new ArrayList<>();

        while (start < end) {
            int currentSum = nums[start] + nums[end];
            if (currentSum == k) {
                List<Integer> currentList = new ArrayList<>();
                if (nums[start] == nums[end]) {
                    currentList.add(nums[start]);
                    currentList.add(nums[end]);
                    twoSumList.add(currentList);
                    return twoSumList;
                } else {
                    int tempStart = start;
                    while (nums[start] == nums[tempStart]) {
                        tempStart++;
                    }
                    int tempEnd = end;
                    while (nums[tempEnd] == nums[end]) {
                        tempEnd--;
                    }
                    currentList.add(nums[start]);
                    currentList.add(nums[end]);
                    twoSumList.add(currentList);
                    start = tempStart;
                    end = tempEnd;
                }
            } else if (currentSum < k) {
                start++;
            } else {
                end--;
            }
        }
        return twoSumList;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> finalList = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int currentNumber = nums[i];
            List<List<Integer>> twoSumList = twoSum(nums, -currentNumber, i + 1);
            if (!twoSumList.isEmpty()) {
                twoSumList.forEach(currentList -> {
                    currentList.add(currentNumber);
                    finalList.add(currentList);
                });
            }
        }

        return finalList;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(new Solution().threeSum(nums));
    }
}
