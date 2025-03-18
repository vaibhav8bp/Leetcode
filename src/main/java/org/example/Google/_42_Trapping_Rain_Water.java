package org.example.Google;

import java.util.Arrays;

// https://leetcode.com/problems/trapping-rain-water/
public class _42_Trapping_Rain_Water {

    public int trap(int[] height) {

        if (height.length <= 2) {
            return 0;
        }

        int trappedWater = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += (leftMax - height[left]);
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    trappedWater +=  (rightMax - height[right]);
                }
                right--;
            }
        }

        return trappedWater;
    }

//    public int trap(int[] height) {
//
//        if (height.length <= 2) {
//            return 0;
//        }
//
//        int trappedWater = 0;
//        int[] nextGreater = new int[height.length - 2];
//        int[] previousGreater = new int[height.length - 2];
//        previousGreater[0] = height[0];
//        for (int i = 1; i < height.length - 2; i++) {
//            previousGreater[i] = Math.max(height[i], previousGreater[i - 1]);
//        }
//        nextGreater[height.length - 3] = height[height.length - 1];
//
//        for (int i = height.length - 4; i >= 0; i--) {
//            nextGreater[i] = Math.max(nextGreater[i + 1], height[i + 2]);
//        }
//
//        for (int i = 1; i < height.length - 1; i++) {
//            if (nextGreater[i - 1] > height[i] && previousGreater[i - 1] > height[i]) {
//                trappedWater += (Math.min(nextGreater[i - 1], previousGreater[i - 1]) - height[i]);
//            }
//        }
//
//        return trappedWater;
//    }
}
