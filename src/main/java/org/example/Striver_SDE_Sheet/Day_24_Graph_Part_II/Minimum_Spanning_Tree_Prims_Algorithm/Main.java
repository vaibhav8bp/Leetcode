package org.example.Striver_SDE_Sheet.Day_24_Graph_Part_II.Minimum_Spanning_Tree_Prims_Algorithm;

import java.io.*;
import java.util.*;

// https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
class Solution {

    static int findMinVertex(int V, List<List<int[]>> adj, int[] distance, boolean[] visited) {
        int minVertex = 0;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < V; i++) {
            if (!visited[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minVertex = i;
            }
        }

        return minVertex;
    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        int[] MST_Edges = new int[V - 1];
        Arrays.fill(MST_Edges, 0);
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        for (int i = 0; i < V - 1; i++) {
            int sourceVertex = findMinVertex(V, adj, distance, visited);
            List<int[]> sourceVertexNeighbors = adj.get(sourceVertex);

            for (int[] currentNeighbor : sourceVertexNeighbors) {
                int destinationVertex = currentNeighbor[0];

                if (visited[destinationVertex]) {
                    continue;
                }

                int distanceFromSourceToDestination = currentNeighbor[1];

                if (distanceFromSourceToDestination < distance[destinationVertex]) {
                    distance[destinationVertex] = distanceFromSourceToDestination;
                    MST_Edges[destinationVertex - 1] = distanceFromSourceToDestination;
                }
            }

            visited[sourceVertex] = true;
        }

        return Arrays.stream(MST_Edges).sum();
    }
}

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[]{b, c});
                list.get(b).add(new int[]{a, c});
            }
            ot.println(Solution.spanningTree(V, E, list));
        }
        ot.close();
    }
}