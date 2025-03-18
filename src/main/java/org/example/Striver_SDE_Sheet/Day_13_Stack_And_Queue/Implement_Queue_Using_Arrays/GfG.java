package org.example.Striver_SDE_Sheet.Day_13_Stack_And_Queue.Implement_Queue_Using_Arrays;

import java.util.Scanner;

class MyQueue {

    int front, rear;
    int[] arr = new int[100005];

    MyQueue() {
        front = -1;
        rear = -1;
    }

    void push(int x) {
        if (front == -1 && rear == -1) {
            front = rear = 0;
            arr[front] = x;
        } else {
            arr[++rear] = x;
        }
    }

    int pop() {
        if (front == -1 && rear == -1) {
            return -1;
        }
        int temp = arr[front];

        if (front == rear) {
            front = rear = -1;
        } else {
            front++;
        }
        return temp;
    }
}


class GfG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            MyQueue obj = new MyQueue();
            int Q = sc.nextInt();
            while (Q > 0) {
                int QueryType = 0;
                QueryType = sc.nextInt();
                if (QueryType == 1) {
                    int a = sc.nextInt();

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