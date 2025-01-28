package org.example.Daily._2025.January._26;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/maximum-employees-to-be-invited-to-a-meeting/
public class _2127_Maximum_Employees_to_Be_Invited_to_a_Meeting {
    public int maximumInvitations(int[] favorite) {

        // What we can deduce is that there are n nodes in the graph and exactly n edges
        // because everyone wants to sit with someone.

        // So there will definitely be a cycle because each node has only 1 outgoing edge. Therefore,
        // there will definitely be a cycle of in this directed graph.

        // 0 -> 1 -> 2 -> 3 -> 1
        // Output is 1,2,3 , Cannot Include 0

        // 0 -> 1 -> 2 <-> 3
        // Output here is 0, 1, 2, 3
        // This also has cycle so for 2 length cycle, so we connect this to other components
        // to maximise our output

        // Possible Output -
        // 1. Length of Longest Cycle Present in the graph.
        // 2. A 2 cycle component which can be connected to other path. Max Length that can be formed of this path.

        // Output is max. of 1 and 2

        boolean[] visited = new boolean[favorite.length];
        int[] inDegree = new int[favorite.length];
        int[] chainLength = new int[favorite.length];

        for (Integer currentFavoritePerson : favorite) {
            inDegree[currentFavoritePerson]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < favorite.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer front = queue.remove();
            visited[front] = true;
            inDegree[favorite[front]]--;
            // No need to use max as nodes will be pushed in queue orderly fashion
            // only when there are no predecessor left to them.
            chainLength[favorite[front]] = chainLength[front] + 1;
            if (inDegree[favorite[front]] == 0) {
                queue.add(favorite[front]);
            }
        }

        int maxCycleLength = 0;
        int maxPathLengthOf2LengthCycle = 0;

        for (int i = 0; i < favorite.length; i++) {

            int currentPerson = i;
            if (!visited[i]) {
                int cycleLength = 0;
                while (!visited[currentPerson]) {
                    visited[currentPerson] = true;
                    cycleLength++;
                    currentPerson = favorite[currentPerson];
                }

                if (cycleLength == 2) {
                    maxPathLengthOf2LengthCycle += 2 + chainLength[i] + chainLength[favorite[i]];
                } else {
                    maxCycleLength = Math.max(maxCycleLength, cycleLength);
                }
            }
        }

        return Math.max(maxCycleLength, maxPathLengthOf2LengthCycle);
    }
}
