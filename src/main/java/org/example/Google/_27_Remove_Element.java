package org.example.Google;

// https://leetcode.com/problems/remove-element/description/
public class _27_Remove_Element {

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int removeElement(int[] nums, int val) {
        int lastOccurrenceOfVal = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                swap(nums, i, lastOccurrenceOfVal++);
            }
        }

        return lastOccurrenceOfVal;
    }
}
