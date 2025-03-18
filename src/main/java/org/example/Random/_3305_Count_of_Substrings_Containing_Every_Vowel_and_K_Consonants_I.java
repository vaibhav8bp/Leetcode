package org.example.Random;

// https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-i/description/
public class _3305_Count_of_Substrings_Containing_Every_Vowel_and_K_Consonants_I {

    // Think k vowel constraint in terms of atleast.
    // Substring with exactly k consonant constraint = substring with atleast k consonants - substring with atleast (k+1) consonants

    private boolean isConditionMet(int aCount, int eCount, int iCount, int oCount, int uCount, int consonantsCount, int k) {
        return (aCount >= 1 && eCount >= 1 && iCount >= 1 && oCount >= 1 && uCount >= 1 && consonantsCount >= k);
    }

    private int countOfSubstringsWithAtLeastKConsonants(String word, int k) {
        int aCount = 0;
        int eCount = 0;
        int iCount = 0;
        int oCount = 0;
        int uCount = 0;
        int consonantsCount = 0;

        // The idea for atleast is such that, once we achieve our substring to be included in our answer
        // all other substrings ahead of it will always be in our answer because that will only increase frequency
        // and never decrease it.

        int answer = 0;

        for (int left = 0, right = 0; right < word.length(); right++) {
            Character currentCharacter = word.charAt(right);

            if (currentCharacter.equals('a')) {
                aCount++;
            } else if (currentCharacter.equals('e')) {
                eCount++;
            } else if (currentCharacter.equals('i')) {
                iCount++;
            } else if (currentCharacter.equals('o')) {
                oCount++;
            } else if (currentCharacter.equals('u')) {
                uCount++;
            } else {
                consonantsCount++;
            }

            while (isConditionMet(aCount, eCount, iCount, oCount, uCount, consonantsCount, k)) {
                // aeioubbbb , Assume k=2, right is 6. now we know everything ahead will add to answer
                // so 9-6=3 can be added. Why ? -> All Substrings -> aeioubb,aeioubbb,aeioubbbb

                answer += (word.length() - right);

                Character currentCharacterAtLeft = word.charAt(left);

                if (currentCharacterAtLeft.equals('a')) {
                    aCount--;
                } else if (currentCharacterAtLeft.equals('e')) {
                    eCount--;
                } else if (currentCharacterAtLeft.equals('i')) {
                    iCount--;
                } else if (currentCharacterAtLeft.equals('o')) {
                    oCount--;
                } else if (currentCharacterAtLeft.equals('u')) {
                    uCount--;
                } else {
                    consonantsCount--;
                }

                left += 1;
            }
        }

        return answer;
    }

