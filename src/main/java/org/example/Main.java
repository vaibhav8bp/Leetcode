package org.example;

import org.example.Weekly._436._3449_Maximize_the_Minimum_Game_Score;

public class Main {
    public static void main(String[] args) {
//        _3428_Maximum_and_Minimum_Sums_of_at_Most_Size_K_Subsequences a = new _3428_Maximum_and_Minimum_Sums_of_at_Most_Size_K_Subsequences();
//        int[] nums = {1,1,1};
//        int k = 2;
//        System.out.println(a.minMaxSums(nums, k));

//        Q3_Maximum_Frequency_After_Subarray_Operation a = new Q3_Maximum_Frequency_After_Subarray_Operation();
//        int[] nums = {10, 6};
//        System.out.println(a.maxFrequency(nums, 8));

        _3449_Maximize_the_Minimum_Game_Score a = new _3449_Maximize_the_Minimum_Game_Score();
        System.out.println(a.maxScore(new int[]{2, 4}, 3));
        System.out.println(a.maxScore(new int[]{1, 2, 3}, 5));
    }
}