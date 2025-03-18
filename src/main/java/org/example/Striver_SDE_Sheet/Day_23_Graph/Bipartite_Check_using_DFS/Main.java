package org.example.Striver_SDE_Sheet.Day_23_Graph.Bipartite_Check_using_DFS;

import java.util.Arrays;

class Solution {

    private boolean isBipartite(int currentIndex, int[][] graph, int[] color) {

        for (int i = 0; i < graph[currentIndex].length; i++) {
            int currentNeighbor = graph[currentIndex][i];
            if (color[currentNeighbor] == -1) {
                color[currentNeighbor] = color[currentIndex] ^ 1;
                if (!isBipartite(currentNeighbor, graph, color)) {
                    return false;
                }
            } else {
                if (color[currentNeighbor] == color[currentIndex]) {
                    return false;
                }
            }
        }


        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                color[i] = 0;
                if (!isBipartite(i, graph, color)) {
                    return false;
                }
            }
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}