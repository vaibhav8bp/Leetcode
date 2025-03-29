package org.example.Weekly._442;

import java.util.*;

// https://leetcode.com/contest/weekly-contest-442/problems/properties-graph/description/
public class Q2_Properties_Graph {

    private static int intersect(int[] firstProperty, int[] secondProperty) {
        Set<Integer> firstSet = new HashSet<>();

        for (int current : firstProperty) {
            firstSet.add(current);
        }

        Set<Integer> secondSet = new HashSet<>();

        for (int current : secondProperty) {
            secondSet.add(current);
        }

        int count = 0;

        for (Integer current : secondSet) {
            if (firstSet.contains(current)) {
                count++;
            }
        }

        return count;
    }

    private static void componentMarker(int currentNode, boolean[] visited, List<Integer>[] graph) {
        visited[currentNode] = true;

        for (Integer currentNeighbor : graph[currentNode]) {
            if (!visited[currentNeighbor]) {
                componentMarker(currentNeighbor, visited, graph);
            }
        }
    }

    public static int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < properties.length; i++) {
            for (int j = i + 1; j < properties.length; j++) {
                if (intersect(properties[i], properties[j]) >= k) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        boolean[] visited = new boolean[n];

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                componentMarker(i, visited, graph);
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] properties = {{1, 1}, {1, 1}};
        System.out.println(numberOfComponents(properties, 2));
    }
}
