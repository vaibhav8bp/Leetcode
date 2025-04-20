package org.example.Striver_SDE_Sheet.Day_8_Greedy_Algorithm._455_Assign_Cookies;

import java.util.Arrays;

// https://leetcode.com/problems/assign-cookies/description/
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gPointer = 0;
        int sPointer = 0;

        while (gPointer < g.length && sPointer < s.length) {
            if (g[gPointer] <= s[sPointer]) {
                gPointer++;
            }
            sPointer++;
        }

        return gPointer;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        System.out.println(new Solution().findContentChildren(g, s));
    }
}
