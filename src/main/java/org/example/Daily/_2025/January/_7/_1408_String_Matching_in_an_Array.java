package org.example.Daily._2025.January._7;

import java.util.ArrayList;
import java.util.List;

public class _1408_String_Matching_in_an_Array {

    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }

        return result;
    }
}
