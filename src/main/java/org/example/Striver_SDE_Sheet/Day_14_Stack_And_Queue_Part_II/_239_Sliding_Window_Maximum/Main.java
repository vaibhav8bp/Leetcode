package org.example.Striver_SDE_Sheet.Day_14_Stack_And_Queue_Part_II._239_Sliding_Window_Maximum;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// https://leetcode.com/problems/sliding-window-maximum/description/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= (i - k)) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.add(i);

            if (i >= (k - 1)) {
                result[resultIndex++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}

// O(N*log(K))
//class Solution {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
//        int[] result = new int[nums.length - k + 1];
//        int resultIndex = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (maxHeap.size() != k) {
//                maxHeap.add(nums[i]);
//            }
//            if (maxHeap.size() == k) {
//                result[resultIndex++] = maxHeap.peek();
//                maxHeap.remove(nums[i - k + 1]);
//            }
//        }
//        return result;
//    }
//}

public class Main {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(nums, k)));
    }
}