    public int countOfSubstrings(String word, int k) {
        return countOfSubstringsWithAtLeastKConsonants(word, k) - countOfSubstringsWithAtLeastKConsonants(word, k + 1);
    }

//    // Every Vowel Needs To Be Present AtLeast Once and there can be only k consonants.
//    // minimum substring length will be k+5.
//    // maximum is not determined as vowels count can be anything.
//    // This constraint is given.
//
//    // 0 <= k <= word.length - 5
//    // try to evaluate all substrings of length (k+5) to substringLength.
//    // Return count of all.
//
//    // TC - O(N^2), SC - O(1)
//    private boolean isCurrentSubstringValid(int aCount, int eCount, int iCount, int oCount, int uCount, int consonantsCount, int k) {
//        return (aCount >= 1 && eCount >= 1 && iCount >= 1 && oCount >= 1 && uCount >= 1 && consonantsCount == k);
//    }
//
//    private int getCountOfSubstringsForCurrentWindow(String word, int currentWindowLength, int k) {
//
//        int currentWindowSubstrings = 0;
//
//        int aCount = 0;
//        int eCount = 0;
//        int iCount = 0;
//        int oCount = 0;
//        int uCount = 0;
//        int consonantsCount = 0;
//
//        for (int i = 0; i < currentWindowLength; i++) {
//            Character currentCharacter = word.charAt(i);
//            if (currentCharacter.equals('a')) {
//                aCount++;
//            } else if (currentCharacter.equals('e')) {
//                eCount++;
//            } else if (currentCharacter.equals('i')) {
//                iCount++;
//            } else if (currentCharacter.equals('o')) {
//                oCount++;
//            } else if (currentCharacter.equals('u')) {
//                uCount++;
//            } else {
//                consonantsCount++;
//            }
//        }
//
//        if (isCurrentSubstringValid(aCount, eCount, iCount, oCount, uCount, consonantsCount, k)) {
//            currentWindowSubstrings++;
//        }
//
//        for (int i = currentWindowLength; i < word.length(); i++) {
//            Character currentCharacter = word.charAt(i);
//            if (currentCharacter.equals('a')) {
//                aCount++;
//            } else if (currentCharacter.equals('e')) {
//                eCount++;
//            } else if (currentCharacter.equals('i')) {
//                iCount++;
//            } else if (currentCharacter.equals('o')) {
//                oCount++;
//            } else if (currentCharacter.equals('u')) {
//                uCount++;
//            } else {
//                consonantsCount++;
//            }
//
//            Character outOfWindowCharacter = word.charAt(i - currentWindowLength);
//            if (outOfWindowCharacter.equals('a')) {
//                aCount--;
//            } else if (outOfWindowCharacter.equals('e')) {
//                eCount--;
//            } else if (outOfWindowCharacter.equals('i')) {
//                iCount--;
//            } else if (outOfWindowCharacter.equals('o')) {
//                oCount--;
//            } else if (outOfWindowCharacter.equals('u')) {
//                uCount--;
//            } else {
//                consonantsCount--;
//            }
//
//            if (isCurrentSubstringValid(aCount, eCount, iCount, oCount, uCount, consonantsCount, k)) {
//                currentWindowSubstrings++;
//            }
//        }
//
//        return currentWindowSubstrings;
//    }
//
//    public int countOfSubstrings(String word, int k) {
//        int minimumSubstringLength = k + 5;
//        int maximumSubstringLength = word.length();
//
//        int answer = 0;
//
//        for (int i = minimumSubstringLength; i <= maximumSubstringLength; i++) {
//            answer += getCountOfSubstringsForCurrentWindow(word, i, k);
//        }
//
//        return answer;
//    }

    // TC - O(N^2), SC - O(N^2)
//    private List<String> getAllSubstrings(String word) {
//
//        List<String> allSubstrings = new ArrayList<>();
//
//        for (int i = 0; i < word.length(); i++) {
//            StringBuilder currentBuilder = new StringBuilder();
//            for (int j = i; j < word.length(); j++) {
//                currentBuilder.append(word.charAt(j));
//                allSubstrings.add(currentBuilder.toString());
//            }
//        }
//
//        return allSubstrings;
//    }
//
//    private boolean isCurrentSubstringEligible(String currentSubstring, int k) {
//        if (currentSubstring.length() < k + 5) {
//            return false;
//        }
//
//        boolean isAPresent = false;
//        boolean isEPresent = false;
//        boolean isIPresent = false;
//        boolean isOPresent = false;
//        boolean isUPresent = false;
//
//        int consonantsCount = 0;
//
//        for (Character currentCharacter : currentSubstring.toCharArray()) {
//            if (currentCharacter.equals('a')) {
//                isAPresent = true;
//            } else if (currentCharacter.equals('e')) {
//                isEPresent = true;
//            } else if (currentCharacter.equals('i')) {
//                isIPresent = true;
//            } else if (currentCharacter.equals('o')) {
//                isOPresent = true;
//            } else if (currentCharacter.equals('u')) {
//                isUPresent = true;
//            } else {
//                consonantsCount++;
//                if (consonantsCount > k) {
//                    return false;
//                }
//            }
//        }
//
//        return (isAPresent && isEPresent && isIPresent && isOPresent && isUPresent && consonantsCount == k);
//    }
//
//    public int countOfSubstrings(String word, int k) {
//        List<String> allSubstrings = getAllSubstrings(word);
//
//        int countOfSubstrings = 0;
//
//        for (String currentSubstring : allSubstrings) {
//            if (isCurrentSubstringEligible(currentSubstring, k)) {
//                countOfSubstrings++;
//            }
//        }
//
//        return countOfSubstrings;
//    }
}
