package org.example.Striver_SDE_Sheet.Day_12_Heaps.Maximum_Sum_Combinations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        A.sort((a, b) -> b - a);
        B.sort((a, b) -> b - a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        boolean breakOuterLoop = false;

        for (Integer integer : A) {
            int index = 0;
            for (Integer value : B) {
                int currentSum = integer + value;
                if (minHeap.size() != C) {
                    minHeap.add(currentSum);
                } else {
                    if (minHeap.peek() < currentSum) {
                        minHeap.remove();
                        minHeap.add(currentSum);
                    } else {
                        if (index == 0) {
                            breakOuterLoop = true;
                        }
                        break;
                    }
                }
                index++;
            }
            if (breakOuterLoop) {
                break;
            }
        }

        ArrayList<Integer> finalList = new ArrayList<>(minHeap);
        finalList.sort(Comparator.reverseOrder());
        return finalList;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83));
        ArrayList<Integer> B = new ArrayList<>(List.of(59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83));
        int C = 10;
        System.out.println(new Solution().solve(A, B, C));
    }
}
