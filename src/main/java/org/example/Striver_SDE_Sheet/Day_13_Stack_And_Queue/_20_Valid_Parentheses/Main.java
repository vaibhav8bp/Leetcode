package org.example.Striver_SDE_Sheet.Day_13_Stack_And_Queue._20_Valid_Parentheses;

import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/description/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.add(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (s.charAt(i) == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else if (s.charAt(i) == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else if (s.charAt(i) == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()[]{}"));
    }
}
