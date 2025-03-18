package org.example.Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/description/
public class _15_3Sum {

    private List<List<Integer>> twoSum(int[] nums,int startingIndex, int target) {
        int low = startingIndex;
        int high = nums.length - 1;

        List<List<Integer>> answer = new ArrayList<>();

        while (low < high) {
            int smallest = nums[low];
            int largest = nums[high];

            int currentSum = smallest + largest;

            if (currentSum < target) {
                low++;
            } else if (currentSum > target) {
                high--;
            } else {
                List<Integer> currentList = new ArrayList<>();
                currentList.add(smallest);
                currentList.add(largest);
                answer.add(currentList);
                int tempLow = low + 1;
                while (tempLow < high && nums[low] == nums[tempLow]) {
                    tempLow++;
                }
                low = tempLow;
                int tempHigh = high - 1;
                while (tempHigh > low && nums[high] == nums[tempHigh]) {
                    tempHigh--;
                }
                high = tempHigh;
            }
        }

        return answer;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> twoSumList = twoSum(nums, i + 1, -nums[i]);
            for (List<Integer> currentList : twoSumList) {
                currentList.add(nums[i]);
            }
            answer.addAll(twoSumList);
        }

        return answer;
    }
}
