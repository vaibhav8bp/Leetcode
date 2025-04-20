package org.example.Daily._2025.April._18;

// https://leetcode.com/problems/count-and-say/description/
public class _38_Count_and_Say {
    public String countAndSay(int n) {
        StringBuilder previous = new StringBuilder().append('1');

        for (int i = 2; i <= n; i++) {
            StringBuilder current = new StringBuilder();

            for (int j = 0; j < previous.length(); ) {
                char currentCharacter = previous.charAt(j);
                int start = j;

                while (start < previous.length() && previous.charAt(start) == currentCharacter) {
                    start++;
                }

                int length = start - j;
                current.append(length).append(currentCharacter);
                j = start;
            }

            previous = current;
        }

        return previous.toString();
    }
}
