package org.example.Striver_SDE_Sheet.Day_14_Stack_And_Queue_Part_II._84_Largest_Rectangle_In_Histogram;

import java.util.Stack;

// https://leetcode.com/problems/largest-rectangle-in-histogram/description/
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        for (int i = 1; i <= heights.length; i++) {
            while (!stack.empty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
                int currentHeight = heights[stack.peek()];
                stack.pop();
                int currentWidth;
                if (stack.empty()) {
                    currentWidth = i;
                } else {
                    currentWidth = i - stack.peek() - 1;
                }
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.add(i);
        }
        return maxArea;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] heights = {2, 4};
        System.out.println(new Solution().largestRectangleArea(heights));
    }
}
