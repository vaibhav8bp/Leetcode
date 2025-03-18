package org.example.Google;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/sliding-window-maximum/description/
public class _239_Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        Deque<Integer> decreasingDequeue = new ArrayDeque<>();

        // Maintain a decreasing dequeue.
        int resultIndex = 0;
        for (int i = 0; i < k; i++) {
            while (!decreasingDequeue.isEmpty() && nums[decreasingDequeue.peekLast()] <= nums[i]) {
                decreasingDequeue.pollLast();
            }
            decreasingDequeue.add(i);
        }

        result[resultIndex++] = nums[decreasingDequeue.peekFirst()];

        for (int i = k; i < nums.length; i++) {
            // Pop Out of window elements first.
            while (!decreasingDequeue.isEmpty() && decreasingDequeue.peekFirst() < (i - k + 1)) {
                decreasingDequeue.pollFirst();
            }
            // Maintain a decreasing dequeue.
            while (!decreasingDequeue.isEmpty() && nums[decreasingDequeue.peekLast()] <= nums[i]) {
                decreasingDequeue.pollLast();
            }
            decreasingDequeue.add(i);
            result[resultIndex++] = nums[decreasingDequeue.peekFirst()];
        }

        return result;
    }
}
