package org.example.Daily._2025.February._18;

// DDD
// xy

public class _2375_Construct_Smallest_Number_From_DI_String {

    private boolean smallestNumberHelper(int currentIndex, String pattern, char[] answer, boolean[] visited) {

        if (currentIndex == pattern.length()) {
            return true;
        }

        Character previousCharacter = pattern.charAt(currentIndex);
        int previousIndexNumber = answer[currentIndex] - 48;

        int start = 0;
        int end = 0;

        if (previousCharacter.equals('D')) {
            start = 1;
            end = previousIndexNumber - 1;
        } else if (previousCharacter.equals('I')) {
            start = previousIndexNumber + 1;
            end = 9;
        }

        for (int i = start; i <= end; i++) {
            if (visited[i - 1]) {
                continue;
            }
            // Putting at currentIndex + 1 because answer will be of pattern.length()+ 1
            answer[currentIndex + 1] = (char) (i + 48);
            visited[i - 1] = true;
            if (smallestNumberHelper(currentIndex + 1, pattern, answer, visited)) {
                return true;
            }
            answer[currentIndex + 1] = '$';
            visited[i - 1] = false;
        }

        return false;
    }

    public String smallestNumber(String pattern) {
        boolean[] visited = new boolean[pattern.length() + 1];
        char[] answer = new char[pattern.length() + 1];

        for (int i = 1; i <= 9; i++) {
            answer[0] = (char) (i + 48);
            visited[i - 1] = true;
            if (smallestNumberHelper(0, pattern, answer, visited)) {
                return new String(answer);
            }
            answer[0] = '$';
            visited[i - 1] = false;
        }
        return null;
    }
}