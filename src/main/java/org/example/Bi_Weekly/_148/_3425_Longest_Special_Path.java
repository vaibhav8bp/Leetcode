package org.example.Bi_Weekly._148;

// https://leetcode.com/problems/longest-special-path/
// TODO : Wrong answer
import java.util.*;

public class _3425_Longest_Special_Path {

    private int[] findLongestSpecialPathFromCurrentIndex(int currentIndex, List<List<int[]>> graph, int[] nums, Set<Integer> currentValuesInPath, int[] parent) {
        currentValuesInPath.add(nums[currentIndex]);

        int[] answer = null;

        for (int[] currentNeighbor : graph.get(currentIndex)) {
            int destination = currentNeighbor[0];
            if (currentValuesInPath.contains(nums[destination]) || parent[currentIndex] == destination) {
                continue;
            }

            int weight = currentNeighbor[1];
            int[] recursivePath = findLongestSpecialPathFromCurrentIndex(destination, graph, nums, currentValuesInPath, parent);

            if (answer == null) {
                answer = new int[2];
                answer[0] = recursivePath[0] + weight;
                answer[1] = recursivePath[1] + 1;
            } else {
                if (answer[0] < (recursivePath[0] + weight)) {
                    answer[0] = recursivePath[0] + weight;
                    answer[1] = recursivePath[1] + 1;
                } else if (answer[0] == (recursivePath[0] + weight)) {
                    answer[1] = Math.min(answer[1], recursivePath[1] + 1);
                }
            }
        }

        currentValuesInPath.remove(nums[currentIndex]);
        if (answer == null) {
            answer = new int[]{0, 1};
        }
        return answer;
    }

    private void parentFinder(List<List<int[]>> graph, int[] parent) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int front = queue.remove();
            visited[front] = true;

            for (int[] currentNeighbor : graph.get(front)) {
                int currentDestination = currentNeighbor[0];
                if (!visited[currentDestination]) {
                    parent[currentDestination] = front;
                    queue.offer(currentDestination);
                }
            }
        }
    }

    public int[] longestSpecialPath(int[][] edges, int[] nums) {
        List<List<int[]>> graph = new ArrayList<>();

        int[] parent = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < nums.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] currentEdge : edges) {
            int source = currentEdge[0];
            int destination = currentEdge[1];
            int weight = currentEdge[2];
            graph.get(source).add(new int[]{destination, weight});
            graph.get(destination).add(new int[]{source, weight});
        }

        parentFinder(graph, parent);
        return findLongestSpecialPathFromCurrentIndex(0, graph, nums, new HashSet<>(), parent);

//        for (int i = 0; i < nums.length; i++) {
//            int[] currentAnswer = findLongestSpecialPathFromCurrentIndex(i, graph, nums, new HashSet<>(), parent);
//            if (answer[0] < currentAnswer[0]) {
//                answer[0] = currentAnswer[0];
//                answer[1] = currentAnswer[1];
//            } else if (answer[0] == currentAnswer[0]) {
//                answer[1] = Math.min(answer[1], currentAnswer[1]);
//            }
//        }

//        return answer;
    }
}