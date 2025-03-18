package org.example.Striver_SDE_Sheet.Day_13_Stack_And_Queue._496_Next_Greater_Element_I;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> numberToNextGreaterMapping = new HashMap<>();
        int[] result = new int[nums1.length];

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                numberToNextGreaterMapping.put(nums2[i], -1);
            } else {
                numberToNextGreaterMapping.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = numberToNextGreaterMapping.get(nums1[i]);
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(new Solution().nextGreaterElement(nums1, nums2)));
    }
}
