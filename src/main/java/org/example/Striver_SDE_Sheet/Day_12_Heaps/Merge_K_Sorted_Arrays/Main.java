package org.example.Striver_SDE_Sheet.Day_12_Heaps.Merge_K_Sorted_Arrays;

import java.util.*;

// https://www.naukri.com/code360/problems/merge-k-sorted-arrays_975379
class Helper {
    int arrayIndex;
    int indexInArray;
    int value;

    public Helper(int arrayIndex, int indexInArray, int value) {
        this.arrayIndex = arrayIndex;
        this.indexInArray = indexInArray;
        this.value = value;
    }
}

class Solution {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        PriorityQueue<Helper> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));

        for (int i = 0; i < k; i++) {
            if (!kArrays.get(i).isEmpty()) {
                priorityQueue.add(new Helper(i, 0, kArrays.get(i).get(0)));
            }
        }

        ArrayList<Integer> integerArrayList = new ArrayList<>();

        while (!priorityQueue.isEmpty()) {
            Helper currentElement = priorityQueue.remove();
            integerArrayList.add(currentElement.value);
            if (currentElement.indexInArray + 1 < kArrays.get(currentElement.arrayIndex).size()) {
                priorityQueue.add(new Helper(currentElement.arrayIndex, currentElement.indexInArray + 1,
                        kArrays.get(currentElement.arrayIndex).get(currentElement.indexInArray + 1)));
            }
        }

        return integerArrayList;
    }
}


public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> kArrays = new ArrayList<>();
        kArrays.add(new ArrayList<>(List.of(3, 5, 9)));
        kArrays.add(new ArrayList<>(List.of(1, 2, 3, 8)));
        System.out.println(Solution.mergeKSortedArrays(kArrays, 2));
    }
}
