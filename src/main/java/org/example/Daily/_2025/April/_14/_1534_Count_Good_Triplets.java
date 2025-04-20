package org.example.Daily._2025.April._14;

// https://leetcode.com/problems/count-good-triplets/description/
public class _1534_Count_Good_Triplets {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {

        int goodTriplets = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 2; j < arr.length; j++) {
                if (Math.abs(arr[i] - arr[j]) > c) {
                    continue;
                }
                for (int k = i + 1; k < j; k++) {
                    if ((Math.abs(arr[i] - arr[k]) <= a) && ((Math.abs(arr[k] - arr[j]) <= b))) {
                        goodTriplets++;
                    }
                }
            }
        }

        return goodTriplets;
    }
}