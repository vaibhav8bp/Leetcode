package org.example.Striver_SDE_Sheet.Day_7_Linked_List_And_Arrays._485_Max_Consecutive_Ones;

// https://leetcode.com/problems/max-consecutive-ones/description/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLength = 0;

        for (int i = 0; i < nums.length; ) {
            if (nums[i] == 1) {
                int currentIndex = i;
                while (currentIndex < nums.length && nums[currentIndex] == nums[i]) {
                    currentIndex++;
                }
                maxLength = Math.max(maxLength, currentIndex - i);
                i = currentIndex;
            } else {
                i++;
            }
        }

        return maxLength;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0, 1, 1, 1};
        System.out.println(new Solution().findMaxConsecutiveOnes(nums));
    }
}
