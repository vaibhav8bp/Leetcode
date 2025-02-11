package org.example.Weekly._436;

//https://leetcode.com/problems/maximize-the-minimum-game-score/

public class _3449_Maximize_the_Minimum_Game_Score {

    // In this function, I have used the methodology that how many steps will be taken in total
    // for currentIndex, that is i to fulfill its quota, that also includes moving to ith index,
    // After every iteration calculation is done so that how many moves were required to fulfill quota
    // and move to i, in next iteration we will again count moves required for (i+1) which will always count
    // 1 move for moving to (i+1). This is because we are starting to move from -1 initially, even moving to 0
    // index required 1 step.

    private boolean canCurrentScoreBeAchievedAtAllIndices(int[] points, long targetScore, int m) {
        long previousPointsAccumulated = 0;
        long totalMovesTaken = 0;

        for (int i = 0; i < points.length; i++) {
            long minimumPointsNeededForCurrentIndex = targetScore - previousPointsAccumulated;

            // Check, if No Additional Moves Required For Current Index
            // Assign previousPointsAccumulated to 0 for next iteration
            // and increment totalMovesTaken by 1 to accommodate moving to ith index.
            if (minimumPointsNeededForCurrentIndex <= 0) {
                // If last index quota's is already filled, we will not even move to that index.
                // What will we do there ? Time pass ?
                if (i == points.length - 1) {
                    return true;
                } else {
                    totalMovesTaken++;
                    if (totalMovesTaken > m) {
                        return false;
                    }
                    previousPointsAccumulated = 0;
                    continue;
                }
            }
            long minimumMovesToAccumulateMinimumPoints = (long) Math.ceil((double) minimumPointsNeededForCurrentIndex / points[i]);
            totalMovesTaken += (2 * minimumMovesToAccumulateMinimumPoints - 1);
            if (totalMovesTaken > m) {
                return false;
            }
            if (i != points.length - 1) {
                previousPointsAccumulated = (minimumMovesToAccumulateMinimumPoints - 1) * (points[i + 1]);
            }
        }

        return true;
    }

    public long maxScore(int[] points, int m) {
        long left = 0;
        long right = ((long) (m + 1) * points[0]) / 2;

        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (canCurrentScoreBeAchievedAtAllIndices(points, mid, m)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
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