package org.example.Google;

// https://leetcode.com/problems/next-permutation/description/
public class _31_Next_Permutation {
    // 1 2 3 8 5 3 10 4 2
    // 1 2 3 8 5 4 2  3 10

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;

        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        for (; i >= 0 && nums[i] >= nums[i + 1]; i--) {
        }

        if (i == -1) {
            reverse(nums, 0);
            return;
        }

        // Find element just larger than breakpoint element.
        int j = nums.length - 1;
        for (; j > i && nums[j] <= nums[i]; j--) {
        }

        swap(nums, i, j);
        reverse(nums, i + 1);
    }
}
