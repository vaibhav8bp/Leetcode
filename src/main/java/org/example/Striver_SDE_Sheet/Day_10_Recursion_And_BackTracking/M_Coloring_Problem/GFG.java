package org.example.Striver_SDE_Sheet.Day_10_Recursion_And_BackTracking.M_Coloring_Problem;

import java.util.*;


class solve {

    private boolean isSafeToColorGivenNodeWithGivenColor(boolean[][] graph, int[] color, int currentNode, int currentColor, int n) {
        for (int i = 0; i < n; i++) {
            if (graph[currentNode][i] && currentColor == color[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean graphColoringHelper(boolean[][] graph, int[] color, int currentNode, int m, int n) {
        if (currentNode == n) {
            return true;
        }

        for (int i = 1; i <= m; i++) {
            if (isSafeToColorGivenNodeWithGivenColor(graph, color, currentNode, i, n)) {
                color[currentNode] = i;
                if (graphColoringHelper(graph, color, currentNode + 1, m, n)) {
                    return true;
                }
                color[currentNode] = -1;
            }
        }

        return false;

    }

    public boolean graphColoring(boolean[][] graph, int m, int n) {
        int[] color = new int[n];
        Arrays.fill(color, -1);
        return graphColoringHelper(graph, color,0, m, n);
    }
}

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean[][] graph = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

//1
//4 3 5
//1 2 2 3 3 4 4 1 1 3