package org.example.Striver_SDE_Sheet.Day_23_Graph.Detect_A_cycle_in_Undirected_Graph_using_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private boolean isCycle(int startIndex, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] parent, Queue<Integer> queue) {
        queue.add(startIndex);
        visited[startIndex] = true;

        while (!queue.isEmpty()) {
            Integer front = queue.remove();
            for (int j = 0; j < adj.get(front).size(); j++) {
                if (parent[front] != adj.get(front).get(j)) {
                    if (visited[adj.get(front).get(j)]) {
                        return true;
                    } else {
                        queue.add(adj.get(front).get(j));
                        visited[adj.get(front).get(j)] = true;
                        parent[adj.get(front).get(j)] = front;
                    }
                }
            }
        }

        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(visited, false);
        Arrays.fill(parent, -1);
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (isCycle(i, adj, visited, parent, queue)) {
                return true;
            }
            Arrays.fill(visited, false);
            Arrays.fill(parent, -1);
            queue.clear();
        }
        return false;
    }
}

//class Solution {
//    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
//        boolean[] visited = new boolean[V];
//        Queue<Integer> queue = new LinkedList<>();
//
//        for (int i = 0; i < V; i++) {
//            Arrays.fill(visited, false);
//            queue.add(i);
//
//            while (!queue.isEmpty()) {
//                Integer front = queue.remove();
//                if (visited[front]) {
//                    return true;
//                }
//                visited[front] = true;
//                for (int j = 0; j < adj.get(front).size(); j++) {
//                    if (!visited[adj.get(front).get(j)]) {
//                        queue.add(adj.get(front).get(j));
//                    }
//                }
//            }
//        }
//        return false;
//    }
//}

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