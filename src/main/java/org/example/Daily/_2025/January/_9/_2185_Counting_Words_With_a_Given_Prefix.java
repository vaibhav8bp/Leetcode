package org.example.Daily._2025.January._9;

public class _2185_Counting_Words_With_a_Given_Prefix {
    public int prefixCount(String[] words, String pref) {
        int count = 0;

        for (String currentWord : words) {
            if (currentWord.startsWith(pref)) {
                count++;
            }
        }

        return count;
    }
}
