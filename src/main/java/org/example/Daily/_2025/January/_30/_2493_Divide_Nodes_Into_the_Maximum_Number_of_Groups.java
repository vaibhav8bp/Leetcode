package org.example.Daily._2025.January._30;

// https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups/description/

import java.util.*;

public class _2493_Divide_Nodes_Into_the_Maximum_Number_of_Groups {

    private boolean isGraphBipartiteHelper(int currentVertex, Boolean[] color, List<Integer>[] graph, List<Integer> currentComponent) {
        currentComponent.add(currentVertex);
        for (Integer currentNeighbor : graph[currentVertex]) {
            if (color[currentNeighbor] == null) {
                color[currentNeighbor] = !color[currentVertex];
                if (!isGraphBipartiteHelper(currentNeighbor, color, graph, currentComponent)) {
                    return false;
                }
            } else {
                if (color[currentNeighbor] == color[currentVertex]) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isGraphBipartite(List<Integer>[] graph, List<List<Integer>> components) {
        Boolean[] color = new Boolean[graph.length];
        Arrays.fill(color, null);

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == null) {
                color[i] = true;
                List<Integer> currentComponent = new ArrayList<>();
                if (!isGraphBipartiteHelper(i, color, graph, currentComponent)) {
                    return false;
                } else {
                    components.add(currentComponent);
                }
            }
        }

        return true;
    }

    private int findDepthFromCurrentVertex(int currentVertex, List<Integer>[] graph) {
        boolean[] visited = new boolean[graph.length];

        int depth = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(currentVertex);

        while (!queue.isEmpty()) {
            depth++;
            List<Integer> nextLevelElements = new ArrayList<>();
            while (!queue.isEmpty()) {
                Integer front = queue.remove();
                if (visited[front]) {
                    continue;
                }
                visited[front] = true;
                for (Integer currentNeighbor : graph[front]) {
                    if (visited[currentNeighbor]) {
                        continue;
                    }
                    nextLevelElements.add(currentNeighbor);
                }
            }
            queue.addAll(nextLevelElements);
        }

        return depth;
    }

    private int findGroupLengthOfComponent(List<Integer> component, List<Integer>[] graph) {

        int answer = 0;

        for (Integer currentVertex : component) {
            answer = Math.max(answer, findDepthFromCurrentVertex(currentVertex, graph));
        }

        return answer;
    }

    public int magnificentSets(int n, int[][] edges) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] currentEdge : edges) {
            int source = currentEdge[0] - 1;
            int destination = currentEdge[1] - 1;
            graph[source].add(destination);
            graph[destination].add(source);
        }

        List<List<Integer>> components = new ArrayList<>();

        if (!isGraphBipartite(graph, components)) {
            return -1;
        }

        int answer = 0;

        for (List<Integer> currentComponent : components) {
            answer += findGroupLengthOfComponent(currentComponent, graph);
        }

        return answer;
    }
}