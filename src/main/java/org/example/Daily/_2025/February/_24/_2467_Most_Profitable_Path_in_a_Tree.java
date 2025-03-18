package org.example.Daily._2025.February._24;

import java.util.*;
import java.util.stream.IntStream;

// https://leetcode.com/problems/most-profitable-path-in-a-tree/
public class _2467_Most_Profitable_Path_in_a_Tree {

    private int mostProfitablePath(int aliceIndex, int bobIndex, List<List<Integer>> graph, int[] parent, boolean[] visited, boolean[] isTerminal, int[] amount) {
        // Check If Alice Has Arrived At Terminal Node
        if (isTerminal[aliceIndex]) {
            if (aliceIndex == bobIndex) {
                return amount[aliceIndex] / 2;
            } else {
                return amount[aliceIndex];
            }
        }

        visited[aliceIndex] = true;
        int originalAliceIndexProfit = amount[aliceIndex];
        int originalBobIndexProfit = amount[bobIndex];
        int currentProfit;
        if (aliceIndex == bobIndex) {
            currentProfit = amount[aliceIndex] / 2;
        } else {
            currentProfit = amount[aliceIndex];
        }

        amount[aliceIndex] = 0;
        amount[bobIndex] = 0;

        int maxNeighborProfit = Integer.MIN_VALUE;

        for (Integer currentAliceNeighbor : graph.get(aliceIndex)) {
            if (!visited[currentAliceNeighbor]) {
                maxNeighborProfit = Math.max(maxNeighborProfit, mostProfitablePath(currentAliceNeighbor, parent[bobIndex], graph, parent, visited, isTerminal, amount));
            }
        }

        visited[aliceIndex] = false;
        amount[aliceIndex] = originalAliceIndexProfit;
        amount[bobIndex] = originalBobIndexProfit;

        /*

        Example why amount restoration for bobIndex is necessary.

        Path 1 ->
        Alice goes to 0 and then 1.
        Bob goes from 3 to 2. Modifies amount at 3 and 2 to 0.

        Path 2 ->
        Alice Goes From 0 to 2 and Bob Comes from 3 to 2.
        Now amount at 2 should have been shared but during path 1
        if we do not backtrack, it could lead to errors.

        Amount at aliceIndex does not need restoration because we are already
        storing its value in currentProfit.

              0
             / \
            1   2
               /
              3
         */

        return currentProfit + maxNeighborProfit;
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = edges.length + 1;

        List<List<Integer>> graph = new ArrayList<>();

        IntStream.range(0, n).forEach(x -> graph.add(new ArrayList<>()));

        Arrays.stream(edges).forEach(currentEdge -> {
            graph.get(currentEdge[0]).add(currentEdge[1]);
            graph.get(currentEdge[1]).add(currentEdge[0]);
        });

        int[] parent = new int[n];
        IntStream.range(0, n).forEach(x -> parent[x] = -1);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        boolean[] isTerminal = new boolean[n];

        while (!queue.isEmpty()) {
            int[] front = queue.remove();
            int currentNode = front[0];
            int currentNodeParent = front[1];
            parent[currentNode] = currentNodeParent;

            boolean terminal = true;

            for (Integer currentNeighbor : graph.get(currentNode)) {
                if (parent[currentNeighbor] == -1) {
                    terminal = false;
                    queue.add(new int[]{currentNeighbor, currentNode});
                }
            }

            if (terminal) {
                isTerminal[currentNode] = true;
            }
        }

        return mostProfitablePath(0, bob, graph, parent, new boolean[n], isTerminal, amount);
    }
}
