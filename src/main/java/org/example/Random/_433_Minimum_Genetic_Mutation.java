package org.example.Random;

import java.util.*;

// https://leetcode.com/problems/minimum-genetic-mutation/description/
public class _433_Minimum_Genetic_Mutation {

    private final char[] characters = {'A', 'C', 'G', 'T'};

    public int minMutation(String startGene, String endGene, String[] bank) {

        if (Objects.equals(startGene, endGene)) {
            return 0;
        }

        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        if (!bankSet.contains(endGene)) {
            return -1;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                String front = queue.remove();

                if (visited.contains(front)) {
                    size--;
                    continue;
                }

                visited.add(front);

                if (front.equals(endGene)) {
                    return level;
                }

                char[] frontCharacterArray = front.toCharArray();

                for (int i = 0; i < frontCharacterArray.length; i++) {
                    char originalCharacter = frontCharacterArray[i];
                    for (Character currentCharacter : characters) {
                        if (currentCharacter == frontCharacterArray[i]) {
                            continue;
                        }
                        frontCharacterArray[i] = currentCharacter;
                        if (bankSet.contains(String.valueOf(frontCharacterArray)) && !visited.contains(String.valueOf(frontCharacterArray))) {
                            queue.add(String.valueOf(frontCharacterArray));
                        }
                        frontCharacterArray[i] = originalCharacter;
                    }
                }
                size--;
            }

            level++;
        }

        return -1;
    }

//    private boolean areStringsNeighbor(String a, String b) {
//        int index = 0;
//        int length = a.length();
//
//        int diffPlaced = 0;
//
//        while (index != length) {
//            if (a.charAt(index) != b.charAt(index)) {
//                if (diffPlaced == 1) {
//                    return false;
//                }
//                diffPlaced = 1;
//            }
//            index++;
//        }
//
//        // Not returning true because strings can be identical too.
//        return diffPlaced == 1;
//    }
//
//    private void graphFormation(String startGene, String[] bank, List<Integer>[] graph) {
//
//        for (int i = 0; i < bank.length + 1; i++) {
//            graph[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < bank.length; i++) {
//            for (int j = i + 1; j < bank.length; j++) {
//                if (areStringsNeighbor(bank[i], bank[j])) {
//                    graph[i].add(j);
//                    graph[j].add(i);
//                }
//            }
//        }
//
//        // bank.length index will be for startGene
//        for (int i = 0; i < bank.length; i++) {
//            if (areStringsNeighbor(startGene, bank[i])) {
//                graph[bank.length].add(i);
//                graph[i].add(bank.length);
//            }
//        }
//    }
//
//    private int findEndGenIndex(String endGene, String[] bank) {
//        for (int i = 0; i < bank.length; i++) {
//            if (bank[i].equals(endGene)) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    public int minMutation(String startGene, String endGene, String[] bank) {
//
//        if (Objects.equals(startGene, endGene)) {
//            return 0;
//        }
//
//        int endGeneIndex = findEndGenIndex(endGene, bank);
//
//        if (endGeneIndex == -1) {
//            return -1;
//        }
//
//        int n = bank.length + 1;
//        List<Integer>[] graph = new ArrayList[n];
//        graphFormation(startGene, bank, graph);
//
//        // Now we have to find min. distance to reach from bank.length index to endGeneIndex.
//
//        boolean[] visited = new boolean[n];
//        int[] distance = new int[n];
//        Arrays.fill(visited, false);
//        Arrays.fill(distance, Integer.MAX_VALUE);
//
//        distance[n - 1] = 0;
//
//        // {distance,vertex} will be pushed.
//        PriorityQueue<int[]> minPQ = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
//        minPQ.add(new int[]{0, n - 1});
//
//        while (!minPQ.isEmpty()) {
//            int[] front = minPQ.remove();
//            int currentVertex = front[1];
//            if (visited[currentVertex]) {
//                continue;
//            }
//            visited[currentVertex] = true;
//            int currentDistance = front[0];
//
//            for (Integer currentNeighbor : graph[currentVertex]) {
//                if (currentDistance + 1 < distance[currentNeighbor]) {
//                    distance[currentNeighbor] = currentDistance + 1;
//                    minPQ.add(new int[]{distance[currentNeighbor], currentNeighbor});
//                }
//            }
//        }
//
//        if (distance[endGeneIndex] == Integer.MAX_VALUE) {
//            return -1;
//        }
//
//        return distance[endGeneIndex];
//    }
}
