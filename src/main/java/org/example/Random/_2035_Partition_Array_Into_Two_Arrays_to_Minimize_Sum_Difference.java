package org.example.Random;

import java.util.*;

// https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/description/
public class _2035_Partition_Array_Into_Two_Arrays_to_Minimize_Sum_Difference {

    private void findAllSubsetSum(int currentIndex, int currentSum, int currentSize, int endIndex, int[] nums, Map<Integer, List<Integer>> sizeToSumsMapper) {
        if (currentIndex == endIndex) {
            if (!sizeToSumsMapper.containsKey(currentSize)) {
                sizeToSumsMapper.put(currentSize, new ArrayList<>());
            }
            sizeToSumsMapper.get(currentSize).add(currentSum);
            return;
        }

        // Include Element
        findAllSubsetSum(currentIndex + 1, currentSum + nums[currentIndex], currentSize + 1, endIndex, nums, sizeToSumsMapper);
        // Exclude Element
        findAllSubsetSum(currentIndex + 1, currentSum, currentSize, endIndex, nums, sizeToSumsMapper);
    }

    private int findClosest(List<Integer> elements, int goal) {
        int low = 0;
        int high = elements.size() - 1;

        int closestValue = elements.get(low);

        while (low <= high) {
            int mid = (low + high) / 2;

            if (Math.abs(goal - closestValue) > Math.abs(goal - elements.get(mid))) {
                closestValue = elements.get(mid);
            }

            if (elements.get(mid) < goal) {
                low = mid + 1;
            } else if (elements.get(mid) > goal) {
                high = mid - 1;
            } else {
                return goal;
            }
        }

        return closestValue;
    }

    public int minimumDifference(int[] nums) {
        Map<Integer, List<Integer>> sizeToSumsMapperForFirstHalf = new HashMap<>();
        Map<Integer, List<Integer>> sizeToSumsMapperForSecondHalf = new HashMap<>();

        int n = nums.length;
        int half = n / 2;

        findAllSubsetSum(0, 0, 0, half, nums, sizeToSumsMapperForFirstHalf);
        findAllSubsetSum(half, 0, 0, n, nums, sizeToSumsMapperForSecondHalf);

        // We have to pick n/2 elements that's it.
        // Doesn't matter where they come from.
        // Can come from one list only or can come from both lists.

        int totalSum = Arrays.stream(nums).sum();
        int goal = totalSum / 2;
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i <= half; i++) {
            List<Integer> firstHalfElements = sizeToSumsMapperForFirstHalf.get(i);
            List<Integer> secondHalfElements = sizeToSumsMapperForSecondHalf.get(half - i);

            if (firstHalfElements == null || secondHalfElements == null) {
                continue;
            }

            Collections.sort(secondHalfElements);

            for (Integer currentSumInFirstHalf : firstHalfElements) {
                int currentSumInSecondHalf = findClosest(secondHalfElements, goal - currentSumInFirstHalf);
                int sum1 = currentSumInFirstHalf + currentSumInSecondHalf;
                int sum2 = totalSum - sum1;
                answer = Math.min(answer, Math.abs(sum1 - sum2));
            }
        }

        return answer;
    }
}