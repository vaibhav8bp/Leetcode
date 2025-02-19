package org.example.Daily._2025.February._19;

// https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
public class _1415_The_k_th_Lexicographical_String_of_All_Happy_Strings_of_Length_n {

    private final char[] happyCharacters = {'a', 'b', 'c'};

    private int currentHappyStringNumber;

    private void getHappyStringHelper(StringBuilder currentString, int k, int n) {
        if (currentString.length() == n) {
            currentHappyStringNumber++;
            return;
        }

        for (char currentHappyCharacter : happyCharacters) {
            if (!currentString.isEmpty() && currentString.charAt(currentString.length() - 1) == currentHappyCharacter) {
                continue;
            }
            currentString.append(currentHappyCharacter);
            getHappyStringHelper(currentString, k, n);
            if (currentHappyStringNumber == k) {
                return;
            }
            currentString.deleteCharAt(currentString.length() - 1);
        }
    }

    public String getHappyString(int n, int k) {
        currentHappyStringNumber = 0;
        StringBuilder answer = new StringBuilder();
        getHappyStringHelper(answer, k, n);
        return answer.toString();
    }
}