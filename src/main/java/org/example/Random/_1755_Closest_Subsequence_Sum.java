package org.example.Random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/closest-subsequence-sum/description/

// 6 -> 0 to 2 and 3 to 5
// 5 -> 0 to 1 and 2 to 4
public class _1755_Closest_Subsequence_Sum {

    private static void findAllSum(int currentIndex, int currentSum, int endIndex, int[] nums, List<Integer> sumList) {
        if (currentIndex == endIndex) {
            sumList.add(currentSum);
            return;
        }

        // Include
        findAllSum(currentIndex + 1, currentSum + nums[currentIndex], endIndex, nums, sumList);
        // Exclude
        findAllSum(currentIndex + 1, currentSum, endIndex, nums, sumList);
    }

    // Find Closest element to goal in elements list, using BS
    // VVVV IMP. We have to find the closest element, NOT just smaller/ just greater.
    private static int findClosest(List<Integer> elements, int goal) {
        int low = 0;
        int high = elements.size() - 1;

        // Better than Integer.MAX_VALUE
        int closestValue = elements.getFirst();
        while (low <= high) {
            int mid = (low + high) / 2;

            // Found Exact element.
            if (elements.get(mid) == goal) {
                return goal;
            }

            if (Math.abs(goal - closestValue) > Math.abs(goal - elements.get(mid))) {
                closestValue=elements.get(mid);
            }

            if (elements.get(mid) < goal) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return closestValue;
    }

    public static int minAbsDifference(int[] nums, int goal) {
        List<Integer> sumOfFirstHalfElements = new ArrayList<>();
        List<Integer> sumOfSecondHalfElements = new ArrayList<>();
        findAllSum(0, 0, nums.length / 2, nums, sumOfFirstHalfElements);
        findAllSum(nums.length / 2, 0, nums.length, nums, sumOfSecondHalfElements);

        Collections.sort(sumOfSecondHalfElements);

        int answer = Integer.MAX_VALUE;

        for (Integer currentSumInFirstHalf : sumOfFirstHalfElements) {
            int sumInSecondHalf = findClosest(sumOfSecondHalfElements, goal - currentSumInFirstHalf);
            answer = Math.min(answer, Math.abs(goal - (currentSumInFirstHalf + sumInSecondHalf)));
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(minAbsDifference(new int[]{5, -7, 3, 5}, 6));
    }
}