package org.example.Daily._2025.April._11;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/count-symmetric-integers/description/
public class _2843_Count_Symmetric_Integers {

    private boolean isSymmetric(int currentNumber, List<Integer> suffixSum) {
        suffixSum.clear();
        // 1212
        // 3210
        // 6532
        while (currentNumber != 0) {
            int currentRemainder = currentNumber % 10;
            if (suffixSum.isEmpty()) {
                suffixSum.add(currentRemainder);
            } else {
                suffixSum.add(currentRemainder + suffixSum.getLast());
            }
            currentNumber /= 10;
        }
        int firstHalfSum = suffixSum.get(suffixSum.size() / 2 - 1);
        int secondHalfSum = suffixSum.getLast() - firstHalfSum;
        return firstHalfSum == secondHalfSum;
    }

    public int countSymmetricIntegers(int low, int high) {

        int answer = 0;
        List<Integer> suffixSum = new ArrayList<>();

        while (low <= high) {
            // Skip odd digit numbers directly
            if (low >= 1 && low <= 9) {
                low = 10;
            } else if (low >= 100 && low <= 999) {
                low = 1000;
            } else if (low == 10000) {
                break;
            }

            if (isSymmetric(low, suffixSum)) {
                answer++;
            }

            low++;
        }

        return answer;
    }
}
