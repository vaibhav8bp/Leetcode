package org.example.Striver_SDE_Sheet.Day_13_Stack_And_Queue.Sort_A_Stack;

import java.util.Scanner;
import java.util.Stack;

class GfG {

    public void insertElementInSortedStack(Stack<Integer> s, int element) {
        if (s.isEmpty()) {
            s.add(element);
            return;
        }

        if (s.peek() < element) {
            s.add(element);
            return;
        }

        int top = s.pop();
        insertElementInSortedStack(s, element);
        s.add(top);
    }

    public Stack<Integer> sort(Stack<Integer> s) {
        if (s.isEmpty() || s.size() == 1) {
            return s;
        }

        int top = s.pop();

        // Call Recursion on (n-1) length stack
        sort(s);

        if (s.peek() < top) {
            s.add(top);
        } else {

            // Recursive Solution
            insertElementInSortedStack(s, top);

            // Iterative Solution
//            Stack<Integer> tempStack = new Stack<>();
//            while (!s.isEmpty() && s.peek() > top) {
//                tempStack.add(s.pop());
//            }
//            s.add(top);
//            while (!tempStack.isEmpty()) {
//                s.add(tempStack.pop());
//            }
        }

        return s;
    }
}

class SortedStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<>();
            int n = sc.nextInt();
            while (n-- > 0) s.push(sc.nextInt());
            GfG g = new GfG();
            Stack<Integer> a = g.sort(s);
            while (!a.empty()) {
                System.out.print(a.peek() + " ");
                a.pop();
            }
            System.out.println();
        }
    }
}

//1
//5
//11 2 32 3 41