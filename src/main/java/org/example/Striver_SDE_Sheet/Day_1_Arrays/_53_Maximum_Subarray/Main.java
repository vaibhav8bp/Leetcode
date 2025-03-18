package org.example.Striver_SDE_Sheet.Day_1_Arrays._53_Maximum_Subarray;

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSumSoFar = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;
            if (currentSum > maxSumSoFar) {
                maxSumSoFar = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSumSoFar;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(arr));
    }
}
