package org.example;

import org.example.Daily._2025.January._28._2658_Maximum_Number_of_Fish_in_a_Grid;

public class Main {
    public static void main(String[] args) {
//        _3428_Maximum_and_Minimum_Sums_of_at_Most_Size_K_Subsequences a = new _3428_Maximum_and_Minimum_Sums_of_at_Most_Size_K_Subsequences();
//        int[] nums = {1,1,1};
//        int k = 2;
//        System.out.println(a.minMaxSums(nums, k));

//        Q3_Maximum_Frequency_After_Subarray_Operation a = new Q3_Maximum_Frequency_After_Subarray_Operation();
//        int[] nums = {10, 6};
//        System.out.println(a.maxFrequency(nums, 8));

        _2658_Maximum_Number_of_Fish_in_a_Grid a = new _2658_Maximum_Number_of_Fish_in_a_Grid();
        int[][] grid = {{0, 2, 1, 0}, {4, 0, 0, 3}, {1, 0, 0, 4}, {0, 3, 2, 0}};
        int[][] grid1 = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 1}};
        System.out.println(a.findMaxFish(grid));
        System.out.println(a.findMaxFish(grid1));
    }
}