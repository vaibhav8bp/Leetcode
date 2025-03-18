package org.example.Striver_SDE_Sheet.Day_23_Graph.Detect_A_cycle_in_Undirected_Graph_using_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


class Solution {

    private boolean isCycle(int currentIndex, int currentParent, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] parent) {
        if (visited[currentIndex]) {
            return true;
        }

        visited[currentIndex] = true;
        parent[currentIndex] = currentParent;

        for (int i = 0; i < adj.get(currentIndex).size(); i++) {
            int currentNeighbor = adj.get(currentIndex).get(i);
            if (parent[currentNeighbor] != currentIndex && isCycle(currentNeighbor, currentIndex, adj, visited, parent)) {
                return true;
            }
        }

        visited[currentIndex] = false;
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(visited, false);
        Arrays.fill(parent, -1);

        for (int i = 0; i < V; i++) {
            if (isCycle(i, -1, adj, visited, parent)) {
                return true;
            }
        }
        return false;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}