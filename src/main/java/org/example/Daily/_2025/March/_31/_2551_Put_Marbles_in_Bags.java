package org.example.Daily._2025.March._31;

import java.util.Arrays;

// https://leetcode.com/problems/put-marbles-in-bags/description/
public class _2551_Put_Marbles_in_Bags {

    public static long putMarbles(int[] weights, int k) {

        for (int i = 0; i < weights.length - 1; i++) {
            weights[i] = weights[i] + weights[i + 1];
        }

        Arrays.sort(weights, 0, weights.length - 1);

        long max = 0;
        long min = 0;

        for (int i = 0; i < k - 1; i++) {
            min += weights[i];
            max += weights[weights.length - 2 - i];
        }

        return max - min;
    }

//    public static long putMarbles(int[] weights, int k) {
//
//        for (int i = 0; i < weights.length - 1; i++) {
//            weights[i] = weights[i] + weights[i + 1];
//        }
//
//        Arrays.sort(weights, 0, weights.length - 1);
//
//
//        long max = 0;
//        long min = 0;
//
//        for (int i = 0; i < k - 1; i++) {
//            min += weights[i];
//            max += weights[weights.length - 2 - i];
//        }
//
//        return max - min;
//    }

    public static void main(String[] args) {
        System.out.println(putMarbles(new int[]{1, 3, 5, 1}, 2));
    }
}

// 1,3,5,1
// cut after i=0 -> [1] [3 5 1] -> 1+1+3+1=6
// cut after i=1 -> [1 3] [5 1] -> 1+3+5+1=10
// cut after i=2 -> [1 3 5] [1] -> 1+5+1+1=8