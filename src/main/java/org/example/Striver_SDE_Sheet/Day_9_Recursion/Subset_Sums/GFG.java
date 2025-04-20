package org.example.Striver_SDE_Sheet.Day_9_Recursion.Subset_Sums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://www.geeksforgeeks.org/problems/subset-sums2234/1
// Recursion
class Solution {

    void subsetSumsHelper(ArrayList<Integer> arr, int currentIndex, int sumTillNow, ArrayList<Integer> sumArray) {
        if (currentIndex == arr.size()) {
            sumArray.add(sumTillNow);
            return;
        }

        // Excluding Current Index Element
        subsetSumsHelper(arr, currentIndex + 1, sumTillNow, sumArray);

        // Including Current Index Element
        subsetSumsHelper(arr, currentIndex + 1, sumTillNow + arr.get(currentIndex), sumArray);
    }

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> sumArrayList = new ArrayList<>();
        subsetSumsHelper(arr, 0, 0, sumArrayList);
        return sumArrayList;
    }
}

public class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(sc.nextInt());
            }
            Solution ob = new Solution();

            ArrayList<Integer> ans = ob.subsetSums(arr, N);
            Collections.sort(ans);
            for (int sum : ans) {
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}