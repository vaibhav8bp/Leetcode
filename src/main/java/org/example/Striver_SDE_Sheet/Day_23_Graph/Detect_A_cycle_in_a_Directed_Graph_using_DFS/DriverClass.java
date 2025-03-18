package org.example.Striver_SDE_Sheet.Day_23_Graph.Detect_A_cycle_in_a_Directed_Graph_using_DFS;


import java.util.*;
import java.lang.*;

class Solution {

   private static boolean isCyclic(int currentIndex, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] dfsVisited) {
       visited[currentIndex] = true;
       dfsVisited[currentIndex] = true;

       ArrayList<Integer> currentNeighborList = adj.get(currentIndex);

       for (Integer integer : currentNeighborList) {
           if (!visited[integer]) {
               if (isCyclic(integer, adj, visited, dfsVisited)) {
                   return true;
               }
           } else {
               // It can happen that node is visited but not in current cycle so check dfsVisited
               if (dfsVisited[integer]) {
                   return true;
               }
           }

       }

       dfsVisited[currentIndex] = false;
       return false;
   }

   public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
       boolean[] visited = new boolean[V];
       boolean[] dfsVisited = new boolean[V];

       Arrays.fill(visited, false);
       Arrays.fill(dfsVisited, false);

       for (int i = 0; i < V; i++) {
           if (!visited[i] && isCyclic(i, adj, visited, dfsVisited)) {
               return true;
           }
       }

       return false;
   }
}

// class Solution {

//     private static boolean isCyclic(int currentIndex, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
//         if (visited[currentIndex]) {
//             return true;
//         }

//         visited[currentIndex] = true;

//         ArrayList<Integer> currentNeighborList = adj.get(currentIndex);

//         for (Integer integer : currentNeighborList) {
//             if (isCyclic(integer, adj, visited)) {
//                 return true;
//             }
//         }

//         visited[currentIndex] = false;

//         return false;
//     }

//     public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
//         boolean[] visited = new boolean[V];
//         Arrays.fill(visited, false);

//         for (int i = 0; i < V; i++) {
//             if (isCyclic(i, adj, visited)) {
//                 return true;
//             }
//         }

//         return false;
//     }
// }

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u - 1).add(v);
            }
            if (Solution.isCyclic(V, list))
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}

//1
//5 4
//1 2
//2 3
//3 4
//4 5
