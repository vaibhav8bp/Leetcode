package org.example.Daily._2025.February._2;

public class _1752_Check_if_Array_Is_Sorted_and_Rotated {

    // 3 4 5 6 7 8 8 1
    // 9 1 2 3 4 5
    private int findBreakingPoint(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }

        return -1;
    }

    public boolean check(int[] nums) {
        int breakingIndex = findBreakingPoint(nums);

        if (breakingIndex == -1) {
            return true;
        }

        int least = nums[0];

        for (int i = breakingIndex + 1; i < nums.length; i++) {
            if (nums[i] > least) {
                return false;
            } else if ((i != nums.length - 1) && (nums[i] > nums[i + 1])) {
                return false;
            }
        }

        return true;
    }
}
