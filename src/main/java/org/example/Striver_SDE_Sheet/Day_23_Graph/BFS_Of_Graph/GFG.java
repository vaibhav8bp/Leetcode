package org.example.Striver_SDE_Sheet.Day_23_Graph.BFS_Of_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[adj.size()];
        Arrays.fill(visited, false);
        ArrayList<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            Integer front = queue.remove();
            if (visited[front]) {
                continue;
            }
            list.add(front);
            visited[front] = true;
            ArrayList<Integer> frontList = adj.get(front);

            if (frontList != null && !frontList.isEmpty()) {
                for (Integer integer : frontList) {
                    if (!visited[integer]) {
                        queue.add(integer);
                    }
                }
            }
        }

        return list;
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
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (Integer an : ans) System.out.print(an + " ");
            System.out.println();
        }
    }
}