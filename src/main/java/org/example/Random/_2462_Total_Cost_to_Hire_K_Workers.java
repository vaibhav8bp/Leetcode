package org.example.Random;

import java.util.PriorityQueue;

// https://leetcode.com/problems/total-cost-to-hire-k-workers/description/
public class _2462_Total_Cost_to_Hire_K_Workers {

    private static void initialPopulation(PriorityQueue<int[]> minPQ, int[] costs, int candidates) {

        // Add All Elements
        if (costs.length <= 2 * candidates) {
            for (int i = 0; i < costs.length; i++) {
                minPQ.add(new int[]{costs[i], i, 2});
            }
        } else {
            for (int i = 0; i < candidates; i++) {
                minPQ.add(new int[]{costs[i], i, 0});
                minPQ.add(new int[]{costs[costs.length - 1 - i], costs.length - 1 - i, 1});
            }
        }
    }

    public static long totalCost(int[] costs, int k, int candidates) {

        // Will store like cost,index,direction.
        // Direction to guide whether next element will be inserted from left/right
        // Direction -> 0 -> Left
        // Direction -> 1 -> Right
        // Direction -> 2-> All

        PriorityQueue<int[]> minPQ = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        });

        initialPopulation(minPQ, costs, candidates);

        int left = candidates;
        int right = costs.length - candidates - 1;

        int candidatesHired = 0;
        long totalCost = 0;

        while (candidatesHired != k) {
            int[] front = minPQ.remove();
            totalCost += front[0];

            if (left <= right) {
                int direction = front[2];
                if (direction == 0) {
                    minPQ.add(new int[]{costs[left], left, 0});
                    left++;
                } else if (direction == 1) {
                    minPQ.add(new int[]{costs[right], right, 1});
                    right--;
                }
            }

            candidatesHired++;
        }

        return totalCost;
    }

    public static void main(String[] args) {
        System.out.println(totalCost(new int[]{31, 25, 72, 79, 74, 65, 84, 91, 18, 59, 27, 9, 81, 33, 17, 58}, 11, 2));
    }

    //  0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15
    // 31 25 72 79 74 65 84 91 18 59 27  9 81 33 17 58

    // k=11
    // candidates=2
}
