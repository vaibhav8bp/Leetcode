package org.example.Daily._2025.March._11;

// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
public class _1358_Number_of_Substrings_Containing_All_Three_Characters {

    private boolean isConditionMet(int aCount, int bCount, int cCount) {
        return (aCount >= 1 && bCount >= 1 && cCount >= 1);
    }

    public int numberOfSubstrings(String s) {
        int numberOfSubstrings = 0;

        int aCount = 0;
        int bCount = 0;
        int cCount = 0;

        for (int left = 0, right = 0; right < s.length(); right++) {
            Character currentCharacter = s.charAt(right);

            if (currentCharacter.equals('a')) {
                aCount++;
            } else if (currentCharacter.equals('b')) {
                bCount++;
            } else if (currentCharacter.equals('c')) {
                cCount++;
            }

            while (isConditionMet(aCount, bCount, cCount)) {
                numberOfSubstrings += s.length() - right;

                Character previousCharacter = s.charAt(left);

                if (previousCharacter.equals('a')) {
                    aCount--;
                } else if (previousCharacter.equals('b')) {
                    bCount--;
                } else if (previousCharacter.equals('c')) {
                    cCount--;
                }

                left++;
            }
        }

        return numberOfSubstrings;
    }
}