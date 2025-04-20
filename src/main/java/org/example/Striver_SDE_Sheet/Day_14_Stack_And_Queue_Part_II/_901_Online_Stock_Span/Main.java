package org.example.Striver_SDE_Sheet.Day_14_Stack_And_Queue_Part_II._901_Online_Stock_Span;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/online-stock-span/description/
class StockSpanner {

    List<Integer> integerList;
    Stack<Integer> stack;

    public StockSpanner() {
        integerList = new ArrayList<>();
        stack = new Stack<>();
    }

    public int next(int price) {
        integerList.add(price);
        if (stack.isEmpty()) {
            stack.add(integerList.size() - 1);
            return 1;
        } else {
            while (!stack.isEmpty() && integerList.get(stack.peek()) <= price) {
                stack.pop();
            }
            int answer;
            if (stack.isEmpty()) {
                answer = integerList.size();
            } else {
                answer = integerList.size() - stack.peek() - 1;
            }
            stack.add(integerList.size() - 1);
            return answer;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));
    }
}
