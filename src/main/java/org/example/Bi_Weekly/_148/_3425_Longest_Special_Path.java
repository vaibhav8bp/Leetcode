//package org.example.Bi_Weekly._148;
//
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Set;
//

// https://leetcode.com/problems/longest-special-path/

// TODO: Pending
//class Answer {
//    int lengthOfSpecialPath;
//    int numberOfNodesInPath;
//    boolean isPathValid;
//
//    public Answer(int lengthOfSpecialPath, int numberOfNodesInPath, boolean isPathValid) {
//        this.lengthOfSpecialPath = lengthOfSpecialPath;
//        this.numberOfNodesInPath = numberOfNodesInPath;
//        this.isPathValid = isPathValid;
//    }
//}
//
//public class Q3_Longest_Special_Path {
//
//    private Answer returnLongestSpecialPathHelper(int currentLength, int currentVertex, int[][] graph, int[] nums, Set<Integer> valuesInPath) {
//
//        if (currentVertex == graph.length - 1) {
//            return new Answer(currentLength, valuesInPath.size(), true);
//        }
//
//        currentLength += nums[currentVertex];
//
//        Answer currentAnswer = new Answer(currentLength, valuesInPath.size(), false);
//
//        for (int i = 0; i < graph[currentVertex].length; i++) {
//            // If No Edge From Current Vertex or neighboring vertex's value already traversed, continue
//            if ((graph[currentVertex][i] == 0) || (valuesInPath.contains(nums[i]))) {
//                continue;
//            }
//
//            valuesInPath.add(nums[i]);
//            if (currentAnswer == null) {
//
//            } else {
//
//            }
////            int[] currentNeighBorResult = returnLongestSpecialPathHelper(i, graph, nums, valuesInPath);
//            valuesInPath.remove(nums[i]);
//        }
//
//        return currentAnswer;
//    }
//
//    public int[] longestSpecialPath(int[][] edges, int[] nums) {
//
//        int[][] graph = new int[nums.length][nums.length];
//
//        for (int[] ints : graph) {
//            Arrays.fill(ints, 0);
//        }
//
//        for (int[] currentEdge : edges) {
//            int source = currentEdge[0];
//            int destination = currentEdge[1];
//            int length = currentEdge[2];
//
//            graph[source][destination] = length;
//        }
//
////        Answer answer = returnLongestSpecialPathHelper(0, graph, nums, new HashSet<>());
//
////        int[] finalAnswer = new int[2];
////
////        if (answer.isPathValid) {
////            finalAnswer[1] = 1;
////        } else {
////            finalAnswer[0] = answer.lengthOfSpecialPath;
////            finalAnswer[1] = answer.numberOfNodesInPath;
////        }
////
////        return finalAnswer;
//    }
//}
