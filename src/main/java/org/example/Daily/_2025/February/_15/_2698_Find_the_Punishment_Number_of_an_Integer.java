package org.example.Daily._2025.February._15;

// https://leetcode.com/problems/find-the-punishment-number-of-an-integer/
public class _2698_Find_the_Punishment_Number_of_an_Integer {

    private int getNumberFromStartToEnd(int start, int end, char[] currentString) {

        int currentNumber = 0;

        for (int i = end - 1, baseIndex = 1; i >= start; i--, baseIndex *= 10) {
            currentNumber += ((Character.getNumericValue(currentString[i]) * baseIndex));
        }

        return currentNumber;
    }

    // Memoization
    private boolean isCurrentNumberEligibleHelper(int currentIndex, char[] currentString, int sumSoFar, int targetNumber, Boolean[][] dp) {
        if (currentIndex == currentString.length) {
            return sumSoFar == targetNumber;
        }

        if (dp[currentIndex][sumSoFar] != null) {
            return dp[currentIndex][sumSoFar];
        }

        // Adding [currentIndex...i] in each iteration
        for (int i = currentIndex; i < currentString.length; i++) {
            int currentSumSoFar = sumSoFar + getNumberFromStartToEnd(currentIndex, i + 1, currentString);
            if (currentSumSoFar > targetNumber) {
                return false;
            }
            if (isCurrentNumberEligibleHelper(i + 1, currentString, currentSumSoFar, targetNumber, dp)) {
                dp[currentIndex][sumSoFar] = true;
                return true;
            }
        }

        dp[currentIndex][sumSoFar] = false;
        return false;
    }

    private boolean isCurrentNumberEligible(int currentNumberSquared, int currentNumber) {
        char[] currentString = String.valueOf(currentNumberSquared).toCharArray();
        // dp[i][j] represents whether starting from index i in the string, we can achieve sum j.
        Boolean[][] dp = new Boolean[currentString.length][currentNumber + 1];
        return isCurrentNumberEligibleHelper(0, currentString, 0, currentNumber, dp);
    }

    public int punishmentNumber(int n) {
        int answer = 0;
        for (int currentNumber = 1; currentNumber <= n; currentNumber++) {
            int currentNumberSquared = currentNumber * currentNumber;
            if (isCurrentNumberEligible(currentNumberSquared, currentNumber)) {
                answer += currentNumberSquared;
            }
        }
        return answer;
    }
}