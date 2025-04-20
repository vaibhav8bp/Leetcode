package org.example.Striver_SDE_Sheet.Day_11_Binary_Search.Aggressive_Cows;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// https://www.spoj.com/problems/AGGRCOW/
class Solution {

    private static boolean areCowsAllocatableInCurrentDistance(int[] stalls, int N, int C, int currentDistance) {
        int lastPlacedStall = stalls[0];
        int cowsPlaced = 1;

        for (int i = 1; i < N; i++) {
            if ((stalls[i] - lastPlacedStall) >= currentDistance) {
                lastPlacedStall = stalls[i];
                cowsPlaced++;
                if (cowsPlaced == C) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[n - 1] - stalls[0];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (!areCowsAllocatableInCurrentDistance(stalls, n, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return high;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = Solution.solve(n, k, v);

            System.out.println(res);
        }
    }
}


//1
//5 3
//1 2 4 8 9