package org.example.Striver_Youtube.DP._16;

// https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Minimum_sum_partition {

    public int minDifference(int[] arr) {
        int totalSum = Arrays.stream(arr).sum();
        int[] previousDP = new int[totalSum + 1];

        for (int i = 0; i < totalSum + 1; i++) {
            int secondPartitionSum = totalSum - i;
            previousDP[i] = Math.abs(i - secondPartitionSum);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int[] currentDP = new int[totalSum + 1];
            for (int j = totalSum; j >= 0; j--) {
                int includeCurrentElement = Integer.MAX_VALUE;
                if (j + arr[i] <= totalSum) {
                    includeCurrentElement = previousDP[j + arr[i]];
                }
                int excludeCurrentElement = previousDP[j];
                currentDP[j] = Math.min(includeCurrentElement, excludeCurrentElement);
            }
            previousDP = currentDP;
        }

        return previousDP[0];
    }

//    public int minDifference(int[] arr) {
//        int totalSum = Arrays.stream(arr).sum();
//        int[] previousDP = new int[totalSum + 1];
//
//        for (int i = 0; i < totalSum + 1; i++) {
//            int secondPartitionSum = totalSum - i;
//            previousDP[i] = Math.abs(i - secondPartitionSum);
//        }
//
//        for (int i = arr.length - 1; i >= 0; i--) {
//            int[] currentDP = new int[totalSum + 1];
//            for (int j = totalSum; j >= 0; j--) {
//                int includeCurrentElement = Integer.MAX_VALUE;
//                if (j + arr[i] <= totalSum) {
//                    includeCurrentElement = previousDP[j + arr[i]];
//                }
//                int excludeCurrentElement = previousDP[j];
//                currentDP[j] = Math.min(includeCurrentElement, excludeCurrentElement);
//            }
//            previousDP = currentDP;
//        }
//
//        return previousDP[0];
//    }

//    public int minDifference(int[] arr) {
//        int totalSum = Arrays.stream(arr).sum();
//        int[][] dp = new int[arr.length + 1][totalSum + 1];
//
//        for (int i = 0; i < totalSum + 1; i++) {
//            int secondPartitionSum = totalSum - i;
//            dp[arr.length][i] = Math.abs(i - secondPartitionSum);
//        }
//
//        for (int i = arr.length - 1; i >= 0; i--) {
//            for (int j = totalSum; j >= 0; j--) {
//                int includeCurrentElement = Integer.MAX_VALUE;
//                if (j + arr[i] <= totalSum) {
//                    includeCurrentElement = dp[i + 1][j + arr[i]];
//                }
//                int excludeCurrentElement = dp[i + 1][j];
//                dp[i][j] = Math.min(includeCurrentElement, excludeCurrentElement);
//            }
//        }
//
//        return dp[0][0];
//    }

//    private int minDifference(int currentIndex, int currentSum, int[] arr, int totalSum, int[][] dp) {
//
//        if (currentIndex == arr.length) {
//            int secondPartitionSum = totalSum - currentSum;
//            return Math.abs(currentSum - secondPartitionSum);
//        }
//
//        if (dp[currentIndex][currentSum] != -1) {
//            return dp[currentIndex][currentSum];
//        }
//
//        int includeCurrentElement = minDifference(currentIndex + 1, currentSum + arr[currentIndex], arr, totalSum, dp);
//        int excludeCurrentElement = minDifference(currentIndex + 1, currentSum, arr, totalSum, dp);
//
//        dp[currentIndex][currentSum] = Math.min(includeCurrentElement, excludeCurrentElement);
//        return dp[currentIndex][currentSum];
//    }
//
//    public int minDifference(int[] arr) {
//        int totalSum = Arrays.stream(arr).sum();
//        int[][] dp = new int[arr.length][totalSum + 1];
//        for (int i = 0; i < arr.length; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        return minDifference(0, 0, arr, totalSum, dp);
//    }

//    private int minDifference(int currentIndex, int currentSum, int[] arr, int totalSum) {
//
//        if (currentIndex == arr.length) {
//            int secondPartitionSum = totalSum - currentSum;
//            return Math.abs(currentSum - secondPartitionSum);
//        }
//
//        int includeCurrentElement = minDifference(currentIndex + 1, currentSum + arr[currentIndex], arr, totalSum);
//        int excludeCurrentElement = minDifference(currentIndex + 1, currentSum, arr, totalSum);
//
//        return Math.min(includeCurrentElement, excludeCurrentElement);
//    }
//
//    public int minDifference(int[] arr) {
//        int totalSum = Arrays.stream(arr).sum();
//        return minDifference(0, 0, arr, totalSum);
//    }

//    private int minDifference(int currentIndex, int s1Sum, int s2Sum, int[] arr, Map<String, Integer> dp) {
//        if (currentIndex == arr.length) {
//            return Math.abs(s1Sum - s2Sum);
//        }
//
//        String currentKey = String.valueOf(currentIndex).concat("-").concat(String.valueOf(s1Sum)).concat("-").concat(String.valueOf(s2Sum));
//
//        if (dp.containsKey(currentKey)) {
//            return dp.get(currentKey);
//        }
//
//        int includeCurrentElementInS1 = minDifference(currentIndex + 1, s1Sum + arr[currentIndex], s2Sum, arr, dp);
//        int includeCurrentElementInS2 = minDifference(currentIndex + 1, s1Sum, arr[currentIndex] + s2Sum, arr, dp);
//
//        dp.put(currentKey, Math.min(includeCurrentElementInS1, includeCurrentElementInS2));
//        return dp.get(currentKey);
//    }
//
//    public int minDifference(int[] arr) {
//        Map<String, Integer> dp = new HashMap<>();
//        return minDifference(0, 0, 0, arr, dp);
//    }

//    private int minDifference(int currentIndex, int s1Sum, int s2Sum, int[] arr) {
//        if (currentIndex == arr.length) {
//            return Math.abs(s1Sum - s2Sum);
//        }
//
//        int includeCurrentElementInS1 = minDifference(currentIndex + 1, s1Sum + arr[currentIndex], s2Sum, arr);
//        int includeCurrentElementInS2 = minDifference(currentIndex + 1, s1Sum, arr[currentIndex] + s2Sum, arr);
//
//        return Math.min(includeCurrentElementInS1, includeCurrentElementInS2);
//    }
//
//    public int minDifference(int[] arr) {
//        return minDifference(0, 0, 0, arr);
//    }
}

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            Minimum_sum_partition ob = new Minimum_sum_partition();
            int ans = ob.minDifference(arr);

            System.out.print(ans);

            System.out.println();
        }
    }
}

/*
1
1 4
 */