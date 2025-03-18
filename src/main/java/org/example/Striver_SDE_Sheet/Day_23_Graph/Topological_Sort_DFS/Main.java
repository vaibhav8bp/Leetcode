package org.example.Striver_SDE_Sheet.Day_23_Graph.Topological_Sort_DFS;

import java.util.*;
import java.io.*;

class Solution {

    static void topoSort(int currentIndex, Stack<Integer> stack, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[currentIndex] = true;

        // Call Recursion on Children
        for (int i = 0; i < adj.get(currentIndex).size(); i++) {
            if (!visited[adj.get(currentIndex).get(i)]) {
                topoSort(adj.get(currentIndex).get(i), stack, visited, adj);
            }
        }

        // Add current to Stack
        // Parent should be pushed after recursion because parent will be popped first
        stack.add(currentIndex);
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoSort(i, stack, visited, adj);
            }
        }

        int[] result = new int[V];
        int resultIndex = 0;

        while (!stack.isEmpty()) {
            result[resultIndex++] = stack.pop();
        }

        return result;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String[] st = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());

            for (int i = 1; i <= edg; i++) {
                String[] s = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = Solution.topoSort(nov, list);

            if (check(list, nov, res))
                System.out.println("1");
            else
                System.out.println("0");
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {

        if (V != res.length)
            return false;

        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}