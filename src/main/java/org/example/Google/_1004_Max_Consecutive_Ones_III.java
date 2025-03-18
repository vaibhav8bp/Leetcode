package org.example.Google;

// https://leetcode.com/problems/max-consecutive-ones-iii/description/
public class _1004_Max_Consecutive_Ones_III {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int zerosCountInCurrentWindow = 0;
        int longestOnes = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                if (zerosCountInCurrentWindow < k) {
                    zerosCountInCurrentWindow++;
                } else {
                    while (nums[left] != 0) {
                        left++;
                    }
                    left++;
                    zerosCountInCurrentWindow = k;
                }
            }
            right++;
            longestOnes = Math.max(longestOnes, right - left);
        }

        return longestOnes;
    }
}
