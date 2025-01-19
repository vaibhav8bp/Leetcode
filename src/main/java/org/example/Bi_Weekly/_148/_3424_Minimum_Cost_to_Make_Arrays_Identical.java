package org.example.Bi_Weekly._148;

// https://leetcode.com/problems/minimum-cost-to-make-arrays-identical/
// TODO: Pending
public class _3424_Minimum_Cost_to_Make_Arrays_Identical {
    public long minCost(int[] arr, int[] brr, long k) {
        int[] relativeDifference = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            relativeDifference[i] = Math.abs(arr[i] - brr[i]);
        }



        return 0;
    }
}
