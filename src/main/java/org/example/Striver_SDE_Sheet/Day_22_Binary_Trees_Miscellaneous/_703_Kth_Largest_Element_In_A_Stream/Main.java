package org.example.Striver_SDE_Sheet.Day_22_Binary_Trees_Miscellaneous._703_Kth_Largest_Element_In_A_Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/kth-largest-element-in-a-stream/
class KthLargest {

    List<Integer> list = new ArrayList<>();
    int k = 0;

    private void addBinarySearch(int currentNumber) {
        if (list.isEmpty() || list.getLast() <= currentNumber) {
            list.add(currentNumber);
            return;
        }

        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid) <= currentNumber) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        list.add(low, currentNumber);
    }

    public KthLargest(int k, int[] nums) {
        Arrays.stream(nums).forEach(this::addBinarySearch);
        this.k = k;
    }

    public int add(int val) {
        addBinarySearch(val);
        return list.get(list.size() - k);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}