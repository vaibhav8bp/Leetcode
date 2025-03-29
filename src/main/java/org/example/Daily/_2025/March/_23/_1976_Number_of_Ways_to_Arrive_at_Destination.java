package org.example.Daily._2025.March._23;

import java.util.*;

// https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/
public class _1976_Number_of_Ways_to_Arrive_at_Destination {

    private final int MODULO = (int) (1e9 + 7);

    private void graphFormation(int n, List<int[]>[] graph, int[][] roads) {
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] currentRoad : roads) {
            int source = currentRoad[0];
            int destination = currentRoad[1];
            int time = currentRoad[2];
            graph[source].add(new int[]{destination, time});
            graph[destination].add(new int[]{source, time});
        }
    }

    public int countPaths(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n];
        graphFormation(n, graph, roads);
        long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        int[] ways = new int[n];
        Arrays.fill(ways, 0);
        distance[0] = 0;
        ways[0] = 1;

        Comparator<long[]> minPQComparator = (Comparator.comparingLong(a -> a[1]));

        PriorityQueue<long[]> minPQ = new PriorityQueue<>(minPQComparator);
        // Soring is on the basis of min. distance which is the second element.
        minPQ.add(new long[]{0, 0});

        while (!minPQ.isEmpty()) {
            long[] front = minPQ.remove();
            int currentVertex = (int) front[0];
            long currentDistance = front[1];

            // To Avoid visited vertices.
            // Can maintain visited[] too.
            if (distance[currentVertex] < currentDistance) {
                continue;
            }

            for (int[] neighbour : graph[currentVertex]) {
                int neighbourVertex = neighbour[0];
                int neighbourDistance = neighbour[1];

                if (currentDistance + neighbourDistance < distance[neighbourVertex]) {
                    distance[neighbourVertex] = currentDistance + neighbourDistance;
                    ways[neighbourVertex] = ways[currentVertex];
                    minPQ.add(new long[]{neighbourVertex, distance[neighbourVertex]});
                } else if (currentDistance + neighbourDistance == distance[neighbourVertex]) {
                    ways[neighbourVertex] = (ways[neighbourVertex] + ways[currentVertex]) % MODULO;
                }
            }
        }

        return ways[n - 1];
    }
}
