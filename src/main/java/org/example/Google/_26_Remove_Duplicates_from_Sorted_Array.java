package org.example.Google;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
public class _26_Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; ) {
            int end = i + 1;

            while (end < nums.length && nums[i] == nums[end]) {
                end++;
            }

            nums[k++] = nums[i];
            i = end;
        }

        return k;
    }
}
