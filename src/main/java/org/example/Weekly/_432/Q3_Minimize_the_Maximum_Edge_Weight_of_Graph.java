package org.example.Weekly._432;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Edge {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

public class Q3_Minimize_the_Maximum_Edge_Weight_of_Graph {

    private boolean isEdgeRemovalPossible(int n, List<Edge> newEdges, PriorityQueue<Edge> maxWeightPriorityQueue, int threshold) {
        return true;
    }

    private int minMaxWeightHelper(int n, List<Edge> newEdges, PriorityQueue<Edge> maxWeightPriorityQueue, int threshold) {
        return 0;
    }

    public int minMaxWeight(int n, int[][] edges, int threshold) {

        Comparator<Edge> maxWeightComparator = (o1, o2) -> o2.weight = o1.weight;
        PriorityQueue<Edge> maxWeightPriorityQueue = new PriorityQueue<>(maxWeightComparator);

        List<Edge> newEdges = new ArrayList<>();

        for (int[] currentEdge : edges) {
            Edge edge = new Edge(currentEdge[0], currentEdge[1], currentEdge[2]);
            newEdges.add(edge);
            maxWeightPriorityQueue.add(edge);
        }

        return minMaxWeightHelper(n, newEdges, maxWeightPriorityQueue, threshold);
    }
}
