package org.example.Striver_SDE_Sheet.Day_10_Recursion_And_BackTracking._Rat_In_A_Maze_Problem_I;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
class Solution {

    //                                             UP              DOWN              LEFT             RIGHT
    public static String[][] directions = {{"-1", "0", "U"}, {"1", "0", "D"}, {"0", "-1", "L"}, {"0", "1", "R"}};

    public static boolean validIndex(int currentRow, int currentColumn, int n) {
        return (currentRow >= 0 && currentRow < n && currentColumn >= 0 && currentColumn < n);
    }

    public static void findPathHelper(int[][] m, boolean[][] visited, ArrayList<String> finalList, String currentString, int currentRow, int currentColumn, int n) {
        if ((currentRow == (n - 1)) && (currentColumn == (n - 1))) {
            finalList.add(currentString);
            return;
        }

        visited[currentRow][currentColumn] = true;
        StringBuilder currentStringBuilder = new StringBuilder(currentString);
        for (String[] direction : directions) {
            int newRow = currentRow + Integer.parseInt(direction[0]);
            int newColumn = currentColumn + Integer.parseInt(direction[1]);
            String currentDirection = direction[2];
            if (validIndex(newRow, newColumn, n) && m[newRow][newColumn] == 1 && !visited[newRow][newColumn]) {
                currentStringBuilder.append(currentDirection);
                findPathHelper(m, visited, finalList, currentStringBuilder.toString(), newRow, newColumn, n);
                currentStringBuilder.deleteCharAt(currentStringBuilder.length() - 1);
            }
        }
        visited[currentRow][currentColumn] = false;

    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> finalList = new ArrayList<>();

        if (m[0][0] == 0) {
            return finalList;
        }

        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }
        findPathHelper(m, visited, finalList, "", 0, 0, n);
        return finalList;
    }
}

public class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = Solution.findPath(a, n);
            Collections.sort(res);
            if (!res.isEmpty()) {
                for (String re : res) System.out.print(re + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

//1
//4
//1 0 0 0
//1 1 0 1
//1 1 0 0
//0 1 1 1