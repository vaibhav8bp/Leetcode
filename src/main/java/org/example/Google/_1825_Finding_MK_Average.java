package org.example.Google;

// https://leetcode.com/problems/finding-mk-average/description/

import java.util.*;

class MKAverage {
    Queue<Integer> queue;
    int middleMapSum;
    TreeMap<Integer, Integer> leftMap, middleMap, rightMap;
    int leftMapSize, rightMapSize;
    int m;
    int k;

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        this.queue = new LinkedList<>();
        this.leftMap = new TreeMap<>();
        this.middleMap = new TreeMap<>();
        this.rightMap = new TreeMap<>();
        this.middleMapSum = 0;
        // Below 2 variables are necessary to get count of all elements in the map.
        // map.size() is inaccurate because duplicate elements will contribute to size only once.
        this.leftMapSize = 0;
        this.rightMapSize = 0;
    }

    private void removeElementFromParticularMap(TreeMap<Integer, Integer> mapping, int num) {
        mapping.put(num, mapping.get(num) - 1);
        if (mapping.get(num) == 0) {
            mapping.remove(num);
        }
    }

    private void addElementToMap(TreeMap<Integer, Integer> mapping, int num) {
        mapping.put(num, mapping.getOrDefault(num, 0) + 1);
    }

    private void balance() {

        // Remove Excess Elements From leftMap to middleMap
        while (leftMapSize > k) {
            int largestLeftMapElement = leftMap.lastKey();
            removeElementFromParticularMap(leftMap, largestLeftMapElement);
            leftMapSize--;
            addElementToMap(middleMap, largestLeftMapElement);
            middleMapSum += largestLeftMapElement;
        }

        // Remove Excess Elements From Right Map to Middle map
        while (rightMapSize > k) {
            int smallestRightMapElement = rightMap.firstKey();
            removeElementFromParticularMap(rightMap, smallestRightMapElement);
            rightMapSize--;
            addElementToMap(middleMap, smallestRightMapElement);
            middleMapSum += smallestRightMapElement;
        }

        // Remove Excess Elements From Middle Map to Left Map
        while (leftMapSize < k && !middleMap.isEmpty()) {
            int smallestMiddleMapElement = middleMap.firstKey();
            removeElementFromParticularMap(middleMap, smallestMiddleMapElement);
            middleMapSum -= smallestMiddleMapElement;
            addElementToMap(leftMap, smallestMiddleMapElement);
            leftMapSize++;
        }

        // Remove Excess Elements From Middle Map to Right Map
        while (rightMapSize < k && !middleMap.isEmpty()) {
            int largestMiddleMapElement = middleMap.lastKey();
            removeElementFromParticularMap(middleMap, largestMiddleMapElement);
            middleMapSum -= largestMiddleMapElement;
            addElementToMap(rightMap, largestMiddleMapElement);
            rightMapSize++;
        }
    }

    private void removeElement(int num) {
        if (leftMap.containsKey(num)) {
            removeElementFromParticularMap(leftMap, num);
            leftMapSize--;
        } else if (middleMap.containsKey(num)) {
            removeElementFromParticularMap(middleMap, num);
            middleMapSum -= num;
        } else if (rightMap.containsKey(num)) {
            removeElementFromParticularMap(rightMap, num);
            rightMapSize--;
        }
        balance();
    }

    private void insertElement(int num) {
        if (leftMapSize < k || leftMap.lastKey() >= num) {
            addElementToMap(leftMap, num);
            leftMapSize++;
        } else if (rightMapSize < k || rightMap.firstKey() <= num) {
            addElementToMap(rightMap, num);
            rightMapSize++;
        } else {
            addElementToMap(middleMap, num);
            middleMapSum += num;
        }
        balance();
    }

    public void addElement(int num) {
        queue.offer(num);

        if (queue.size() > m) {
            int oldestElement = queue.remove();
            removeElement(oldestElement);
        }

        insertElement(num);
    }

    public int calculateMKAverage() {
        if (queue.size() < m) {
            return -1;
        }
        return (int) Math.floor((double) middleMapSum / (m - 2 * k));
    }
}

// Brute Force
//class MKAverage {
//    List<Integer> elements;
//    int m;
//    int k;
//
//    public MKAverage(int m, int k) {
//        elements = new ArrayList<>();
//        this.m = m;
//        this.k = k;
//    }
//
//    public void addElement(int num) {
//        elements.add(num);
//    }
//
//    public int calculateMKAverage() {
//        if (elements.size() < m) {
//            return -1;
//        }
//
//        List<Integer> lastMElements = new ArrayList<>();
//
//        // 0 1 2 3 4 5
//
//        for (int i = elements.size() - m; i < elements.size(); i++) {
//            lastMElements.add(elements.get(i));
//        }
//
//        Collections.sort(lastMElements);
//
//        // 0 1 2 3 4 5 6 7 8 9
//
//        long remainingElementsSum = 0;
//        int remainingElementsCount = lastMElements.size() - 2 * k;
//
//        for (int i = k; i < lastMElements.size() - k; i++) {
//            remainingElementsSum += lastMElements.get(i);
//        }
//
//        double average = (double) remainingElementsSum / remainingElementsCount;
//
//        return (int) Math.floor(average);
//    }
//}

public class _1825_Finding_MK_Average {
    public static void main(String[] args) {
        MKAverage a = new MKAverage(3, 1);
        a.addElement(3);
        a.addElement(1);
        System.out.println(a.calculateMKAverage());
        a.addElement(10);
        System.out.println(a.calculateMKAverage());
        a.addElement(5);
        a.addElement(5);
        a.addElement(5);
        System.out.println(a.calculateMKAverage());
    }
}