package org.example.Google;

import java.util.Map;

// https://leetcode.com/problems/roman-to-integer/description/
public class _13_Roman_to_Integer {

    private final Map<Character, Integer> romanToDecimalMapping = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000);

    public int romanToInt(String s) {

        int answer = 0;

        for (int i = s.length() - 1; i >= 0; ) {
            int end = i - 1;
            while (end >= 0 && s.charAt(end) == s.charAt(i)) {
                end--;
            }
            int count = i - end;
            answer += (romanToDecimalMapping.get(s.charAt(i)) * count);
            if (count == 1 && end >= 0 && romanToDecimalMapping.get(s.charAt(end)) < romanToDecimalMapping.get(s.charAt(i))) {
                answer -= romanToDecimalMapping.get(s.charAt(end));
                end--;
            }
            i = end;
        }

        return answer;
    }
}
