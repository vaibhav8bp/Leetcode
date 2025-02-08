package org.example.Bi_Weekly._147;

// https://leetcode.com/problems/maximize-subarray-sum-after-removing-all-occurrences-of-one-element/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _3410_Maximize_Subarray_Sum_After_Removing_All_Occurrences_of_One_Element {
    static class SegmentTree {
        // Represents total sum of segment/subarray
        long totalSum;
        // Represents max. prefixSum of segment/subarray
        long maxPrefixSum;
        // Represents max. suffixSum of segment/subarray
        long maxSuffixSum;
        // Represents the maximum sum of segment/subarray
        long maxSum;

        public SegmentTree(int value) {
            this.maxSum = value;
            this.totalSum = value;
            this.maxPrefixSum = value;
            this.maxSuffixSum = value;
        }

        public SegmentTree() {
            this.maxSum = 0;
            this.totalSum = 0;
            this.maxPrefixSum = 0;
            this.maxSuffixSum = 0;
        }
    }

    private SegmentTree mergeLeftAndRightNodes(SegmentTree leftChildSegment, SegmentTree rightChildSegment) {
        SegmentTree segmentTree = new SegmentTree();
        segmentTree.totalSum = leftChildSegment.totalSum + rightChildSegment.totalSum;
        segmentTree.maxPrefixSum = Math.max(leftChildSegment.maxPrefixSum, leftChildSegment.totalSum + rightChildSegment.maxPrefixSum);
        segmentTree.maxSuffixSum = Math.max(rightChildSegment.maxSuffixSum, rightChildSegment.totalSum + leftChildSegment.maxSuffixSum);
        segmentTree.maxSum = Math.max(leftChildSegment.maxSum, Math.max(rightChildSegment.maxSum, leftChildSegment.maxSuffixSum + rightChildSegment.maxPrefixSum));
        return segmentTree;
    }

    private void buildSegmentTree(int[] nums, int segmentTreeIndex, int start, int end, List<SegmentTree> segmentTree) {
        if (start > end) {
            return;
        } else if (start == end) {
            segmentTree.set(segmentTreeIndex, new SegmentTree(nums[start]));
            return;
        }

        int mid = (start + end) / 2;
        buildSegmentTree(nums, 2 * segmentTreeIndex + 1, start, mid, segmentTree);
        buildSegmentTree(nums, 2 * segmentTreeIndex + 2, mid + 1, end, segmentTree);
        segmentTree.set(segmentTreeIndex, mergeLeftAndRightNodes(segmentTree.get(2 * segmentTreeIndex + 1), segmentTree.get(2 * segmentTreeIndex + 2)));
    }

    // index role is solely to restrict recursion of this function, if at any time segment gap that is start...end
    // doesn't accommodate index, no need to update segment tree.
    private void updateSegmentTree(int segmentTreeIndex, int start, int end, int index, int updatedValue, List<SegmentTree> segmentTree) {
        if (index < start || index > end) {
            return;
        } else if (start == end) {
            segmentTree.set(segmentTreeIndex, new SegmentTree(updatedValue));
            return;
        }

        int mid = (start + end) / 2;
        updateSegmentTree(2 * segmentTreeIndex + 1, start, mid, index, updatedValue, segmentTree);
        updateSegmentTree(2 * segmentTreeIndex + 2, mid + 1, end, index, updatedValue, segmentTree);
        segmentTree.set(segmentTreeIndex, mergeLeftAndRightNodes(segmentTree.get(2 * segmentTreeIndex + 1), segmentTree.get(2 * segmentTreeIndex + 2)));
    }

    public long maxSubarraySum(int[] nums) {

        Map<Integer, List<Integer>> valueToIndexMapping = new HashMap<>();

        int maxValueInArray = Integer.MIN_VALUE;
        boolean areAllNumbersSame = false;

        for (int i = 0; i < nums.length; i++) {
            maxValueInArray = Math.max(maxValueInArray, nums[i]);
            valueToIndexMapping.computeIfAbsent(nums[i], a -> new ArrayList<>()).add(i);
            if (i == (nums.length - 1) && valueToIndexMapping.get(nums[i]).size() == nums.length) {
                areAllNumbersSame = true;
            }
        }

        // If maxValue in Array is -ve or 0, just return maxValue as taking other elements will only decrease the sum.
        if (maxValueInArray <= 0) {
            return maxValueInArray;
        }

        // If all numbers are same and if code reaches this point, we are sure that, not all numbers are -ve
        // If areAllNumbersSame is true, it means nums only contains +ve elements, we can just return
        // number*arrayLength.

        if (areAllNumbersSame) {
            return (long) nums[0] * nums.length;
        }

        List<SegmentTree> segmentTree = new ArrayList<>();

        // This is because segment tree is a balanced tree. To accommodate for last element's children, 4*n is the min. safest bet.
        // Last Element's Children will definitely will be in range if we set max. to 4*n.

        int MAX_SIZE = 4 * nums.length;

        for (int i = 0; i < MAX_SIZE; i++) {
            segmentTree.add(new SegmentTree());
        }

        buildSegmentTree(nums, 0, 0, nums.length - 1, segmentTree);

        // Max. Subarray Sum When No Element Removed
        long answer = segmentTree.getFirst().maxSum;

        for (Map.Entry<Integer, List<Integer>> currentEntry : valueToIndexMapping.entrySet()) {
            // Set All Elements Of Current Element To 0 For now, to calculate
            // max. subarray sum after removing all values of current element

            for (Integer currentIndex : currentEntry.getValue()) {
                updateSegmentTree(0, 0, nums.length - 1, currentIndex, 0, segmentTree);
            }

            answer = Math.max(answer, segmentTree.getFirst().maxSum);

            // After getting max. sum, restore original values in the array
            for (Integer currentIndex : currentEntry.getValue()) {
                updateSegmentTree(0, 0, nums.length - 1, currentIndex, currentEntry.getKey(), segmentTree);
            }
        }

        return answer;
    }

    // Kadane's Algorithm Solution
    // Apply Kadane Algorithm by removing every -ve element and computing max subarray sum.
    // Return max of all.

