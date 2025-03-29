package org.example.Daily._2025.March._20;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-cost-walk-in-weighted-graph/description/
public class _3108_Minimum_Cost_Walk_in_Weighted_Graph {

    private int findParent(int node, int[] parent) {
        while (parent[node] != node) {
            node = parent[node];
        }
        return node;
    }

    private int computeWeight(int firstNodeParent, int secondNodeParent, int currentWeight, int[] weights) {
        int firstNodeParentWeight = weights[firstNodeParent];
        if (firstNodeParentWeight == -1) {
            firstNodeParentWeight = currentWeight;
        }

        int secondNodeParentWeight = weights[secondNodeParent];
        if (secondNodeParentWeight == -1) {
            secondNodeParentWeight = currentWeight;
        }

        return firstNodeParentWeight & secondNodeParentWeight & currentWeight;
    }

    private void unionFind(int firstNode, int secondNode, int[] parent, int[] rank, int[] weights, int currentWeight) {
        int firstNodeParent = findParent(firstNode, parent);
        int secondNodeParent = findParent(secondNode, parent);

        if (firstNodeParent != secondNodeParent) {
            if (rank[firstNodeParent] <= rank[secondNodeParent]) {
                parent[firstNodeParent] = secondNodeParent;
                if (rank[firstNodeParent] == rank[secondNodeParent]) {
                    rank[secondNodeParent]++;
                }
                weights[secondNodeParent] = computeWeight(firstNodeParent, secondNodeParent, currentWeight, weights);
            } else {
                parent[secondNodeParent] = firstNodeParent;
                weights[firstNodeParent] = computeWeight(firstNodeParent, secondNodeParent, currentWeight, weights);
            }
        } else {
            // When 2 nodes are already in same component, we don't need to adjust parent or rank,
            // we just need to adjust weight.
            weights[firstNodeParent] &= currentWeight;
        }
    }

    // The idea is simple that the bitwise operation & always reduces the result and never increases it,
    // therefore for elements in the same component, their answer is bitwise & of all edges,
    // and for elements in different component answer is -1 as per question.
    // Use Union Find for component generation, and in it only adjust weight for each component.
    // Initialization with -1 is done because 1& anything will set answer to 1 only, so initialized with -1
    // and check if -1 in unionFind, assign currentWeight as it will be the first weight of that component.

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] rank = new int[n];

        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int[] weights = new int[n];
        Arrays.fill(weights, -1);

        for (int[] currentEdge : edges) {
            int source = currentEdge[0];
            int destination = currentEdge[1];
            int weight = currentEdge[2];
            unionFind(source, destination, parent, rank, weights, weight);
        }

        int[] result = new int[query.length];
        int resultIndex = 0;

        for (int[] currentQuery : query) {
            int source = currentQuery[0];
            int destination = currentQuery[1];

            int sourceParent = findParent(source, parent);
            int destinationParent = findParent(destination, parent);

            if (sourceParent != destinationParent) {
                result[resultIndex++] = -1;
            } else {
                result[resultIndex++] = weights[sourceParent];
            }
        }

        return result;
    }
}