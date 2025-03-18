package org.example.Striver_SDE_Sheet.Day_23_Graph.Topological_Sort_BFS;

import java.util.*;
import java.io.*;

class Solution {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V];
        Arrays.fill(inDegree, 0);

        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[V];
        int resultIndex = 0;

        for (ArrayList<Integer> allNodesNeighbors : adj) {
            for (Integer currentNeighbor : allNodesNeighbors) {
                inDegree[currentNeighbor]++;
            }
        }

        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                result[resultIndex++] = i;
            }
        }

        while (!queue.isEmpty()) {
            Integer front = queue.remove();

            for (int i = 0; i < adj.get(front).size(); i++) {
                inDegree[adj.get(front).get(i)]--;
                if (inDegree[adj.get(front).get(i)] == 0) {
                    queue.add(adj.get(front).get(i));
                    result[resultIndex++] = adj.get(front).get(i);
                }
            }
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