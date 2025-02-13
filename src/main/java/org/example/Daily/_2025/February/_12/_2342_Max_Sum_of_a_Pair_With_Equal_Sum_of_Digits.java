package org.example.Daily._2025.February._12;

import java.util.Arrays;

// https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/

//1 <= nums[i] <= 10^9
// 1000000000
//  999999999

// Above no. can achieve max. sum
// So Total Sums Possible Are 0..9*9
public class _2342_Max_Sum_of_a_Pair_With_Equal_Sum_of_Digits {

    private int findDigitSum(int currentNumber) {
        int sum = 0;

        while (currentNumber != 0) {
            sum += (currentNumber % 10);
            currentNumber /= 10;
        }

        return sum;
    }

    public int maximumSum(int[] nums) {
        int[] sumToNumberMapper = new int[82];
        Arrays.fill(sumToNumberMapper, -1);

        int answer = -1;

        for (Integer currentNumber : nums) {
            int currentNumberDigitsSum = findDigitSum(currentNumber);

            // First No. Pair Cannot Be Formed
            if (sumToNumberMapper[currentNumberDigitsSum] == -1) {
                sumToNumberMapper[currentNumberDigitsSum] = currentNumber;
            } else {
                answer = Math.max(answer, currentNumber + sumToNumberMapper[currentNumberDigitsSum]);
                sumToNumberMapper[currentNumberDigitsSum] = Math.max(sumToNumberMapper[currentNumberDigitsSum], currentNumber);
            }
        }

        return answer;
    }

//    public int maximumSum(int[] nums) {
//        Map<Integer, PriorityQueue<Integer>> digitSumToActualDigitMapper = new HashMap<>();
//
//        for (Integer currentNumber : nums) {
//            int currentNumbersDigitSum = findDigitSum(currentNumber);
//            if (!digitSumToActualDigitMapper.containsKey(currentNumbersDigitSum)) {
//                digitSumToActualDigitMapper.put(currentNumbersDigitSum, new PriorityQueue<>((o1, o2) -> o2 - o1));
//            }
//            digitSumToActualDigitMapper.get(currentNumbersDigitSum).add(currentNumber);
//        }
//
//        int answer = Integer.MIN_VALUE;
//
//        for (Map.Entry<Integer, PriorityQueue<Integer>> currentEntry : digitSumToActualDigitMapper.entrySet()) {
//            PriorityQueue<Integer> currentPQ = currentEntry.getValue();
//            if (currentPQ.size() >= 2) {
//                answer = Math.max(answer, currentPQ.remove() + currentPQ.remove());
//            }
//        }
//
//        return (answer == Integer.MIN_VALUE) ? -1 : answer;
//    }
}
