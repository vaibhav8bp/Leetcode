package org.example.Striver_SDE_Sheet.Day_24_Graph_Part_II.Floyd_Warshall;

import java.io.*;

class Solution {
    public void shortest_distance(int[][] matrix) {
        for (int iteration = 0; iteration < matrix.length; iteration++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][iteration] == -1 || matrix[iteration][j] == -1) {
                        continue;
                    }
                    if (matrix[i][j] == -1) {
                        matrix[i][j] = matrix[i][iteration] + matrix[iteration][j];
                    } else {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][iteration] + matrix[iteration][j]);
                    }
                }
            }
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().trim().split(" ");
                for (int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortest_distance(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}