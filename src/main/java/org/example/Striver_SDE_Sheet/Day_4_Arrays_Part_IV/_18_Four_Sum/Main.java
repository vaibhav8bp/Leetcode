package org.example.Striver_SDE_Sheet.Day_4_Arrays_Part_IV._18_Four_Sum;

import java.util.*;

class Solution {

    private List<List<Integer>> twoSum(int[] nums, long target) {
        int start = 0, end = nums.length - 1;
        List<List<Integer>> finalList = new ArrayList<>();

        while (start < end) {
            long currentSum = nums[start] + nums[end];
            if (currentSum == target) {
                // Entire Array Is Same
                if (nums[start] == nums[end]) {
                    List<Integer> elementList = List.of(nums[start], nums[end]);
                    finalList.add(new ArrayList<>(elementList));
                    return finalList;
                } else {
                    int tempStart = start;
                    while (nums[start] == nums[tempStart]) {
                        tempStart++;
                    }
                    int tempEnd = end;
                    while (nums[end] == nums[tempEnd]) {
                        tempEnd--;
                    }
                    List<Integer> elementList = List.of(nums[start], nums[end]);
                    finalList.add(new ArrayList<>(elementList));
                    start = tempStart;
                    end = tempEnd;
                }
            } else if (currentSum < target) {
                start++;
            } else {
                end--;
            }
        }

        return finalList;
    }

    private List<List<Integer>> threeSum(int[] nums, long target) {
        List<List<Integer>> finalList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            long remainingTargetAfterCurrentNum = target - nums[i];
            List<List<Integer>> twoSumList = twoSum(Arrays.copyOfRange(nums, i + 1, nums.length), remainingTargetAfterCurrentNum);

            for (List<Integer> integers : twoSumList) {
                integers.add(nums[i]);
                finalList.add(integers);
            }
        }
        return finalList;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        if (nums.length < 4) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        if (nums[0] == nums[nums.length - 1]) {
            long sum = 4L * nums[0];
            if (sum == target) {
                return List.of(new ArrayList<>(List.of(nums[0], nums[0], nums[0], nums[0])));
            } else {
                return new ArrayList<>();
            }
        }

        List<List<Integer>> finalList = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int remainingTargetAfterCurrentNum = target - nums[i];
            List<List<Integer>> threeSumList = threeSum(Arrays.copyOfRange(nums, i + 1, nums.length), remainingTargetAfterCurrentNum);

            for (List<Integer> integers : threeSumList) {
                integers.add(nums[i]);
                finalList.add(integers);
            }
        }


        return finalList;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{-1000000000, -1000000000, 1000000000, -1000000000, -1000000000};
        int target = 294967296;
        System.out.println(new Solution().fourSum(nums, target));
    }
}
