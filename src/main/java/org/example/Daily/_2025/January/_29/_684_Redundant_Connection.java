package org.example.Daily._2025.January._29;

// https://leetcode.com/problems/redundant-connection/description/
public class _684_Redundant_Connection {

    private int getParentVertex(int vertex, int[] parent) {
        while (parent[vertex] != vertex) {
            vertex = parent[vertex];
        }

        return parent[vertex];
    }

    private void union(int source, int destination, int[] parent, int[] rank) {
        int sourceParent = getParentVertex(source, parent);
        int destinationParent = getParentVertex(destination, parent);

        if (sourceParent != destinationParent) {
            if (rank[sourceParent] == rank[destinationParent]) {
                parent[sourceParent] = destinationParent;
                rank[destinationParent]++;
            } else if (rank[sourceParent] < rank[destinationParent]) {
                parent[sourceParent] = destinationParent;
            } else {
                parent[destinationParent] = sourceParent;
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        // It is given that the graph will only have n edges.
        // Therefor only 1 edge can be removed

        for (int[] currentEdge : edges) {
            int source = currentEdge[0] - 1;
            int destination = currentEdge[1] - 1;

            int sourceParent = getParentVertex(source, parent);
            int destinationParent = getParentVertex(destination, parent);

            if (sourceParent == destinationParent) {
                return currentEdge;
            } else {
                union(source, destination, parent, rank);
            }
        }

        return new int[]{};
    }
}