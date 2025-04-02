package org.example.Striver_SDE_Sheet.Day_3_Arrays_Part_III._74_Search_A_2D_Matrix;

// https://leetcode.com/problems/search-a-2d-matrix/description/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int rowCount = matrix.length;
        int columnCount = matrix[0].length;
        int start = 0;
        int end = rowCount * columnCount - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int rowIndexOfMidPosition = mid / columnCount;
            int columnIndexOfMidPosition = mid % columnCount;

            if (matrix[rowIndexOfMidPosition][columnIndexOfMidPosition] == target) {
                return true;
            } else if (matrix[rowIndexOfMidPosition][columnIndexOfMidPosition] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        System.out.println(new Solution().searchMatrix(matrix, target));
    }
}
