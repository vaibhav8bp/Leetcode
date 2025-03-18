package org.example.Striver_SDE_Sheet.Day_14_Stack_And_Queue_Part_II._Maximum_of_minimum_for_every_window_size;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

class Solution {

    private static void formulatePreviousSmaller(int[] arr, int n, Stack<Integer> stack, int[] previousSmaller) {
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                previousSmaller[i] = -1;
            } else {
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    previousSmaller[i] = -1;
                } else {
                    previousSmaller[i] = stack.peek();
                }
            }
            stack.add(i);
        }
    }

    private static void formulateNextSmaller(int[] arr, int n, Stack<Integer> stack, int[] nextSmaller) {
        stack.add(0);
        for (int i = 1; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || arr[stack.peek()] > arr[i])) {
                nextSmaller[stack.peek()] = i;
                stack.pop();
            }
            stack.add(i);
        }
    }

    static int[] maxOfMin(int[] arr, int n) {
        int[] previousSmaller = new int[n];
        int[] nextSmaller = new int[n];

        Stack<Integer> stack = new Stack<>();
        formulatePreviousSmaller(arr, n, stack, previousSmaller);
        stack.clear();
        formulateNextSmaller(arr, n, stack, nextSmaller);

        int[] result = new int[n];
        Arrays.fill(result, 0);

        for (int i = 0; i < n; i++) {
            // One more -1 for avoiding n+1 length array
            result[nextSmaller[i] - previousSmaller[i] - 1 - 1] = Math.max(result[nextSmaller[i] - previousSmaller[i] - 1 - 1], arr[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            result[i] = Math.max(result[i], result[i + 1]);
        }

        return result;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            int[] res = Solution.maxOfMin(arr, n);

            for (int i = 0; i < n; i++)
                System.out.print (res[i] + " ");
            System.out.println ();
        }
    }
}
