package org.example.Daily._2025.April._16;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/count-the-number-of-good-subarrays/description/
public class _2537_Count_the_Number_of_Good_Subarrays {

    // 0 1 2 3 4 5 6
    // 3 1 4 3 2 2 4
    public static long countGood(int[] nums, int k) {

        long answer = 0;
        long totalPairsSoFar = 0;

        Map<Integer, Integer> numberToFrequencyMapping = new HashMap<>();

        for (int left = 0, right = 0, n = nums.length; right < n; right++) {
            int previousFrequencyOfNumsRight = numberToFrequencyMapping.getOrDefault(nums[right], 0);
            numberToFrequencyMapping.put(nums[right], previousFrequencyOfNumsRight + 1);
            totalPairsSoFar += (previousFrequencyOfNumsRight);

            while (totalPairsSoFar >= k) {
                answer += (n - right);
                int currentFrequencyOfNumsLeft = numberToFrequencyMapping.getOrDefault(nums[left], 0);
                numberToFrequencyMapping.put(nums[left], currentFrequencyOfNumsLeft - 1);
                if (numberToFrequencyMapping.get(nums[left]) == 0) {
                    numberToFrequencyMapping.remove(nums[left]);
                }
                totalPairsSoFar -= (currentFrequencyOfNumsLeft - 1);
                left++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(countGood(new int[]{1, 1, 1, 1, 1}, 10));
    }
}
