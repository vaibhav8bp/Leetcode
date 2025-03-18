package org.example.Daily._2025.March._16;

import java.sql.Time;
import java.util.Arrays;

// https://leetcode.com/problems/minimum-time-to-repair-cars/description/
public class _2594_Minimum_Time_to_Repair_Cars {

    // What is the BS space ?
    // [1...max(rank)*cars*cars]

    private boolean isPossibleToCompleteAllCarsInCurrentTime(long currentTime, int[] ranks, int cars) {
        // Time taken by ith mechanic to fix n cars = rank(i)*n*n
        // Time = rank(i)*n*n
        // Math.sqrt(Time/ranks(i))=n, pick floor value
        // So check each mechanic can fix how many cars in currentTime

        long carsFixed = 0;

        for (Integer currentRank : ranks) {
            carsFixed += (int) Math.sqrt( (double) currentTime / currentRank);
            if (carsFixed >= cars) {
                return true;
            }
        }

        return false;
    }

    public long repairCars(int[] ranks, int cars) {
        long left = 1;
        long right = (long) Arrays.stream(ranks).min().getAsInt() * cars * cars;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (isPossibleToCompleteAllCarsInCurrentTime(mid, ranks, cars)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
