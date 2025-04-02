package org.example.Striver_SDE_Sheet.Day_3_Arrays_Part_III._169_Majority_Element;

// https://leetcode.com/problems/majority-element/
class Solution {
    public int majorityElement(int[] nums) {
        int element = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == element) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    element = nums[i];
                    count = 1;
                }
            }
        }

        return element;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new Solution().majorityElement(nums));
    }
}
