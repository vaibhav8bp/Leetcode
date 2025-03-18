package org.example.Striver_Youtube.DP._7;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// https://www.geeksforgeeks.org/problems/geeks-training/0

public class Geeks_Training {

    public int maximumPoints(int[][] points) {
        int[] previousDP = new int[4];
        Arrays.fill(previousDP, 0);

        for (int i = points.length - 1; i >= 0; i--) {
            int[] dp = new int[4];
            for (int j = 2; j >= -1; j--) {
                int answer = Integer.MIN_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (k != j) {
                        answer = Math.max(answer, points[i][k] + previousDP[k + 1]);
                    }
                }
                dp[j + 1] = answer;
            }
            previousDP = dp;
        }

        return previousDP[0];
    }

//    private int maximumPoints(int currentIndex, int previousActivityPicked, int[][] points, int[][] dp) {
//        if (currentIndex == points.length) {
//            return 0;
//        }
//
//        if (dp[currentIndex][previousActivityPicked + 1] != -1) {
//            return dp[currentIndex][previousActivityPicked + 1];
//        }
//
//        int answer = Integer.MIN_VALUE;
//
//        for (int i = 0; i < 3; i++) {
//            if (i != previousActivityPicked) {
//                answer = Math.max(answer, points[currentIndex][i] + maximumPoints(currentIndex + 1, i, points, dp));
//            }
//        }
//
//        dp[currentIndex][previousActivityPicked + 1] = answer;
//        return dp[currentIndex][previousActivityPicked + 1];
//    }
//
//    public int maximumPoints(int[][] points) {
//        int[][] dp = new int[points.length][4];
//        for (int i = 0; i < points.length; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return maximumPoints(0, -1, points, dp);
//    }

//    private int maximumPoints(int currentIndex, int previousActivityPicked, int[][] points) {
//        if (currentIndex == points.length) {
//            return 0;
//        }
//
//        int answer = Integer.MIN_VALUE;
//
//        for (int i = 0; i < 3; i++) {
//            if (i != previousActivityPicked) {
//                answer = Math.max(answer, points[currentIndex][i] + maximumPoints(currentIndex + 1, i, points));
//            }
//        }
//
//        return answer;
//    }
//
//    public int maximumPoints( int[][] points) {
//        return maximumPoints(0, -1, points);
//    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Geeks_Training obj = new Geeks_Training();
            int res = obj.maximumPoints(arr);
            System.out.println(res);

            System.out.println("~");
        }
    }
}