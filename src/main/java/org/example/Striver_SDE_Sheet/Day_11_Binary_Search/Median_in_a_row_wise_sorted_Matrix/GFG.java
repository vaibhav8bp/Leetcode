package org.example.Striver_SDE_Sheet.Day_11_Binary_Search.Median_in_a_row_wise_sorted_Matrix;

import java.io.*;

// https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1
class Solution {

    private int[] minAndMaxOfMatrix(int[][] matrix, int R, int C) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < R; i++) {
            min = Math.min(min, matrix[i][0]);
            max = Math.max(max, matrix[i][C - 1]);
        }

        return new int[]{min, max};
    }

    public int countOfElementsSmallerOrEqualToX(int[][] matrix, int R, int C, int x) {
        int answer = 0;

        for (int i = 0; i < R; i++) {
            int low = 0;
            int high = C - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (matrix[i][mid] <= x) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            answer += low;
        }
        return answer;
    }

    int median(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        int[] minAndMaxOfMatrix = minAndMaxOfMatrix(matrix, R, C);
        int low = minAndMaxOfMatrix[0];
        int high = minAndMaxOfMatrix[1];
        int midIndexOfMatrix = (R * C) / 2;

        while (low <= high) {
            int mid = (low + high) / 2;
            int countOfElementsSmallerOrEqualToMid = countOfElementsSmallerOrEqualToX(matrix, R, C, mid);
            if (countOfElementsSmallerOrEqualToMid <= midIndexOfMatrix) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int R = Integer.parseInt(read.readLine());
            int C = Integer.parseInt(read.readLine());
            int[][] matrix = new int[R][C];
            for (int i = 0; i < R; i++) {
                String[] line = read.readLine().trim().split(" ");
                for (int j = 0; j < C; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}