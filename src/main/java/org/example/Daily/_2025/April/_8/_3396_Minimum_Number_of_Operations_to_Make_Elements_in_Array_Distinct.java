package org.example.Daily._2025.April._8;

// https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/
public class _3396_Minimum_Number_of_Operations_to_Make_Elements_in_Array_Distinct {

    public int minimumOperations(int[] nums) {

        // Since we are detecting duplicates and removing elements from the start,
        // we are going till the end to find when nums is distinct.
        // So we can just traverse from the back and find the occurrence of the first duplicate element.
        // As we will have to go till that element and remove it.

        int n = nums.length;

        int[] frequency = new int[101];

        for (int i = n - 1; i >= 0; i--) {
            frequency[nums[i]]++;
            if (frequency[nums[i]] > 1) {
                // for i=0, we want 1 operation.
                return (i + 3) / 3;
            }
        }

        return 0;
    }

//    public int minimumOperations(int[] nums) {
//
//        int n = nums.length;
//
//        Map<Integer, Integer> elementToFrequencyMapper = new HashMap<>();
//        for (int num : nums) {
//            elementToFrequencyMapper.put(num, elementToFrequencyMapper.getOrDefault(num, 0) + 1);
//        }
//
//        int operations = 0;
//
//        for (int i = 0; i < n && elementToFrequencyMapper.size() != (n - i); ) {
//            operations++;
//            int startIndex = i;
//            int endIndex = Math.min(startIndex + 2, n - 1);
//
//            for (int j = startIndex; j <= endIndex; j++) {
//                elementToFrequencyMapper.put(nums[j], elementToFrequencyMapper.get(nums[j]) - 1);
//                if (elementToFrequencyMapper.get(nums[j]) == 0) {
//                    elementToFrequencyMapper.remove(nums[j]);
//                }
//            }
//
//            i = endIndex + 1;
//        }
//
//        return operations;
//    }
}
