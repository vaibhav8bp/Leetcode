package org.example.Google;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/
public class _22_Generate_Parentheses {

    private void generateParenthesis(StringBuilder currentString, int openCount, int closeCount, int n, List<String> answer) {
        if (openCount == n && closeCount == n) {
            answer.add(new String(currentString));
            return;
        }

        if (openCount < n) {
            currentString.append('(');
            generateParenthesis(currentString, openCount + 1, closeCount, n, answer);
            currentString.deleteCharAt(currentString.length() - 1);
        }

        if (closeCount < n && closeCount < openCount) {
            currentString.append(')');
            generateParenthesis(currentString, openCount, closeCount + 1, n, answer);
            currentString.deleteCharAt(currentString.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        generateParenthesis(new StringBuilder(), 0, 0, n, answer);
        return answer;
    }
}