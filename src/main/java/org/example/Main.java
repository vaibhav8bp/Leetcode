package org.example;


import org.example.Weekly._433._3428_Maximum_and_Minimum_Sums_of_at_Most_Size_K_Subsequences;

public class Main {
    public static void main(String[] args) {
//        _2429_Minimize_XOR a = new _2429_Minimize_XOR();
//        System.out.println(a.minimizeXor(12, 12));

        _3428_Maximum_and_Minimum_Sums_of_at_Most_Size_K_Subsequences a = new _3428_Maximum_and_Minimum_Sums_of_at_Most_Size_K_Subsequences();
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(a.minMaxSums(nums, k));
    }
}