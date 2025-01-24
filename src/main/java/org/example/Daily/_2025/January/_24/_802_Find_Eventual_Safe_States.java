package org.example.Daily._2025.January._24;

import java.util.*;

public class _802_Find_Eventual_Safe_States {

    public List<Integer> eventualSafeNodes(int[][] graph) {

        List<List<Integer>> adjacencyList = new ArrayList<>();

        int[] inDegree = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                // Reversed The Graph
                adjacencyList.get(graph[i][j]).add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> finalNodesList = new ArrayList<>();

        boolean[] result = new boolean[graph.length];

        while (!queue.isEmpty()) {
            Integer top = queue.remove();
            result[top] = true;

            for (Integer currentNeighbor : adjacencyList.get(top)) {
                inDegree[currentNeighbor]--;
                if (inDegree[currentNeighbor] == 0) {
                    queue.add(currentNeighbor);
                }
            }
        }

        for (int i = 0; i < graph.length; i++) {
            if (result[i]) {
                finalNodesList.add(i);
            }
        }

        return finalNodesList;
    }

    // DFS
//    private boolean eventualSafeNodesHelper(List<List<Integer>> adjacencyList, int currentVertex, boolean[] overallVisited, boolean[] currentVisited) {
//        overallVisited[currentVertex] = true;
//        currentVisited[currentVertex] = true;
//
//        for (Integer currentNeighbor : adjacencyList.get(currentVertex)) {
//            if (!overallVisited[currentNeighbor] && !eventualSafeNodesHelper(adjacencyList, currentNeighbor, overallVisited, currentVisited)) {
//                return false;
//            } else if (currentVisited[currentNeighbor]) {
//                return false;
//            }
//        }
//        currentVisited[currentVertex] = false;
//        return true;
//    }
//
//    public List<Integer> eventualSafeNodes(int[][] graph) {
//
//        boolean[] overallVisited = new boolean[graph.length];
//        boolean[] currentVisited = new boolean[graph.length];
//
//        List<List<Integer>> adjacencyList = new ArrayList<>();
//
//        for (int i = 0; i < graph.length; i++) {
//            adjacencyList.add(new ArrayList<>());
//            for (int j = 0; j < graph[i].length; j++) {
//                adjacencyList.get(i).add(graph[i][j]);
//            }
//        }
//
//        List<Integer> finalNodesList = new ArrayList<>();
//
//        for (int i = 0; i < graph.length; i++) {
//            if (eventualSafeNodesHelper(adjacencyList, i, overallVisited, currentVisited)) {
//                finalNodesList.add(i);
//            }
//        }
//
//        return finalNodesList;
//    }
}