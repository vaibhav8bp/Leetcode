package org.example.Striver_SDE_Sheet.Day_24_Graph_Part_II.Strongly_Connected_Components_Kosarajus_Algo;

import java.util.*;

class Solution {

    private void fillStackWithFinishTime(int currentIndex, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[currentIndex] = true;

        for (int i = 0; i < adj.get(currentIndex).size(); i++) {
            int currentNeighbor = adj.get(currentIndex).get(i);
            if (!visited[currentNeighbor]) {
                fillStackWithFinishTime(currentNeighbor, adj, visited, stack);
            }
        }

        stack.add(currentIndex);
    }

    private void dfs(int currentIndex, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[currentIndex] = true;

        for (int i = 0; i < adj.get(currentIndex).size(); i++) {
            int currentNeighbor = adj.get(currentIndex).get(i);
            if (!visited[currentNeighbor]) {
                dfs(currentNeighbor, adj, visited);
            }
        }
    }

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);


        // Step 1: DFS Traversal On Graph and store node with their finishing time by pushing in stack

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                fillStackWithFinishTime(i, adj, visited, stack);
            }
        }

        // Step 2: Reverse All Edges Of The Graph

        ArrayList<ArrayList<Integer>> reversedGraph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            reversedGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                reversedGraph.get(adj.get(i).get(j)).add(i);
            }
        }

        // Step 3: Perform DFS on reversed graph and starting point will be stack's top
        // no. of DFS traversals is the count of SCC's
        // If you want to store those SCC too can pass a list and populate it
        int DFSTraversalCount = 0;
        Arrays.fill(visited, false);

        while (!stack.isEmpty()) {
            Integer top = stack.pop();
            if (!visited[top]) {
                DFSTraversalCount++;
                dfs(top, reversedGraph, visited);
            }
        }

        return DFSTraversalCount;
    }
}

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());

            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());

            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                int v = Integer.parseInt(sc.next());

                // adding directed edgese between
                // vertex 'u' and 'v'
                adj.get(u).add(v);
            }

            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
        }
    }
}