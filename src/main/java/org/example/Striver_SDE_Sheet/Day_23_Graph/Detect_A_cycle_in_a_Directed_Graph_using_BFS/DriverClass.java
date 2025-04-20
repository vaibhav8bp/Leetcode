package org.example.Striver_SDE_Sheet.Day_23_Graph.Detect_A_cycle_in_a_Directed_Graph_using_BFS;

import java.util.*;
import java.lang.*;

class Solution {
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V];
        Arrays.fill(inDegree, 0);

        for (ArrayList<Integer> integers : adj) {
            for (Integer integer : integers) {
                inDegree[integer]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                count++;
            }
        }
        while (!queue.isEmpty()) {
            Integer front = queue.remove();
            for (int i = 0; i < adj.get(front).size(); i++) {
                inDegree[adj.get(front).get(i)]--;
                if (inDegree[adj.get(front).get(i)] == 0) {
                    queue.add(adj.get(front).get(i));
                    count++;
                }
            }
        }

        return (count == V);
    }
}

// class Solution {
//    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
//        boolean[] visited = new boolean[V];
//        Queue<Integer> queue = new LinkedList<>();
//        Arrays.fill(visited, false);

//        for (int i = 0; i < V; i++) {
//            queue.add(i);
//            while (!queue.isEmpty()) {
//                Integer front = queue.remove();

//                if (visited[front]) {
//                    if (front == i) {
//                        return true;
//                    } else {
//                        continue;
//                    }
//                }

//                visited[front] = true;
//                ArrayList<Integer> neighborList = adj.get(front);

//                queue.addAll(neighborList);
//            }

//            Arrays.fill(visited, false);
//        }

//        return false;
//    }
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
                list.get(u).add(v);
            }
            if (Solution.isCyclic(V, list)) System.out.println("1");
            else System.out.println("0");
        }
    }
}

//1
//6 5
//5 3
//3 1
//1 2
//2 4
//4 0