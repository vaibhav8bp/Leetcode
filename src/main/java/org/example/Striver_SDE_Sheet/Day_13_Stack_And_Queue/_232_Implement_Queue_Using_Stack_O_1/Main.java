package org.example.Striver_SDE_Sheet.Day_13_Stack_And_Queue._232_Implement_Queue_Using_Stack_O_1;

import java.util.Stack;

class MyQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            if (stack1.empty()) {
                return -1;
            } else {
                while (!stack1.empty()) {
                    stack2.add(stack1.pop());
                }
                return stack2.pop();
            }
        }
    }

    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        } else {
            if (stack1.empty()) {
                return -1;
            } else {
                while (!stack1.empty()) {
                    stack2.add(stack1.pop());
                }
                return stack2.peek();
            }
        }
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.empty();
    }
}

public class Main {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.pop());
        System.out.println(obj.peek());
        System.out.println(obj.empty());
    }
}
