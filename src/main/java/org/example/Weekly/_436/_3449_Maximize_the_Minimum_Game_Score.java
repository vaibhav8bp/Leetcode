package org.example.Weekly._436;

//https://leetcode.com/problems/maximize-the-minimum-game-score/

public class _3449_Maximize_the_Minimum_Game_Score {

    public long maxScore(int[] points, int m) {
        return 0;
    }

//    private long findMinimumValueInArray(long[] gameScore) {
//        long minimum = Long.MAX_VALUE;
//
//        for (Long currentScore : gameScore) {
//            minimum = Math.min(minimum, currentScore);
//        }
//
//        return minimum;
//    }
//
//    private long maxScoreHelper(int currentIndex, long[] gameScore, int[] points, int m) {
//        if (m == 0) {
//            return findMinimumValueInArray(gameScore);
//        }
//
//        // 2 choices, Either Increase(i)/Decrease(i)
//
//        long increase = 0;
//        long decrease = 0;
//
//        if ((currentIndex + 1) < points.length) {
//            gameScore[currentIndex + 1] += points[currentIndex + 1];
//            increase = findMinimumValueInArray(gameScore);
//            long recursion = maxScoreHelper(currentIndex + 1, gameScore, points, m - 1);
//            increase = Math.max(increase, recursion);
//            gameScore[currentIndex + 1] -= points[currentIndex + 1];
//        }
//
//        if ((currentIndex - 1) >= 0) {
//            gameScore[currentIndex - 1] += points[currentIndex - 1];
//            decrease = findMinimumValueInArray(gameScore);
//            long recursion = maxScoreHelper(currentIndex - 1, gameScore, points, m - 1);
//            decrease = Math.max(decrease, recursion);
//            gameScore[currentIndex - 1] -= points[currentIndex - 1];
//        }
//
//        return Math.max(increase, decrease);
//    }
//
//    public long maxScore(int[] points, int m) {
//        long[] gameScore = new long[points.length];
//        return maxScoreHelper(-1, gameScore, points, m);
//    }
}