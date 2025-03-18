package org.example.Google;

// https://leetcode.com/problems/design-a-number-container-system/

import java.util.*;

class NumberContainers {

    private Map<Integer, PriorityQueue<Integer>> numberToIndexesMapping;
    private Map<Integer, Integer> indexToNumberMapping;
    private final Comparator<Integer> indexComparator = Comparator.naturalOrder();

    public NumberContainers() {
        numberToIndexesMapping = new HashMap<>();
        indexToNumberMapping = new HashMap<>();
    }

    private void addNumber(int index, int number) {
        indexToNumberMapping.put(index, number);
        if (!numberToIndexesMapping.containsKey(number)) {
            numberToIndexesMapping.put(number, new PriorityQueue<>(indexComparator));
        }
        numberToIndexesMapping.get(number).add(index);
    }

    private void removeOldNumberAtCurrentIndex(int index) {
        int oldNumberAtCurrentIndex = indexToNumberMapping.get(index);
        PriorityQueue<Integer> oldNumbersMap = numberToIndexesMapping.get(oldNumberAtCurrentIndex);
        if (oldNumbersMap.size() == 1) {
            numberToIndexesMapping.remove(oldNumberAtCurrentIndex);
        } else {
            oldNumbersMap.remove(index);
        }
        indexToNumberMapping.remove(index);
    }

    public void change(int index, int number) {
        if (indexToNumberMapping.containsKey(index)) {
            if (indexToNumberMapping.get(index) != number) {
                removeOldNumberAtCurrentIndex(index);
                addNumber(index, number);
            }
        } else {
            addNumber(index, number);
        }
    }

    public int find(int number) {
        if (!numberToIndexesMapping.containsKey(number)) {
            return -1;
        } else {
            return numberToIndexesMapping.get(number).peek();
        }
    }
}

public class _2349_Design_a_Number_Container_System {
    public static void main(String[] args) {
        NumberContainers a = new NumberContainers();
        System.out.println(a.find(10));
        a.change(2, 10);
        a.change(1, 10);
        a.change(3, 10);
        a.change(5, 10);
        System.out.println(a.find(10));
        a.change(1, 20);
        System.out.println(a.find(10));
    }
}