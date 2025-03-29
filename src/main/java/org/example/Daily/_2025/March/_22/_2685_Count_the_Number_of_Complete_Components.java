package org.example.Daily._2025.March._22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/count-the-number-of-complete-components/description/
public class _2685_Count_the_Number_of_Complete_Components {

    private int findParent(int currentNode, int[] parent) {
        while (currentNode != parent[currentNode]) {
            currentNode = parent[currentNode];
        }

        return parent[currentNode];
    }

    private void findUnion(int node1, int node2, int[] parent, int[] rank) {
        int node1parent = findParent(node1, parent);
        int node2Parent = findParent(node2, parent);

        if (node1parent != node2Parent) {
            if (rank[node1parent] <= rank[node2Parent]) {
                parent[node1parent] = node2Parent;
                if (rank[node1parent] == rank[node2Parent]) {
                    rank[node2Parent]++;
                }
            } else {
                parent[node2Parent] = node1parent;
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int[] rank = new int[n];

        for (int[] currentEdge : edges) {
            findUnion(currentEdge[0], currentEdge[1], parent, rank);
        }

        // Key will be root of each component and value will be all elements of that component.
        Map<Integer, List<Integer>> parentToChildMapping = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = findParent(i, parent);

            if (!parentToChildMapping.containsKey(root)) {
                parentToChildMapping.put(root, new ArrayList<>());
            }

            parentToChildMapping.get(root).add(i);
        }

        Map<Integer, Integer> componentToComponentLengthMapping = new HashMap<>();

        for (int[] currentEdge : edges) {
            int root = findParent(currentEdge[0], parent);
            // No need for both vertices as each edge will be counted once only.
            componentToComponentLengthMapping.put(root, componentToComponentLengthMapping.getOrDefault(root, 0) + 1);
        }

        int answer = 0;

        for (Map.Entry<Integer, List<Integer>> currentEntry : parentToChildMapping.entrySet()) {
            int componentSize = currentEntry.getValue().size();
            int numberOfEdgesRequiredForCompleteComponent = ((componentSize) * (componentSize - 1)) / 2;
            int actualEdgesInComponent = componentToComponentLengthMapping.getOrDefault(currentEntry.getKey(), 0);

            if (numberOfEdgesRequiredForCompleteComponent == actualEdgesInComponent) {
                answer++;
            }
        }

        return answer;
    }

//    private void graphFormation(int n, List<Integer>[] graph, int[][] edges) {
//        for (int i = 0; i < n; i++) {
//            graph[i] = new ArrayList<>();
//        }
//
//        for (int[] currentEdge : edges) {
//            int source = currentEdge[0];
//            int destination = currentEdge[1];
//
//            graph[source].add(destination);
//            graph[destination].add(source);
//        }
//    }
//
//    // For a component to be complete the degree of each node should be equal to componentLength - 1.
//    private boolean checkIfCurrentComponentIsComplete(List<Integer> component, int[] degree) {
//        int currentComponentLength = component.size();
//
//        for (Integer currentNode : component) {
//            if (degree[currentNode] != currentComponentLength - 1) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    private void getCurrentComponent(int currentNode, List<Integer>[] graph, boolean[] visited, List<Integer> currentComponent) {
//        visited[currentNode] = true;
//        currentComponent.add(currentNode);
//
//        for (Integer currentNeighbor : graph[currentNode]) {
//            if (!visited[currentNeighbor]) {
//                getCurrentComponent(currentNeighbor, graph, visited, currentComponent);
//            }
//        }
//    }
//
//    public int countCompleteComponents(int n, int[][] edges) {
//        List<Integer>[] graph = new ArrayList[n];
//        graphFormation(n, graph, edges);
//
//        int[] degree = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            degree[i] = graph[i].size();
//        }
//
//        boolean[] visited = new boolean[n];
//
//        int answer = 0;
//        for (int i = 0; i < n; i++) {
//            if (!visited[i]) {
//                List<Integer> currentComponent = new ArrayList<>();
//                getCurrentComponent(i, graph, visited, currentComponent);
//                if (checkIfCurrentComponentIsComplete(currentComponent, degree)) {
//                    answer++;
//                }
//            }
//        }
//
//        return answer;
//    }
}
