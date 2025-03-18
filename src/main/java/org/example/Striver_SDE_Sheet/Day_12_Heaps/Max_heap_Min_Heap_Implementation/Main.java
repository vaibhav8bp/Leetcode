package org.example.Striver_SDE_Sheet.Day_12_Heaps.Max_heap_Min_Heap_Implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private static final List<Integer> minHeapArray = new ArrayList<>();

    static void swap(int start, int end) {
        int temp = minHeapArray.get(start);
        minHeapArray.set(start, minHeapArray.get(end));
        minHeapArray.set(end, temp);
    }

    static void insert(int item) {
        minHeapArray.add(item);

        int childIndex = minHeapArray.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex != 0) {
            int elementAtChildIndex = minHeapArray.get(childIndex);
            int elementAtParentIndex = minHeapArray.get(parentIndex);

            if (elementAtParentIndex <= elementAtChildIndex) {
                break;
            } else {
                swap(childIndex, parentIndex);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            }
        }
    }

    static int delete() {
        if (minHeapArray.isEmpty()) {
            return -1;
        }

        int temp = minHeapArray.get(minHeapArray.size() - 1);
        int smallestElement = minHeapArray.get(0);
        minHeapArray.remove(minHeapArray.size() - 1);

        if (minHeapArray.isEmpty()) {
            return smallestElement;
        }

        minHeapArray.set(0, temp);

        int parentIndex = 0;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        while (leftChildIndex < minHeapArray.size()) {
            int minChildIndex = leftChildIndex;

            if (rightChildIndex < minHeapArray.size()) {
                minChildIndex = (minHeapArray.get(leftChildIndex) <= minHeapArray.get(rightChildIndex)) ? leftChildIndex : rightChildIndex;
            }

            int elementAtMinChildIndex = minHeapArray.get(minChildIndex);
            int elementAtParentIndex = minHeapArray.get(parentIndex);

            if (elementAtParentIndex <= elementAtMinChildIndex) {
                break;
            } else {
                swap(minChildIndex, parentIndex);
                parentIndex = minChildIndex;
                leftChildIndex = 2 * parentIndex + 1;
                rightChildIndex = 2 * parentIndex + 2;
            }
        }

        return smallestElement;
    }

    static int[] minHeap(int n, int[][] q) {

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (q[i][0] == 1) {
                count++;
            }
        }

        int[] result = new int[count];
        int resultIndex = 0;

        for (int i = 0; i < n; i++) {
            if (q[i][0] == 0) {
                insert(q[i][1]);
            } else if (q[i][0] == 1) {
                int deletedElement = delete();
                result[resultIndex++] = deletedElement;
            }
        }

        minHeapArray.clear();

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] q = {{0, 48}, {1}, {0, 35}, {0, 43}};
        System.out.println(Arrays.toString(Solution.minHeap(4, q)));
    }
}


//2
//        5
//        0 5
//        1
//        0 43
//        0 15
//        0 5
//        2
//        0 4
//        1
