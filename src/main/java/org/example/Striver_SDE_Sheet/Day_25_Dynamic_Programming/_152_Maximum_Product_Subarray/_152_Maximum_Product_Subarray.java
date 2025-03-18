package org.example.Striver_SDE_Sheet.Day_25_Dynamic_Programming._152_Maximum_Product_Subarray;

// https://leetcode.com/problems/maximum-product-subarray/
public class _152_Maximum_Product_Subarray {

    public static int maxProduct(int[] nums) {
        int maxProductSoFar = nums[0];
        int minProductSoFar = nums[0];

        int overallMaxProduct = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempMaxHolder = maxProductSoFar;
            maxProductSoFar = Math.max(maxProductSoFar * nums[i], Math.max(minProductSoFar * nums[i], nums[i]));
            // If Odd No. of One's we have to leave either left most -ve element/ right most -ve element.
            // Consider example -++-
            // before i=3
            // maxProductSoFar has product of ++
            // minProductSoFar has product of -++;
            // for i=3
            // maxProductSoFar becomes -++-
            // and minProductSoFar becomes ++- (leaving previous, -++ has already been considered)
            // Considering nums[i] at every step, for zeros
            minProductSoFar = Math.min(tempMaxHolder * nums[i], Math.min(minProductSoFar * nums[i], nums[i]));
            overallMaxProduct = Math.max(overallMaxProduct, maxProductSoFar);
        }

        return overallMaxProduct;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
    }
}