package org.example.Daily._2025.January._27;

import java.util.*;

// https://leetcode.com/problems/course-schedule-iv/
public class _1462_Course_Schedule_IV {
    private void fillParentDependenciesIntoChild(int child, int parent, boolean[][] dependencies) {
        dependencies[child][parent] = true;
        for (int i = 0; i < dependencies.length; i++) {
            if (dependencies[parent][i]) {
                dependencies[child][i] = true;
            }
        }
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        List<List<Integer>> graph = new ArrayList<>();
        boolean[][] dependencies = new boolean[numCourses][numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        for (int[] currentPrerequisite : prerequisites) {
            // Adding reversed graph because we will build from parent to child.
            // Parent's dependencies will be passed from parent to child.
            // Whatever parent's depends upon, child will depend on that + child
            // will also depend on parent.
            graph.get(currentPrerequisite[1]).add(currentPrerequisite[0]);
            inDegree[currentPrerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer front = queue.remove();

            for (Integer currentNeighbor : graph.get(front)) {
                fillParentDependenciesIntoChild(currentNeighbor, front, dependencies);
                inDegree[currentNeighbor]--;
                if (inDegree[currentNeighbor] == 0) {
                    queue.add(currentNeighbor);
                }
            }
        }

        List<Boolean> answer = new ArrayList<>();

        for (int[] query : queries) {
            answer.add(dependencies[query[0]][query[1]]);
        }

        return answer;
    }
}
