package org.example.Striver_SDE_Sheet.Day_13_Stack_And_Queue._225_Implement_Stack_Using_Queue_Single_Queue;

import java.util.LinkedList;

// https://leetcode.com/problems/implement-stack-using-queues/description/
//Using 1 Queue
class MyStack {

    LinkedList<Integer> queue = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        if (empty()) {
            return -1;
        }
        return queue.pollLast();
    }

    public int top() {
        if (empty()) {
            return -1;
        }
        return queue.peekLast();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}


public class Main {

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }
}