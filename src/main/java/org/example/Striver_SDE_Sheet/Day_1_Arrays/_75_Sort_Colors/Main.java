package org.example.Striver_SDE_Sheet.Day_1_Arrays._75_Sort_Colors;

import java.util.Arrays;

class Solution {

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        int lastZeroIndex = 0;
        int lastTwoIndex = nums.length - 1;
        int i = 0;
        while (i <= lastTwoIndex) {
            if (nums[i] == 0) {
                swap(nums, i, lastZeroIndex);
                lastZeroIndex++;
            }
            if (nums[i] == 2) {
                swap(nums, i, lastTwoIndex);
                lastTwoIndex--;
                i--;
            }
            i++;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 0, 1};
        new Solution().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
