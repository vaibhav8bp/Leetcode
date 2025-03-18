package org.example.Striver_SDE_Sheet.Day_1_Arrays._31_Next_Permutation;

import java.util.Arrays;

class Solution {

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }

        // A. Find Longest Prefix Array

        int index = nums.length - 2;

        for (; index >= 0; index--) {
            if (nums[index] < nums[index + 1]) {
                break;
            }
        }

        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // B. Find Element just greater than breaking point start from right as there is
        // a decreasing slope here so

        for (int i = nums.length - 1; i > index; i--) {
            if (nums[index] < nums[i]) {
                swap(nums, index, i);
                reverse(nums, index + 1, nums.length - 1);
                break;
            }
        }

    }
}

public class Main {
    public static void main(String[] args) {
        int[] test = new int[]{2, 3, 1, 3, 3};
        new Solution().nextPermutation(test);
        System.out.println(Arrays.toString(test));
    }
}
