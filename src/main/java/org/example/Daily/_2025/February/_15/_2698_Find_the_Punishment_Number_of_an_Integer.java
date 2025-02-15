package org.example.Daily._2025.February._15;

// https://leetcode.com/problems/find-the-punishment-number-of-an-integer/
public class _2698_Find_the_Punishment_Number_of_an_Integer {

    private boolean isCurrentNumberEligibleHelper(int currentIndex, String currentString, int sumSoFar, int targetNumber) {
        if (currentIndex == currentString.length()) {
            return sumSoFar == targetNumber;
        }

        // abcd

        // Adding [currentIndex...i] in each iteration
        for (int i = currentIndex; i < currentString.length(); i++) {
            int currentPartitionSum = Integer.parseInt(currentString.substring(currentIndex, i + 1));
            sumSoFar += currentPartitionSum;
            if (sumSoFar > targetNumber) {
                return false;
            }
            if (isCurrentNumberEligibleHelper(i + 1, currentString, sumSoFar, targetNumber)) {
                return true;
            }
            sumSoFar -= currentPartitionSum;
        }

        return false;
    }

    private boolean isCurrentNumberEligible(int currentNumberSquared, int currentNumber) {
        return isCurrentNumberEligibleHelper(0, String.valueOf(currentNumberSquared), 0, currentNumber);
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