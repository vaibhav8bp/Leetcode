package org.example.Daily._2025.April._1;


// https://leetcode.com/problems/solving-questions-with-brainpower/description/
public class _2140_Solving_Questions_With_Brainpower {

    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];

        for (int i = questions.length - 1; i >= 0; i--) {
            long skipCurrentQuestion = (i + 1) < questions.length ? dp[i + 1] : 0;
            long doCurrentQuestion = (i + questions[i][1] + 1) < questions.length ? questions[i][0] + dp[i + questions[i][1] + 1] : questions[i][0];
            dp[i] = Math.max(skipCurrentQuestion, doCurrentQuestion);
        }

        return dp[0];
    }

//    private long mostPoints(int currentIndex, int[][] questions, long[] dp) {
//        if (currentIndex >= questions.length) {
//            return 0;
//        }
//
//        if (dp[currentIndex] != -1) {
//            return dp[currentIndex];
//        }
//
//        long skipCurrentQuestion = mostPoints(currentIndex + 1, questions, dp);
//        long doCurrentQuestion = questions[currentIndex][0] + mostPoints(currentIndex + questions[currentIndex][1] + 1, questions, dp);
//
//        dp[currentIndex] = Math.max(skipCurrentQuestion, doCurrentQuestion);
//        return dp[currentIndex];
//    }
//
//    public long mostPoints(int[][] questions) {
//        long[] dp = new long[questions.length];
//        Arrays.fill(dp, -1);
//        return mostPoints(0, questions, dp);
//    }

//    private long mostPoints(int currentIndex, int[][] questions) {
//        if (currentIndex >= questions.length) {
//            return 0;
//        }
//
//        long skipCurrentQuestion = mostPoints(currentIndex + 1, questions);
//        long doCurrentQuestion = questions[currentIndex][0] + mostPoints(currentIndex + questions[currentIndex][1] + 1, questions);
//
//        return Math.max(skipCurrentQuestion, doCurrentQuestion);
//    }
//
//    public long mostPoints(int[][] questions) {
//        return mostPoints(0, questions);
//    }
}
