package org.example.Striver_SDE_Sheet.Day_12_Heaps._347_Top_K_Frequent_Elements;

import java.util.*;

// Without Sorting/PQ
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numberToFrequencyMap = new HashMap<>();
        for (int num : nums) {
            if (numberToFrequencyMap.containsKey(num)) {
                numberToFrequencyMap.put(num, numberToFrequencyMap.get(num) + 1);
            } else {
                numberToFrequencyMap.put(num, 1);
            }
        }

        // frequency[i] represents i as frequency of elements
        // Using List<Integer>[] because frequency array size is fixed can be max nums.length
        // but the no. of elements of a particular frequency can be variable so using a dynamic array

        List<Integer>[] frequencyArray = new ArrayList[nums.length];
        for (int i = 0; i < nums.length; i++) {
            frequencyArray[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> currentEntry : numberToFrequencyMap.entrySet()) {
            frequencyArray[currentEntry.getValue() - 1].add(currentEntry.getKey());
        }

        int[] result = new int[k];
        int resultIndex = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < frequencyArray[i].size(); j++) {
                result[resultIndex++] = frequencyArray[i].get(j);
                if (resultIndex == k) {
                    break;
                }
            }

            if (resultIndex == k) {
                break;
            }
        }

        return result;
    }
}

//class Helper {
//    int element;
//    int frequency;
//
//    public Helper(int element, int frequency) {
//        this.element = element;
//        this.frequency = frequency;
//    }
//}
//
//class Solution {
//    public int[] topKFrequent(int[] nums, int k) {
//        HashMap<Integer, Integer> numberToFrequencyMap = new HashMap<>();
//        for (int num : nums) {
//            if (numberToFrequencyMap.containsKey(num)) {
//                numberToFrequencyMap.put(num, numberToFrequencyMap.get(num) + 1);
//            } else {
//                numberToFrequencyMap.put(num, 1);
//            }
//        }
//
//        PriorityQueue<Helper> priorityQueue = new PriorityQueue<>((a, b) -> b.frequency - a.frequency);
//
//        for (Map.Entry<Integer, Integer> currentEntry : numberToFrequencyMap.entrySet()) {
//            priorityQueue.add(new Helper(currentEntry.getKey(), currentEntry.getValue()));
//        }
//
//        int[] result = new int[k];
//        int resultIndex = 0;
//
//        while (k != 0) {
//            result[resultIndex++] = priorityQueue.remove().element;
//            k--;
//        }
//
//        return result;
//    }
//}

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(new Solution().topKFrequent(nums, 2)));
    }
}
