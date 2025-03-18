package org.example.Random;

// https://leetcode.com/problems/zero-array-transformation-i/description/
public class _3355_Zero_Array_Transformation_I {
    // nums = [4,3,2,1], queries = [[1,3],[0,2]]

    public static boolean isZeroArray(int[] nums, int[][] queries) {

        int[] runningCount = new int[nums.length];

        for (int[] currentQuery : queries) {
            runningCount[currentQuery[0]]++;
            if (currentQuery[1] != nums.length - 1) {
                runningCount[currentQuery[1] + 1]--;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                runningCount[i] += runningCount[i - 1];
            }
            if (runningCount[i] < nums[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] queries = {{1, 3}, {0, 2}};
        System.out.println(isZeroArray(new int[]{4, 3, 2, 1}, queries));
    }
}
