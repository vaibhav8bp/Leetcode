package org.example.Daily._2025.March._8;

// https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/
public class _2379_Minimum_Recolors_to_Get_K_Consecutive_Black_Blocks {
    public int minimumRecolors(String blocks, int k) {
        int whiteBlocksSoFar = 0;

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteBlocksSoFar++;
            }
        }

        if (whiteBlocksSoFar == 0 || k == blocks.length()) {
            return whiteBlocksSoFar;
        }

        int minimumOperations = whiteBlocksSoFar;

        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i - k) == 'W') {
                whiteBlocksSoFar--;
            }
            if (blocks.charAt(i) == 'W') {
                whiteBlocksSoFar++;
            }
            minimumOperations = Math.min(minimumOperations, whiteBlocksSoFar);
        }

        return minimumOperations;
    }
}
