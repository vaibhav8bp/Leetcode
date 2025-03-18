package org.example.Striver_SDE_Sheet.Day_23_Graph.Bipartite_Check_using_BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private boolean isBiPartite(int currentIndex, int[][] graph, int[] color, Queue<Integer> queue) {
        queue.add(currentIndex);
        color[currentIndex] = 0;
        while (!queue.isEmpty()) {
            Integer front = queue.remove();
            int frontColor = color[front];

            for (int i = 0; i < graph[front].length; i++) {
                if (color[graph[front][i]] == -1) {
                    queue.add(graph[front][i]);
                    color[graph[front][i]] = frontColor ^ 1;
                } else {
                    if (color[graph[front][i]] == frontColor) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1 && !isBiPartite(i, graph, color, queue)) {
                return false;
            }
        }

        return true;
    }
}

// class Solution {

//    // This will return
//    // -1 if can't color currentIndex
//    // 0 if color currentIndex with 0
//    // 1 if color currentIndex with 1
//    private int isCurrentIndexNeighborsHas2Colors(int[] graph, boolean[] visited, int[] color) {

//        boolean found0Color = false;
//        boolean found1Color = false;

//        for (int currentNeighbor : graph) {
//            if (visited[currentNeighbor]) {
//                if (color[currentNeighbor] == 0) {
//                    found0Color = true;
//                } else if (color[currentNeighbor] == 1) {
//                    found1Color = true;
//                }
//                if (found0Color && found1Color) {
//                    return -1;
//                }
//            }
//        }

//        if (found0Color) {
//            return 1;
//        }
//        return 0;
//    }

//    private boolean isBiPartite(int currentIndex, int[][] graph, boolean[] visited, int[] color, Queue<Integer> queue) {
//        queue.add(currentIndex);
//        while (!queue.isEmpty()) {
//            Integer front = queue.remove();
//            int frontColor = isCurrentIndexNeighborsHas2Colors(graph[front], visited, color);
//            if (frontColor == -1) {
//                return false;
//            }
//            visited[front] = true;
//            color[front] = frontColor;

//            for (int i = 0; i < graph[front].length; i++) {
//                if (!visited[graph[front][i]]) {
//                    queue.add(graph[front][i]);
//                }
//            }
//        }
//        return true;
//    }

//    public boolean isBipartite(int[][] graph) {
//        boolean[] visited = new boolean[graph.length];
//        Arrays.fill(visited, false);

//        int[] color = new int[graph.length];
//        Arrays.fill(color, -1);

//        Queue<Integer> queue = new LinkedList<>();

//        for (int i = 0; i < graph.length; i++) {
//            if (!visited[i] && !isBiPartite(i, graph, visited, color, queue)) {
//                return false;
//            }
//        }

//        return true;
//    }
// }

// BackTracking
// class Solution {

//    private boolean isPossibleToColorCurrentNodeWithCurrentColor(int[] graph, int[] color, int currentColor) {

//        for (int currentNeighbor : graph) {
//            if (color[currentNeighbor] == currentColor) {
//                return false;
//            }
//        }

//        return true;
//    }

//    private boolean isBipartite(int currentIndex, int[][] graph, int[] color) {
//        if (currentIndex == graph.length) {
//            return true;
//        }

//        for (int i = 1; i <= 2; i++) {
//            if (isPossibleToColorCurrentNodeWithCurrentColor(graph[currentIndex], color, i)) {
//                color[currentIndex] = i;
//                if (isBipartite(currentIndex + 1, graph, color)) {
//                    return true;
//                }
//                color[currentIndex] = -1;
//            }
//        }

//        return false;
//    }

//    public boolean isBipartite(int[][] graph) {
//        int[] color = new int[graph.length];
//        Arrays.fill(color, -1);
//        return isBipartite(0, graph, color);
//    }
// }

public class Main {
    public static void main(String[] args) {

    }
}