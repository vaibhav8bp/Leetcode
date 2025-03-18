package org.example.Google;

import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/largest-rectangle-in-histogram/description/
public class _84_Largest_Rectangle_in_Histogram {

    // 0  1  2  3  4  5
    // 2, 1, 5, 6, 2, 3

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> increasingHeightStack = new Stack<>();
        increasingHeightStack.add(0);

        for (int i = 1; i <= heights.length; i++) {
            while (!increasingHeightStack.isEmpty() && ((i == heights.length) || heights[increasingHeightStack.peek()] >= heights[i])) {
                int currentIndex = increasingHeightStack.pop();
                int left = (increasingHeightStack.isEmpty()) ? -1 : increasingHeightStack.peek();
                maxArea = Math.max(maxArea, (i - left - 1) * heights[currentIndex]);
            }
            increasingHeightStack.add(i);
        }

        return maxArea;
    }

//    public static int largestRectangleArea(int[] heights) {
//        int maxArea = 0;
//        Stack<Integer> increasingHeightStack = new Stack<>();
//        increasingHeightStack.add(0);
//
//        for (int i = 1; i < heights.length; i++) {
//            while (!increasingHeightStack.isEmpty() && heights[increasingHeightStack.peek()] >= heights[i]) {
//                int currentIndex = increasingHeightStack.pop();
//                int left = (increasingHeightStack.isEmpty()) ? -1 : increasingHeightStack.peek();
//                maxArea = Math.max(maxArea, (i - left - 1) * heights[currentIndex]);
//            }
//            increasingHeightStack.add(i);
//        }
//
//        while (!increasingHeightStack.isEmpty()) {
//            int currentIndex = increasingHeightStack.pop();
//            int left = (increasingHeightStack.isEmpty()) ? -1 : increasingHeightStack.peek();
//            maxArea = Math.max(maxArea, (heights.length - left - 1) * heights[currentIndex]);
//        }
//
//        return maxArea;
//    }

//    static void populateLeftSmallerHeights(int[] heights, int[] leftSmallerHeights) {
//        Stack<Integer> leftSmallerStack = new Stack<>();
//        leftSmallerHeights[0] = -1;
//        leftSmallerStack.add(0);
//        for (int i = 1; i < heights.length; i++) {
//            while (!leftSmallerStack.isEmpty() && heights[leftSmallerStack.peek()] >= heights[i]) {
//                leftSmallerStack.pop();
//            }
//            if (leftSmallerStack.empty()) {
//                leftSmallerHeights[i] = -1;
//            } else {
//                leftSmallerHeights[i] = leftSmallerStack.peek();
//            }
//            leftSmallerStack.add(i);
//        }
//    }
//
//    static void populateRightSmallerHeights(int[] heights, int[] rightSmallerHeights) {
//        Stack<Integer> rightSmallerStack = new Stack<>();
//        rightSmallerHeights[rightSmallerHeights.length - 1] = rightSmallerHeights.length;
//        rightSmallerStack.add(rightSmallerHeights.length - 1);
//
//        for (int i = heights.length - 2; i >= 0; i--) {
//            while (!rightSmallerStack.isEmpty() && heights[rightSmallerStack.peek()] >= heights[i]) {
//                rightSmallerStack.pop();
//            }
//            if (rightSmallerStack.empty()) {
//                rightSmallerHeights[i] = rightSmallerHeights.length;
//            } else {
//                rightSmallerHeights[i] = rightSmallerStack.peek();
//            }
//            rightSmallerStack.add(i);
//        }
//    }
//
//    public static int largestRectangleArea(int[] heights) {
//        int[] leftSmallerHeights = new int[heights.length];
//        int[] rightSmallerHeights = new int[heights.length];
//        populateLeftSmallerHeights(heights, leftSmallerHeights);
//        populateRightSmallerHeights(heights, rightSmallerHeights);
//        int maxArea = 0;
//        for (int i = 0; i < heights.length; i++) {
//            int length = heights[i];
//            int width = (rightSmallerHeights[i] - 1) - (leftSmallerHeights[i] + 1) + 1;
//            maxArea = Math.max(maxArea, length * width);
//        }
//
//        return maxArea;
//    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
