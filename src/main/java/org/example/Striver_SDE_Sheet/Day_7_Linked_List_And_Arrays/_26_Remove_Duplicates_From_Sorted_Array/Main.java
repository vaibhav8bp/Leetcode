package org.example.Striver_SDE_Sheet.Day_7_Linked_List_And_Arrays._26_Remove_Duplicates_From_Sorted_Array;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
class Solution {
    public int removeDuplicates(int[] nums) {
        int nextAvailableIndex = 0;

        for (int i = 0; i < nums.length; ) {
            int currentIndex = i;
            while (currentIndex < nums.length && nums[currentIndex] == nums[i]) {
                currentIndex++;
            }
            nums[nextAvailableIndex++] = nums[i];
            i = currentIndex;
        }

        return nextAvailableIndex;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(new Solution().removeDuplicates(nums));
    }
}
