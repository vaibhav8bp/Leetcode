package org.example.Random;

import java.util.*;

// https://leetcode.com/problems/maximum-total-damage-with-spell-casting/description/
public class _3186_Maximum_Total_Damage_With_Spell_Casting {

    private static boolean isPossible(int lastPower, int currentPower) {
        return (currentPower - lastPower) > 2;
    }

    public static long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> elementToFrequencyMapper = new HashMap<>();

        for (int currentPower : power) {
            elementToFrequencyMapper.put(currentPower, elementToFrequencyMapper.getOrDefault(currentPower, 0) + 1);
        }

        int[][] uniquePowers = new int[elementToFrequencyMapper.size()][2];
        int index = 0;

        for (int currentPower : elementToFrequencyMapper.keySet()) {
            uniquePowers[index][0] = currentPower;
            uniquePowers[index][1] = elementToFrequencyMapper.get(currentPower);
            index++;
        }

        Arrays.sort(uniquePowers, Comparator.comparingInt(o -> o[0]));

        long[] dp = new long[uniquePowers.length + 1];
        dp[uniquePowers.length] = 0;

        for (int i = uniquePowers.length - 1; i >= 0; i--) {
            long skipCurrentIndexPower = dp[i + 1];

            long currentCost = (long) uniquePowers[i][0] * uniquePowers[i][1];
            int nextIndex = i + 1;

            while (nextIndex < uniquePowers.length && !isPossible(uniquePowers[i][0], uniquePowers[nextIndex][0])) {
                nextIndex++;
            }

            long includeCurrentPower = currentCost + dp[nextIndex];

            dp[i] = Math.max(includeCurrentPower, skipCurrentIndexPower);
        }

        return dp[0];
    }

//    private static boolean isPossible(int lastPower, int currentPower) {
//        return (currentPower - lastPower) > 2;
//    }
//
//    private static long maximumTotalDamage(int currentIndex, int[][] uniquePowers, long[] dp) {
//        if (currentIndex == uniquePowers.length) {
//            return 0;
//        }
//
//        if (dp[currentIndex] != -1) {
//            return dp[currentIndex];
//        }
//
//        long skipCurrentIndexPower = maximumTotalDamage(currentIndex + 1, uniquePowers, dp);
//
//        long currentCost = (long) uniquePowers[currentIndex][0] * uniquePowers[currentIndex][1];
//        int nextIndex = currentIndex + 1;
//
//        while (nextIndex < uniquePowers.length && !isPossible(uniquePowers[currentIndex][0], uniquePowers[nextIndex][0])) {
//            nextIndex++;
//        }
//
//        long includeCurrentPower = currentCost + maximumTotalDamage(nextIndex, uniquePowers, dp);
//
//        dp[currentIndex] = Math.max(includeCurrentPower, skipCurrentIndexPower);
//        return dp[currentIndex];
//    }
//
//    public static long maximumTotalDamage(int[] power) {
//        Map<Integer, Integer> elementToFrequencyMapper = new HashMap<>();
//
//        for (int currentPower : power) {
//            elementToFrequencyMapper.put(currentPower, elementToFrequencyMapper.getOrDefault(currentPower, 0) + 1);
//        }
//
//        int[][] uniquePowers = new int[elementToFrequencyMapper.size()][2];
//        int index = 0;
//
//        for (int currentPower : elementToFrequencyMapper.keySet()) {
//            uniquePowers[index][0] = currentPower;
//            uniquePowers[index][1] = elementToFrequencyMapper.get(currentPower);
//            index++;
//        }
//
//        long[] dp = new long[uniquePowers.length];
//        Arrays.fill(dp, -1);
//        Arrays.sort(uniquePowers, Comparator.comparingInt(o -> o[0]));
//        return maximumTotalDamage(0, uniquePowers, dp);
//    }

//    private static boolean isPossible(int lastPower, int currentPower) {
//        return (currentPower - lastPower) > 2;
//    }
//
//    private static long maximumTotalDamage(int currentIndex, int[][] uniquePowers) {
//        if (currentIndex == uniquePowers.length) {
//            return 0;
//        }
//
//        long skipCurrentIndexPower = maximumTotalDamage(currentIndex + 1, uniquePowers);
//
//        long currentCost = (long) uniquePowers[currentIndex][0] * uniquePowers[currentIndex][1];
//        int nextIndex = currentIndex + 1;
//
//        while (nextIndex < uniquePowers.length && !isPossible(uniquePowers[currentIndex][0], uniquePowers[nextIndex][0])) {
//            nextIndex++;
//        }
//
//        long includeCurrentPower = currentCost + maximumTotalDamage(nextIndex, uniquePowers);
//
//        return Math.max(includeCurrentPower, skipCurrentIndexPower);
//    }
//
//    public static long maximumTotalDamage(int[] power) {
//        Map<Integer, Integer> elementToFrequencyMapper = new HashMap<>();
//
//        for (int currentPower : power) {
//            elementToFrequencyMapper.put(currentPower, elementToFrequencyMapper.getOrDefault(currentPower, 0) + 1);
//        }
//
//        int[][] uniquePowers = new int[elementToFrequencyMapper.size()][2];
//        int index = 0;
//
//        for (int currentPower : elementToFrequencyMapper.keySet()) {
//            uniquePowers[index][0] = currentPower;
//            uniquePowers[index][1] = elementToFrequencyMapper.get(currentPower);
//            index++;
//        }
//
//        Arrays.sort(uniquePowers, Comparator.comparingInt(o -> o[0]));
//        return maximumTotalDamage(0, uniquePowers);
//    }
}