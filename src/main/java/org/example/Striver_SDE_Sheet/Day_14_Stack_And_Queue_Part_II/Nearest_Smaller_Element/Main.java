package org.example.Striver_SDE_Sheet.Day_14_Stack_And_Queue_Part_II.Nearest_Smaller_Element;

import java.util.Arrays;
import java.util.Stack;

// https://www.interviewbit.com/problems/nearest-smaller-element/
class Solution {
    public int[] prevSmaller(int[] A) {
        Stack<Integer> stack = new Stack<>();

        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                while (!stack.isEmpty() && stack.peek() >= A[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peek();
                }
            }
            stack.add(A[i]);
        }
        return result;
    }
}


public class Main {
    public static void main(String[] args) {
        int[] A = {3, 2, 1};
        System.out.println(Arrays.toString(new Solution().prevSmaller(A)));
    }
}
