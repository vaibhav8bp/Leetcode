package org.example.Striver_SDE_Sheet.Day_14_Stack_And_Queue_Part_II._155_Min_Stack;

import java.util.Stack;


// At any time top of the stack will contain helper object
// value will be the inserted value and minSoFar will be min
// till that element(included)

class Helper {
    int value;
    int minSoFar;

    public Helper(int value, int minSoFar) {
        this.value = value;
        this.minSoFar = minSoFar;
    }
}

class MinStack {

    Stack<Helper> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.add(new Helper(val, val));
        } else {
            int previousMin = stack.peek().minSoFar;
            if (previousMin > val) {
                stack.add(new Helper(val, val));
            } else {
                stack.add(new Helper(val, previousMin));
            }
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().minSoFar;
    }
}

public class Main {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(10);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();

    }
}
