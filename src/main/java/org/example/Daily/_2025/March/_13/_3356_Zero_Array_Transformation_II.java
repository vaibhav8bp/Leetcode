package org.example.Daily._2025.March._13;

// https://leetcode.com/problems/zero-array-transformation-ii/description/

import java.util.Arrays;

public class _3356_Zero_Array_Transformation_II {

    private static boolean isPossible(int[] nums, int k, int[][] queries) {
        int[] runningCount = new int[nums.length];

        for (int i = 0; i <= k; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int value = queries[i][2];

            runningCount[left] += value;
            if (right + 1 < nums.length) {
                runningCount[right + 1] -= value;
            }
        }

        for (int i = 0; i < runningCount.length; i++) {
            if (i != 0) {
                runningCount[i] += runningCount[i - 1];
            }
            if (runningCount[i] < nums[i]) {
                return false;
            }
        }

        return true;
    }

    public static int minZeroArray(int[] nums, int[][] queries) {

        if (Arrays.stream(nums).allMatch(x -> x == 0)) {
            return 0;
        }

        if (!isPossible(nums, queries.length - 1, queries)) {
            return -1;
        }

        int low = 0;
        int high = queries.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(nums, mid, queries)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low + 1;
    }

//    private boolean isPossible(int[] nums, int[] runningCount) {
//        int[] temp = new int[runningCount.length];
//        System.arraycopy(runningCount, 0, temp, 0, runningCount.length);
//
//        for (int i = 0; i < nums.length; i++) {
//            if (i != 0) {
//                temp[i] += temp[i - 1];
//            }
//            if (temp[i] < nums[i]) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    public int minZeroArray(int[] nums, int[][] queries) {
//        int[] runningCount = new int[nums.length];
//
//        if (isPossible(nums, runningCount)) {
//            return 0;
//        }
//
//        int currentQueryCount = 0;
//
//        for (int[] currentQuery : queries) {
//            currentQueryCount++;
//            runningCount[currentQuery[0]] += currentQuery[2];
//            if (currentQuery[1] != nums.length - 1) {
//                runningCount[currentQuery[1] + 1] -= currentQuery[2];
//            }
//            if (isPossible(nums, runningCount)) {
//                return currentQueryCount;
//            }
//        }
//
//        return -1;
//    }

    public static void main(String[] args) {
        int[][] queries = {{0, 0, 5}, {0, 0, 1}, {0, 0, 3}, {0, 0, 2}};
        System.out.println(minZeroArray(new int[]{5}, queries));
    }
}
