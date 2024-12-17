package org.example.Weekly._419;

import java.util.*;

class Helper {
    int number;
    int frequency;

    public Helper(int number, int frequency) {
        this.number = number;
        this.frequency = frequency;
    }
}

class Solution {

    private int getXSum(Map<Integer, Integer> numberToFrequencyMapper, int x) {
        int sum = 0;
        if (numberToFrequencyMapper.size() < x) {
            for (Map.Entry<Integer, Integer> currentEntry : numberToFrequencyMapper.entrySet()) {
                sum += (currentEntry.getKey() * currentEntry.getValue());
            }
        } else {

            PriorityQueue<Helper> priorityQueue = getHelpers();

            for (Map.Entry<Integer, Integer> currentEntry : numberToFrequencyMapper.entrySet()) {
                priorityQueue.add(new Helper(currentEntry.getKey(), currentEntry.getValue()));
            }

            for (int i = 0; i < x; i++) {
                Helper highestFrequency = priorityQueue.poll();
                sum += (highestFrequency.frequency * highestFrequency.number);
            }
        }
        return sum;
    }

    private static PriorityQueue<Helper> getHelpers() {
        Comparator<Helper> helperComparator = (o1, o2) -> {
            if (o2.frequency > o1.frequency) {
                return 1;
            } else if (o2.frequency == o1.frequency) {
                if (o2.number > o1.number) {
                    return 1;
                }
                return -1;
            } else {
                return -1;
            }
        };

        return new PriorityQueue<>(helperComparator);
    }

    public int[] findXSum(int[] nums, int k, int x) {

        int resultArrayLength = nums.length - k + 1;
        int[] result = new int[resultArrayLength];
        int resultIndex = 0;

        Map<Integer, Integer> numberToFrequencyMapper = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!numberToFrequencyMapper.containsKey(nums[i])) {
                numberToFrequencyMapper.put(nums[i], 1);
            } else {
                numberToFrequencyMapper.put(nums[i], numberToFrequencyMapper.get(nums[i]) + 1);
            }
            if (i >= (k - 1)) {
                if (i != (k - 1)) {
                    if (numberToFrequencyMapper.get(nums[i - k]) == 1) {
                        numberToFrequencyMapper.remove(nums[i - k]);
                    } else {
                        numberToFrequencyMapper.put(nums[i - k], numberToFrequencyMapper.get(nums[i - k]) - 1);
                    }
                }
                result[resultIndex++] = getXSum(numberToFrequencyMapper, x);
            }
        }
        return result;
    }
}

public class Find_X_Sum_of_All_K_Long_Subarrays_I {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findXSum(new int[]{1, 1, 2, 2, 3, 4, 2, 3}, 6, 2)));
    }
}