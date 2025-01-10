package org.example.Daily._2025.January._4;

import java.util.*;

public class _1930_Unique_Length_3_Palindromic_Subsequences {

    // Maintain minIndex and maxIndex array for every character,that will store the first and last index
    // of that character. Then traverse all the 26 characters in that array, and between the first and last
    // character, count the unique characters, that will be the no. of 3 length palindromes that are possible
    // for that character i.e. no. of 3 length palindromes starting and ending at that character.

    public int countPalindromicSubsequence(String s) {
        int[] firstIndex = new int[26];
        int[] lastIndex = new int[26];
        Arrays.fill(firstIndex, Integer.MAX_VALUE);
        Arrays.fill(lastIndex, Integer.MIN_VALUE);

        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'a';
            firstIndex[charIndex] = Math.min(firstIndex[charIndex], i);
            lastIndex[charIndex] = Math.max(lastIndex[charIndex], i);
        }

        int count = 0;
        Map<Character, Boolean> characterExistenceMapping = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            int firstIndexOfCharacterI = firstIndex[i];
            int lastIndexOfCharacterI = lastIndex[i];

            if (firstIndexOfCharacterI == Integer.MAX_VALUE || lastIndexOfCharacterI == Integer.MIN_VALUE) {
                continue;
            }

            for (int j = firstIndexOfCharacterI + 1; j < lastIndexOfCharacterI; j++) {
                characterExistenceMapping.put(s.charAt(j), true);
            }

            count += characterExistenceMapping.size();
            characterExistenceMapping.clear();
        }

        return count;
    }

    // For a String to be a palindrome of length 3, first and last character should match, that's it.
    // Middle Character can be anything.
    //  adbcaxa
//    public int countPalindromicSubsequence(String s) {
//        Set<String> palindromes = new HashSet<>();
//        Map<Character, List<Integer>> characterToListOfIndexesMapping = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (!characterToListOfIndexesMapping.containsKey(s.charAt(i))) {
//                characterToListOfIndexesMapping.put(s.charAt(i), new ArrayList<>());
//            }
//            List<Integer> currentCharacterIndicesList = characterToListOfIndexesMapping.get(s.charAt(i));
//            if (i >= 2) {
//                if (!currentCharacterIndicesList.isEmpty()) {
//                    int lastIndexOfCurrentCharacter = currentCharacterIndicesList.getLast();
//                    for (int j = lastIndexOfCurrentCharacter + 1; j < i; j++) {
//                        palindromes.add(new StringBuilder().append(s.charAt(i)).append(s.charAt(j)).append(s.charAt(i)).toString());
//                    }
//                    if (currentCharacterIndicesList.size() > 1) {
//                        palindromes.add(new StringBuilder().append(s.charAt(i)).append(s.charAt(i)).append(s.charAt(i)).toString());
//                    }
//                }
//            }
//            currentCharacterIndicesList.add(i);
//        }
//        return palindromes.size();
//    }
}

//public class _1930_Unique_Length_3_Palindromic_Subsequences {
//
//    // For a String to be a palindrome of length 3, first and last character should match, that's it.
//    // Middle Character can be anything.
//    // adbcaxa
//    private void countPalindromicSubsequenceStartingAtI(Set<String> palindromes, String s, int currentIndex) {
//        for (int i = currentIndex + 2; i < s.length(); i++) {
//            if (s.charAt(i) == s.charAt(currentIndex)) {
//                for (int j = currentIndex + 1; j < i; j++) {
//                    String currentPalindrome = new StringBuilder().append(s.charAt(currentIndex)).append(s.charAt(j)).append(s.charAt(i)).toString();
//                    palindromes.add(currentPalindrome);
//                }
//            }
//        }
//    }
//
//    public int countPalindromicSubsequence(String s) {
//        Set<String> palindromes = new HashSet<>();
//        for (int i = 0; i < s.length() - 2; i++) {
//            countPalindromicSubsequenceStartingAtI(palindromes, s, i);
//        }
//        return palindromes.size();
//    }
//}

// Brute Force Solution
//public class _1930_Unique_Length_3_Palindromic_Subsequences {
//
//    private boolean isPalindrome(String s) {
//        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
//            if (s.charAt(i) != s.charAt(j)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private void getAllSubsequencesOfLengthKHelper(Set<String> answer, StringBuilder currentString, String originalString, int k, int currentIndex) {
//        if (currentString.length() == k) {
//            answer.add(currentString.toString());
//            return;
//        }
//
//        if (currentIndex == originalString.length()) {
//            return;
//        }
//
//        currentString.append(originalString.charAt(currentIndex));
//        getAllSubsequencesOfLengthKHelper(answer, currentString, originalString, k, currentIndex + 1);
//        currentString.deleteCharAt(currentString.length() - 1);
//        getAllSubsequencesOfLengthKHelper(answer, currentString, originalString, k, currentIndex + 1);
//    }
//
//    Set<String> getAllSubsequencesOfLengthK(String s, int k) {
//        Set<String> answer = new HashSet<>();
//
//        if (s.length() < k) {
//            return answer;
//        } else if (s.length() == k) {
//            answer.add(s);
//            return answer;
//        }
//
//        getAllSubsequencesOfLengthKHelper(answer, new StringBuilder(), s, k, 0);
//        return answer;
//    }
//
//    public int countPalindromicSubsequence(String s) {
//
//        int answer = 0;
//        Set<String> subsequencesOfLength3 = getAllSubsequencesOfLengthK(s, 3);
//
//        for (String currentString : subsequencesOfLength3) {
//            if (isPalindrome(currentString)) {
//                answer++;
//            }
//        }
//
//        return answer;
//    }
//}
