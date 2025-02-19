package org.example.Daily._2025.February._18;

// DDD
// xy

public class _2375_Construct_Smallest_Number_From_DI_String {

    // IIIDIDDD
    // 123549876

    // DDD
    // 4321

    // Simple Initialize a string with 123..
    // In case of D's reverse the length.
    // Observe First Example Carefully.
    // III -> For I do nothing
    // 123
    // D -> reverse Next d's length+1 characters.

    private void reverseFromStartToEnd(StringBuilder answer, int start, int end) {
        while (start < end) {
            char temp = answer.charAt(start);
            answer.setCharAt(start, answer.charAt(end));
            answer.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    public String smallestNumber(String pattern) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i <= pattern.length(); i++) {
            // 49 because starting from i=0
            answer.append((char) (i + 49));
        }

        for (int i = 0; i < pattern.length(); i++) {
            Character currentCharacter = pattern.charAt(i);
            if (currentCharacter.equals('I')) {
                continue;
            } else if (currentCharacter.equals('D')) {
                int end = i;
                while (end < pattern.length() && pattern.charAt(end) == ('D')) {
                    end++;
                }
                reverseFromStartToEnd(answer, i, end);
                i = end - 1;
            }
        }

        return answer.toString();
    }

    //  Backtracking
//    private boolean smallestNumberHelper(int currentIndex, String pattern, char[] answer, boolean[] visited) {
//
//        if (currentIndex == pattern.length()) {
//            return true;
//        }
//
//        Character previousCharacter = pattern.charAt(currentIndex);
//        int previousIndexNumber = answer[currentIndex] - 48;
//
//        int start = 0;
//        int end = 0;
//
//        if (previousCharacter.equals('D')) {
//            start = 1;
//            end = previousIndexNumber - 1;
//        } else if (previousCharacter.equals('I')) {
//            start = previousIndexNumber + 1;
//            end = 9;
//        }
//
//        for (int i = start; i <= end; i++) {
//            if (visited[i - 1]) {
//                continue;
//            }
//            // Putting at currentIndex + 1 because answer will be of pattern.length()+ 1
//            answer[currentIndex + 1] = (char) (i + 48);
//            visited[i - 1] = true;
//            if (smallestNumberHelper(currentIndex + 1, pattern, answer, visited)) {
//                return true;
//            }
//            answer[currentIndex + 1] = '$';
//            visited[i - 1] = false;
//        }
//
//        return false;
//    }
//
//    public String smallestNumber(String pattern) {
//        boolean[] visited = new boolean[pattern.length() + 1];
//        char[] answer = new char[pattern.length() + 1];
//
//        for (int i = 1; i <= 9; i++) {
//            answer[0] = (char) (i + 48);
//            visited[i - 1] = true;
//            if (smallestNumberHelper(0, pattern, answer, visited)) {
//                return new String(answer);
//            }
//            answer[0] = '$';
//            visited[i - 1] = false;
//        }
//        return null;
//    }
}