package org.example.Google;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/zigzag-conversion/description/
public class _6_Zigzag_Conversion {
    public static String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        List<Character>[] charactersList = new ArrayList[numRows];

        for (int i = 0; i < numRows; i++) {
            charactersList[i] = new ArrayList<>();
        }

        int currentRowIndex = 0;
        boolean increasingFlow = true;

        for (Character currentCharacter : s.toCharArray()) {
            charactersList[currentRowIndex].add(currentCharacter);
            if (increasingFlow) {
                currentRowIndex++;
                if (currentRowIndex == numRows) {
                    currentRowIndex -= 2;
                    increasingFlow = false;
                }
            } else {
                currentRowIndex--;
                if (currentRowIndex == -1) {
                    currentRowIndex = 1;
                    increasingFlow = true;
                }
            }
        }

        StringBuilder answer = new StringBuilder();

        for (List<Character> currentRowCharacterList : charactersList) {
            for (Character currentCharacter : currentRowCharacterList) {
                answer.append(currentCharacter);
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
