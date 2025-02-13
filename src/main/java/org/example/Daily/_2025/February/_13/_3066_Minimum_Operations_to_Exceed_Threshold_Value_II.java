package org.example.Daily._2025.February._13;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii
public class _3066_Minimum_Operations_to_Exceed_Threshold_Value_II {
    public int minOperations(int[] nums, int k) {
        int operations = 0;
        PriorityQueue<Long> minHeap = new PriorityQueue<>(Comparator.comparingLong(o -> o));

        for (Integer currentNumber : nums) {
            minHeap.add(Long.valueOf(currentNumber));
        }

        while (minHeap.size() >= 2 && minHeap.peek() < k) {
            long smallest = minHeap.remove();
            long secondSmallest = minHeap.remove();
            long numberToBeAdded = smallest * 2 + secondSmallest;
            minHeap.add(numberToBeAdded);
            operations++;
        }

        return operations;
    }
}
