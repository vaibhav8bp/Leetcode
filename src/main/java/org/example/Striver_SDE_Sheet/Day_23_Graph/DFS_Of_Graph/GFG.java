package org.example.Striver_SDE_Sheet.Day_23_Graph.DFS_Of_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    private void dfsOfGraph(int currentIndex, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> finalList, boolean[] visited) {
        finalList.add(currentIndex);
        visited[currentIndex] = true;

        ArrayList<Integer> list = adj.get(currentIndex);
        if (list != null && !list.isEmpty()) {
            for (Integer integer : list) {
                if (!visited[integer]) {
                    dfsOfGraph(integer, adj, finalList, visited);
                }
            }
        }
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        ArrayList<Integer> finalList = new ArrayList<>();
        dfsOfGraph(0, adj, finalList, visited);
        return finalList;
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
            ArrayList<ArrayList<Integer>> adj =
                    new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
            for (Integer an : ans) System.out.print(an + " ");
            System.out.println();
        }
    }
}