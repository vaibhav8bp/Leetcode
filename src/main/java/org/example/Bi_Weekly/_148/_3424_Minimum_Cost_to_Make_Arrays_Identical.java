package org.example.Bi_Weekly._148;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-cost-to-make-arrays-identical/

public class _3424_Minimum_Cost_to_Make_Arrays_Identical {

    public long minCost(int[] arr, int[] brr, long k) {

        long withoutChangingOrderingDifference = 0;

        for (int i = 0; i < arr.length; i++) {
            withoutChangingOrderingDifference += (Math.abs(brr[i] - arr[i]));
        }

        long changingOrderingDifference = k;

        Arrays.sort(arr);
        Arrays.sort(brr);

        for (int i = 0; i < arr.length; i++) {
            changingOrderingDifference += (Math.abs(brr[i] - arr[i]));
        }

        return Math.min(withoutChangingOrderingDifference, changingOrderingDifference);
    }
}
