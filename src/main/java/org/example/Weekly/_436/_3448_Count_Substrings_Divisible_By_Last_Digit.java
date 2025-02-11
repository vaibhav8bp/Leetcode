package org.example.Weekly._436;

// https://leetcode.com/problems/count-substrings-divisible-by-last-digit/
public class _3448_Count_Substrings_Divisible_By_Last_Digit {

    private void updateModulo7(int[] modulo7, int currentNumber) {
        int[] temp = new int[7];

        for (int i = 0; i < 7; i++) {
            temp[((i * 10) + currentNumber) % 7] = modulo7[i];
        }

        System.arraycopy(temp, 0, modulo7, 0, 7);
    }

    public long countSubstrings(String s) {
        int length = s.length();

        long answer = 0;

        int[] prefixRemainderModulo3 = new int[length];
        int[] prefixRemainderModulo9 = new int[length];
        int[] modulo7 = new int[7];

        long[] frequencyOfRemainderModulo3 = new long[3];
        long[] frequencyOfRemainderModulo9 = new long[9];

        int firstNumber = Character.getNumericValue(s.charAt(0));

        prefixRemainderModulo3[0] = firstNumber % 3;
        prefixRemainderModulo9[0] = firstNumber % 9;

        for (int i = 1; i < length; i++) {
            int currentNumber = Character.getNumericValue(s.charAt(i));
            prefixRemainderModulo3[i] = (10 * prefixRemainderModulo3[i - 1] + currentNumber) % 3;
            prefixRemainderModulo9[i] = (10 * prefixRemainderModulo9[i - 1] + currentNumber) % 9;
        }

        for (int currentIndex = 0; currentIndex < s.length(); currentIndex++) {
            int currentNumber = Character.getNumericValue(s.charAt(currentIndex));
            if (currentNumber == 0) {
            } else if (currentNumber == 1 || currentNumber == 2 || currentNumber == 5) {
                answer += (currentIndex + 1);
            } else if (currentNumber == 3 || currentNumber == 6) {
                answer += (prefixRemainderModulo3[currentIndex] == 0) ? 1L : 0L;
                answer += frequencyOfRemainderModulo3[prefixRemainderModulo3[currentIndex]];
            } else if (currentNumber == 9) {
                answer += (prefixRemainderModulo9[currentIndex] == 0) ? 1L : 0L;
                answer += frequencyOfRemainderModulo9[prefixRemainderModulo9[currentIndex]];
            } else if (currentNumber == 4) {
                answer++;
                if (currentIndex > 0) {
                    int last2Digits = Character.getNumericValue(s.charAt(currentIndex - 1)) * 10 + currentNumber;
                    if (last2Digits % 4 == 0) {
                        answer += currentIndex;
                    }
                }
            } else if (currentNumber == 8) {
                answer++;
                if (currentIndex == 1) {
                    int last2Digits = Character.getNumericValue(s.charAt(currentIndex - 1)) * 10 + currentNumber;
                    if (last2Digits % 8 == 0) {
                        answer += 1;
                    }
                } else if (currentIndex > 1) {
                    int last2Digits = Character.getNumericValue(s.charAt(currentIndex - 1)) * 10 + currentNumber;
                    if (last2Digits % 8 == 0) {
                        answer += 1;
                    }

                    int last3Digits = Character.getNumericValue(s.charAt(currentIndex - 2)) * 100 + last2Digits;
                    if (last3Digits % 8 == 0) {
                        answer += (currentIndex - 1);
                    }
                }
            } else {
                answer += (1 + modulo7[0]);
            }

            frequencyOfRemainderModulo3[prefixRemainderModulo3[currentIndex]]++;
            frequencyOfRemainderModulo9[prefixRemainderModulo9[currentIndex]]++;
            updateModulo7(modulo7, currentNumber);
            // Here We are Only Updating 1 length substring, but in the update function
            // we are updating for all prefix substrings
            modulo7[currentNumber % 7]++;
        }

        return answer;
    }

//    public long countSubstrings(String s) {
//        long answer = 0;
//        // dp[i][j] represents the count of substrings that leave remainder j, when divided by i.
//        long[][] dp = new long[10][9];

//        for (Character currentCharacter : s.toCharArray()) {
//            int currentNumber = Character.getNumericValue(currentCharacter);

//            // For no. Ending at 0, no substring will be counted.
//            long[][] current = new long[10][9];

//            for (int i = 1; i < 10; i++) {
//                // Max. Remainder Possible is 8.
//                for (int j = 0; j < 9; j++) {
//                    // For substring ending at previous index/previous character, their remainder is j
//                    // So for substring ending at current index/current character their remainder will be
//                    int currentRemainder = (j * 10 + currentNumber) % i;

//                    // dp[i][j], is count of substrings ending at previous index/character when divided by i and leaving remainder j.
//                    // So we have to pass all previous answer to current state, that is current[i][newRemainder] will have all count of dp[i][j]

//                    // ..........i
//                    //           |
//                    // All answers of above should be added to current.
//                    // ..........ii
//                    current[i][currentRemainder] += dp[i][j];
//                }
//                // For Substring of 1 length
//                current[i][currentNumber % i]++;
//            }
//            dp = current;
//            answer += dp[currentNumber][0];
//        }

//        return answer;
//    }

    // Brute Force
//    private void getAllSubstrings(String s, List<String> substrings) {
//        for (int i = 0; i < s.length(); i++) {
//            StringBuilder currentString = new StringBuilder();
//            for (int j = i; j < s.length(); j++) {
//                currentString.append(s.charAt(j));
//                substrings.add(currentString.toString());
//            }
//        }
//    }
//
//    private boolean checkIfCurrentStringIsDivisibleByLastNonZeroDigit(String currentString) {
//
//        int lastNonZeroDigit = Integer.parseInt(String.valueOf(currentString.charAt(currentString.length() - 1)));
//
//        if (lastNonZeroDigit == 0) {
//            return false;
//        }
//
//        long currentNumber = Long.parseLong(currentString);
//        return (currentNumber % lastNonZeroDigit) == 0;
//    }
//
//    public long countSubstrings(String s) {
//        List<String> substrings = new ArrayList<>();
//        getAllSubstrings(s, substrings);
//
//        long answer = 0;
//
//        for (String currentString : substrings) {
//            if (checkIfCurrentStringIsDivisibleByLastNonZeroDigit(currentString)) {
//                answer++;
//            }
//        }
//
//        return answer;
//    }
}