//   private long maxSubarraySumHelper(int[] nums, int elementToBeExcluded) {
//       int sumSoFar = 0;
//       int maxSumSoFar = Integer.MIN_VALUE;
//
//       for (Integer currentElement : nums) {
//           if (currentElement == elementToBeExcluded) {
//               continue;
//           }
//
//           sumSoFar += currentElement;
//           maxSumSoFar = Math.max(maxSumSoFar, sumSoFar);
//
//           if (sumSoFar < 0) {
//               sumSoFar = 0;
//           }
//       }
//
//       return maxSumSoFar;
//   }
//
//   public long maxSubarraySum(int[] nums) {
//
//       Map<Integer, Integer> numberExistsMapper = new HashMap<>();
//
//       for (Integer currentNumber : nums) {
//           numberExistsMapper.put(currentNumber, numberExistsMapper.getOrDefault(currentNumber, 0) + 1);
//
//           // If all elements are same, if -ve return number, if positive return number*arrayLength;
//           if (numberExistsMapper.get(currentNumber) == nums.length) {
//               if (currentNumber <= 0) {
//                   return currentNumber;
//               } else {
//                   return (long) currentNumber * nums.length;
//               }
//           }
//       }
//
//       // Whole Subarray can be max. too, in case of whole array having positive elements.
//       // It is not necessary to remove any element. In question, it is mentioned at-most once, not exactly once.
//       long answer = Arrays.stream(nums).sum();
//
//       for (Integer currentNumber : numberExistsMapper.keySet()) {
//           // Only remove -ve element
//           if (currentNumber < 0) {
//               answer = Math.max(answer, maxSubarraySumHelper(nums, currentNumber));
//           }
//       }
//
//       return answer;
//   }
}