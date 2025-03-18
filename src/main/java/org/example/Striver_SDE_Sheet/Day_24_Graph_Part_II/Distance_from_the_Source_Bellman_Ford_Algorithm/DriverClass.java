package org.example.Striver_SDE_Sheet.Day_24_Graph_Part_II.Distance_from_the_Source_Bellman_Ford_Algorithm;

import java.util.*;
import java.io.*;

class Solution {

    static int nonReachableNodeLength = 10_00_00_000;

    static int[] edgeTraversal(ArrayList<ArrayList<Integer>> edges, int[] distance, boolean nthCheck) {
        for (ArrayList<Integer> edge : edges) {
            int currentSource = edge.get(0);
            int currentDestination = edge.get(1);
            int currentSourceToCurrentDestinationWeight = edge.get(2);

            // Source Itself is Non Visited , No need to do anything
            if (distance[currentSource] == nonReachableNodeLength) {
                continue;
            }

            if (distance[currentSource] + currentSourceToCurrentDestinationWeight < distance[currentDestination]) {
                if (nthCheck) {
                    return new int[]{-1};
                }
                distance[currentDestination] = distance[currentSource] + currentSourceToCurrentDestinationWeight;
            }
        }

        return distance;
    }

    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {

        int[] distance = new int[V];
        Arrays.fill(distance, nonReachableNodeLength);
        distance[S] = 0;

        for (int iteration = 0; iteration < (V - 1); iteration++) {
            edgeTraversal(edges, distance, false);
        }

        // If even in nth iteration distance is getting reduced then -ve cycle is there for sure
        return edgeTraversal(edges, distance, true);
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

            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

            int i = 0;
            while (i++ < E) {
                String[] S = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<>();
                t1.add(u);
                t1.add(v);
                t1.add(w);
                edges.add(t1);
            }

            int S = Integer.parseInt(read.readLine());

            int[] ptr = Solution.bellman_ford(V, edges, S);

            for (i = 0; i < ptr.length; i++) System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}