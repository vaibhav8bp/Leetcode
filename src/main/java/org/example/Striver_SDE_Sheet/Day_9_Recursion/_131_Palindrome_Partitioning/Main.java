package org.example.Striver_SDE_Sheet.Day_9_Recursion._131_Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.List;

class Solution {
    boolean checkPalindrome(String stringToBeChecked, int start, int end) {
        while (start < end) {
            if (stringToBeChecked.charAt(start) != stringToBeChecked.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    void partitionHelper(String s, int currentIndex, List<List<String>> finalList, List<String> currentList) {
        if (currentIndex == s.length()) {
            finalList.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = currentIndex; i < s.length(); i++) {
            // Passing i because i is the final index. length is (i+1)
            if (checkPalindrome(s, currentIndex, i)) {
                currentList.add(s.substring(currentIndex, i + 1));
                partitionHelper(s, i + 1, finalList, currentList);
                currentList.removeLast();
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> finalList = new ArrayList<>();
        List<String> currentList = new ArrayList<>();
        partitionHelper(s, 0, finalList, currentList);
        return finalList;
    }
}

public class Main {
    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(new Solution().partition(s));
    }
}