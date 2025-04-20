package org.example.Striver_SDE_Sheet.Day_13_Stack_And_Queue.Implement_Stack_Using_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.geeksforgeeks.org/problems/implement-stack-using-array/1
class MyStack {
    int top;
    int[] arr = new int[1000];

    MyStack() {
        top = -1;
    }

    void push(int a) {
        if (top == 999) {
            return;
        }
        arr[++top] = a;
    }

    int pop() {
        if (top == -1) {
            return -1;
        } else return arr[top--];
    }
}

public class GfG {

    public static void main(String[] args) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t > 0) {
            MyStack obj = new MyStack();
            int Q = Integer.parseInt(read.readLine());
            int k = 0;
            String[] str = read.readLine().trim().split(" ");
            while (Q > 0) {
                int QueryType = 0;
                QueryType = Integer.parseInt(str[k++]);
                if (QueryType == 1) {
                    int a = Integer.parseInt(str[k++]);

                    obj.push(a);

                } else if (QueryType == 2) {
                    System.out.print(obj.pop() + " ");
                }
                Q--;
            }
            System.out.println();
            t--;
        }
    }
}