package org.example.Striver_SDE_Sheet.Day_25_Dynamic_Programming._152_Maximum_Product_Subarray;

// https://www.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1

import java.util.*;

class MaxSumISSolution {

    public int maxSumIS(int[] arr) {
        int[] dp = new int[arr.length + 1];

        int[] previousDp = new int[arr.length + 1];
        Arrays.fill(previousDp, 0);

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= -1; j--) {
                // Not Pick
                int notPickCurrentElement = previousDp[j + 1];

                // Pick
                int pickCurrentElement = 0;
                if (j == -1) {
                    pickCurrentElement = arr[i] + previousDp[i + 1];
                } else {
                    if (arr[j] < arr[i]) {
                        pickCurrentElement = arr[i] + previousDp[i + 1];
                    }
                }

                dp[j + 1] = Math.max(pickCurrentElement, notPickCurrentElement);
            }
            previousDp = dp;
        }

        return previousDp[0];
    }

    // For arr index is j only,
    // For DP Index is j+1.
//    public int maxSumIS(int[] arr) {
//        int[][] dp = new int[arr.length + 1][arr.length + 1];
//        for (int i = 0; i < arr.length + 1; i++) {
//            dp[arr.length][i] = 0;
//        }
//
//        for (int i = arr.length - 1; i >= 0; i--) {
//            for (int j = i - 1; j >= -1; j--) {
//                // Not Pick
//                int notPickCurrentElement = dp[i + 1][j + 1];
//
//                // Pick
//                int pickCurrentElement = 0;
//                if (j == -1) {
//                    pickCurrentElement = arr[i] + dp[i + 1][i + 1];
//                } else {
//                    if (arr[j] < arr[i]) {
//                        pickCurrentElement = arr[i] + dp[i + 1][i + 1];
//                    }
//                }
//
//                dp[i][j + 1] = Math.max(pickCurrentElement, notPickCurrentElement);
//            }
//        }
//
//        return dp[0][0];
//    }

//    private int maxSumIS(int currentIndex, int previousIndex, int[] arr, int[][] dp) {
//        if (currentIndex == arr.length) {
//            return 0;
//        }
//
//        if (dp[currentIndex][previousIndex + 1] != -1) {
//            return dp[currentIndex][previousIndex + 1];
//        }
//
//        // Not Pick
//        int notPickCurrentElement = maxSumIS(currentIndex + 1, previousIndex, arr, dp);
//
//        // Pick
//        int pickCurrentElement = 0;
//        if (previousIndex == -1) {
//            pickCurrentElement = arr[currentIndex] + maxSumIS(currentIndex + 1, currentIndex, arr, dp);
//        } else {
//            if (arr[previousIndex] < arr[currentIndex]) {
//                pickCurrentElement = arr[currentIndex] + maxSumIS(currentIndex + 1, currentIndex, arr, dp);
//            }
//        }
//
//        dp[currentIndex][previousIndex + 1] = Math.max(pickCurrentElement, notPickCurrentElement);
//        return dp[currentIndex][previousIndex + 1];
//    }
//
//    public int maxSumIS(int[] arr) {
//        int[][] dp = new int[arr.length][arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return maxSumIS(0, -1, arr, dp);
//    }


    // Here BS nlog(n) would not work as we have to maximize sum to maximize length.
    // eg. 3 2 4 6
    // BS will give answer 2+4+6
    // In Real Answer is 3+4+6

//    private int maxSumIS(int currentIndex, int previousIndex, int[] arr) {
//        if (currentIndex == arr.length) {
//            return 0;
//        }
//
//        // Not Pick
//        int notPickCurrentElement = maxSumIS(currentIndex + 1, previousIndex, arr);
//
//        // Pick
//        int pickCurrentElement = 0;
//        if (previousIndex == -1) {
//            pickCurrentElement = arr[currentIndex] + maxSumIS(currentIndex + 1, currentIndex, arr);
//        } else {
//            if (arr[previousIndex] < arr[currentIndex]) {
//                pickCurrentElement = arr[currentIndex] + maxSumIS(currentIndex + 1, currentIndex, arr);
//            }
//        }
//
//        return Math.max(pickCurrentElement, notPickCurrentElement);
//    }
//
//    public int maxSumIS(int[] arr) {
//        return maxSumIS(0, -1, arr);
//    }
}

class GfG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String[] temp = sc.nextLine().trim().split(" ");
            int n = temp.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(temp[i]);
            MaxSumISSolution ob = new MaxSumISSolution();
            System.out.println(ob.maxSumIS(arr));
            System.out.println("~");
        }
    }
}

/*
1
5 3 2 4 7 9 8 2 3
 */