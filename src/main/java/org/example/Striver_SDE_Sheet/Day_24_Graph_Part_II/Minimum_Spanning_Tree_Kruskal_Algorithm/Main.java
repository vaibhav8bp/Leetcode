package org.example.Striver_SDE_Sheet.Day_24_Graph_Part_II.Minimum_Spanning_Tree_Kruskal_Algorithm;

import java.io.*;
import java.lang.*;
import java.util.*;

// https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
class Edge {
    int sourceVertex;
    int destinationVertex;
    int sourceToDestinationDistance;

    public Edge(int sourceVertex, int destinationVertex, int sourceToDestinationDistance) {
        this.sourceVertex = sourceVertex;
        this.destinationVertex = destinationVertex;
        this.sourceToDestinationDistance = sourceToDestinationDistance;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "sourceVertex=" + sourceVertex +
                ", destinationVertex=" + destinationVertex +
                ", sourceToDestinationDistance=" + sourceToDestinationDistance +
                '}';
    }
}

class Solution {

    static int findParent(int V, int[] parent) {
        while (parent[V] != V) {
            V = parent[V];
        }
        return parent[V];
    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                // To Avoid same edges
                if (i < adj.get(i).get(j)[0]) {
                    edges.add(new Edge(i, adj.get(i).get(j)[0], adj.get(i).get(j)[1]));
                }
            }
        }

        edges.sort(Comparator.comparingInt(o -> o.sourceToDestinationDistance));

        int MSTEdgesCount = 0;
        int currentEdgeCount = 0;
        int sum = 0;
        int[] parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        while (MSTEdgesCount != (V - 1)) {
            Edge currentEdge = edges.get(currentEdgeCount++);

            int v1 = findParent(currentEdge.sourceVertex, parent);
            int v2 = findParent(currentEdge.destinationVertex, parent);

            if (v1 != v2) {
                sum += currentEdge.sourceToDestinationDistance;
                MSTEdgesCount++;
                parent[v1] = v2;
            }
        }

        return sum;
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

//1
//6 6
//0 3 6
//1 2 3
//1 3 3
//1 4 3
//3 4 3
//3 5 6