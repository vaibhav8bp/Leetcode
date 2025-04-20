package org.example.Striver_SDE_Sheet.Day_10_Recursion_And_BackTracking._Word_Break_II;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.naukri.com/code360/problems/983635
class Solution {

    public static void wordBreakHelper(String s, int currentIndex, StringBuilder currentString, ArrayList<String> dictionary, ArrayList<String> finalList) {
        if (currentIndex == s.length()) {
            finalList.add(currentString.toString());
            return;
        }

        StringBuilder currentWord = new StringBuilder();
        StringBuilder currentBuilder = new StringBuilder(currentString);

        for (int i = currentIndex; i < s.length(); i++) {
            currentWord.append(s.charAt(i));
            if (dictionary.contains(currentWord.toString())) {
                if (!currentBuilder.isEmpty()) {
                    currentBuilder.append(" ");
                }
                currentBuilder.append(currentWord);
                wordBreakHelper(s, i + 1, currentBuilder, dictionary, finalList);
                currentBuilder.delete(currentString.length(), currentBuilder.length());
            }
        }
    }

    public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
        ArrayList<String> finalList = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        wordBreakHelper(s, 0, current, dictionary, finalList);
        return finalList;
    }
}

public class Main {
    public static void main(String[] args) {
        String s = "godisnowherenowhere";
        ArrayList<String> list = new ArrayList<>(Arrays.asList("god", "is", "now", "no", "where", "here"));
        System.out.println(Solution.wordBreak(s, list));
    }
}
