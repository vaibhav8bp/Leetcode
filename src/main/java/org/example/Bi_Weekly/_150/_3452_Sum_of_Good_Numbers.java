package org.example.Bi_Weekly._150;

// https://leetcode.com/problems/sum-of-good-numbers/
public class _3452_Sum_of_Good_Numbers {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            boolean isGood = true;
            if ((i - k) >= 0 && nums[i - k] >= nums[i]) {
                isGood = false;
            }
            if ((i + k) < nums.length && nums[i + k] >= nums[i]) {
                isGood = false;
            }
            if (isGood) {
                answer += nums[i];
            }
        }

        return answer;
    }
}
