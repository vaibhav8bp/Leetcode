package org.example.Google;

import java.util.Arrays;

// https://leetcode.com/problems/candy/description/
public class _135_Candy {

    // 1,2,87,87,87,2,1
    public static int candy(int[] ratings) {

        if (ratings.length == 1) {
            return 1;
        }

        int totalCandies = 0;
        int lengthOfIncreasingSlope = 0;
        boolean wasDecreasing = false;
        boolean wasHorizontal = false;

        for (int currentIndex = 0; currentIndex < ratings.length - 1; ) {
            // Increasing Slope
            if (ratings[currentIndex] < ratings[currentIndex + 1]) {
                lengthOfIncreasingSlope = 1;
                while (currentIndex < ratings.length - 1 && ratings[currentIndex] < ratings[currentIndex + 1]) {
                    currentIndex++;
                    lengthOfIncreasingSlope++;
                }
                totalCandies += ((lengthOfIncreasingSlope) * (lengthOfIncreasingSlope + 1) / 2);
                if (wasDecreasing || wasHorizontal) {
                    totalCandies -= 1;
                }
                wasDecreasing = false;
                wasHorizontal = false;
            }
            // Decreasing Slope
            else if (ratings[currentIndex] > ratings[currentIndex + 1]) {
                int lengthOfDecreasingSlope = 1;
                while (currentIndex < ratings.length - 1 && ratings[currentIndex] > ratings[currentIndex + 1]) {
                    currentIndex++;
                    lengthOfDecreasingSlope++;
                }
                totalCandies += ((lengthOfDecreasingSlope) * (lengthOfDecreasingSlope + 1) / 2);
                if (lengthOfIncreasingSlope != 0) {
                    totalCandies -= Math.min(lengthOfIncreasingSlope, lengthOfDecreasingSlope);
                }
                if (wasHorizontal) {
                    totalCandies -= 1;
                }
                lengthOfIncreasingSlope = 0;
                wasDecreasing = true;
                wasHorizontal = false;
            }
            // Horizontal Slope
            else {
                int lengthOfHorizontalSlope = 1;
                while (currentIndex < ratings.length - 1 && ratings[currentIndex] == ratings[currentIndex + 1]) {
                    currentIndex++;
                    lengthOfHorizontalSlope++;
                }
                totalCandies += lengthOfHorizontalSlope;
                if (lengthOfIncreasingSlope != 0 || wasDecreasing) {
                    totalCandies -= 1;
                }
                lengthOfIncreasingSlope = 0;
                wasDecreasing = false;
                wasHorizontal = true;
            }
        }

        return totalCandies;
    }

//    public static int candy(int[] ratings) {
//        int[] leftCandies = new int[ratings.length];
//
//        leftCandies[0] = 1;
//
//        for (int i = 1; i < ratings.length; i++) {
//            if (ratings[i] > ratings[i - 1]) {
//                leftCandies[i] = leftCandies[i - 1] + 1;
//            } else {
//                leftCandies[i] = 1;
//            }
//        }
//
//        int totalCandies = Math.max(1, leftCandies[ratings.length - 1]);
//        int previous = totalCandies;
//
//        for (int i = ratings.length - 2; i >= 0; i--) {
//            if (ratings[i] > ratings[i + 1]) {
//                totalCandies += Math.max(previous + 1, leftCandies[i]);
//                previous++;
//            } else {
//                totalCandies += Math.max(1, leftCandies[i]);
//                previous = 1;
//            }
//        }
//
//        return totalCandies;
//    }

//    public static int candy(int[] ratings) {
//        int[] leftCandies = new int[ratings.length];
//
//        leftCandies[0] = 1;
//
//        for (int i = 1; i < ratings.length; i++) {
//            if (ratings[i] > ratings[i - 1]) {
//                leftCandies[i] = leftCandies[i - 1] + 1;
//            } else {
//                leftCandies[i] = 1;
//            }
//        }
//
//        int totalCandies = Math.max(1, leftCandies[ratings.length - 1]);
//        int previous = totalCandies;
//
//        for (int i = ratings.length - 2; i >= 0; i--) {
//            if (ratings[i] > ratings[i + 1]) {
//                totalCandies += Math.max(previous + 1, leftCandies[i]);
//                previous++;
//            } else {
//                totalCandies += Math.max(1, leftCandies[i]);
//                previous = 1;
//            }
//        }
//
//        return totalCandies;
//    }

//    public int candy(int[] ratings) {
//        int[] leftCandies = new int[ratings.length];
//        int[] rightCandies = new int[ratings.length];
//
//        leftCandies[0] = 1;
//
//        for (int i = 1; i < ratings.length; i++) {
//            if (ratings[i] > ratings[i - 1]) {
//                leftCandies[i] = leftCandies[i - 1] + 1;
//            } else {
//                leftCandies[i] = 1;
//            }
//        }
//
//        rightCandies[ratings.length - 1] = 1;
//
//        for (int i = ratings.length - 2; i >= 0; i--) {
//            if (ratings[i] > ratings[i + 1]) {
//                rightCandies[i] = rightCandies[i + 1] + 1;
//            } else {
//                rightCandies[i] = 1;
//            }
//        }
//
//        int totalCandies = 0;
//
//        for (int i = 0; i < ratings.length; i++) {
//            totalCandies += Math.max(leftCandies[i], rightCandies[i]);
//        }
//
//        return totalCandies;
//    }

    public static void main(String[] args) {
        System.out.println(candy(new int[]{1, 2, 87, 87, 87, 2, 1}));
    }
}
