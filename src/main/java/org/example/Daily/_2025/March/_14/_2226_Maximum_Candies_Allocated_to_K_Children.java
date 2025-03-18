package org.example.Daily._2025.March._14;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-candies-allocated-to-k-children/description/
public class _2226_Maximum_Candies_Allocated_to_K_Children {

    // if we can pick a min capability after picking k items lets say =x
    // then for every capability >=x , x will always be there.
    private static boolean isPossible(int[] candies, int mid, long k) {
        long childrenCount = 0;
        for (Integer currentCandiePileCount : candies) {
            // Compute current pile can be divided into how many sub piles.

            // 12 with 5 can be divided into 2.
            long subPilesCount = currentCandiePileCount / mid;
            childrenCount += subPilesCount;
            if (childrenCount >= k) {
                return true;
            }
        }
        return false;
    }

    public static int maximumCandies(int[] candies, long k) {

        int left = 1;
        int right = Arrays.stream(candies).max().getAsInt();

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(candies, mid, k)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        System.out.println(maximumCandies(new int[]{4, 7, 5}, 4));
    }
}