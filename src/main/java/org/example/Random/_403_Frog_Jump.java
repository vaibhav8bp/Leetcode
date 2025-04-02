package org.example.Random;

import java.util.*;

// https://leetcode.com/problems/frog-jump/description/
public class _403_Frog_Jump {

    private final int[] directions = {-1, 0, +1};

    public boolean canCross(int[] stones) {

        // Given
        // 2 <= stones.length <= 2000

        Map<Integer, Integer> stonesToIndexMapping = new HashMap<>();

        for (int i = 0; i < stones.length; i++) {
            stonesToIndexMapping.put(stones[i], i);
        }

        int firstStonePosition = stones[0];

        if (!stonesToIndexMapping.containsKey(firstStonePosition + 1)) {
            return false;
        }

        boolean[][] dp = new boolean[stones.length][stones.length];

        Arrays.fill(dp[stones.length - 1], true);

        for (int i = stones.length - 2; i >= 1; i--) {
            for (int j = stones.length - 2; j >= 1; j--) {
                for (Integer currentDirection : directions) {
                    int newJump = j + currentDirection;

                    // Max Jump Possible is of length stones.length-2
                    if (newJump == 0) {
                        continue;
                    }

                    int newStonePosition = stones[i] + newJump;

                    int newStonePositionIndex = stonesToIndexMapping.getOrDefault(newStonePosition, -1);

                    if (newStonePositionIndex != -1 && dp[newStonePositionIndex][newJump]) {
                        dp[i][j] = true;
                        break;
                    }
                }
                if (!dp[i][j]) {
                    dp[i][j] = false;
                }
            }
        }

        return dp[1][1];
    }

//    private final int[] directions = {-1, 0, +1};
//
//    private boolean canCross(int currentIndex, int lastJump, int[] stones, Map<Integer, Integer> stonesToIndexMapping, Boolean[][] dp) {
//
//        if (currentIndex == stones.length - 1) {
//            return true;
//        }
//
//        if (dp[currentIndex][lastJump] != null) {
//            return dp[currentIndex][lastJump];
//        }
//
//        for (Integer currentDirection : directions) {
//            int newJump = lastJump + currentDirection;
//
//            if (newJump == 0) {
//                continue;
//            }
//
//            int newStonePosition = stones[currentIndex] + newJump;
//
//            int newStonePositionIndex = stonesToIndexMapping.getOrDefault(newStonePosition, -1);
//
//            if (newStonePositionIndex != -1 && canCross(newStonePositionIndex, newJump, stones, stonesToIndexMapping, dp)) {
//                dp[currentIndex][lastJump] = true;
//                return true;
//            }
//        }
//
//        dp[currentIndex][lastJump] = false;
//        return false;
//    }
//
//    public boolean canCross(int[] stones) {
//
//        // Given
//        // 2 <= stones.length <= 2000
//
//        Map<Integer, Integer> stonesToIndexMapping = new HashMap<>();
//
//        for (int i = 0; i < stones.length; i++) {
//            stonesToIndexMapping.put(stones[i], i);
//        }
//
//        int firstStonePosition = stones[0];
//
//        if (!stonesToIndexMapping.containsKey(firstStonePosition + 1)) {
//            return false;
//        }
//
//        Boolean[][] dp = new Boolean[stones.length][stones.length];
//
//        return canCross(1, 1, stones, stonesToIndexMapping, dp);
//    }

//    private final int[] directions = {-1, 0, +1};
//
//    private boolean canCross(int currentIndex, int lastJump, int[] stones, Map<Integer, Integer> stonesToIndexMapping) {
//
//        if (currentIndex == stones.length - 1) {
//            return true;
//        }
//
//        for (Integer currentDirection : directions) {
//            int newJump = lastJump + currentDirection;
//
//            if (newJump == 0) {
//                continue;
//            }
//
//            int newStonePosition = stones[currentIndex] + newJump;
//
//            int newStonePositionIndex = stonesToIndexMapping.getOrDefault(newStonePosition, -1);
//
//            if (newStonePositionIndex != -1 && canCross(newStonePositionIndex, newJump, stones, stonesToIndexMapping)) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    public boolean canCross(int[] stones) {
//
//        // Given
//        // 2 <= stones.length <= 2000
//
//        Map<Integer, Integer> stonesToIndexMapping = new HashMap<>();
//
//        for (int i = 0; i < stones.length; i++) {
//            stonesToIndexMapping.put(stones[i], i);
//        }
//
//        int firstStonePosition = stones[0];
//
//        if (!stonesToIndexMapping.containsKey(firstStonePosition + 1)) {
//            return false;
//        }
//
//        return canCross(1, 1, stones, stonesToIndexMapping);
//    }
}
