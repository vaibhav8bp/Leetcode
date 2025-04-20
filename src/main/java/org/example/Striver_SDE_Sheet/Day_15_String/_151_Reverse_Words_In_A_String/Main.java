package org.example.Striver_SDE_Sheet.Day_15_String._151_Reverse_Words_In_A_String;

// https://leetcode.com/problems/reverse-words-in-a-string/description/
class Solution {

    private void removeStartAndEndSpaces(StringBuilder currentString) {
        int start = 0;
        while (currentString.charAt(start) == ' ') {
            start++;
        }

        currentString.delete(0, start);

        int end = currentString.length() - 1;
        while (currentString.charAt(end) == ' ') {
            end--;
        }

        currentString.delete(end + 1, currentString.length());
    }

    private void reverse(StringBuilder stringBuilder, int start, int end) {
        while (start < end) {
            char temp = stringBuilder.charAt(start);
            stringBuilder.setCharAt(start, stringBuilder.charAt(end));
            stringBuilder.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    public String reverseWords(String s) {
        StringBuilder currentString = new StringBuilder(s);
        removeStartAndEndSpaces(currentString);
        reverse(currentString, 0, currentString.length() - 1);

        int start = 0;
        int end = 0;

        while (start < currentString.length()) {
            while (end < currentString.length() && currentString.charAt(end) != ' ') {
                end++;
            }

            reverse(currentString, start, end - 1);

            if (end == currentString.length()) {
                break;
            }

            int firstIndexOfSpace = end;
            // Check For More Than 1 Space
            while (end < currentString.length() && currentString.charAt(end) == ' ') {
                end++;
            }

            if (firstIndexOfSpace + 1 != end) {
                currentString.delete(firstIndexOfSpace + 1, end);
                end -= (end - (firstIndexOfSpace + 1));
            }

            start = end;
        }

        return currentString.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("a good   example"));
    }
}
