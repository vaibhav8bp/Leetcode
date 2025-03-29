package org.example.Striver_Youtube.DP._18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/partitions-with-given-difference/0
public class Partitions_with_Given_Difference {

    int countPartitions(int[] arr, int d) {
        int n = arr.length;
        int totalSum = Arrays.stream(arr).sum();
        int[] previousDP = new int[totalSum + 1];

        for (int i = 0; i < totalSum + 1; i++) {
            int s2 = totalSum - i;

            if (i >= s2 && i - s2 == d) {
                previousDP[i] = 1;
            } else {
                previousDP[i] = 0;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int[] currentDP = new int[totalSum + 1];
            for (int j = totalSum; j >= 0; j--) {
                int includeCurrentElement = 0;
                if ((j + arr[i]) <= totalSum) {
                    includeCurrentElement = previousDP[j + arr[i]];
                }
                int excludeCurrentElement = previousDP[j];
                currentDP[j] = includeCurrentElement + excludeCurrentElement;
            }
            previousDP = currentDP;
        }

        return previousDP[0];
    }

//    int countPartitions(int[] arr, int d) {
//        int n = arr.length;
//        int totalSum = Arrays.stream(arr).sum();
//        int[][] dp = new int[n + 1][totalSum + 1];
//
//        for (int i = 0; i < totalSum + 1; i++) {
//            int s2 = totalSum - i;
//
//            if (i >= s2 && i - s2 == d) {
//                dp[n][i] = 1;
//            } else {
//                dp[n][i] = 0;
//            }
//        }
//
//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = totalSum; j >= 0; j--) {
//                int includeCurrentElement = 0;
//                if ((j + arr[i]) <= totalSum) {
//                    includeCurrentElement = dp[i + 1][j + arr[i]];
//                }
//                int excludeCurrentElement = dp[i + 1][j];
//                dp[i][j] = includeCurrentElement + excludeCurrentElement;
//            }
//        }
//
//        return dp[0][0];
//    }

//    private int countPartitions(int currentIndex, int currentSum, int d, int totalSum, int[] arr, int[][] dp) {
//        if (currentIndex == arr.length) {
//            int s2 = totalSum - currentSum;
//            if (currentSum >= s2 && currentSum - s2 == d) {
//                return 1;
//            }
//            return 0;
//        }
//
//        if (dp[currentIndex][currentSum] != -1) {
//            return dp[currentIndex][currentSum];
//        }
//
//        int includeCurrentElement = countPartitions(currentIndex + 1, currentSum + arr[currentIndex], d, totalSum, arr, dp);
//        int excludeCurrentElement = countPartitions(currentIndex + 1, currentSum, d, totalSum, arr, dp);
//
//        dp[currentIndex][currentSum] = includeCurrentElement + excludeCurrentElement;
//        return dp[currentIndex][currentSum];
//    }
//
//    int countPartitions(int[] arr, int d) {
//        int n = arr.length;
//        int totalSum = Arrays.stream(arr).sum();
//        int[][] dp = new int[n][totalSum + 1];
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return countPartitions(0, 0, d, Arrays.stream(arr).sum(), arr, dp);
//    }

//    private int countPartitions(int currentIndex, int currentSum, int d, int totalSum, int[] arr) {
//        if (currentIndex == arr.length) {
//            int s2 = totalSum - currentSum;
//
//            if (currentSum >= s2 && currentSum - s2 == d) {
//                return 1;
//            }
//            return 0;
//        }
//
//        int includeCurrentElement = countPartitions(currentIndex + 1, currentSum + arr[currentIndex], d, totalSum, arr);
//        int excludeCurrentElement = countPartitions(currentIndex + 1, currentSum, d, totalSum, arr);
//
//        return includeCurrentElement + excludeCurrentElement;
//    }
//
//    int countPartitions(int[] arr, int d) {
//        return countPartitions(0, 0, d, Arrays.stream(arr).sum(), arr);
//    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Partitions_with_Given_Difference sln = new Partitions_with_Given_Difference();
            int ans = sln.countPartitions(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}

/*
1
5 2 6 4
3
 */

/*
1
1 1 1 1
0
 */

/*
1
1 2 1 0 1 3 3
11
 */