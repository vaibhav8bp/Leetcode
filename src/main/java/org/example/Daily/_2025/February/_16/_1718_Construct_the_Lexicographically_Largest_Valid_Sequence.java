package org.example.Daily._2025.February._16;

// https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/
public class _1718_Construct_the_Lexicographically_Largest_Valid_Sequence {

    private boolean constructDistancedSequenceHelper(int currentIndex, int n, int[] result, boolean[] visited) {
        // Find First Vacant Index

        while (currentIndex < result.length && result[currentIndex] != 0) {
            currentIndex++;
        }

        if (currentIndex == result.length) {
            return true;
        }

        for (int i = n; i >= 1; i--) {
            if (visited[i - 1]) {
                continue;
            }
            if (i == 1) {
                result[currentIndex] = i;
                visited[i - 1] = true;
                if (constructDistancedSequenceHelper(currentIndex + 1, n, result, visited)) {
                    return true;
                }
                result[currentIndex] = 0;
                visited[i - 1] = false;
            } else {
                if ((currentIndex + i) < result.length && result[currentIndex + i] == 0) {
                    result[currentIndex] = i;
                    result[currentIndex + i] = i;
                    visited[i - 1] = true;
                    if (constructDistancedSequenceHelper(currentIndex + 1, n, result, visited)) {
                        return true;
                    }
                    result[currentIndex] = 0;
                    result[currentIndex + i] = 0;
                    visited[i - 1] = false;
                }
            }
        }

        return false;
    }

    public int[] constructDistancedSequence(int n) {
        int[] result = new int[2 * n - 1];
        boolean[] visited = new boolean[n];
        if (constructDistancedSequenceHelper(0, n, result, visited)) {
            return result;
        }
        return null;
    }
}
