package org.example.Weekly._433;

// https://leetcode.com/problems/sum-of-variable-length-subarrays/
public class _3427_Sum_of_Variable_Length_Subarrays {

    public int subarraySum(int[] nums) {
        int[] prefixSum = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefixSum[i] = nums[i];
            } else {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }
        }

        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            int start = Math.max(0, i - nums[i]);
            if (start == 0) {
                answer += prefixSum[i];
            } else {
                answer += prefixSum[i] - prefixSum[start - 1];
            }

        }

        return answer;
    }
}
