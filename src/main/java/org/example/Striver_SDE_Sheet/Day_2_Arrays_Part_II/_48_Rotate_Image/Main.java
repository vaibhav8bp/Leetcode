package org.example.Striver_SDE_Sheet.Day_2_Arrays_Part_II._48_Rotate_Image;

import java.util.Arrays;

class Solution {

    private void swap(int[][] matrix, int oldX, int oldY, int newX, int newY) {
        int temp = matrix[oldX][oldY];
        matrix[oldX][oldY] = matrix[newX][newY];
        matrix[newX][newY] = temp;
    }

    public void rotate(int[][] matrix) {

        // Swap arr[i][j] with arr[j][i]
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        // Reverse every ith row
        for (int i = 0; i < matrix.length; i++) {
            int colStart = 0;
            int colEnd = matrix.length - 1;
            while (colStart < colEnd) {
                swap(matrix, i, colStart, i, colEnd);
                colStart++;
                colEnd--;
            }
        }
    }
}

// class Solution {
//     public void rotate(int[][] matrix) {
//         int rowStart = 0, rowEnd = matrix.length - 1, colStart = 0, colEnd = matrix.length - 1;
//         while ((rowStart <= rowEnd) && (colStart <= colEnd)) {
//             for (int i = 0; i < (colEnd - colStart); i++) {
//                 int temp = matrix[rowStart + i][colEnd];
//                 matrix[rowStart + i][colEnd] = matrix[rowStart][colStart + i];
//                 int temp1 = matrix[rowEnd][colEnd - i];
//                 matrix[rowEnd][colEnd - i] = temp;
//                 temp = matrix[rowEnd - i][colStart];
//                 matrix[rowEnd - i][colStart] = temp1;
//                 matrix[rowStart][colStart + i] = temp;
//             }
//             rowStart++;
//             colStart++;
//             rowEnd--;
//             colEnd--;
//         }
//     }
// }

public class Main {
    public static void main(String[] args) {
        int[][] arr = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        Solution solution = new Solution();
        solution.rotate(arr);
        System.out.println(Arrays.deepToString(arr));
    }
}
