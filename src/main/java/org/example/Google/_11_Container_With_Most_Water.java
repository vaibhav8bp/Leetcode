package org.example.Google;

// https://leetcode.com/problems/container-with-most-water/description/
public class _11_Container_With_Most_Water {

    // Optimized - 2 Pointer Approach

    // Take 2 pointers left and right, move on smaller side.
    // Why ?
    // let's say height[l] < height[r]
    // current width that is r-l is the biggest width possible currently,
    // and we know l's height is also less than r's height, so can l contribute to maxArea ?
    // it will never be able to contribute to maxArea because if we decrease r width will decrease for sure
    // but will height increase ? no max height a tower can contribute is = to its own height.
    // So for area to increase either width/ height should increase, here neither are happening.
    // Therefore, always move less heights pointer.

    public int maxArea(int[] height) {

        int maxArea = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int currentWidth = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    // O(N^2) Brute Force
//    public int maxArea(int[] height) {
//
//        int maxArea = 0;
//
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                int currentWidth = j - i;
//                int currentHeight = Math.min(height[i], height[j]);
//                maxArea = Math.max(maxArea, currentHeight * currentWidth);
//            }
//        }
//
//        return maxArea;
//    }
}
