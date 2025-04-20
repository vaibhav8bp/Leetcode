package org.example.Striver_SDE_Sheet.Day_10_Recursion_And_BackTracking.M_Coloring_Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
class Solution {

    private boolean isSafeToColorGivenNodeWithGivenColor(int currentNode, int colorToBeChecked, int[] color, List<Integer>[] graph) {

        for (Integer currentNeighbor : graph[currentNode]) {
            if (color[currentNeighbor] == colorToBeChecked) {
                return false;
            }
        }

        return true;
    }

    private boolean graphColoringHelper(int currentNode, int v, int m, int[] color, List<Integer>[] graph) {
        if (currentNode == v) {
            return true;
        }

        for (int i = 1; i <= m; i++) {
            if (isSafeToColorGivenNodeWithGivenColor(currentNode, i, color, graph)) {
                color[currentNode] = i;
                if (graphColoringHelper(currentNode + 1, v, m, color, graph)) {
                    return true;
                }
                color[currentNode] = -1;
            }
        }

        return false;
    }

    boolean graphColoring(int v, List<int[]> edges, int m) {
        int[] color = new int[v];
        Arrays.fill(color, -1);

        List<Integer>[] graph = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] currentEdge : edges) {
            int source = currentEdge[0];
            int destination = currentEdge[1];
            graph[source].add(destination);
            graph[destination].add(source);
        }

        return graphColoringHelper(0, v, m, color, graph);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());      // Number of vertices
            String[] arrInput = br.readLine().trim().split(" "); // Input for edges

            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < arrInput.length; i += 2) {
                int u = Integer.parseInt(arrInput[i]);
                int v = Integer.parseInt(arrInput[i + 1]);
                edges.add(new int[]{u, v});
            }

            int m = Integer.parseInt(br.readLine().trim()); // Number of colors

            Solution sol = new Solution();
            System.out.println(sol.graphColoring(n, edges, m) ? "true" : "false");
            System.out.println("~");
        }
    }
}