package org.example.Daily._2025.February._8;

import java.util.*;

// https://leetcode.com/problems/design-a-number-container-system/
public class _2349_Design_a_Number_Container_System {

}

class NumberContainers {

    private final Map<Integer, Integer> indexToNumberMapping;
    private final Map<Integer, PriorityQueue<Integer>> numberToListOfIndexMapping;
    private final Comparator<Integer> minIndexComparator = Comparator.comparingInt(o -> o);

    public NumberContainers() {
        indexToNumberMapping = new HashMap<>();
        numberToListOfIndexMapping = new HashMap<>();
    }

    private void addNumberToPQ(int index, int number) {
        indexToNumberMapping.put(index, number);
        PriorityQueue<Integer> currentPQ;
        if (!numberToListOfIndexMapping.containsKey(number)) {
            currentPQ = new PriorityQueue<>(minIndexComparator);
            currentPQ.add(index);
            numberToListOfIndexMapping.put(number, currentPQ);
        } else {
            currentPQ = numberToListOfIndexMapping.get(number);
            currentPQ.add(index);
        }
    }

    private void removeIndexFromPQ(int index) {
        int oldNumberAtIndex = indexToNumberMapping.get(index);
        indexToNumberMapping.remove(index);
        PriorityQueue<Integer> oldNumberPQ = numberToListOfIndexMapping.get(oldNumberAtIndex);
        oldNumberPQ.remove(index);

        if (oldNumberPQ.isEmpty()) {
            numberToListOfIndexMapping.remove(oldNumberAtIndex);
        }
    }

    public void change(int index, int number) {
        // There is no number at index
        if (!indexToNumberMapping.containsKey(index)) {
            addNumberToPQ(index, number);
        }
        // There is a number at index
        else {
            // If same no. at index, do nothing
            // Else change existing data
            if (!(indexToNumberMapping.get(index) == number)) {
                removeIndexFromPQ(index);
                addNumberToPQ(index, number);
            }
        }
    }

    public int find(int number) {
        if (numberToListOfIndexMapping.containsKey(number)) {
            return numberToListOfIndexMapping.get(number).peek();
        }
        return -1;
    }
}