package org.example.Random;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/continuous-subarrays/description/
public class _2762_Continuous_Subarrays {

    public long continuousSubarrays(int[] nums) {
        long answer = 0;

        int left = 0;
        int right = 0;

        Deque<Integer> increasingDequeue = new ArrayDeque<>();
        Deque<Integer> decreasingDequeue = new ArrayDeque<>();

        while (right < nums.length) {

            while (!increasingDequeue.isEmpty() && nums[increasingDequeue.getLast()] > nums[right]) {
                increasingDequeue.pollLast();
            }

            while (!decreasingDequeue.isEmpty() && nums[decreasingDequeue.getLast()] < nums[right]) {
                decreasingDequeue.pollLast();
            }

            increasingDequeue.add(right);
            decreasingDequeue.add(right);

            // 1 2 3 4 5

            while (Math.abs(nums[increasingDequeue.getFirst()] - nums[decreasingDequeue.getFirst()]) > 2) {
                left++;
                if (increasingDequeue.getFirst() < left) {
                    increasingDequeue.pollFirst();
                }
                if (decreasingDequeue.getFirst() < left) {
                    decreasingDequeue.pollFirst();
                }
            }

            answer += (right - left + 1);
            right++;
        }

        return answer;
    }

//    public long continuousSubarrays(int[] nums) {
//        long answer = 0;
//
//        int left = 0;
//        int right = 0;
//
//        TreeMap<Integer, Integer> elementToFrequencyMapper = new TreeMap<>();
//
//        while (right < nums.length) {
//
//            // Putting nums[right], so that Math.abs(nums[right] - maxValue) <=2 can be satisfied.
//            int minValue = elementToFrequencyMapper.isEmpty() ? nums[right] : elementToFrequencyMapper.firstKey();
//            int maxValue = elementToFrequencyMapper.isEmpty() ? nums[right] : elementToFrequencyMapper.lastKey();
//
//            while ((Math.abs(nums[right] - maxValue) > 2) || (Math.abs(nums[right] - minValue) > 2)) {
//                elementToFrequencyMapper.put(nums[left], elementToFrequencyMapper.get(nums[left]) - 1);
//                if (elementToFrequencyMapper.get(nums[left]) == 0) {
//                    elementToFrequencyMapper.remove(nums[left]);
//                }
//                minValue = elementToFrequencyMapper.isEmpty() ? nums[right] : elementToFrequencyMapper.firstKey();
//                maxValue = elementToFrequencyMapper.isEmpty() ? nums[right] : elementToFrequencyMapper.lastKey();
//                left++;
//            }
//
//            answer += (right - left + 1);
//
//            elementToFrequencyMapper.put(nums[right], elementToFrequencyMapper.getOrDefault(nums[right], 0) + 1);
//            right++;
//        }
//
//        return answer;
//    }
}
