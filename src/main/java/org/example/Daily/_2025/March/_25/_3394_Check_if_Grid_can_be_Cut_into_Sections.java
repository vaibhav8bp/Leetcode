package org.example.Daily._2025.March._25;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/
public class _3394_Check_if_Grid_can_be_Cut_into_Sections {

    private boolean checkValidCuts(int[][] rectangles, int axis) {

        Arrays.sort(rectangles, Comparator.comparingInt(o -> o[axis]));

        int previousEnd = -1;
        int countOfPartitions = 0;

        for (int[] currentRectangle : rectangles) {
            int currentRectangleStart = currentRectangle[axis];
            int currentRectangleEnd = currentRectangle[axis + 2];

            if (previousEnd <= currentRectangleStart) {
                previousEnd = currentRectangleEnd;
                countOfPartitions++;
                if (countOfPartitions == 2) {
                    return true;
                }
            } else {
                previousEnd = Math.max(previousEnd, currentRectangleEnd);
            }
        }

        return false;
    }

    public boolean checkValidCuts(int n, int[][] rectangles) {
        return checkValidCuts(rectangles, 0) || checkValidCuts(rectangles, 1);
    }
}
