package org.example.Striver_SDE_Sheet.Day_12_Heaps._215_Kth_Largest_Element_In_An_Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/description/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        List<Integer> integerList = Arrays.stream(nums).boxed().toList();
        maxHeap.addAll(integerList);

        while (k != 1) {
            maxHeap.remove();
            k--;
        }

        return maxHeap.peek();
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(new Solution().findKthLargest(nums, 4));
    }
}
