package org.example.Striver_SDE_Sheet.Day_24_Graph_Part_II.Dijkstra_Algorithm;

import java.util.*;
import java.io.*;

class Solution {

    static int findMinVertex(int V, int[] distance, boolean[] visited) {
        int minValue = Integer.MAX_VALUE;
        int minVertex = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i] && distance[i] < minValue) {
                minValue = distance[i];
                minVertex = i;
            }
        }

        return minVertex;
    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[S] = 0;
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        for (int i = 0; i < V - 1; i++) {
            int sourceVertex = findMinVertex(V, distance, visited);
            ArrayList<ArrayList<Integer>> minVertexNeighborList = adj.get(sourceVertex);

            for (ArrayList<Integer> integers : minVertexNeighborList) {
                int destinationVertex = integers.get(0);
                int sourceVertexToDestinationVertexWeight = integers.get(1);

                if (distance[sourceVertex] + sourceVertexToDestinationVertexWeight < distance[destinationVertex]) {
                    distance[destinationVertex] = distance[sourceVertex] + sourceVertexToDestinationVertexWeight;
                }
            }

            visited[sourceVertex] = true;
        }

        return distance;
    }
}

class DriverClass {
    public static void main(String[] args) throws IOException {

        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] str = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            int i = 0;
            while (i++ < E) {
                String[] S = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }

            int S = Integer.parseInt(read.readLine());

            int[] ptr = Solution.dijkstra(V, adj, S);

            for (i = 0; i < V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}