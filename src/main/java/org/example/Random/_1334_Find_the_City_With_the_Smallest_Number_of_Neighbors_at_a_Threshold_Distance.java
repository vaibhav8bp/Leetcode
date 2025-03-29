package org.example.Random;

import java.util.Arrays;

// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/
public class _1334_Find_the_City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance {

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], -1);
        }

        for (int[] currentEdge : edges) {
            int source = currentEdge[0];
            int destination = currentEdge[1];
            int weight = currentEdge[2];

            matrix[source][source] = 0;
            matrix[destination][destination] = 0;
            matrix[source][destination] = weight;
            matrix[destination][source] = weight;
        }

        for (int iteration = 0; iteration < n; iteration++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j || matrix[i][iteration] == -1 || matrix[iteration][j] == -1) {
                        continue;
                    } else if (matrix[i][j] == -1) {
                        matrix[i][j] = matrix[i][iteration] + matrix[iteration][j];
                    } else {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][iteration] + matrix[iteration][j]);
                    }
                }
            }
        }

        int minCities = Integer.MAX_VALUE;
        int index = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int currentCities = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && matrix[i][j] <= distanceThreshold) {
                    currentCities++;
                }
            }
            if (currentCities < minCities) {
                minCities = currentCities;
                index = i;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        int distanceThreshold = 4;
        System.out.println(findTheCity(n, edges, distanceThreshold));
    }
}
