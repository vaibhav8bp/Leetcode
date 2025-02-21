package org.example.Daily._2025.February._19;

// https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
public class _1415_The_k_th_Lexicographical_String_of_All_Happy_Strings_of_Length_n {

    private final char[][] happyCharacters = {{'b', 'c'}, {'a', 'c'}, {'a', 'b'}};

    public String getHappyString(int n, int k) {

        int totalCombinationsPossible = 3 * (int) Math.pow(2, n - 1);

        if (totalCombinationsPossible < k) {
            return "";
        }

        // n = 3
        // totalCombinationsPossible = 12

        // 1 2  3  4
        // 5 6  7  8
        // 9 10 11 12

        StringBuilder answer = new StringBuilder();

        int group1LowerLimit = 1;
        int group1UpperLimit = totalCombinationsPossible / 3;

        int group2LowerLimit = group1UpperLimit + 1;
        int group2UpperLimit = 2 * group1UpperLimit;

        int group3LowerLimit = group2UpperLimit + 1;
        int group3UpperLimit = 3 * group1UpperLimit;

        if (k >= group1LowerLimit && k <= group1UpperLimit) {
            answer.append('a');
        } else if (k >= group2LowerLimit && k <= group2UpperLimit) {
            answer.append('b');
            k -= group1UpperLimit;
        } else if (k >= group3LowerLimit && k <= group3UpperLimit) {
            answer.append('c');
            k -= group2UpperLimit;
        }

        Character previousCharacter = answer.charAt(0);

        int currentLimit = group1UpperLimit;

        while (currentLimit != 1) {
            int halfLimit = currentLimit / 2;
            int previousCharacterIndex = previousCharacter - 'a';
            if (k <= halfLimit) {
                previousCharacter = happyCharacters[previousCharacterIndex][0];
            } else {
                previousCharacter = happyCharacters[previousCharacterIndex][1];
                k -= halfLimit;
            }
            answer.append(previousCharacter);
            currentLimit /= 2;
        }

        return answer.toString();
    }

//    private final char[] happyCharacters = {'a', 'b', 'c'};

//    private int currentHappyStringNumber;

//    private void getHappyStringHelper(StringBuilder currentString, int k, int n) {
//        if (currentString.length() == n) {
//            currentHappyStringNumber++;
//            return;
//        }

//        for (char currentHappyCharacter : happyCharacters) {
//            if (!currentString.isEmpty() && currentString.charAt(currentString.length() - 1) == currentHappyCharacter) {
//                continue;
//            }
//            currentString.append(currentHappyCharacter);
//            getHappyStringHelper(currentString, k, n);
//            if (currentHappyStringNumber == k) {
//                return;
//            }
//            currentString.deleteCharAt(currentString.length() - 1);
//        }
//    }

//    public String getHappyString(int n, int k) {
//        currentHappyStringNumber = 0;
//        StringBuilder answer = new StringBuilder();
//        getHappyStringHelper(answer, k, n);
//        return answer.toString();
//    }
}