package org.example.Striver_SDE_Sheet.Day_15_String._13_Roman_To_Integer;

//Symbol	Value
//I	         1
//V	         5
//X	         10
//L	         50
//C	         100
//D	         500
//M	         1000

import java.util.HashMap;
import java.util.Map;

class Helper {
    public Character smaller;
    public int value;

    public Helper(Character smaller, int value) {
        this.smaller = smaller;
        this.value = value;
    }
}

class Solution {

    public int romanToInt(String s) {
        Map<Character, Helper> romanToIntegerMapping = new HashMap<>();

        romanToIntegerMapping.put('I', new Helper(null, 1));
        romanToIntegerMapping.put('V', new Helper('I', 5));
        romanToIntegerMapping.put('X', new Helper('I', 10));
        romanToIntegerMapping.put('L', new Helper('X', 50));
        romanToIntegerMapping.put('C', new Helper('X', 100));
        romanToIntegerMapping.put('D', new Helper('C', 500));
        romanToIntegerMapping.put('M', new Helper('C', 1000));

        int answer = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'I') {
                answer++;
            } else if (i > 0) {
                if (s.charAt(i - 1) == romanToIntegerMapping.get(s.charAt(i)).smaller) {
                    answer += (
                            romanToIntegerMapping.get(s.charAt(i)).value - romanToIntegerMapping.get(romanToIntegerMapping.get(s.charAt(i)).smaller).value
                    );
                    i--;
                } else {
                    answer += romanToIntegerMapping.get(s.charAt(i)).value;
                }
            } else {
                answer += romanToIntegerMapping.get(s.charAt(0)).value;
            }
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("LVIII"));
    }
}
