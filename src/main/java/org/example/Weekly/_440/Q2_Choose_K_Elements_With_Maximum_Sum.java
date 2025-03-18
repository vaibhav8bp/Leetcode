package org.example.Weekly._440;

import java.util.*;

// 0 1 2 3 4
// 4 2 1 5 3

// 0 1 2 3 4
// 2 1 4 0 3
// 1 2 3 4 5

// 0  1  2  3  4
// 10 20 30 40 50

// 0  1  2  3  4
// 4  3  2  1  0
// 50 40 30 20 10

public class Q2_Choose_K_Elements_With_Maximum_Sum {

    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {

        TreeMap<Integer, List<Integer>> valueToIndexMapping = new TreeMap<>();

        for (int i = 0; i < nums1.length; i++) {
            valueToIndexMapping.putIfAbsent(nums1[i], new ArrayList<>());
            valueToIndexMapping.get(nums1[i]).add(i);
        }

        long[] answer = new long[nums1.length];
        long previousSum = 0;
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        for (Map.Entry<Integer, List<Integer>> currentEntry : valueToIndexMapping.entrySet()) {
            for (Integer currentIndex : currentEntry.getValue()) {
                answer[currentIndex] = previousSum;
            }
            for (Integer currentIndex : currentEntry.getValue()) {
                if (minPQ.size() < k) {
                    minPQ.add(nums2[currentIndex]);
                } else {
                    if (minPQ.peek() < nums2[currentIndex]) {
                        previousSum -= minPQ.remove();
                        previousSum += nums2[currentIndex];
                        minPQ.add(nums2[currentIndex]);
                    }
                }
            }
        }

        return answer;
    }

//    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
//        List<Integer>[] listOfIndicesOfElementsSmallerThanCurrentIndexElements = new ArrayList[nums1.length];
//        long[] answer = new long[nums1.length];
//
//        for (int i = 0; i < nums1.length; i++) {
//            listOfIndicesOfElementsSmallerThanCurrentIndexElements[i] = new ArrayList<>();
//            for (int j = 0; j < nums1.length; j++) {
//                if (i != j && nums1[j] < nums1[i]) {
//                    listOfIndicesOfElementsSmallerThanCurrentIndexElements[i].add(j);
//                }
//            }
//
//            List<Integer> elements = new ArrayList<>();
//
//            for (Integer currentIndex : listOfIndicesOfElementsSmallerThanCurrentIndexElements[i]) {
//                elements.add(nums2[currentIndex]);
//            }
//
//            elements.sort(Comparator.reverseOrder());
//
//            long currentSum = 0;
//
//            for (int j = 0; j < k && j < elements.size(); j++) {
//                currentSum += elements.get(j);
//            }
//
//            answer[i] = currentSum;
//        }
//
//
//        return answer;
//    }
}
