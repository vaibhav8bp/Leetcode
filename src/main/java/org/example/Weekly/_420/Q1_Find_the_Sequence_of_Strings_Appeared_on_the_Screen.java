package org.example.Weekly._420;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> stringSequence(String target) {
        List<String> finalList = new ArrayList<>();

        StringBuilder lastString = new StringBuilder();

        int targetLengthAchieved = 0;
        while (targetLengthAchieved != target.length()) {
            char currentChar = 'a';
            lastString.append(currentChar);
            finalList.add(lastString.toString());
            if (target.charAt(targetLengthAchieved) != currentChar) {
                currentChar++;
                do {
                    lastString.deleteCharAt(lastString.length() - 1);
                    lastString.append(currentChar);
                    finalList.add(lastString.toString());
                    currentChar++;
                } while (currentChar != target.charAt(targetLengthAchieved));

                lastString.deleteCharAt(lastString.length() - 1);
                lastString.append(currentChar);
                finalList.add(lastString.toString());
            }
            targetLengthAchieved++;
        }
        return finalList;
    }

    public static class Q1_Find_the_Sequence_of_Strings_Appeared_on_the_Screen {
        public static void main(String[] args) {
            System.out.println(new Solution().stringSequence("abc"));
        }
    }
}
