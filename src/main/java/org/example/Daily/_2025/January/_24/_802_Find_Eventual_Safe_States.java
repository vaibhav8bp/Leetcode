package org.example.Daily._2025.January._24;

import java.util.*;

// https://leetcode.com/problems/find-eventual-safe-states/
public class _802_Find_Eventual_Safe_States {

//   public List<Integer> eventualSafeNodes(int[][] graph) {
//
//       List<List<Integer>> adjacencyList = new ArrayList<>();
//
//       int[] inDegree = new int[graph.length];
//
//       for (int i = 0; i < graph.length; i++) {
//           adjacencyList.add(new ArrayList<>());
//       }
//
//       for (int i = 0; i < graph.length; i++) {
//           for (int j = 0; j < graph[i].length; j++) {
//               // Reversed The Graph
//               adjacencyList.get(graph[i][j]).add(i);
//               inDegree[i]++;
//           }
//       }
//
//       Queue<Integer> queue = new LinkedList<>();
//
//       for (int i = 0; i < graph.length; i++) {
//           if (inDegree[i] == 0) {
//               queue.add(i);
//           }
//       }
//
//       List<Integer> finalNodesList = new ArrayList<>();
//
//       boolean[] result = new boolean[graph.length];
//
//       while (!queue.isEmpty()) {
//           Integer top = queue.remove();
//           result[top] = true;
//
//           for (Integer currentNeighbor : adjacencyList.get(top)) {
//               inDegree[currentNeighbor]--;
//               if (inDegree[currentNeighbor] == 0) {
//                   queue.add(currentNeighbor);
//               }
//           }
//       }
//
//       for (int i = 0; i < graph.length; i++) {
//           if (result[i]) {
//               finalNodesList.add(i);
//           }
//       }
//
//       return finalNodesList;
//   }

    // DFS
    private boolean eventualSafeNodesHelper(int[][] graph, int currentVertex, List<Boolean> safe) {

        if (safe.get(currentVertex) != null) {
            return safe.get(currentVertex);
        }

        safe.set(currentVertex, false);

        for (Integer currentNeighbor : graph[currentVertex]) {
            if (!eventualSafeNodesHelper(graph, currentNeighbor, safe)) {
                return false;
            }
        }

        safe.set(currentVertex, true);
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        List<Boolean> safe = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            safe.add(null);
        }

        List<Integer> finalNodesList = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            if (eventualSafeNodesHelper(graph, i, safe)) {
                finalNodesList.add(i);
            }
        }

        return finalNodesList;
    }
}