package org.example.Daily._2025.February._10;

import java.util.Stack;

//https://leetcode.com/problems/clear-digits/
public class _3174_Clear_Digits {

    public String clearDigits(String s) {
        Stack<Character> characterStack = new Stack<>();

        for (Character currentCharacter : s.toCharArray()) {
            if (currentCharacter >= 48 && currentCharacter <= 57) {
                if (!characterStack.isEmpty()) {
                    characterStack.pop();
                }
            } else {
                characterStack.push(currentCharacter);
            }
        }

        StringBuilder answer = new StringBuilder();

        while (!characterStack.isEmpty()) {
            answer.append(characterStack.pop());
        }

        return answer.reverse().toString();
    }

//    private int[] indexOfLeftNonDigitForDigit(StringBuilder currentString) {
//
//        int index = -1;
//
//        for (int i = 0; i < currentString.length(); i++) {
//            if (currentString.charAt(i) >= 48 && currentString.charAt(i) <= 57) {
//                return new int[]{i, index};
//            } else {
//                index = i;
//            }
//        }
//
//        return null;
//    }
//
//    public String clearDigits(String s) {
//
//        StringBuilder answer = new StringBuilder(s);
//
//        int[] indexes = indexOfLeftNonDigitForDigit(answer);
//
//        while (indexes != null) {
//            int digitIndex = indexes[0];
//            int nonDigitIndex = indexes[1];
//
//            answer.deleteCharAt(digitIndex);
//            if (nonDigitIndex != -1) {
//                answer.deleteCharAt(nonDigitIndex);
//            }
//
//            indexes = indexOfLeftNonDigitForDigit(answer);
//        }
//
//        return answer.toString();
//    }
}
