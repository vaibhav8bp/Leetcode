package org.example.Daily._2025.January._25;

import java.util.*;

// https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/
public class _2948_Make_Lexicographically_Smallest_Array_by_Swapping_Elements {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[][] sorted = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            sorted[i][0] = nums[i];
            sorted[i][1] = i;
        }

        Arrays.sort(sorted, Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < nums.length; ) {

            int groupEndIndex = i + 1;

            while (groupEndIndex < nums.length && ((groupEndIndex == 0) || sorted[groupEndIndex][0] - sorted[groupEndIndex - 1][0] <= limit)) {
                groupEndIndex++;
            }

            List<Integer> originalNumsIndex = new ArrayList<>();

            for (int j = i; j < groupEndIndex; j++) {
                originalNumsIndex.add(sorted[j][1]);
            }

            Collections.sort(originalNumsIndex);

            for (int k = 0, j = i; k < originalNumsIndex.size() && j < groupEndIndex; k++, j++) {
                nums[originalNumsIndex.get(k)] = sorted[j][0];
            }

            i = groupEndIndex;
        }

        return nums;
    }

    // Brute Force - O(N^2)
//    private void swap(int[] nums, int leftIndex, int rightIndex) {
//        int temp = nums[leftIndex];
//        nums[leftIndex] = nums[rightIndex];
//        nums[rightIndex] = temp;
//    }

//    private static int getCurrentIndexForContention(int[] nums, int limit, int leftIndexForSwapping) {
//        int currentIndexForContention = -1;
//        for (int rightIndexForSwapping = leftIndexForSwapping + 1; rightIndexForSwapping < nums.length; rightIndexForSwapping++) {
//            if (nums[leftIndexForSwapping] > nums[rightIndexForSwapping] && (nums[leftIndexForSwapping] - nums[rightIndexForSwapping] <= limit)) {
//                if (currentIndexForContention == -1) {
//                    currentIndexForContention = rightIndexForSwapping;
//                } else {
//                    currentIndexForContention = (nums[currentIndexForContention] <= nums[rightIndexForSwapping]) ? currentIndexForContention : rightIndexForSwapping;
//                }
//            }
//        }
//        return currentIndexForContention;
//    }

//    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

//        for (int leftIndexForSwapping = 0; leftIndexForSwapping < nums.length; leftIndexForSwapping++) {
//            int currentIndexForContention = getCurrentIndexForContention(nums, limit, leftIndexForSwapping);

//            if (currentIndexForContention != -1) {
//                swap(nums, leftIndexForSwapping, currentIndexForContention);
//                // This is because now at leftIndex there is a smaller element, now a smaller element can be found
//                // in right of new leftIndex because of limit constraint, as earlier there was a bigger no. now a
//                // smaller no. is there and constraint needs to be rechecked.

//                // Eg. 6 4 2 with limit 2.
//                // First Swap
//                // 4 6 2
//                // now 4 and 2 can also be swapped
//                leftIndexForSwapping--;
//            }
//        }

//        return nums;
//    }
}
