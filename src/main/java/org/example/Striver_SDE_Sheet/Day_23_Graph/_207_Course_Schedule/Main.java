package org.example.Striver_SDE_Sheet.Day_23_Graph._207_Course_Schedule;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// DFS
// class Solution {

//     private boolean isDetectCycle(int currentIndex, boolean[] visited, List<Integer>[] matrix) {
//         if (visited[currentIndex]) {
//             return true;
//         }

//         visited[currentIndex] = true;

//         for (int i = 0; i < matrix[currentIndex].size(); i++) {
//             if (isDetectCycle(matrix[currentIndex].get(i), visited, matrix)) {
//                 return true;
//             }
//         }

//         visited[currentIndex] = false;
//         return false;
//     }

//     public boolean canFinish(int numCourses, int[][] prerequisites) {

//         List<Integer>[] matrix = new ArrayList[numCourses];
//         boolean[] visited = new boolean[numCourses];
//         Arrays.fill(visited, false);

//         for (int i = 0; i < numCourses; i++) {
//             matrix[i] = new ArrayList<>();
//         }

//         for (int i = 0; i < prerequisites.length; i++) {
//             matrix[prerequisites[i][0]].add(prerequisites[i][1]);
//         }

//         for (int i = 0; i < numCourses; i++) {
//             if (isDetectCycle(i, visited, matrix)) {
//                 return false;
//             }
//         }

//         return true;
//     }
// }

// BFS
class Solution {
   public boolean canFinish(int numCourses, int[][] prerequisites) {

       if (prerequisites == null || prerequisites.length == 0) {
           return true;
       }

       Queue<Integer> queue = new LinkedList<>();
       int[][] matrix = new int[numCourses][numCourses];
       int[] degree = new int[numCourses];
       int countOfCourseDone = 0;

       for (int i = 0; i < numCourses; i++) {
           Arrays.fill(matrix[i], 0);
       }

       Arrays.fill(degree, 0);

       for (int i = 0; i < prerequisites.length; i++) {
           // Condition on i should be before j. So condition is on j. Therefore incrementing degree of j
           degree[prerequisites[i][1]]++;
           matrix[prerequisites[i][0]][prerequisites[i][1]] = 1;
       }

       for (int i = 0; i < numCourses; i++) {
           // These have no restriction can just execute these courses.
           if (degree[i] == 0) {
               countOfCourseDone++;
               queue.add(i);
           }
       }

       while (!queue.isEmpty()) {
           Integer front = queue.remove();
           for (int i = 0; i < numCourses; i++) {
               if (matrix[front][i] == 1) {
                   degree[i]--;
                   if (degree[i] == 0) {
                       queue.add(i);
                       countOfCourseDone++;
                   }
               }
           }
       }

       return countOfCourseDone == numCourses;
   }
}

public class Main {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println(new Solution().canFinish(numCourses, prerequisites));
    }
}
